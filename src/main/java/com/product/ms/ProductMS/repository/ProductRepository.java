package com.product.ms.ProductMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.ms.ProductMS.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
	
}
