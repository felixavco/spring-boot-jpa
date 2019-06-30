package com.xilews.springboot.app.models.service;

import java.util.List;

import com.xilews.springboot.app.models.entity.Client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClientService {

	public List<Client> findAll();

	public Page<Client> findAll(Pageable pageable);

	public void save(Client client);

	public Client findOne(Long id);

	public void deleteOne(Long id);

}
