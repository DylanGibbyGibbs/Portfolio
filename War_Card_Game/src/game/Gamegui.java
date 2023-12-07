/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package game;

/**
 *
 * @author Gibby
 */
public class Gamegui extends javax.swing.JFrame {

    /**
     * Creates new
     */
    deck mydeck = new deck();
    player one = new player(); 
    player two = new player();
    player allthemarbles = new player();
    boolean win = false;
    
    
    public Gamegui() {
        initComponents();
        //Initialize the main deck and the sub decks.
        mydeck.initializedeck(); //initialize big deck
        mydeck.shuffle(); //Shuffle big deck
       
        one.playerdeck = mydeck.splitdeckone(); //Split the deck and return the array list
        two.playerdeck = mydeck.splitdecktwo(); //Split the deck and return the array list
        
        p1count.setText("Player 1 Card Count: " + one.playerdeck.size());
        p2count.setText("Player 2 Card Count: " + one.playerdeck.size());
       
      
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Initialize = new javax.swing.JButton();
        War = new javax.swing.JButton();
        Bluecard1 = new javax.swing.JLabel();
        Bluecard2 = new javax.swing.JLabel();
        Redcard2 = new javax.swing.JLabel();
        Redcard1 = new javax.swing.JLabel();
        p1count = new javax.swing.JLabel();
        p2count = new javax.swing.JLabel();
        Winner = new javax.swing.JLabel();
        Redcard3 = new javax.swing.JLabel();
        Bluecard3 = new javax.swing.JLabel();
        Redcard4 = new javax.swing.JLabel();
        Bluecard4 = new javax.swing.JLabel();
        Auto = new javax.swing.JButton();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        Initialize.setText("New Game");
        Initialize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InitializeActionPerformed(evt);
            }
        });

        War.setText("War!");
        War.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WarActionPerformed(evt);
            }
        });

        Bluecard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b1fv.png"))); // NOI18N

        Bluecard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b1fv.png"))); // NOI18N

        Redcard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); // NOI18N

        Redcard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); // NOI18N

        p1count.setBackground(new java.awt.Color(255, 255, 255));
        p1count.setForeground(new java.awt.Color(255, 255, 255));
        p1count.setText("Player 1 Card Count: 0");

        p2count.setBackground(new java.awt.Color(255, 255, 255));
        p2count.setForeground(new java.awt.Color(255, 255, 255));
        p2count.setText("Player 2 Card Count: 0");

        Winner.setForeground(new java.awt.Color(255, 255, 255));

        Redcard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); // NOI18N

        Bluecard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b1fv.png"))); // NOI18N

        Redcard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); // NOI18N

        Bluecard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b1fv.png"))); // NOI18N

        Auto.setText("Auto War!");
        Auto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Bluecard1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Bluecard2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Redcard1)
                                .addGap(18, 18, 18)
                                .addComponent(Redcard2))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Initialize)
                        .addGap(54, 54, 54)
                        .addComponent(Auto)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Bluecard3)
                                .addGap(18, 18, 18)
                                .addComponent(Bluecard4)
                                .addGap(18, 18, 18)
                                .addComponent(p2count))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Redcard3)
                                .addGap(18, 18, 18)
                                .addComponent(Redcard4)
                                .addGap(18, 18, 18)
                                .addComponent(p1count)))
                        .addContainerGap(13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(War)
                        .addGap(100, 100, 100)
                        .addComponent(Winner)
                        .addGap(54, 54, 54))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Redcard2)
                            .addComponent(Redcard1)
                            .addComponent(Redcard3)
                            .addComponent(Redcard4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(p1count)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Bluecard1)
                            .addComponent(Bluecard2)
                            .addComponent(Bluecard3)
                            .addComponent(Bluecard4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Initialize)
                            .addComponent(War)
                            .addComponent(Winner)
                            .addComponent(Auto))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(p2count)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WarActionPerformed
      //Set Icons
         Bluecard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b1fv.png")));
         Bluecard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b1fv.png")));
         Bluecard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b1fv.png"))); // NOI18N
         Bluecard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b1fv.png"))); // NOI18N
         Redcard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png")));
         Redcard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png")));
         Redcard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); 
         Redcard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/b2fv.png"))); // NOI18N

        
        
        //System.out.println(two.playerdeck.size());
        card Player1Card1 = one.playerdeck.remove(0);
        int Player1Card1Value = Player1Card1.getvalue();
        Redcard1.setIcon(new javax.swing.ImageIcon(getClass().getResource(Player1Card1.getImage())));
        
        card Player2Card1 = two.playerdeck.remove(0);
        int Player2Card1Value = Player2Card1.getvalue();
        Bluecard1.setIcon(new javax.swing.ImageIcon(getClass().getResource(Player2Card1.getImage())));
        
      
        
        //Remember for this condition that in the array the kings are first value = 0; Thus it looks backwards
        if(Player1Card1Value < Player2Card1Value)
        {
            Winner.setText("Player 1 Wins");
             
            
            one.playerdeck.add(Player2Card1);
            one.playerdeck.add(Player1Card1);
        }
        if(Player1Card1Value > Player2Card1Value)
        {
            Winner.setText("Player 2 Wins");
            two.playerdeck.add(Player1Card1);
            two.playerdeck.add(Player2Card1);
        }
        if(Player1Card1Value == Player2Card1Value && one.playerdeck.size() != 0 && two.playerdeck.size() != 0)
           {
                    
                card Player1Card2 = one.playerdeck.remove(0);
                int Player1Card2Value = Player1Card2.getvalue();
                card Player2Card2 = two.playerdeck.remove(0);
                int Player2Card2Value = Player2Card2.getvalue();
               
                Redcard2.setIcon(new javax.swing.ImageIcon(getClass().getResource(Player1Card2.getImage())));
                Bluecard2.setIcon(new javax.swing.ImageIcon(getClass().getResource(Player2Card2.getImage())));
                
                if(Player1Card2Value < Player2Card2Value)
                {
                    Winner.setText("Player 1 Wins");
                    one.playerdeck.add(Player2Card1);
                    one.playerdeck.add(Player1Card1);
                    one.playerdeck.add(Player2Card2);
                    one.playerdeck.add(Player1Card2);
                }
                if(Player1Card2Value > Player2Card2Value)
                {
                    Winner.setText("Player 2 Wins");
                    two.playerdeck.add(Player1Card1);
                    two.playerdeck.add(Player2Card1);
                    two.playerdeck.add(Player1Card2);
                    two.playerdeck.add(Player2Card2);
                }
                if(Player1Card2Value == Player2Card2Value && one.playerdeck.size() != 0 && two.playerdeck.size() != 0)
                    {
                 
                         card Player1Card3 = one.playerdeck.remove(0);
                         int Player1Card3Value = Player1Card3.getvalue();
                         card Player2Card3 = two.playerdeck.remove(0);
                         int Player2Card3Value = Player2Card3.getvalue();
                        
                         Redcard3.setIcon(new javax.swing.ImageIcon(getClass().getResource(Player1Card3.getImage())));
                         Bluecard3.setIcon(new javax.swing.ImageIcon(getClass().getResource(Player2Card3.getImage())));
                         
                         if(Player1Card3Value < Player2Card3Value)
                         {
                             Winner.setText("Player 1 Wins");
                             one.playerdeck.add(Player2Card1);
                             one.playerdeck.add(Player1Card1);
                             one.playerdeck.add(Player2Card2);
                             one.playerdeck.add(Player1Card2);
                             one.playerdeck.add(Player2Card3);
                             one.playerdeck.add(Player1Card3);
                         }
                         if(Player1Card3Value > Player2Card3Value)
                         {
                             Winner.setText("Player 2 Wins");
                             two.playerdeck.add(Player1Card1);
                             two.playerdeck.add(Player2Card1);
                             two.playerdeck.add(Player1Card2);
                             two.playerdeck.add(Player2Card2);
                             two.playerdeck.add(Player1Card3);
                             two.playerdeck.add(Player2Card3);
                         }
                         if(Player1Card3Value == Player2Card3Value && one.playerdeck.size() != 0 && two.playerdeck.size() != 0)
                            {
                                 card Player1Card4 = one.playerdeck.remove(0);
                                 int Player1Card4Value = Player1Card4.getvalue();
                                 card Player2Card4 = two.playerdeck.remove(0);
                                 int Player2Card4Value = Player2Card4.getvalue();
                                 
                                
                                 Redcard4.setIcon(new javax.swing.ImageIcon(getClass().getResource(Player1Card4.getImage())));
                                 Bluecard4.setIcon(new javax.swing.ImageIcon(getClass().getResource(Player2Card4.getImage())));
                                 
                                 if(Player1Card4Value < Player2Card4Value)
                                 {
                                     Winner.setText("Player 1 Wins");
                                     one.playerdeck.add(Player2Card1);
                                     one.playerdeck.add(Player1Card1);
                                     one.playerdeck.add(Player2Card2);
                                     one.playerdeck.add(Player1Card2);
                                     one.playerdeck.add(Player2Card3);
                                     one.playerdeck.add(Player1Card3);
                                     one.playerdeck.add(Player2Card4);
                                     one.playerdeck.add(Player1Card4);
                                 }
                                 if(Player1Card4Value > Player2Card4Value)
                                 {
                                     Winner.setText("Player 2 Wins");
                                     two.playerdeck.add(Player1Card1);
                                     two.playerdeck.add(Player2Card1);
                                     two.playerdeck.add(Player1Card2);
                                     two.playerdeck.add(Player2Card2);
                                     two.playerdeck.add(Player1Card3);
                                     two.playerdeck.add(Player2Card3);
                                     two.playerdeck.add(Player1Card4);
                                     two.playerdeck.add(Player2Card4);
                                 }  
                            }
                    }     
           }
            
         
         
       
        p1count.setText("Player 1 Card Count: " + one.playerdeck.size());
        p2count.setText("Player 2 Card Count: " + two.playerdeck.size());
        
        if(two.playerdeck.size() ==0)
        {
            win = true;
            Winner.setText("Player One Wins The Game!");
            War.setVisible(false);
            Auto.setVisible(false);
        }
        if(one.playerdeck.size() == 0)
        {
            win = true;
            Winner.setText("Player Two Wins The Game!");
            War.setVisible(false);
            Auto.setVisible(false);
        }
        
        
    }//GEN-LAST:event_WarActionPerformed

    private void InitializeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InitializeActionPerformed
        // TODO add your handling code here:
        mydeck.initializedeck(); //initialize big deck
        mydeck.shuffle(); //Shuffle big deck
        one.playerdeck = mydeck.splitdeckone(); //Split the deck and return the array list
        two.playerdeck = mydeck.splitdecktwo(); //Split the deck and return the array list
        
        p1count.setText("Player 1 Card Count: " + one.playerdeck.size());
        p2count.setText("Player 2 Card Count: " + one.playerdeck.size());
        Auto.setVisible(true);
        War.setVisible(true);
        
    }//GEN-LAST:event_InitializeActionPerformed

    private void AutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AutoActionPerformed
        // TODO add your handling code here:
        while(win == false)
        {
            War.doClick(100);
        }
    }//GEN-LAST:event_AutoActionPerformed

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
            java.util.logging.Logger.getLogger(Gamegui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gamegui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gamegui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gamegui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gamegui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Auto;
    private javax.swing.JLabel Bluecard1;
    private javax.swing.JLabel Bluecard2;
    private javax.swing.JLabel Bluecard3;
    private javax.swing.JLabel Bluecard4;
    private javax.swing.JButton Initialize;
    private javax.swing.JLabel Redcard1;
    private javax.swing.JLabel Redcard2;
    private javax.swing.JLabel Redcard3;
    private javax.swing.JLabel Redcard4;
    private javax.swing.JButton War;
    private javax.swing.JLabel Winner;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel p1count;
    private javax.swing.JLabel p2count;
    // End of variables declaration//GEN-END:variables
}
