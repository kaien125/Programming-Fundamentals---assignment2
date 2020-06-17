public class Application extends Content {
	private String os;

	public Application(String id, String name, double price, String os) {
		super(id, name, price);
		this.os = os;
	}

	
	public Application(String id, String name, String os) {
		this(id, name, 0, os);
	}

	
	public String getOs() {
		return os;
	}
}
