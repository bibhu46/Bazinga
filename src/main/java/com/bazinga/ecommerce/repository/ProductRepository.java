package com.bazinga.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bazinga.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
