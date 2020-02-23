package com.brian.demo.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.brian.demo.entities.Item;
import com.brian.demo.repositories.ItemRepository;
import com.mongodb.util.JSON;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/items")
public class ItemController {
	
    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    @PutMapping
    public void updateItem(@Valid @RequestBody Item item){ 	
    	itemRepository.save(item);
    }
    
    @GetMapping
    public List<Item> getItems() {
        return (List<Item>) itemRepository.findAll();
    }

    @PostMapping
    void addItem(@Valid @RequestBody Item item) {
        itemRepository.save(item);
      
    }
    
    @DeleteMapping("/{id}")
    void DeleteItem(@PathVariable long id) {
    	try {
        itemRepository.deleteById(id);}
        
    	catch(EmptyResultDataAccessException exc){
    		 throw new ResponseStatusException(
    		           HttpStatus.NOT_FOUND, "Id Not Found", exc);
    	}
    }
		
		
}
