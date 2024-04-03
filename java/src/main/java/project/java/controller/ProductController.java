package project.java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.java.beans.Product;
import project.java.exception.ProductNotFoundException;
import project.java.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	static int id=1;
	
	
	@PostMapping(path = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> addProduct(@RequestBody Product product){
		product.setProductId(id);
		Product p = productService.addProduct(product);
		id++;
		return ResponseEntity.status(201).body(p);
	}
	
	@GetMapping(path = "/getProducts")
	public ResponseEntity<Object> getProducts(){
		
		List<Product> p = productService.getProducts();
		
		return ResponseEntity.status(200).body(p);
		
	}
	
	@GetMapping(path = "/generateBills")
	public ResponseEntity<Object> generateBills(){
		
		Map<String,Object> p = productService.generateBills();
		
		return ResponseEntity.status(200).body(p);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteProfile(@PathVariable int id) {
		try {
			productService.deleteProduct(id);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
	}

}
