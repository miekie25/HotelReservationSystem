/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelreservationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mikae
 */
public class DatabaseManager {

    private String databaseURL = "jdbc:ucanaccess://HotelReservation.accdb";

    public String retrieveUserID(String guestFirstName, String guestLastName, String guestPhoneNumber) {
        String userID = null;

        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            String sql = "SELECT UserID FROM tblUser WHERE FirstName = ? AND LastName = ? AND PhoneNumber = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, guestFirstName);
            statement.setString(2, guestLastName);
            statement.setString(3, guestPhoneNumber);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                userID = resultSet.getString("UserID");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userID;
    }
}
