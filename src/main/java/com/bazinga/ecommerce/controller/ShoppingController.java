package com.bazinga.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bazinga.ecommerce.model.Cart;
import com.bazinga.ecommerce.model.OrderedProduct;
import com.bazinga.ecommerce.model.Product;
import com.bazinga.ecommerce.model.WebResponse;
import com.bazinga.ecommerce.service.ShoppingService;

@RestController
public class ShoppingController {
	
	@Autowired
	ShoppingService service;

	@GetMapping(value ="/products")
	public List<Product> showAllProducts(){
		return service.showAllProducts();
	}
	
	@PostMapping(value ="/addItems")
	public ResponseEntity<WebResponse> addItemsToCart(@RequestBody OrderedProduct ordProduct) {
		WebResponse webResponse = service.addProductToCart(ordProduct);
		return new ResponseEntity<>(webResponse, HttpStatus.OK);
	}
	
	@PutMapping(value ="/updateQuantity/{productId}/{quantity}")
	public Product updateQuantity(@PathVariable int productId, @PathVariable int quantity) {
		return service.updateQuantityInCart(productId, quantity);
	}
	
	@GetMapping(value ="/showCart")
	public List<Cart> showCart(){
	return service.viewCart();
	}
}
