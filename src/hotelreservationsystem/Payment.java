/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelreservationsystem;

import java.text.DecimalFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 * The user enters their payment information on this screen to pay for their
 * reservation.
 *
 * @author Mikaela Padayachie
 */
public class Payment extends javax.swing.JFrame {

    private static double price;
    private String userID;
    private String roomID;
    private String guestName;
    private String guestPhoneNumber;
    private String guestEmailAddress;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean paid;
    private double totalCost;

    /**
     * Creates new form Payment
     */
    public Payment(double price) {
        // Sets the price for this payment instance
        Payment.price = price;

        // Initializes the graphical user interface components
        initComponents();

        // Formats the price to display with two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedPrice = "R" + decimalFormat.format(price);

        // Sets the text of a label to display the total amount due
        lblTotalAmountDue.setText("Total Amount Due " + formattedPrice);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExit = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lblSelectCardType = new javax.swing.JLabel();
        lblNote2 = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        lblPaymentHeading = new javax.swing.JLabel();
        btnVisa = new javax.swing.JButton();
        btnMastercard = new javax.swing.JButton();
        btnAmericanExpress = new javax.swing.JButton();
        lblTotalAmountDue = new javax.swing.JLabel();
        lblNameOnCard = new javax.swing.JLabel();
        txtfNameOnCard = new javax.swing.JTextField();
        lblCardNumber = new javax.swing.JLabel();
        txtfCardNumber = new javax.swing.JTextField();
        txtfCCV = new javax.swing.JTextField();
        txtfExpiryDate = new javax.swing.JTextField();
        lblCVVNumber = new javax.swing.JLabel();
        lblExpiryDate = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnExit.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnExit.setText("exit");
        btnExit.setToolTipText("click here to terminate your reservation");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnMenu.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnMenu.setText("menu");
        btnMenu.setToolTipText("click here for menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnBack.setText("back");
        btnBack.setToolTipText("go to previous screen");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        btnNext.setText("next");
        btnNext.setToolTipText("go to next screen");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblSelectCardType.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblSelectCardType.setText("Select a card type:");

        lblNote2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblNote2.setForeground(new java.awt.Color(255, 0, 0));
        lblNote2.setText("and will not be shared with any parties other than the hotel for reservation purposes");

        lblNote.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblNote.setForeground(new java.awt.Color(255, 0, 0));
        lblNote.setText("NOTE: all payment information is strictly confidential");

        lblPaymentHeading.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lblPaymentHeading.setForeground(new java.awt.Color(0, 0, 255));
        lblPaymentHeading.setText("Payment");

        btnVisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/visa.jpg"))); // NOI18N
        btnVisa.setToolTipText("visa");
        btnVisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaActionPerformed(evt);
            }
        });

        btnMastercard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/mastercard.jpg"))); // NOI18N
        btnMastercard.setToolTipText("mastercard");
        btnMastercard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMastercardActionPerformed(evt);
            }
        });

        btnAmericanExpress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/americanExpress.jpg"))); // NOI18N
        btnAmericanExpress.setToolTipText("american express");
        btnAmericanExpress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAmericanExpressActionPerformed(evt);
            }
        });

        lblTotalAmountDue.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblTotalAmountDue.setText("Total amount due: ");

        lblNameOnCard.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblNameOnCard.setText("Name on card:");

        txtfNameOnCard.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtfNameOnCard.setToolTipText("please enter name on card");
        txtfNameOnCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfNameOnCardActionPerformed(evt);
            }
        });

        lblCardNumber.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblCardNumber.setText("Card number:");

        txtfCardNumber.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtfCardNumber.setToolTipText("please enter card number");
        txtfCardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfCardNumberActionPerformed(evt);
            }
        });

        txtfCCV.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtfCCV.setToolTipText("3 digits");

        txtfExpiryDate.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtfExpiryDate.setToolTipText("MM/YY Format");
        txtfExpiryDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfExpiryDateActionPerformed(evt);
            }
        });

        lblCVVNumber.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblCVVNumber.setText("CVV");

        lblExpiryDate.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lblExpiryDate.setText("Expiry date");

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/white background.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPaymentHeading)
                        .addGap(211, 211, 211)
                        .addComponent(btnMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblTotalAmountDue, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtfExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtfCCV, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblSelectCardType)
                                                        .addComponent(lblNameOnCard)
                                                        .addComponent(lblCardNumber))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(btnVisa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(37, 37, 37)
                                                            .addComponent(btnMastercard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(42, 42, 42)
                                                            .addComponent(btnAmericanExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(txtfNameOnCard)
                                                        .addComponent(txtfCardNumber))))
                                            .addComponent(lblNote)))
                                    .addComponent(btnBack))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 82, Short.MAX_VALUE)
                                .addComponent(lblNote2)
                                .addGap(28, 28, 28)))
                        .addComponent(btnNext)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(lblExpiryDate)
                .addGap(217, 217, 217)
                .addComponent(lblCVVNumber)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMenu)
                            .addComponent(btnExit))
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPaymentHeading)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalAmountDue)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMastercard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVisa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAmericanExpress, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSelectCardType, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNameOnCard, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfNameOnCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCVVNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfCCV, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblNote)
                        .addGap(18, 18, 18)
                        .addComponent(lblNote2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnNext)
                        .addGap(19, 19, 19))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfNameOnCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfNameOnCardActionPerformed

    }//GEN-LAST:event_txtfNameOnCardActionPerformed

    private void txtfCardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfCardNumberActionPerformed

    }//GEN-LAST:event_txtfCardNumberActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // This method confirms if the user wants to end the program upon pressing the 'exit' button
        int choice = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to exit?\nThis will terminate your current process of making a reservation.",
                "Exit Confirmation", // Displays a confirmation dialog with a warning message
                JOptionPane.YES_NO_OPTION, // Provides Yes and No button
                JOptionPane.WARNING_MESSAGE // Uses a warning icon
        );

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0); // Terminates the program
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed

        // Validates card number length
        String cardNumber = txtfCardNumber.getText(); // Gets the entered card number from a text field.
        // Checks if the card number length is not 15 and not 16 (common lengths for credit card numbers).
        if (cardNumber.length() != 15 && cardNumber.length() != 16) {
            // Displays an error message dialog if the card number length is invalid.
            JOptionPane.showMessageDialog(this, "Please enter a valid card number.", "Invalid Card Number", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validates expiry date
        String expiryDate = txtfExpiryDate.getText(); // Gets the entered expiry date from a text field.
        // Checks if the expiry date does not match the expected format "MM/YY" using a regular expression.
        if (!expiryDate.matches("^(0[1-9]|1[0-2])/([2-3]\\d)$")) {
            // Displays an error message dialog if the expiry date format is invalid.
            JOptionPane.showMessageDialog(this, "Please enter a valid expiry date in the format MM/YY.", "Invalid Expiry Date", JOptionPane.ERROR_MESSAGE);
            return;

        }

        // Validates CVV
        String cvv = txtfCCV.getText(); // Gets the entered CVV from a text field
        // Checks if the CVV does not match the expected format of exactly three digits.
        if (!cvv.matches("\\d{3}")) {
            // Displays an error message dialog if the CVV format is invalid.
            JOptionPane.showMessageDialog(this, "Please enter a valid CVV with 3 digits.", "Invalid CVV", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validates name on card
        String nameOnCard = txtfNameOnCard.getText(); // Get the entered name on the card from a text field.
        // Checks if the name on the card contains only letters, spaces, or hyphens using a regular expression.
        if (!nameOnCard.matches("^[A-Za-z\\s-]+$")) {
            // Displays an error message dialog if the name on the card format is invalid.
            JOptionPane.showMessageDialog(this, "Please enter a valid name on card without special characters.", "Invalid Name on Card", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Generates a username for the guest based on their name, surname, and card number (called from Guest class)
        String generatedUsername = Guest.generateUsername(ReservationDataController.guestName, ReservationDataController.guestSurname, cardNumber);

        // Retrieves the user ID from the database using the generated username
        userID = User.getUserIdFromDatabase(ReservationDataController.getUsername());

        // Retrieves the selected room type for the reservation
        roomID = ReservationDataController.getSelectedRoomType();

        // Creates a combined guest name by concatenating the guest's first and last names
        guestName = ReservationDataController.guestName + " " + ReservationDataController.guestSurname;

        // Retrieves the guest's phone number from the reservation data controller
        guestPhoneNumber = ReservationDataController.getGuestPhoneNumber();

        // Retrieves the guest's email address from the reservation data controller
        guestEmailAddress = ReservationDataController.emailAddress;

        // Retrieves the check-in and check-out dates from the reservation data controller
        checkInDate = ReservationDataController.checkInDate;
        checkOutDate = ReservationDataController.checkOutDate;

        // Marks the reservation as paid
        paid = true;

        // Calculates the total cost of the reservation (called from ReservationDataController class)
        totalCost = ReservationDataController.calculateTotalCost();

        // Adds the reservation details to the database (called from this class)
        addReservationToDatabase();

        // If all validations pass and reservation data is successfully processed:
        // Shows the PaymentSuccessful screen
        new PaymentSuccessful().setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnNextActionPerformed

    // Adds reservation details to the database
    private void addReservationToDatabase() {
        // Add reservation to the database
        ReservationDataController.addReservationToDatabase(
                userID, roomID, guestName, guestPhoneNumber, guestEmailAddress,
                checkInDate, checkOutDate, paid, totalCost
        );
    }

    private void btnVisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaActionPerformed

    }//GEN-LAST:event_btnVisaActionPerformed

    private void btnAmericanExpressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAmericanExpressActionPerformed
   

    }//GEN-LAST:event_btnAmericanExpressActionPerformed

    private void btnMastercardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMastercardActionPerformed

    }//GEN-LAST:event_btnMastercardActionPerformed

    private void txtfExpiryDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfExpiryDateActionPerformed
        
    }//GEN-LAST:event_txtfExpiryDateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new SelectRoomType().setVisible(true); // Takes user back to the SelectRoomType screen
        this.setVisible(false); // Closes this screen
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        new Menu().setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment(price).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAmericanExpress;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMastercard;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnVisa;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblCVVNumber;
    private javax.swing.JLabel lblCardNumber;
    private javax.swing.JLabel lblExpiryDate;
    private javax.swing.JLabel lblNameOnCard;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblNote2;
    private javax.swing.JLabel lblPaymentHeading;
    private javax.swing.JLabel lblSelectCardType;
    private javax.swing.JLabel lblTotalAmountDue;
    private javax.swing.JTextField txtfCCV;
    private javax.swing.JTextField txtfCardNumber;
    private javax.swing.JTextField txtfExpiryDate;
    private javax.swing.JTextField txtfNameOnCard;
    // End of variables declaration//GEN-END:variables

}
