package com.bazinga.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bazinga.ecommerce.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Modifying
	@Query(value ="UPDATE Cart c set c.quantity = ?2 where c.product_Id=?1 ", nativeQuery= true)
	public void updateQuantity(int productId, int quantity);
}
