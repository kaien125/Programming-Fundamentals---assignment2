public class Magazine extends Publication {
	private int volume;

	public Magazine(String id, String name, double price, String publisher, int page, int volume) {
		super(id, name, price, publisher, page);
		this.volume = volume;
	}

	
	public int getVolume() {
		return volume;
	}
}