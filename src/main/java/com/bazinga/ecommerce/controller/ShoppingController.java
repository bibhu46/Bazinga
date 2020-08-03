package com.bazinga.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bazinga.ecommerce.model.Product;
import com.bazinga.ecommerce.service.ShoppingService;

@RestController
public class ShoppingController {
	
	@Autowired
	ShoppingService service;

	@GetMapping(value ="/products")
	public List<Product> showAllProducts(){
		return service.showAllProducts();
	}
}
