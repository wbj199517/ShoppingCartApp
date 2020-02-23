package com.brian.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brian.demo.entities.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long>{} 

