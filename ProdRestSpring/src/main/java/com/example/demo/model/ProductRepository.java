package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	List<Product> findByProductname(String name);

	List<Product> findByPrice(int price);

	List<Product> findByOrderByPriceAsc();
	void deleteByPrice(int prc);

}
