package com.xilews.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.xilews.springboot.app.models.entity.Client;

@Repository
public class ClientDao implements IClientDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAll() {
		List<Client> clients = em.createQuery("from Client").getResultList();
		return clients;
	}

	@Override
	public void save(Client client) {
		if (client.getId() != null && client.getId() > 0) {
			em.merge(client); // Edit existing client
		} else {
			em.persist(client); // Create a new client
		}

	}

	@Override
	public Client findOne(Long id) {
		return em.find(Client.class, id);
	}

	@Override
	public void deleteOne(Long id) {
		Client client = findOne(id);
		em.remove(client);
	}

}
