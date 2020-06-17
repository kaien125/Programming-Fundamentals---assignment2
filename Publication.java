//Publication cannot be instantiated
public abstract class Publication extends Content {
	private String publisher;
	private int page;

	public Publication(String id, String name, double price, String publisher, int page) {
		super(id, name, price);
		this.publisher = publisher;
		this.page = page;
	}

	
	public String getPublisher() {
		return publisher;
	}

	
	public int getPage() {
		return page;
	}
}