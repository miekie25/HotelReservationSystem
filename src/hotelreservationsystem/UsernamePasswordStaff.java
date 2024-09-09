/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelreservationsystem;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mikaela Padayachie
 */
public final class UsernamePasswordStaff extends javax.swing.JFrame {

    String databaseURL = "jdbc:ucanaccess://HotelReservation.accdb";

    // Variable to store whether it's an update or a new staff member registration
    private boolean isUpdate = false;

    private String existingFirstName;
    private String existingLastName;
    private String existingJobPosition;
    private String existingUsername;
    public static String loggedInUsername;

    /**
     * Creates new form UsernamePasswordStaff
     *
     * @param username
     */
    public UsernamePasswordStaff(String username) {
        UsernamePasswordStaff.loggedInUsername = username;
        initComponents();

        // Retrieve the existing staff member's information from the database
        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            String sql = "SELECT FirstName, LastName, JobPosition FROM Staff WHERE StaffUsername = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String existingFirstName = resultSet.getString("FirstName");
                String existingLastName = resultSet.getString("LastName");
                String existingJobPosition = resultSet.getString("JobPosition");

                // Call the displayStaffInformation method with the retrieved data
                displayStaffInformation(username, "", existingFirstName, existingLastName, existingJobPosition);
            } else {
                // Handle the case where the staff member is not found
                System.out.println("Staff member not found.");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public UsernamePasswordStaff() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBackground = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblStaffInformation = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblJobPosition = new javax.swing.JLabel();
        lblGenerateUsernameAndPassword = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtfUsername = new javax.swing.JTextField();
        pwfPassword = new javax.swing.JPasswordField();
        txtfFirstName = new javax.swing.JTextField();
        txtfSurname = new javax.swing.JTextField();
        cbJobPosition = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnMenu1 = new javax.swing.JButton();
        lblBackground1 = new javax.swing.JLabel();

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/white background.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnBack.setText("back");
        btnBack.setToolTipText("go to previous screen");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnExit.setText("exit");
        btnExit.setToolTipText("click here to terminate your reservation");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblStaffInformation.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblStaffInformation.setForeground(new java.awt.Color(0, 0, 255));
        lblStaffInformation.setText("Staff information");

        lblName.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblName.setText("Name:");

        lblSurname.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblSurname.setText("Surname:");

        lblJobPosition.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblJobPosition.setText("Job position:");

        lblGenerateUsernameAndPassword.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblGenerateUsernameAndPassword.setText("Please generate a username and password for yourself");

        lblUsername.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblUsername.setText("Username:");

        lblPassword.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblPassword.setText("Password:");

        txtfUsername.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtfUsername.setToolTipText("please enter a username");
        txtfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfUsernameActionPerformed(evt);
            }
        });

        pwfPassword.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        pwfPassword.setToolTipText("please enter a password");

        txtfFirstName.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtfFirstName.setToolTipText("please enter your name");

        txtfSurname.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtfSurname.setToolTipText("please enter your surname");

        cbJobPosition.setBackground(new java.awt.Color(0, 0, 255));
        cbJobPosition.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cbJobPosition.setMaximumRowCount(5);
        cbJobPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Management", "Superversion", "Reception", "Housekeeping", "Guest Services" }));
        cbJobPosition.setToolTipText("please select a job position");
        cbJobPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJobPositionActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnSave.setText("save");
        btnSave.setToolTipText("click here for menu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnMenu1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnMenu1.setText("menu");
        btnMenu1.setToolTipText("click here for menu");
        btnMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenu1ActionPerformed(evt);
            }
        });

        lblBackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/white background.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfFirstName))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(lblSurname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtfSurname))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblStaffInformation)
                                .addGap(169, 169, 169)
                                .addComponent(btnMenu1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSave))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblJobPosition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbJobPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPassword)
                            .addComponent(lblUsername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblGenerateUsernameAndPassword)
                                .addGap(0, 146, Short.MAX_VALUE))
                            .addComponent(txtfUsername)
                            .addComponent(pwfPassword, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblBackground1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 650, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExit)
                        .addComponent(btnMenu1))
                    .addComponent(lblStaffInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJobPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbJobPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(lblGenerateUsernameAndPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack)
                            .addComponent(btnSave))
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblBackground1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 411, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private boolean isStaffInformationValid() {
        return isFirstNameValid() && isSurnameValid() && isUsernameValid() && isPasswordValid();
    }

    private boolean isFirstNameValid() {
        String firstName = txtfFirstName.getText().trim();

        if (firstName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your first name.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!firstName.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid first name.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (firstName.length() > 100) {
            JOptionPane.showMessageDialog(this, "First name should not exceed 100 characters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean isSurnameValid() {
        String surname = txtfSurname.getText().trim();

        if (surname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your surname.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!surname.matches("^[a-zA-Z]+$")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid surname.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (surname.length() > 100) {
            JOptionPane.showMessageDialog(this, "Surname should not exceed 100 characters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean isUsernameValid() {
        String username = txtfUsername.getText().trim();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a username.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!username.matches("^[a-zA-Z]+[a-zA-Z0-9_.@]*$")) {
            JOptionPane.showMessageDialog(this, "Username must start with letters and can only contain letters, numbers, _, @, and .", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (username.length() > 16) {
            JOptionPane.showMessageDialog(this, "Username should not exceed 16 characters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean isPasswordValid() {
        char[] password = pwfPassword.getPassword();

        if (password.length == 0) {
            JOptionPane.showMessageDialog(this, "Please enter a password.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Password validation is subjective, so no specific validation logic is applied.
        if (password.length > 10) {
            JOptionPane.showMessageDialog(this, "Password should not exceed 10 characters.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Get the values from the input fields
        String updatedFirstName = txtfFirstName.getText().trim();
        String updatedLastName = txtfSurname.getText().trim();
        String updatedJobPosition = cbJobPosition.getSelectedItem().toString().trim();
        String updatedUsername = txtfUsername.getText().trim();
        String updatedPassword = new String(pwfPassword.getPassword()).trim();

        // Check if any of the required fields are empty
        if (updatedFirstName.isEmpty() || updatedLastName.isEmpty() || updatedJobPosition.isEmpty() || updatedUsername.isEmpty() || updatedPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(databaseURL);
            if (isUpdate) {
                // Check if any fields have changed
                if (!existingFirstName.equals(updatedFirstName)
                        || !existingLastName.equals(updatedLastName)
                        || !existingJobPosition.equals(updatedJobPosition)
                        || !existingUsername.equals(updatedUsername)) {
                    // Fields have changed, perform the update
                    Staff.updateStaffInformation(connection, updatedUsername, updatedPassword, updatedFirstName, updatedLastName, updatedJobPosition, loggedInUsername);
                    JOptionPane.showMessageDialog(this, "Staff information updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // No fields have changed, show a message or perform other actions
                    JOptionPane.showMessageDialog(this, "No changes detected.", "No Changes", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                // It's a new staff member registration
                // Call a method to insert the new staff member into the database
                Staff.insertStaff(connection, updatedUsername, updatedPassword, updatedFirstName, updatedLastName, updatedJobPosition);
                JOptionPane.showMessageDialog(this, "New staff member added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

            // Clear the input fields or navigate to the next screen
            // ... (your code here)
        } catch (SQLException ex) {
            Logger.getLogger(UsernamePasswordStaff.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Unable to save staff information.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close the connection in the finally block
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            new StaffHomePage().setVisible(true);
            this.setVisible(false); // Closes the current screen

        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenu1ActionPerformed
        new Menu().setVisible(true);
    }//GEN-LAST:event_btnMenu1ActionPerformed

    private void cbJobPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJobPositionActionPerformed

    }//GEN-LAST:event_cbJobPositionActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // This method confirms if the user wants to end the program upon pressing the 'exit' button
        int choice = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to exit?\nThis will terminate your current process of adding a staff member",
                "Exit Confirmation", // Displays a confirmation dialog with a warning message
                JOptionPane.YES_NO_OPTION, // Provides Yes and No button
                JOptionPane.WARNING_MESSAGE // Use a warning icon
        );

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0); // Terminate the program
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new StaffHomePage().setVisible(true); // Takes user back to the StaaffHomePage
        this.setVisible(false); // Closes the screen once the user has added a staff member
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfUsernameActionPerformed

    }//GEN-LAST:event_txtfUsernameActionPerformed
    public void displayStaffInformation(String username, String password, String firstName, String lastName, String jobPosition) {
        // Displays existing staff information in the input fields
        txtfFirstName.setText(firstName);
        txtfSurname.setText(lastName);
        cbJobPosition.setSelectedItem(jobPosition);
        txtfUsername.setText(username);
        // Sets some placeholder text in the password field (e.g., "********")
        // Setting asterisks to mask the password
        String maskedPassword = "********";
        pwfPassword.setText(maskedPassword);

        // Stores the existing information for later comparison during updates
        existingFirstName = firstName;
        existingLastName = lastName;
        existingJobPosition = jobPosition;
        existingUsername = username;
        // Sets some placeholder text in the password field (e.g., "********")
        // Setting asterisks to mask the password
        String maskedPassword2 = "********";
        pwfPassword.setText(maskedPassword);

        // Set the update flag
        isUpdate = true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UsernamePasswordStaff.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsernamePasswordStaff.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsernamePasswordStaff.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsernamePasswordStaff.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsernamePasswordStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMenu1;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbJobPosition;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBackground1;
    private javax.swing.JLabel lblGenerateUsernameAndPassword;
    private javax.swing.JLabel lblJobPosition;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblStaffInformation;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField pwfPassword;
    private javax.swing.JTextField txtfFirstName;
    private javax.swing.JTextField txtfSurname;
    private javax.swing.JTextField txtfUsername;
    // End of variables declaration//GEN-END:variables
}
