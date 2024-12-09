package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	ItemService itservice;
	
	@PostMapping("/additem")
	public Item regItem(@RequestBody Item it) {
		return itservice.addItem(it);
	}
	
	@GetMapping("/getitems")
	public List<Item> getIt(){
		return itservice.getItem();
	}
	
	@DeleteMapping("/deleteitem/{id}")
	public ResponseEntity<String> deleteIt(@PathVariable Integer id) {
	    if (itservice.existsById(id)) { 
	        itservice.deleteItem(id);
	        return ResponseEntity.ok("Item has been successfully deleted.");
	    } 
	    else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item with ID " + id + " not found.");
	    }
	}

	
	@PutMapping("/updateitem")
	public ResponseEntity<?> updateIt(@RequestBody Item item) {
	    if (itservice.existsById((int) item.getId())) 
	    {
	        Item updatedItem = itservice.UpdateItem(item);
	        return ResponseEntity.ok(updatedItem);
	    } 
	    else 
	    {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item with ID " + item.getId() + " not found.");
	    }
	}

	
}
