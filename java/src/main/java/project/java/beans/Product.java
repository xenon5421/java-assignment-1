package project.java.beans;

public class Product {

int productId;
int price;
String productName;
int quantity;

public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Product(int productId, int price, String productName) {
	super();
	this.productId = productId;
	this.price = price;
	this.productName = productName;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Product [productId=" + productId + ", price=" + price + ", productName=" + productName + "]";
}

}
