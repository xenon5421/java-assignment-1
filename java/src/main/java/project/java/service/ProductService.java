package project.java.service;

import java.util.List;
import java.util.Map;

import project.java.beans.Product;
import project.java.exception.ProductNotFoundException;

public interface ProductService {
	
	public Product addProduct(Product product);
	public List<Product> getProducts();
	public Map<String, Object> generateBills();
	void deleteProduct(int id) throws ProductNotFoundException;

}
