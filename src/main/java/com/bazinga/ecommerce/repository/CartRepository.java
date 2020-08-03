package com.bazinga.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bazinga.ecommerce.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	
}
