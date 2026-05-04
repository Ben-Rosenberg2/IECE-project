package pwchk;
import java.util.Scanner;

public class pwchecker {
	//starts with scanner input for main func
	// method for username creationv and scectrity
	// method for password creation and security
	// separate method to iterate through characters for uppercase (used by both)
	// separate method to iterate through characters for number (used by both)
	// final method for checking both properly
	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        String username;
	        String password;
	        System.out.println("Create Account:");
	        // Create username
	        username = createUsername(input);
	        // Create password
	        password = createPassword(input);
	        System.out.println();
	        System.out.println("Account created successfully!");
	        System.out.println();
	        // Login section
	        login(input, username, password);
	        input.close();
	    }
	    // Method to create username
	    public static String createUsername(Scanner input) {
	        String username;
	        boolean validUsername = false;
	        do {
	            System.out.print("Create username: ");
	            username = input.nextLine();
	            if (username.length() <= 3) {
	                System.out.println("Username is too short.");
	            }
	            else if (!hasNumber(username)) {
	                System.out.println("Username needs a number.");
	            }
	            else {
	                System.out.println("Username is accepted.");
	                validUsername = true;
	            }
	        } while (validUsername == false);
	        return username;
	    }
	    // Method to create password
	    public static String createPassword(Scanner input) {
	        String password;
	        boolean validPassword = false;
	        do {
	            System.out.print("Create password: ");
	            password = input.nextLine();

	            if (password.length() <= 8) {
	                System.out.println("Password is too short.");
	            }
	            else if (!hasNumber(password)) {
	                System.out.println("Password needs a number.");
	            }
	            else if (!hasUppercase(password)) {
	                System.out.println("Password needs an uppercase letter.");
	            }
	            else {
	                System.out.println("Password accepted.");
	                validPassword = true;
	            }
	        } while (validPassword == false);
	        return password;
	    }
	    // Method to check if text has a number
	    public static boolean hasNumber(String text) {
	        for (int i = 0; i < text.length(); i++) {
	            char ch = text.charAt(i);
	            if (ch >= '0' && ch <= '9') {
	                return true;
	            }
	        }
	        return false;
	    }
	    // Method to check if text has uppercase letter
	    public static boolean hasUppercase(String text) {
	        for (int i = 0; i < text.length(); i++) {
	            char ch = text.charAt(i);
	            if (ch >= 'A' && ch <= 'Z') {
	                return true;
	            }
	        }
	        return false;
	    }
	    // Method for login system
	    public static void login(Scanner input, String correctUsername, String correctPassword) {
	        int attempts = 0;
	        boolean loggedIn = false;
	        System.out.println("=== Login ===");
	        while (attempts < 3 && loggedIn == false) {
	            System.out.print("Enter username: ");
	            String enteredUsername = input.nextLine();
	            System.out.print("Enter password: ");
	            String enteredPassword = input.nextLine();
	            if (enteredUsername.equals(correctUsername) && enteredPassword.equals(correctPassword)) {
	                System.out.println("You are logged in.");
	                loggedIn = true;
	            }
	            else {
	                attempts++;
	                System.out.println("Username or password is incorrect.");
	                System.out.println("Attempts used: " + attempts + "/3");
	            }
	        }
	        if (loggedIn == false) {
	            System.out.println("You are locked out.");
	        }
	    }
	}
	
	
