package com.xilews.springboot.app.models.dao;

import com.xilews.springboot.app.models.entity.Client;

// import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// public interface IClientDao extends CrudRepository<Client, Long>{
public interface IClientDao extends PagingAndSortingRepository<Client, Long>{


}
