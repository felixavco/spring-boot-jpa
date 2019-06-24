package com.xilews.springboot.app.models.dao;

import java.util.List;

import com.xilews.springboot.app.models.entity.Client;

public interface IClientDao {

	public List<Client> findAll();

	public void save(Client client);
}
