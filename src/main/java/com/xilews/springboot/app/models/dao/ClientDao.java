package com.xilews.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xilews.springboot.app.models.entity.Client;

@Repository
public class ClientDao implements IClientDao {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Client> findAll() {
		List<Client> clients = em.createQuery("from Client").getResultList();
		return clients;
	}

	@Override
	@Transactional
	public void save(Client client) {
		if(client.getId() != null && client.getId() > 0) {
			em.merge(client); //Edit existing client
		} else {
			em.persist(client); // Create a new client
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Client findOne(Long id) {
		return em.find(Client.class, id);
	}

	@Override
	@Transactional
	public void deleteOne(Long id) {
		Client client = findOne(id);
		em.remove(client);
	}
	
}
