package com.product.ms.ProductMS.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.ms.ProductMS.dto.ProductRequest;
import com.product.ms.ProductMS.dto.ProductResponse;
import com.product.ms.ProductMS.model.Product;
import com.product.ms.ProductMS.repository.ProductRepository;

@Service
public class ProductService {
	
	private final Logger log = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest) {
		
		Product product = new Product();
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
			
		productRepository.save(product);
		
		log.info("Product Saved!!!");
	}
	
	public List<ProductResponse> getAllProducts(){
		List<Product> productList =  productRepository.findAll();
		
		return productList.stream().map(this::mapToProductResponse).toList();
	}
	
	private ProductResponse mapToProductResponse(Product product) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setDescription(product.getDescription());
		productResponse.setPrice(product.getPrice());
		
		return productResponse;
	}
}
