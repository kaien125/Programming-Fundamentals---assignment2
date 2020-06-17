//User cannot be instantiated
public abstract class User {
	private String id;
	private String name;

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	
	public String getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	
	public void changeName(String newName) {
		name = newName;
		
		System.out.println("Name of " + getId() + " has been changed to " + getName());
	}
	
	
	public abstract boolean download(Content content);
}