# Password Checker

## Scope of the Project

This project is a console-based account creation and login system written in Java. The goal was to build a simple but functional security application that demonstrates core programming concepts including loops, methods, file I/O, string manipulation, and input validation. The program allows a user to create an account with a secure username and password, encrypts the credentials using a Caesar cipher with a shift of 10, saves the encrypted account to a local database file, and then prompts the user to log in. The system enforces security rules during account creation and locks the user out after 3 failed login attempts before automatically restarting.

---

## How to Use the Program

1. Run the program in any Java IDE such as Eclipse or IntelliJ, or from the command line using `javac` and `java`
2. The program will automatically create a `database.txt` file inside `src/passwordcheck/` if one does not already exist
3. When prompted, create a username that is longer than 3 characters and contains at least one number
4. When prompted, create a password that is longer than 8 characters and contains at least one number and one uppercase letter
5. Once your account is created, the encrypted credentials will be saved to `database.txt` and a confirmation message will be displayed
6. You will then be prompted to log in using the username and password you just created
7. You have 3 attempts to log in correctly — after each failed attempt a 5 second countdown timer will run before you can try again
8. Any input entered during the countdown timer will be ignored
9. After 3 failed attempts the program will restart and prompt you to create a new account
10. After a successful login the program will restart automatically

---

## Validity Checks

The following input validation is performed throughout the program:

- Username cannot be blank
- Username must be longer than 3 characters
- Username must contain at least one number
- Password cannot be blank
- Password must be longer than 8 characters
- Password must contain at least one number
- Password must contain at least one uppercase letter
- Login attempts are limited to 3 before the program restarts
- Input entered during the countdown timer is detected and ignored

---

## Encryption

All usernames and passwords are encrypted before being saved to the database using a Caesar cipher with a shift value of 10. Uppercase letters, lowercase letters, and digits are each shifted independently within their own character ranges, wrapping around when the end of the range is reached.

---

## Example Output

**Account Creation (successful):**
```
Database file found.
Create Your Account! :
Create username: hi
Username is too short.
Create username: john
Username needs a number.
Create username: john1
Username accepted.
Create password: password
Password is too short.
Create password: password1
Password needs an uppercase letter.
Create password: Password1
Password accepted.
Successfully wrote account to database.
Account created successfully.
Encrypted account was saved to database.txt.
```

**Successful Login:**
```
Login Time!
Enter username: john1
Enter password: Password1
You are logged in.

Restarting program...
```

**Failed Login Attempts:**
```
Login Time!
Enter username: john1
Enter password: wrongpass
Username or password is incorrect.
Attempts used: 1/3
Try again in 5...
Try again in 4...
Try again in 3...
Try again in 2...
Try again in 1...
Timer finished.
Press Enter to continue.
Enter username: john1
Enter password: wrongagain
Username or password is incorrect.
Attempts used: 2/3
Try again in 5...
Try again in 4...
Try again in 3...
Try again in 2...
Try again in 1...
Timer finished.
Press Enter to continue.
Enter username: john1
Enter password: stillwrong
Username or password is incorrect.
Attempts used: 3/3
Too many incorrect attempts.
The program will restart.
Try again in 5...
Try again in 4...
Try again in 3...
Try again in 2...
Try again in 1...
Timer finished.
Press Enter to continue.

Restarting program...
```

**database.txt contents:**
```
username 1: tYxb1
password 1: Zkccgybn1

username 2: admZ2
password 2: Zkccgybn1
```

**Input ignored during countdown:**
```
Try again in 5...
Try again in 4...
Try again in 3...
Try again in 2...
Try again in 1...
Timer finished.
Press Enter to continue.
hello
Input during the timer was ignored.
Press Enter only to continue.
```

---

## GitHub Repository

[Paste your GitHub link here]
