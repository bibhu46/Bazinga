package com.bazinga.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bazinga.ecommerce.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	
}
