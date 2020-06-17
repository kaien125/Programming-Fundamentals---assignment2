import java.util.ArrayList;

public class Customer extends User {
	private String phone;
	private double fund;
	private ArrayList<Content> contents;
	//introduce a boolean variable to check if the customer is premium
	private boolean premium;
	
	public Customer(String id, String name, String phone, double fund) {
		super(id, name);
		this.phone = phone;
		this.fund = fund;	 
		contents = new ArrayList<Content>();
		premium = false;
	}
	
	
	public Customer(String id, String name, String phone) {
		this(id, name, phone, 50); 
	}
	
	
	public String getPhone() {
		return phone;
	}
	
	
	public double getFund() {
		return fund;
	}
	
	
	//setter for premium
	public boolean isPremium() {
		return premium;
	}
	
	
	public ArrayList<Content> getContents() {
		return contents;
	}
	
	
	public void addContent(Content content) {
		contents.add(content);
	}
	
	
	//deduct amount from fund
	public boolean cost(double amount) {
		if(fund >= amount) {
			fund -= amount;
			
			return true;
		}
		else {
			System.out.println(getId() + " " + getName() + " not enough found.");
			
			return false;
		}
	}
	
	
	public boolean download (Content content) {
		//use nested if-else to check fund and premium
		if (premium) {
			//price for premium customer is 20% off
			//round to two decimal places for discounted price
			double discountPrice = Math.round(content.getPrice() * 0.8 * 100.0) / 100.0;
			
			if (discountPrice <= fund) {
				cost(discountPrice);
				
				content.addDownload();
				
				addContent(content);
				
				System.out.println("Premium customer " + getId() + " " + getName() + " downloaded " + content.getId() + " " + content.getName() + " for discount price $" + discountPrice + ".");
				
				return true;
			}
			else {
				System.out.println("Premium customer " + getId() + " "  + getName() + " download " + content.getId() + " " + content.getName() + " fail.");
				
				return false;		
				}
		}
		//full price for non premium customer
		else {
			if (content.getPrice() <= fund) {
			cost(content.getPrice());
			
			content.addDownload();
			
			addContent(content);
			
			System.out.println("Customer " + getId() + " " + getName()  + " downloaded " + content.getId() + " " + content.getName()  + " for $" + content.getPrice() + ".");
			
			return true;
			}
			else {
				System.out.println("Customer " + getId() + " " + getName()  + " download " +  content.getId() + " " + content.getName()  + " fail.");
				
				return false;		
			}	
		}
	}
				
	
	//method overloading for bulk download
	public boolean download (Content[] list) {
		double tol_price = 0;
		
		//calculate a sum price of contents in the list
		for(Content content : list) {
			tol_price += content.getPrice();
		}
		
		//use nested if-else to check fund and premium
		if (premium) {
			//price for premium customer is 20% off
			//round to two decimal places for discounted price
			double discont_tol_price = Math.round(tol_price * 0.8* 100.0) / 100.0;
			
			if (discont_tol_price <= fund) {
				cost(discont_tol_price);
				
				for(Content content : list) {
					content.addDownload();
					
					addContent(content);
				}
				System.out.println("Premium customer " + getId() + " " + getName()  + " bulk downloaded for total discount price $" + discont_tol_price + ".");
				
				return true;
			}
			else {		
				System.out.println("Premium customer " + getId() + " " + getName()  + " bulk download fail.");
				
				return false;
			}
		}
		//full price for non premium customer
		else {
			if (tol_price <= fund) {
				cost(tol_price);
				
				for(Content content : list) {
				content.addDownload();
				
				addContent(content);
				}
				
				System.out.println("Customer " + getId() + " " + getName()  + " bulk downloaded for total price $" + tol_price + ".");
				
				return true;
			}
			else {
				System.out.println("Customer " + getId() + " " + getName()  + " bulk download fail.");
				
				return false;
			}	
		}
	}

	
	//use for loop and ArrayList to print all contents downloaded by this customer
	public void showDownloads() {
		System.out.println("Contents downloaded by " + getId() + " " + getName()  + ": ");
		
		for(Content content : contents) {
			System.out.println(content.getId() + " " + content.getName());
		}
	}
	
	//deduct 100 from fund and change premium to true
	public boolean becomePremium() {
			if(cost(100)) {
				premium = true;
				
				System.out.println(getId() + " " + getName()  + " upgraded to premium.");
				
				return true;	
			}
			else {
				System.out.println(getId() + " " + getName()  + " upgraded fail.");
				
				return false;			
			}
	}
}	