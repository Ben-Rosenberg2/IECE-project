package passwordcheck;
import java.util.Scanner;
import java.io.*;
public class passwordchecker {
    // main func: scanner & calls the methods for user creation, pwcreation, cesar shivt, and accountnymber
    // method to create the database file inside src/passwordcheck
    // method for username creation and security checks
    // method for password creation and uppercase/number/length checks
    // separate method to iterate through characters for number
    // separate method to iterate through characters for uppercase
    // final method for checking both username and password properly during login
    // method for countdown delay after wrong login attempt
    // method to encrypt username and password with Caesar shift of 10
	//method for IGNORING USER INPUT DURING COUNTDOWN LINES
    // method to write encrypted username and password to database file
    // method to count current accounts and create the next account number
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //start main scanner
        boolean programRunning = true;
        //while loop keeps the whole program running again after 3 failed login attempts
        while (programRunning == true) {
            createDatabaseFile(); //calls database creation method
            System.out.println("Create Your Account! :");
            String username = createUsername(input);  //calls user creation method
            String password = createPassword(input); //calls pw creation method
            String encryptedUsername = encryptText(username);  //sends user to cipher func
            String encryptedPassword = encryptText(password);  //sends pw to cipher function 
            int accountNumber = getNextAccountNumber(); //calls func to set the account nymber intiger 
            String fileContent = ""; //THIS IS WHAT MAKES THE TEXT FILE FUNCTIONAL THIS TOOK FOREVER
            fileContent = fileContent + "username " + accountNumber + ": " + encryptedUsername + "\n";
            fileContent = fileContent + "password " + accountNumber + ": " + encryptedPassword + "\n";
            fileContent = fileContent + "\n";
            fileWrite(fileContent);
            System.out.println();
            System.out.println("Account created successfully.");
            System.out.println("Encrypted account was saved to database.txt.");
            System.out.println();
            login(input, username, password); //CALLS Tthe login function
            System.out.println();
            System.out.println("Restarting program...");
            System.out.println();
        }
        input.close();
    }
    // this method creates the database file if it does not already exist
    public static void createDatabaseFile() {
        try {
            File folder = new File("src/passwordcheck");
            if (!folder.exists()) {
                folder.mkdirs();
            }
            File file = new File("src/passwordcheck/database.txt"); //make text file if not found
            if (file.createNewFile()) {
                System.out.println("Database file created.");
            }
            else {
                System.out.println("Database file found."); //notify that text file already exists
            }
        }
        catch (IOException e) { //validity check so program wont stop, will restart the program. 
            System.out.println("Error creating database file.");
        }
    }
    // this method asks the user to create a valid username
    public static String createUsername(Scanner input) { //new canner in 
        String username = "";
        boolean validUsername = false;
        // iteration: this while loop repeats until the username follows all username rules
        while (validUsername == false) {
            System.out.print("Create username: ");
            username = input.nextLine();
            if (username.length() == 0) {
                System.out.println("Username cannot be blank."); //catches no input error
            }
            else if (username.length() <= 3) {
                System.out.println("Username is too short.");
            }
            else if (hasNumber(username) == false) {
                System.out.println("Username needs a number.");
            }
            else {
                System.out.println("Username accepted.");
                validUsername = true;
            }
        }
        return username;
    }
    // method asks the user to create a valid password
    public static String createPassword(Scanner input) {
        String password = "";
        boolean validPassword = false;
        // while loop repeats until the password follows all password rules
        while (validPassword == false) {
            System.out.print("Create password: ");
            password = input.nextLine();
            if (password.length() == 0) {
                System.out.println("Password cannot be blank.");
            }
            else if (password.length() <= 8) {
                System.out.println("Password is too short.");
            }
            else if (hasNumber(password) == false) {
                System.out.println("Password needs a number.");
            }
            else if (hasUppercase(password) == false) {
                System.out.println("Password needs an uppercase letter.");
            }
            else {
                System.out.println("Password accepted.");
                validPassword = true;
            }
        }
        return password;
    }
    //method for checking text has nymber
    public static boolean hasNumber(String text) {
        // iteration: this for loop checks every character in the string one at a time
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= '0' && ch <= '9') { //checks0-9
                return true;
            }
        }
        return false;
    }
    // method for checking text has uppercase
    public static boolean hasUppercase(String text) {
        // iteration: this for loop checks every character in the string one at a time
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                return true;
            }
        }
        return false;
    }
    //method for checking if the entered username and password match the created account
    public static void login(Scanner input, String correctUsername, String correctPassword) {
        int attempts = 0;
        boolean loggedIn = false;
        System.out.println("Login Time!");
        //loop gives the user up to 3 login attempts
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
                if (attempts < 3) {
                    countdown();
                    waitForEnterAfterCountdown(input); //THIS CALLS THE final added method to stop the user from entering 
                }
            }
        }
        if (loggedIn == false) { //restarts program after countdown
            System.out.println("Too many incorrect attempts.");
            System.out.println("The program will restart.");
            countdown();
            waitForEnterAfterCountdown(input);
        }
    }
    //5 SECOND TIMER COUNTDOWN METHOD
    public static void countdown() {
        //for loop counts down from 5 to 1 with sleep of 1000
        for (int i = 5; i >= 1; i--) {
            System.out.println("Try again in " + i + "...");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("Countdown interrupted.");
            }
        }
    }
    public static void waitForEnterAfterCountdown(Scanner input) { //this method IGNORES USER INPUT DURING TIMEER
        String extraInput = "not empty"; 
        System.out.println("Timer finished.");
        System.out.println("Press Enter to continue.");
        while (!extraInput.equals("")) {
            extraInput = input.nextLine();
            if (!extraInput.equals("")) {
                System.out.println("Input during the timer was ignored.");
                System.out.println("Press Enter only to continue.");
            } //CRUDE, but prevents error if mispressed characters dutring username and password entry. 
        }
    }
    // method to cesar shift +10 
    public static String encryptText(String text) {
        String encrypted = "";
        int shift = 10;
        // for loop goes through every character and shifts letters or numbers
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (((ch - 'A' + shift) % 26) + 'A');
            }
            else if (ch >= 'a' && ch <= 'z') {
                ch = (char) (((ch - 'a' + shift) % 26) + 'a');
            }
            else if (ch >= '0' && ch <= '9') {
                ch = (char) (((ch - '0' + shift) % 10) + '0');
            }
            encrypted = encrypted + ch;
        }
        return encrypted;
    }
    // methodwrites the encrypted account information to database.txt
    public static void fileWrite(String content) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/passwordcheck/database.txt", true));
            bw.write(content);
            bw.close();
            System.out.println("Successfully wrote account to database.");
        }
        catch (IOException e) {
            System.out.println("Error writing to database file.");
        }
    }
    // this method counts how many accounts already exist so the next account gets the right number
    public static int getNextAccountNumber() {
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/passwordcheck/database.txt"));
            String line;
            //  while loop reads the database file one line at a time
            while ((line = br.readLine()) != null) {
                if (line.startsWith("username ")) {
                    count++;
                }
            }
            br.close();
        }
        catch (IOException e) {
            count = 0;
        }
        return count + 1;
    }
}