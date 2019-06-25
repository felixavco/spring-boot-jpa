package com.xilews.springboot.app.models.dao;

import com.xilews.springboot.app.models.entity.Client;

import org.springframework.data.repository.CrudRepository;

public interface IClientDao extends CrudRepository<Client, Long>{

}
