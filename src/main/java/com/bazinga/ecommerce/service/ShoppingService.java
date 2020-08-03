package com.bazinga.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazinga.ecommerce.exception.ProductNotFoundException;
import com.bazinga.ecommerce.model.Cart;
import com.bazinga.ecommerce.model.OrderedProduct;
import com.bazinga.ecommerce.model.Product;
import com.bazinga.ecommerce.model.WebResponse;
import com.bazinga.ecommerce.repository.CartRepository;
import com.bazinga.ecommerce.repository.ProductRepository;

@Service
public class ShoppingService {

	@Autowired
	CartRepository cartRepo;
	@Autowired
	ProductRepository productRepo;

	public List<Product> showAllProducts() {
		return productRepo.findAll();
	}

	public WebResponse addProductToCart(OrderedProduct ordProduct) {

		for (Product p : ordProduct.getProducts()) {
			Optional<Product> prd = productRepo.findById(p.getProductId());
			if (prd.isPresent()) {
				Cart cart = new Cart(p.getName(), p.getProductId(), p.getQuantity(), p.getPrice()*p.getQuantity());
				cartRepo.save(cart);
			} else {
				throw new ProductNotFoundException("the selected product doesn't exist.");
			}

		}
		WebResponse webResponse = new WebResponse();
		webResponse.setMessage("Products added to cart");
		webResponse.setStatus("success");
		return webResponse;

	}
	
	public Product updateQuantityInCart(int productId, int quantity) {
		cartRepo.updateQuantity(productId, quantity);
		Product p = new Product();
		p.setProductId(productId);
		p.setName(cartRepo.findById(productId).get().getProductName());
		p.setQuantity(cartRepo.findById(productId).get().getQuantity());
		return p;
		}
	}

