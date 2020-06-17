import java.util.ArrayList;

//Content cannot be instantiated
public abstract class Content {
	private String id;
	private String name;
	private int download;
	private double price;
	private ArrayList<Comment> comments;

	public Content(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
		download = 0;
		comments = new ArrayList<Comment>();
	}

	
	public String getId() {
		return id;
	}

	
	public double getPrice() {
		return price;
	}

	
	public int getDownload() {
		return download;
	}

	
	public String getName() {
		return name;
	}

	
	public ArrayList<Comment> getComments() {
		return comments;
	}

	
	public void addDownload() {
		download += 1;
	}

	
	//print download times
	public void showDownloads() {
		System.out.println(id + " " + name + " downloaded " + download + " times");
	}

	
	// use return value of admin.login() as boolean parameter login
	public boolean setPrice(boolean login, double newPrice) {
		if (login) {
			price = newPrice;
			System.out.println("Content " + id + " " + name + " Price changed.");
			return true;
		} 
		else {
			System.out.println("Content " + id + " " + name + " Price not changed.");
			return false;
		}
	}

	
	// a overloaded method for changing variable price
	public boolean setPrice(double newPrice) {
		price = newPrice;
		return true;
	}

	
	// add new comment to ArrayList comments
	public void addReview(Comment comment) {
		comments.add(comment);
		System.out.println("Comment for " + id + " " + name + " has been added.");
	}

	
	// use for loop to print comments in ArrayList comments
	public void showReviews() {
		System.out.println("Comment for " + id + " " + name + ":");
		for (Comment i : comments) {
			System.out.println(i.getComment());
		}
	}
}
