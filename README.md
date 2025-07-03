# Bogey Password Manager (BPM)

Bogey Password Manager (BPM) is a simple password manager built in Java using NetBeans and Maven.  
It uses Swing for the GUI and MySQL for storing encrypted credentials.

---

## Current Features

- User login and registration
- Add passwords with website/app name, username/email, and password
- View all saved entries in a table
- Toggle password visibility (masked or decrypted)
- Encrypted password storage
- Auto-refresh after adding new entries
- Clears input fields after submission
- Edit and Delete Passwords

---

## Tech Stack

- Java (Swing)
- MySQL
- JDBC
- Maven
- Custom EncryptionHelper

---

## How to Run

### Prerequisites

- Java 21+
- Maven installed
- MySQL server

### Steps

1. Clone the project  
   `git clone https://github.com/desciii/bogeypasswordmanager.git`

2. Set up the database  
   Create a MySQL database and use the schema below.

3. Configure DB connection  
   Edit `DBConnection.java` with your MySQL credentials.

4. Build the project  
   `mvn clean install`

5. Run the app  
   Launch `BPM.java` inside your IDE.

---

### Made by: @desciii