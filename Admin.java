import java.util.Scanner;

public class Admin extends User {
	private String passWord;
	private int level;

	public Admin(String id, String name, String passWord, int level) {
		super(id, name);
		this.passWord = passWord;
		this.level = level;
	}

	
	public int getLevel() {
		return level;
	}

	
	public String getPassword() {
		return passWord;
	}

	
	public boolean login() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Please input password for Admin " + getId() + " " + getName() + ":");

		String pass = sc.nextLine();

		// compare input with password
		if (pass.equals(getPassword())) {
			System.out.println("Admin " + getId() + " " + getName() + " Login successful.");
			return true;
		} 
		else {
			System.out.print("Admin " + getId() + " " + getName() + " Login fail.");
			return false;
		}
	}

	
	public boolean download(Content content) {
		System.out.println("Admin cannot download content.");
		return false;
	}
}