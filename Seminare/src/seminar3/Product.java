package seminar3;

public class Product 
{
	private String ProductName;
	private double ProductPrice;
	
	public Product(String productName,double productPrice)
	{
		ProductName = productName;
		ProductPrice = productPrice;
		
	}
	public String getName()
	{
		return ProductName;
	}
	public double getPrice()
	{
		return ProductPrice;
	}
	public void reducePrice(double disscount)
	{
		ProductPrice -= disscount;
	}
	
	public static void main(String[]args)
	{
		Product product1 = new Product("Bread",10);
		
		System.out.println("Product name: " + product1.getName());
		System.out.println("Product price: " + product1.getPrice());
		  product1.reducePrice(5);
		System.out.println("Product price after disscount: " + product1.getPrice());
	
		Product product2 = new Product("Milk",15.5);
		System.out.println("Product name: " + product2.getName());
		System.out.println("Product price: " + product2.getPrice());
		  product2.reducePrice(5.4);
		System.out.println("Product price after disscount: " + product2.getPrice());
	
	
	}
	
	
	

}
