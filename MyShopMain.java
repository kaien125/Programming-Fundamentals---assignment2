// My name: Wenkai LI
// My student ID: s3815738
// The highest level I've completed is: HD 

import java.util.Scanner;

public class MyShopMain {
	public static void main(String[] args) {

		// *************** PASS LEVEL ***************
		// *********************************************
		/// *

		MyShop shop = new MyShop();

		// creating new contents
		Content con1 = new Application("con1", "Map", 6.4, "androidV4");

		Content con4 = new Application("con4", "Map", "androidV4");

		String[] authors4 = { "Tom", "Jerry" };
		Content con2 = new Book("con2", "Cook Book", 14.7, "MIT Press", 200, authors4);

		Content con3 = new Magazine("con3", "Science", 13.99, "Science Media", 50, 202005);

		// adding new contents to the shop
		shop.addContent(con1);
		shop.addContent(con2);
		shop.addContent(con3);
		shop.addContent(con4);

		// creating new users
		User u1 = new Customer("u1", "warmguy", "0567000", 200);
		User u2 = new Customer("u2", "alwaysaynever", "0433542");
		Admin u3 = new Admin("u3", "Paul", "beatles123", 3);

		// add new user to the shop
		shop.addUser(u1);
		shop.addUser(u2);
		shop.addUser(u3);

		u1.download(con1);
		u2.download(con2);
		u3.download(con3);

		u1.changeName("kindguy");
		u3.changeName("John");

		con1.setPrice(u3.login(), 14.25);
		shop.setPrice(u3.login(), u3.getLevel(), -0.10);

		// create new publications
		String[] authors1 = { "L. Tolstoy" };
		Book b1 = new Book("b1", "War and Peace", 12.55, "The Russian Messenger", 1225, authors1);

		String[] authors2 = { "F. Scott Fitzgerald" };
		Book b2 = new Book("b2", "The great gatsby", 10, "Charles Scribner's Sons", 180, authors2);

		String[] authors3 = { "Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein" };
		Book b3 = new Book("b3", "Introduction to algorithms", 100, "MIT Press", 1312, authors3);

		Magazine m1 = new Magazine("m1", "Forbes", 8.99, "Forbes Media", 50, 201904);

		// add new publications to the shop
		shop.addContent(b1);
		shop.addContent(b2);
		shop.addContent(b3);
		shop.addContent(m1);

		// create new applications
		Application g1 = new Application("g1", "Pokemon", 5.3, "androidV4");
		Application g2 = new Application("g2", "Pokemon", 5, "iOSV10");
		// a free app
		Application app1 = new Application("app1", "Calendar", "androidV3");

		// add new applications to the shop
		shop.addContent(g1);
		shop.addContent(g2);
		shop.addContent(app1);

		shop.showContent();

		// */
		// *************** CREDIT LEVEL ***************
		// ******** disable me if not completed ********
		/// *

		// Adding new customers
		Customer c1 = new Customer("c1", "coolguy", "0412000", 200);
		Customer c2 = new Customer("c2", "neversaynever", "0433191");
		Customer c3 = new Customer("c3", "Hello 123", "0413456", 1000);
		Customer c4 = new Customer("c4", "Jackie Chan", "0417654");

		shop.addUser(c1);
		shop.addUser(c2);
		shop.addUser(c3);
		shop.addUser(c4);

		// Adding new admins
		Admin a1 = new Admin("a1", "SuperBlack", "opensesame", 10);
		Admin a2 = new Admin("a2", "Adele", "kitty123", 3);

		shop.addUser(a1);
		shop.addUser(a2);

		shop.showUser();

		// change the user name
		c2.changeName("neversaybye");
		a1.changeName("superblack");

		shop.showUser();

		// */
		// ************* DISTINCTION LEVEL *************
		// ******** disable me if not completed ********
		/// *

		Comment comment1 = new Comment(c1, "This is a fantastic game!");
		g1.addReview(comment1);

		Comment comment2 = new Comment(c2, 5);
		g1.addReview(comment2);

		Comment comment3 = new Comment(c3, 3, "This is an average game!");
		g1.addReview(comment3);

		Comment comment4 = new Comment(c4, "I quite like this game!", 4);
		g1.addReview(comment4);
		
		Comment comment5 = new Comment(c2, "I quite like this game!", 4);
		g2.addReview(comment5);

		g1.addReview(new Comment(c3, "The game crashes frequently"));

		b1.addReview(new Comment(c2, "I love Tolstoy!"));
		
		con1.addReview(new Comment(c1, "I like this one.", 5));
		
		con2.addReview(new Comment(c2, 5, "I like this one."));
		
		con3.addReview(new Comment(c3, 5));

		// show comments for g1
		g1.showReviews();
		// show comments for b1
		b1.showReviews();

		// show all comments ever made
		shop.showAllReviews();

		// Simulating transactions, showing content etc etc.
		// They can be driven by menu input as well.
		if (c1.download(b1))
			System.out.println(c1.getName() + " bought " + b1.getName());
		else
			System.out.println("Not enough fund");

		c1.download(b3);
		c1.download(m1);

		// show c1's downloads
		c1.showDownloads();

		c2.download(m1);
		c3.download(m1);

		// show number of downloads of m1
		m1.showDownloads();

		// show all comments ever made
		shop.showDownloads();

		// */
		// ************** HD LEVEL **************
		// ******** disable me if not completed ********
		/// *

		c3.becomePremium();
		c3.download(b1);
		c3.download(g1);
		shop.showDownloads();

		c4.download(g1);
		c4.becomePremium();
		c4.download(m1);
		shop.showDownloads();

		Customer c5 = new Customer("c5", "neverenough", "0486734", 2000);
		Content[] list = { b1, b2, b3, m1, g1, g2, app1 };

		// download many items in one go
		c5.download(list);
		shop.showDownloads();

		// an admin can reset the price for an item
		b1.setPrice(a2.login(), 14.25);

		// an admin with level > 5 bulk reduces all prices by 10%
		shop.setPrice(a1.login(), a1.getLevel(), -0.10);
		shop.setPrice(a2.login(), a2.getLevel(), -0.10);
		// */

		// ************************ Menu ***************************
		// Write a menu driven part to allow keyboard input
		// Input validation is a must
		// You may define method(s) for menu handling
		// **********************************************************

		String shopMenu[] = { "\n Please select:", " -------------------------", "  Add Contents Options:",
				" -------------------------", "     (1) Add Application", "\n     (2) Add Book",
				"\n     (3) Add Magazine", " -------------------------", "  Show Options", " -------------------------",
				"     (4) Show All Contents", "\n     (5) Show All Users", "\n     (6) Show All downloads ",
				"\n     (7) Show All comments ", " -------------------------", "  Other Options",
				" -------------------------", "     (8) Quite " };

		boolean menuValid = false;
		int shopOption = 0;

		Scanner sc = new Scanner(System.in);

		// use while loop to show the menu
		while (shopOption != 8) {
			for (int i = 0; i < shopMenu.length; i++)
				System.out.println(shopMenu[i]);
			// use do-while loop for input validating
			do {
				// use try-catch to handle exceptions
				try {
					shopOption = Integer.parseInt(sc.nextLine());

					menuValid = true;
					// print prompt message when exception occurs
				} 
				catch (Exception eMenu) {
					System.out.println("Invalid input.");
					System.out.println("Please select from 1 to 8.");

					// when exception occurs, print menu again
					for (int i = 0; i < shopMenu.length; i++)
						System.out.println(shopMenu[i]);

					// set menu_valid to false to go back to the do-while loop
					menuValid = false;
				}
			} while (!menuValid);

			switch (shopOption) {
			case 1:
				boolean appPriceValid = false;
				double appPrice = 0;

				System.out.println("Adding new Application. Please input:");
				System.out.println("Application ID:");

				String appId = sc.nextLine();

				System.out.println("Application Name:");

				String appName = sc.nextLine();

				// use do-while loop to recover when exception occurs
				do {
					try {
						System.out.println("Application price (if free, please enter 0):");

						appPrice = Double.parseDouble(sc.nextLine());

						appPriceValid = true;
					} 
					catch (Exception eApp) {
						System.err.println("Invalid input.");
						System.out.println("Please input a number for price.");
						System.out.println("");
					}
				} while (!appPriceValid);

				System.out.println("Application Operating System: ");

				String appOs = sc.nextLine();

				Application app = new Application(appId, appName, appPrice, appOs);

				shop.addContent(app);
				break;
			case 2:
				boolean bookPriceValid = false;
				double bookPrice = 0;

				System.out.println("Adding new Book. Please input:");
				System.out.println("Book ID:");

				String bookId = sc.nextLine();

				System.out.println("Book Name:");

				String bookName = sc.nextLine();

				// use do-while loop to recover when exception occurs
				do {
					try {
						System.out.println("Book price (if free, please enter 0):");

						bookPrice = Double.parseDouble(sc.nextLine());

						bookPriceValid = true;
					} 
					catch (Exception eBook) {
						System.err.println("Invalid input.");
						System.out.println("Please input a number for price.");
						System.out.println("");
					}
				} while (!bookPriceValid);

				System.out.println("Book Publisher: ");
				String bookPublisher = sc.nextLine();

				int bookPage = 0;
				boolean bookPageValid = false;

				// use do-while loop to recover when exception occurs
				do {
					try {
						System.out.println("Book Page: ");

						bookPage = Integer.parseInt(sc.nextLine());

						bookPageValid = true;
					} 
					catch (Exception eMag) {
						System.err.println("Invalid input.");
						System.out.println("Please input a number for page.");
						System.out.println("");
					}
				} while (!bookPageValid);

				System.out.println("Book Author (Use ',' to separate different authors): ");

				String bookAuthors = sc.nextLine();

				String[] bookAuthorList = bookAuthors.split(",");

				Book book = new Book(bookId, bookName, bookPrice, bookPublisher, bookPage, bookAuthorList);

				shop.addContent(book);
				break;
			case 3:
				System.out.println("Adding new Magazine. Please input:");
				System.out.println("Magazine ID:");

				String magId = sc.nextLine();

				System.out.println("Magazine Name:");
				
				String magName = sc.nextLine();

				double magPrice = 0;
				boolean magPriceValid = false;

				// use do-while loop to recover when exception occurs
				do {
					try {
						System.out.println("Magazine price (if free, please enter 0):");

						magPrice = Double.parseDouble(sc.nextLine());

						magPriceValid = true;
					} 
					catch (Exception eMag) {
						System.err.println("Invalid input.");
						System.out.println("Please input a number for price.");
						System.out.println("");
					}
				} while (!magPriceValid);

				System.out.println("Magazine Publisher: ");
				String magPublisher = sc.nextLine();

				int magPage = 0;
				boolean magPageValid = false;

				// use do-while loop to recover when exception occurs
				do {
					try {
						System.out.println("Magazine Page: ");

						magPage = Integer.parseInt(sc.nextLine());

						magPageValid = true;
					} 
					catch (Exception eMag) {
						System.err.println("Invalid input.");
						System.out.println("Please input a number for page.");
						System.out.println("");
					}
				} while (!magPageValid);

				int magVolum = 0;
				boolean magVolumValid = false;

				// use do-while loop to recover when exception occurs
				do {
					try {
						System.out.println("Magazine Volum: ");

						magVolum = Integer.parseInt(sc.nextLine());

						magVolumValid = true;
					} 
					catch (Exception eMag) {
						System.err.println("Invalid input.");
						System.out.println("Please input a number for volum.");
						System.out.println("");
					}
				} while (!magVolumValid);

				Magazine mag = new Magazine(magId, magName, magPrice, magPublisher, magPage, magVolum);

				shop.addContent(mag);
				break;
			case 4:
				shop.showContent();
				break;
			case 5:
				shop.showUser();
				break;
			case 6:
				shop.showDownloads();
				break;
			case 7:
				shop.showAllReviews();
				break;
			case 8:
				System.out.println("Quiting...");
				System.exit(0);
			default:
				System.out.println("Wrong option. Please select 1 to 8.");
			}
		}
	}
}