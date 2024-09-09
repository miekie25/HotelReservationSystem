/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Mikaela Padayachie
 */
public class User {

    protected String username;
    protected String password;
    protected String firstName;
    protected String lastName;

    // Constructor for User class
    public User(String un, String pw, String fn, String ln) {
        this.username = un;
        this.password = pw;
        this.firstName = fn;
        this.lastName = ln;
    }

    // Getter and setter methods for User class variables
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUsername(String un) {
        this.username = un;
    }

    public void setPassword(String pw) {
        this.password = pw;
    }

    public void setFirstName(String fn) {
        this.firstName = fn;
    }

    public void setLastName(String ln) {
        this.lastName = ln;
    }

    // Method to insert a user into the database (tblUser)
    public static void insertUser(Connection connection, String username,
            String password, String firstName, String lastName) {
        try {
            // Builds out a string for a prepared statement
            String sql = "INSERT INTO tblUser "
                    + "(Username, Password, FirstName, LastName) "
                    + "VALUES (?, ?, ?, ?)";

            // Creates the prepared statement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Sets values that will be inserted
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);

            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("UNABLE TO INSERT A USER INTO THE DATABASE");
        }
    }

    // Method to get a user from the database by their ID
    public static String getUserIdFromDatabase(String generatedUsername) {
        // Defines database URL
        String databaseURL = "jdbc:ucanaccess://HotelReservation.accdb";

        // Sets variable userId as null
        String userId = null;

        // Sets variable connection as null
        Connection connection = null;

        try {
            // Builds the SQL string for the select statement
            String sql = "SELECT UserID FROM tblUser WHERE Username = ?";

            connection = DriverManager.getConnection(databaseURL);

            // Creates the prepared statement
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, generatedUsername);

            // Executes the query
            ResultSet resultSet = statement.executeQuery();

            // Checks if a result was returned
            if (resultSet.next()) {
                userId = resultSet.getString("UserID");
            }
        } catch (SQLException ex) {
            System.out.println("UNABLE TO GET USER FROM DATABASE");
        } finally {
            // Closes the database connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("UNABLE TO GET USER FROM DATABASE");
                }
            }
        }

        return userId;
    }

    public static boolean updateUsernameAndPassword(Connection connection, String currentPassword, String newUsername, String newPassword) {
        try {
            // Builds the SQL string for the update statement for tblUser
            String userSql = "UPDATE tblUser SET Username = ?, Password = ? WHERE Password = ?";

            // Creates the prepared statement for tblUser
            PreparedStatement userStatement = connection.prepareStatement(userSql);

            // Sest values for the update in tblUser
            userStatement.setString(1, newUsername);
            userStatement.setString(2, newPassword);
            userStatement.setString(3, currentPassword);

            int userRowsUpdated = userStatement.executeUpdate();

            // Builds the SQL string for the update statement for tblGuest
            String guestSql = "UPDATE tblGuest SET GuestUsername = ?, GuestPassword = ? WHERE GuestPassword = ?";

            // Creates the prepared statement for tblGuest
            PreparedStatement guestStatement = connection.prepareStatement(guestSql);

            // Sets values for the update in tblGuest
            guestStatement.setString(1, newUsername);
            guestStatement.setString(2, newPassword);
            guestStatement.setString(3, currentPassword);

            int guestRowsUpdated = guestStatement.executeUpdate();

            if (userRowsUpdated > 0 && guestRowsUpdated > 0) {
                System.out.println("Username and password updated successfully in both tables.");
                return true; // Successful update
            } else {
                System.out.println("No records updated. User not found or current password incorrect.");
                return false; // Update failed
            }
        } catch (Exception ex) {
            System.out.println("Unable to update username and password.");
            ex.printStackTrace();
            return false; // Update failed due to an exception
        }
    }
}
