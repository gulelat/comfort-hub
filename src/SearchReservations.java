
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dorothy
 */
public class SearchReservations extends javax.swing.JFrame {

    
    
    /**
     * Declare variables and creates columns for table
     */
    
     Connection conn = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        
        String[] colname = {"pName", "roomNo", "nationality", "phoneNO", "roomType","price","TimeIn" ,"TimeOut"  };
        String [] searchOptions = {"pName", "roomNo", "nationality", "phoneNO",  "roomType","price","TimeIn" ,"TimeOut" };
        DefaultTableModel dm = new DefaultTableModel(colname, 8);
    
    
    /**
     * Creates new form SearchReservations
     */
    public SearchReservations() {
        initComponents();
         setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        reservationTable.setEnabled(false);
        reservationTable.setModel(dm);
        dm.setColumnIdentifiers(colname);
        msgLabel.setText("Select either pName,roomNo,nationality, phoneNO, roomType,price,TimeIn ,TimeOut");
        
        
        for(int i=0; i<searchOptions.length;i++){       //add items to combobox
           searchCombo.addItem(searchOptions[i]);       
        }
        
        System.out.println("SQL Test");

        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/comfort_hub?user=root&password=root");
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }

        System.out.println("Connection established");     
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msgLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CLOSEButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationTable = new javax.swing.JTable();
        SearchButtonReservation = new javax.swing.JButton();
        SearchReservationText = new javax.swing.JTextField();
        searchCombo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        msgLabel.setBackground(new java.awt.Color(255, 255, 255));
        msgLabel.setText("jLabel3");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("RESERVATION");

        CLOSEButton.setBackground(new java.awt.Color(153, 102, 0));
        CLOSEButton.setForeground(new java.awt.Color(51, 51, 0));
        CLOSEButton.setText("CLOSE");
        CLOSEButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLOSEButtonActionPerformed(evt);
            }
        });

        reservationTable.setBackground(new java.awt.Color(153, 102, 0));
        reservationTable.setModel(dm);
        jScrollPane1.setViewportView(reservationTable);

        SearchButtonReservation.setBackground(new java.awt.Color(153, 102, 0));
        SearchButtonReservation.setForeground(new java.awt.Color(51, 51, 0));
        SearchButtonReservation.setText("SEARCH");
        SearchButtonReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonReservationActionPerformed(evt);
            }
        });

        SearchReservationText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchReservationTextActionPerformed(evt);
            }
        });

        searchCombo.setBackground(new java.awt.Color(153, 102, 0));
        searchCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(CLOSEButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchReservationText, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchButtonReservation))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(msgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchReservationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButtonReservation)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msgLabel)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(CLOSEButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CLOSEButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLOSEButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CLOSEButtonActionPerformed

    private void SearchButtonReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonReservationActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_SearchButtonReservationActionPerformed

    private void SearchReservationTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchReservationTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchReservationTextActionPerformed

    private void searchComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchComboActionPerformed

 /**
  * 
  * @return CLOSEButton,SearchButtonReservation,SearchReservationText,searchCombo,
  * msgLabel,reservationTable,dm
  */     
public JButton getCLOSEButton(){
       return  CLOSEButton;
    }


public JButton getSearchButtonReservation(){
       return  SearchButtonReservation;
    }
    
   
public JTextField getSearchReservationText(){
       return  SearchReservationText;
    } 
    

public JComboBox getsearchCombo(){
       return  searchCombo;
    }


public JLabel getmsgLabel(){
       return  msgLabel;
    }



public JTable getreservationTable(){
       return  reservationTable;
    }


public DefaultTableModel getModel(){
return dm;
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
            java.util.logging.Logger.getLogger(SearchReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchReservations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CLOSEButton;
    private javax.swing.JButton SearchButtonReservation;
    private javax.swing.JTextField SearchReservationText;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel msgLabel;
    private javax.swing.JTable reservationTable;
    private javax.swing.JComboBox searchCombo;
    // End of variables declaration//GEN-END:variables
}
