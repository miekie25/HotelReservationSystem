/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservationsystem;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * The Staff class represents staff members of the hotel reservation system. It
 * extends the User class and includes additional information such as the job
 * position. It provides methods for inserting staff information into the
 * database.
 *
 * @author Mikaela Padayachie
 */
public class Staff extends User {

    private String jobPosition;

    // Constructor for Staff object
    public Staff(String jp, String un, String pw, String fn, String ln) {
        super(un, pw, fn, ln);
        this.jobPosition = jp;
    }

    // Getters and setters for Staff class variables
    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    //Method to inserta staff member into the database (tblStaff)
    public static void insertStaff(Connection connection, String username, String password, String firstName, String lastName, String jobPosition) {
        try {
            // Builds the SQL string for the prepared statement
            String sql = "INSERT INTO tblStaff "
                    + "(StaffUsername, StaffPassword, FirstName, LastName, JobPosition) "
                    + "VALUES (?, ?, ?, ?, ?)";

            // Creates the prepared statement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Sets values that will be inserted
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, jobPosition);

            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void updateStaffInformation(Connection connection, String currentUsername, String username, String password, String firstName, String lastName, String jobPosition) {
        try {
            // Build the SQL string for the update statement
            String sql = "UPDATE Staff SET StaffUsername = ?, StaffPassword = ?, FirstName = ?, LastName = ?, JobPosition = ? WHERE StaffUsername = ?";

            // Create the prepared statement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set values for the update
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, jobPosition);
            statement.setString(6, currentUsername);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Staff information updated successfully.");
            } else {
                System.out.println("No records updated. Staff member not found.");
            }
        } catch (SQLException ex) {
            System.out.println("Unable to update staff information.");
            ex.printStackTrace();
        }
    }
}
