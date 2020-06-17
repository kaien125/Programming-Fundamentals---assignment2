public class Comment {
	private Customer customer;
	private String comment;
	private int rating;

	// four constructors for different signatures
	public Comment(Customer customer, int rating) {
		this.customer = customer;
		this.rating = rating;
	}

	
	public Comment(Customer customer, String comment) {
		this.customer = customer;
		this.comment = comment;
	}

	
	public Comment(Customer customer, int rating, String comment) {
		this(customer, rating);
		this.comment = comment;
	}

	
	public Comment(Customer customer, String comment, int rating) {
		this(customer, comment);
		this.rating = rating;
	}

	
	public String getComment() {
		return comment;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	
	public int getRating() {
		return rating;
	}
}