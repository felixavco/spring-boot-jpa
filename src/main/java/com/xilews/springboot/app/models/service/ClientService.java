package com.xilews.springboot.app.models.service;

import java.util.List;

import com.xilews.springboot.app.models.dao.IClientDao;
import com.xilews.springboot.app.models.entity.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService implements IClientService {

    @Autowired
    private IClientDao clientDao;

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    @Transactional
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    @Transactional(readOnly = true)
    public Client findOne(Long id) {
        return clientDao.findOne(id);
    }

    @Override
    @Transactional
    public void deleteOne(Long id) {
        clientDao.deleteOne(id);
    }

}
