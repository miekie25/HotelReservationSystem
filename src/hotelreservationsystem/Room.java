/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 * The Room class represents a hotel room and provides methods to manage room
 * properties and availability.
 *
 * @author Mikaela Padayachie
 */
public class Room {

    // Defines database URL
    private static final String databaseURL = "jdbc:ucanaccess://HotelReservation.accdb";

    private static int nextRoomNumber = 01; // Starting room number
    private int roomNumber;
    private String roomType;
    private boolean roomStatus;
    private double roomRate;
    public static final double STANDARD_ROOM_RATE = 350;
    public static final double DELUXE_ROOM_RATE = 500;
    public static final double EXECUTIVE_ROOM_RATE = 1000;

    // Keeps track of booked rooms for each type
    public static int bookedStandardRooms = 0;
    public static int bookedDeluxeRooms = 0;
    public static int bookedExecutiveRooms = 0;

    // Defines maximum number of rooms for each type
    public static final int MAX_STANDARD_ROOMS = 50;
    public static final int MAX_DELUXE_ROOMS = 50;
    public static final int MAX_EXECUTIVE_ROOMS = 50;

    // Static counters for room numbers
    private static int standardRoomCounter = 1;
    private static int deluxeRoomCounter = 1;
    private static int executiveRoomCounter = 1;

    // Getter and setter methods for room properties
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isRoomStatus() {
        return roomStatus;
    }

    public void setRoomNumber(int rn) {
        this.roomNumber = rn;
    }

    public void setRoomType(String rt) {
        this.roomType = rt;
    }

    public void setRoomStatus(boolean rs) {
        this.roomStatus = rs;
    }

    public static double getStandardRoomRate() {
        return STANDARD_ROOM_RATE;
    }

    public static double getDeluxeRoomRate() {
        return DELUXE_ROOM_RATE;
    }

    public static double getExecutiveRoomRate() {
        return EXECUTIVE_ROOM_RATE;
    }

    //Method to check the room status
    public Room(String rt, boolean rs) {
        this.roomNumber = nextRoomNumber++;
        this.roomType = rt;
        this.roomStatus = rs;
        if (rt.equals("Standard")) {
            this.roomRate = STANDARD_ROOM_RATE;
        } else if (rt.equals("Deluxe")) {
            this.roomRate = DELUXE_ROOM_RATE;
        } else if (rt.equals("Executive")) {
            this.roomRate = EXECUTIVE_ROOM_RATE;
        }
    }

    // Method to book a room
    public void bookRoom() {
        if (roomType.equals("Standard") && bookedStandardRooms < MAX_STANDARD_ROOMS) {
            bookedStandardRooms++;
            updateAvailabilityInDatabase("Standard", -1); // Decreases availability by 1
        } else if (roomType.equals("Deluxe") && bookedDeluxeRooms < MAX_DELUXE_ROOMS) {
            bookedDeluxeRooms++;
            updateAvailabilityInDatabase("Deluxe", -1); // Decreases availability by 1
        } else if (roomType.equals("Executive") && bookedExecutiveRooms < MAX_EXECUTIVE_ROOMS) {
            bookedExecutiveRooms++;
            updateAvailabilityInDatabase("Executive", -1); // Decreases availability by 1
        }
        roomStatus = false;
    }

    // Method to release a booked room
    public void releaseRoom() {
        roomStatus = true;
        if (roomType.equals("Standard")) {
            bookedStandardRooms--;
        } else if (roomType.equals("Deluxe")) {
            bookedDeluxeRooms--;
        } else if (roomType.equals("Executive")) {
            bookedExecutiveRooms--;
        }
    }

    // Method to update the availibility of the room in the database (tblRoom)
    public static void updateAvailabilityInDatabase(String roomType, int change) {
        Connection connection = null;
        try {
            // Builds the SQL string for the update statement
            String sql = "UPDATE tblRoom SET AvailableRooms = AvailableRooms + ? WHERE RoomType = ?";

            connection = DriverManager.getConnection(databaseURL);

            // Creates the prepared statement
            PreparedStatement statement = connection.prepareStatement(sql);

            // Sets values for the prepared statement
            statement.setInt(1, change);
            statement.setString(2, roomType);

            statement.executeUpdate();
        } catch (Exception ex) {
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

    // Method to generate room ID based on room type and current counter
    public static String generateRoomID(String roomType) {
        int roomNumber = 0;
        switch (roomType) {
            case "Standard":
                roomNumber = standardRoomCounter++;
                break;
            case "Deluxe":
                roomNumber = deluxeRoomCounter++;
                break;
            case "Executive":
                roomNumber = executiveRoomCounter++;
                break;
        }
        return roomType.substring(0, 1) + String.format("%02d", roomNumber);
    }
}
