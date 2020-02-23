package com.brian.demo.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;

@Entity
public class Item {

	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    
    
    @NotNull(message = "Name cannot be null")
    private final String name;
    
    @Min(value = 0, message = "Amount should not be less than 0")
    @Max(value = 999, message = "Amount should not be greater than 999")
    private int amount;
    
    
    
    
    public Item() {
        this.name = "";
        this.amount = 0;
    }
    
    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
    	this.amount = amount;
    }
    
    
    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + ", amount=" + amount + '}';
    }

}
