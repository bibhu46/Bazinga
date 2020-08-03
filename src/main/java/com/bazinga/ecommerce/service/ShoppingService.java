package com.bazinga.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazinga.ecommerce.model.Product;
import com.bazinga.ecommerce.repository.CartRepository;
import com.bazinga.ecommerce.repository.ProductRepository;

@Service
public class ShoppingService {

	@Autowired
	CartRepository cartRepo;
	@Autowired
	ProductRepository productRepo;
	
	public List<Product> showAllProducts(){
		return productRepo.findAll();
	}
	

}
