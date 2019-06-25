package com.xilews.springboot.app.models.service;

import java.util.List;

import com.xilews.springboot.app.models.entity.Client;

public interface IClientService {

    public List<Client> findAll();

	public void save(Client client);

	public Client findOne(Long id);

	public void deleteOne(Long id);

}
