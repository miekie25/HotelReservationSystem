/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservationsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

/**
 * This class contains methods to insert and delete reservations in the
 * database.
 *
 * @author Mikaela Padayachie
 */
public class Reservation {

    private int reservationID;
    private String userID;
    private String roomID;
    private String guestName;
    private String guestCellphoneNumber;
    private String guestEmailAddress;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean paid;
    private double totalCost;

    // Constructor for creating a reservation object
    public Reservation(String uID, String rID, String guestName,
            String guestCellphoneNumber, String guestEmailAddress,
            LocalDate checkInDate, LocalDate checkOutDate, boolean paid, double totalCost) {
        this.userID = uID;
        this.roomID = rID;
        this.guestName = guestName;
        this.guestCellphoneNumber = guestCellphoneNumber;
        this.guestEmailAddress = guestEmailAddress;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.paid = paid;
        this.totalCost = totalCost;
    }

    // Getter and setter methods for Reservation properties
    public void setUserID(String uID) {
        this.userID = uID;
    }

    public String getUserID() {
        return userID;
    }

    public int getReservationID() {
        return reservationID;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getGuestCellphoneNumber() {
        return guestCellphoneNumber;
    }

    public String getGuestEmailAddress() {
        return guestEmailAddress;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setGuestCellphoneNumber(String guestCellphoneNumber) {
        this.guestCellphoneNumber = guestCellphoneNumber;
    }

    public void setGuestEmailAddress(String guestEmailAddress) {
        this.guestEmailAddress = guestEmailAddress;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    // Method to insert a reservation into the database
    public static void insertReservation(Connection connection, String userID, String roomID, String guestName,
            String guestPhoneNumber, String guestEmailAddress, LocalDate checkInDate, LocalDate checkOutDate,
            boolean paid, double totalCost) {
        try {
            // Builds the SQL statement for inserting a reservation
            String sql = "INSERT INTO tblReservation "
                    + "(UserID, RoomID, GuestName, GuestPhoneNumber, GuestEmailAddress, CheckInDate, CheckOutDate, Paid, TotalCost) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Creates the prepared statement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Sets values for the reservation
            statement.setString(1, userID);
            statement.setString(2, roomID);
            statement.setString(3, guestName);
            statement.setString(4, guestPhoneNumber);
            statement.setString(5, guestEmailAddress);
            statement.setDate(6, java.sql.Date.valueOf(checkInDate));
            statement.setDate(7, java.sql.Date.valueOf(checkOutDate));
            statement.setBoolean(8, paid == true);
            statement.setDouble(9, totalCost);

            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println("UNABLE TO ADD INSERT RESERVATION");
        }
    }

    public static void deleteReservation(Connection connection, String userID) {
        try {
            // Builds a string for a prepared statement
            String sql = "DELETE FROM tblReservation WHERE UserID = ?";

            // Creates the prepared statement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Sets values that will be inserted
            statement.setString(1, userID);

            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println("UNABLE TO DELETE RESERVATION");
        }
    }

}
