/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * The ReservationDataController class manages reservation data and provides
 * methods
 *
 * @author Mikaela Padayachie
 */
public class ReservationDataController {

    private static String username;
    private static String password;
    public static String guestName;
    public static String guestSurname;
    private static String phoneNumber;
    public static String emailAddress;
    private static String selectedRoomType;
    public static LocalDate checkInDate;
    public static LocalDate checkOutDate;
    private static double totalCost;

    // Setter and getter methods for other data fields
    public static void setTotalCost(double totalCost) {
        ReservationDataController.totalCost = totalCost;
    }

    public static void setUsername(String username) {
        ReservationDataController.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static void setCheckInDate(LocalDate checkInDate) {
        ReservationDataController.checkInDate = checkInDate;
    }

    public static void setCheckOutDate(LocalDate checkOutDate) {
        ReservationDataController.checkOutDate = checkOutDate;
    }

    public static void setGuestName(String guestName) {
        ReservationDataController.guestName = guestName;
    }

    public static String getGuestName() {
        return guestName;
    }

    public static void setGuestSurname(String guestSurname) {
        ReservationDataController.guestSurname = guestSurname;
    }

    public static String getGuestSurname() {
        return guestSurname;
    }

    public static void setGuestPhoneNumber(String phoneNumber) {
        ReservationDataController.phoneNumber = phoneNumber;
    }

    public static String getGuestPhoneNumber() {
        return phoneNumber;
    }

    public static void setEmailAddress(String emailAddress) {
        ReservationDataController.emailAddress = emailAddress;
    }

    public static void setPassword(String password) {
        ReservationDataController.password = password;
    }

    public static void setSelectedRoomType(String selectedRoomType) {
        ReservationDataController.selectedRoomType = selectedRoomType;
    }

    public static String getSelectedRoomType() {
        return selectedRoomType;
    }

    //Calculates the total cost of the reservation based on check-in date, check-out date,and the selected room type's rate
    public static double calculateTotalCost() {
        if (checkInDate != null && checkOutDate != null && selectedRoomType != null) {
            // Calculates the number of nights between check-in and check-out dates
            long numberOfNights = ChronoUnit.DAYS.between(checkInDate, checkOutDate);

            // Gets the rate of the selected room type
            double roomRate = getRateForRoomType(selectedRoomType); // Replace with your method

            // Calculates and return the total cost
            return numberOfNights * roomRate;
        }
        return 0.0; // Returns 0 if necessary data is not available
    }

    // Method to get the rate for a room type
    private static double getRateForRoomType(String roomType) {
        switch (roomType) {
            case "Standard":
                return Room.getStandardRoomRate();
            case "Deluxe":
                return Room.getDeluxeRoomRate();
            case "Executive":
                return Room.getExecutiveRoomRate();
            default:
                return 0.0; // Returns 0 for unknown room types
        }
    }

    // Method to add a reservation to the database
    public static void addReservationToDatabase(String userID, String roomID, String guestName,
            String guestPhoneNumber, String guestEmailAddress, LocalDate checkInDate, LocalDate checkOutDate,
            boolean paid, double totalCost) {

        // Defines the database connection URL
        String databaseURL = "jdbc:ucanaccess://HotelReservation.accdb";

        // Initialize the connection variable to null
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(databaseURL);

            // Inserts the reservation using Reservation class's insertReservation method
            Reservation.insertReservation(connection, userID, roomID, guestName, guestPhoneNumber,
                    guestEmailAddress, checkInDate, checkOutDate, paid, totalCost);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // Closes the database connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
