package car_rental_system;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class RenterMenuUI extends javax.swing.JFrame {
    String R_username;
    public RenterMenuUI() {
        initComponents();
        try {
            this.setIconImage(ImageIO.read(new File("src/Images/icon.png")));
        } catch (IOException ex) {
            Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public RenterMenuUI(String user) {
        initComponents();
        R_username = user;
        try {
            this.setIconImage(ImageIO.read(new File("src/Images/icon.png")));
        } catch (IOException ex) {
            Logger.getLogger(LoginUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ERes = new javax.swing.JButton();
        NRes = new javax.swing.JButton();
        MyAcc = new javax.swing.JButton();
        MyRes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ERes.setBackground(new java.awt.Color(94, 57, 156));
        ERes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ERes.setForeground(new java.awt.Color(255, 255, 255));
        ERes.setText("Edit Reservation");
        ERes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ERes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EResActionPerformed(evt);
            }
        });

        NRes.setBackground(new java.awt.Color(94, 57, 156));
        NRes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NRes.setForeground(new java.awt.Color(255, 255, 255));
        NRes.setText("New Reservation");
        NRes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        NRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NResActionPerformed(evt);
            }
        });

        MyAcc.setBackground(new java.awt.Color(94, 57, 156));
        MyAcc.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        MyAcc.setForeground(new java.awt.Color(255, 255, 255));
        MyAcc.setText("My account");
        MyAcc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        MyAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyAccActionPerformed(evt);
            }
        });

        MyRes.setBackground(new java.awt.Color(94, 57, 156));
        MyRes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        MyRes.setForeground(new java.awt.Color(255, 255, 255));
        MyRes.setText("My Reservations");
        MyRes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MyAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ERes, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NRes, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MyRes, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(MyRes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(ERes, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NRes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addComponent(MyAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EResActionPerformed
       EditReservationUI u = new EditReservationUI();
       u.setVisible(true);
       u.pack();
       u.setLocationRelativeTo(null);
       u.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.dispose();
    }//GEN-LAST:event_EResActionPerformed

    private void NResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NResActionPerformed
        ReserveUI m = new ReserveUI(R_username);
        m.setVisible(true);
        m.pack();
        m.setLocationRelativeTo(null);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_NResActionPerformed

    private void MyAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyAccActionPerformed
        
    }//GEN-LAST:event_MyAccActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ERes;
    private javax.swing.JButton MyAcc;
    private javax.swing.JButton MyRes;
    private javax.swing.JButton NRes;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
