/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservationsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Class representing a guest in the hotel reservation system.
 *
 * @author Mikaela Padayachie
 */
public class Guest extends User {

    private String phoneNumber;
    private String emailAddress;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String roomType;

    // Constructor to initialize guest information
    public Guest(String un, String pw, String fn, String ln, String pn, String ea, LocalDate CID, LocalDate COD) {
        super(un, pw, fn, ln);
        this.phoneNumber = pn;
        this.emailAddress = ea;
        this.checkInDate = CID;
        this.checkOutDate = COD;
    }

    // Getter methods for guest information
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public String getRoomType() {
        return roomType;
    }

    // Setter methods for guest information
    public void setPhoneNumber(String pn) {
        this.phoneNumber = pn;
    }

    public void setEmailAddress(String ea) {
        this.emailAddress = ea;
    }

    public void setCheckInDate(LocalDate CID) {
        this.checkInDate = CID;
    }

    public void setCheckOutDate(LocalDate COD) {
        this.checkOutDate = COD;
    }

    public void setRoomType(String rt) {
        this.roomType = rt;
    }

    // Method to generate a username based on first name, last name, and phone number
    public static String generateUsername(String firstName, String lastName, String phoneNumber) {
        // Gets the first two letters of the first name
        String firstInitials = firstName.substring(0, Math.min(2, firstName.length())).toLowerCase();

        // Gets the last two letters of the last name
        String lastInitials = lastName.substring(Math.max(0, lastName.length() - 2)).toLowerCase();

        // Gets the first three digits of the phone number
        String phoneNumberDigits = phoneNumber.replaceAll("[^0-9]", "").substring(0, Math.min(3, phoneNumber.length()));

        // Combines the components to form the username
        String generatedUsername = firstInitials + lastInitials + phoneNumberDigits;

        return generatedUsername;
    }

    // Method to generate password based on the first 3 letters of firstName + 3 random numbers
    public static String generatePassword(String firstName) {
        String randomNumbers = generateRandomNumbers();
        return firstName.substring(0, 3).toLowerCase() + randomNumbers;
    }

    // Method to generate three random numbers for the password
    public static String generateRandomNumbers() {
        StringBuilder randomNumbers = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int randomNumber = (int) (Math.random() * 9) + 1; // Generates a random number between 1 and 9 (inclusive)
            randomNumbers.append(randomNumber);
        }
        return randomNumbers.toString();
    }

    // Method to insert guest information into the database
    public static void insertGuest(Connection connection, String username, String password, String firstName, String lastName, String cellphoneNumber, String emailAddress, LocalDate CheckInDate, LocalDate CheckOutDate) {
        try {
            // Builds the SQL string for the prepared statement
            String sql = "INSERT INTO tblGuest "
                    + "(GuestUsername, GuestPassword, FirstName, LastName, CellphoneNumber, EmailAddress, CheckInDate, CheckOutDate)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            // Creates the prepared statement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Sets values that will be inserted into the database (tblGuest)
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, cellphoneNumber);
            statement.setString(6, emailAddress);
            statement.setDate(7, Date.valueOf(CheckInDate));
            statement.setDate(8, Date.valueOf(CheckOutDate));

            // Executes the SQL statement to insert guest information
            statement.executeUpdate();
        } catch (Exception ex) {
            // Handles any exceptions that may occur during database access by printing the stack trace
            System.out.println("UNABLE TO INSERT GUEST");
        }
    }
}
