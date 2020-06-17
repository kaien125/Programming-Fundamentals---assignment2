public class Book extends Publication {
	private String[] authors;

	public Book(String id, String name, double price, String publisher, int page, String[] authors) {
		super(id, name, price, publisher, page);
		this.authors = authors;
	}

	
	public String[] getAuthors() {
		return authors;
	}
}
