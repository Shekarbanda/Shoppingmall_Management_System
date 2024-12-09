package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;


@Service
public class ItemService {
	
	@Autowired
	public ItemRepository irepo;
	
	//adding data
	public Item addItem(Item it) {
		return irepo.save(it);
	}
	
	//getting data
	public List<Item> getItem(){
		
		return irepo.findAll();
	}
	
	//deleting data
	public void deleteItem(int id) {
		irepo.deleteById(id);
	}
	
	//update data
	public Item UpdateItem(Item item) {
		long itemid = item.getId();
		Item item1 = irepo.findById((int) itemid).get();
		item1.setName(item.getName());
		return irepo.save(item);
	}

	public boolean existsById(Integer id) {
		return irepo.existsById(id);
	}
	
}
