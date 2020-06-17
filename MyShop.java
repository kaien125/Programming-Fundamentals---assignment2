import java.util.ArrayList;

public class MyShop {
	private ArrayList<Content> contents;
	private ArrayList<User> users;

	public MyShop() {
		contents = new ArrayList<Content>();
		users = new ArrayList<User>();
	}

	
	public void addContent(Content content) {
		contents.add(content);

		// print out adding message according to subclass
		if (content instanceof Application)
			System.out.println("Application " + content.getId() + " " + content.getName() + " has been added.");
		else if (content instanceof Book)
			System.out.println("Book " + content.getId() + " " + content.getName() + " has been added.");
		else if (content instanceof Magazine)
			System.out.println("Magazine " + content.getId() + " " + content.getName() + " has been added.");
	}

	
	public void showContent() {
		System.out.println("Contents in this shop:");

		// print out content id and name according to subclass
		for (Content i : contents) {
			if (i instanceof Application)
				System.out.println("Application ID: " + i.getId() + " | Application Name: " + i.getName());
			else if (i instanceof Book)
				System.out.println("Book ID: " + i.getId() + " | Book Name: " + i.getName());
			else if (i instanceof Magazine)
				System.out.println("Magazine ID: " + i.getId() + " | Magazine Name: " + i.getName());

		}
	}

	
	// show download numbers of all contents in the shop
	public void showDownloads() {
		System.out.println("Downloads in this shop: ");

		for (Content i : contents) {
			System.out.println(i.getId() + " " + i.getName() + " downloaded " + i.getDownload() + " times");
		}
	}

	
	public void addUser(User user) {
		users.add(user);

		// print out adding message according to subclass
		if (user instanceof Customer)
			System.out.println("Customer " + user.getId() + " " + user.getName() + " has been added.");
		else if (user instanceof Admin)
			System.out.println("Admin " + user.getId() + " " + user.getName() + " has been added.");
	}

	
	// print all users id and name in the shop
	public void showUser() {
		System.out.println("Users in this shop:");

		// print out user id and name according to subclass
		for (User i : users) {
			if (i instanceof Customer)
				System.out.println("Customer ID: " + i.getId() + " | Customer Name: " + i.getName());
			else if (i instanceof Admin)
				System.out.println("Admin ID: " + i.getId() + " | Admin Name: " + i.getName());
		}
	}

	
	// print comments for all contents in the shop
	public void showAllReviews() {
		System.out.println("Comments for all contents in this shop:");

		// print comments if the content has comment
		for (Content i : contents) {
			if (i.getComments().size() != 0)
				i.showReviews();
		}
	}

	
	// adjust price in bulk
	// use return value of admin.login() as boolean parameter login
	// double parameter discount should be negative
	public boolean setPrice(boolean login, int level, double discount) {
		if (login & (level > 5)) {
			System.out.println("Level satisfied.");

			for (Content i : contents) {
				i.setPrice(i.getPrice() * (1 + discount));
			}

			System.out.println("Bulk price changed.");

			return true;
		} 
		else {
			System.out.println("Bulk price not changed.");

			return false;
		}
	}
}