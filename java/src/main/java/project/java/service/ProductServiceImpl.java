package project.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import project.java.beans.Product;
import project.java.exception.ProductNotFoundException;

@Service
public class ProductServiceImpl implements ProductService{

	private static List<Product> productList = new ArrayList<Product>();
	
	@Override
	public Product addProduct(Product product) {
		productList.add(product);
		return product; 
	}

	@Override
	public List<Product> getProducts() {
		return productList;
	}

	@Override
	public Map<String, Object> generateBills() {

		Map<String,Object> bill = new HashMap<>();
		
		long finalPrice=0;
		for(Product p : productList) {
			long total =0;
			total= p.getQuantity()*p.getPrice();
			long cgst=(long) (total*0.09);
			long sgst=cgst*2;
			System.out.println("gst "+cgst);
			finalPrice=total+cgst+sgst;
			bill.put("Product ID", p.getProductId());
			bill.put("Product", p.getProductName());
			bill.put("Quantity", p.getQuantity());
			bill.put("Price", finalPrice);
		}
		
		return bill;
	}
	
	@Override
	public void deleteProduct(int id) throws ProductNotFoundException {
		Product p = findById(id);
		productList.remove(p);
	}
	
public Product findById(int id) throws ProductNotFoundException {
		
		return productList.stream()
		.filter(x-> x.getProductId() == id)
		.findFirst()
		.orElseThrow(()->new ProductNotFoundException(
				"sorry "+id+" not found"));		
	}


}
