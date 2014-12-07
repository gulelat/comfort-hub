
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dorothy
 */
public class SearchReservationsController {
   
    
    
        Connection conn = null;
        PreparedStatement p = null;
        ResultSet rs = null;
        
        
 private SearchReservations view2;
    
    private ActionListener actionListener;
    
    
    public SearchReservationsController(SearchReservations v){
        view2 = v;
        view2.setVisible(true);
    }
    
    
    
    public void control(){
        
          try{
                   Class.forName("com.mysql.jdbc.Driver").newInstance();
                    conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull", "root", "root");
                   // System.out.println("passes");
        }catch (Exception e){
            System.out.println("exception in control "+e.toString());
            System.out.println(" NO PASSWORD RES");
        }
          
    actionListener= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==view2.getSearchButtonReservation()){
                 Reserve();
                    
                }
                
                
                else if(e.getSource()==view2.getCLOSEButton()){
                 //view2.setVisible(false);
                     view2.dispose();
                }
                               
                   
            }
        };
    view2.getCLOSEButton().addActionListener(actionListener);
    view2.getSearchButtonReservation().addActionListener(actionListener);
   
    }
    public void showMyForm(){
        new SearchSuite().setVisible(true); 
    }

    
    
    public void Reserve(){
        
          try{
                   Class.forName("com.mysql.jdbc.Driver").newInstance();
                    conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull", "root", "root");
                    //System.out.println("passes");
        }catch (Exception e){
            System.out.println("exception in control "+e.toString());
            System.out.println(" NO PASSWORD RES");
        }
        
        
        
    
     if(view2.getSearchReservationText().getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"please fill search field");
        }
         if(view2.getsearchCombo().getSelectedIndex()==0){
              view2.getmsgLabel().setText("Enter pName");
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    p = conn.prepareStatement("SELECT * FROM reservations   where pName=?");
                    p.setString(1, view2.getSearchReservationText().getText());
                    rs = p.executeQuery();
                    
            //this clears table
                 view2.getModel().setRowCount(0);
                 
                while(rs.next()){
                   view2.getModel().addRow(new String[]{
                   rs.getString("pName"),
                   rs.getString("roomNo"),
                   rs.getString("nationality"),
                   rs.getString("phoneNO"),
                   rs.getString("roomType"),
                   rs.getString("price"),
                   rs.getString("TimeIn"),  
                   rs.getString("TimeOut"),
                   });
                }
                //view2.getreservationTable().setModel(tbl);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
            
         }
        
         
         if(view2.getsearchCombo().getSelectedIndex()==1){
             view2.getmsgLabel().setText("Enter from");
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    p = conn.prepareStatement("SELECT * FROM reservations   where roomNo=?");
                    p.setString(1, view2.getSearchReservationText().getText());
                    rs = p.executeQuery();

                    //this clears table
                 view2.getModel().setRowCount(0);
                    
                    
                while(rs.next()){
                   view2.getModel().addRow(new String[]{
                   rs.getString("pName"),
                   rs.getString("roomNo"),
                   rs.getString("nationality"),
                   rs.getString("phoneNO"),
                   rs.getString("roomType"),
                   rs.getString("price"),
                   rs.getString("TimeIn"),  
                   rs.getString("TimeOut"),         
                   });
                }
                //view2.getreservationTable().setModel(tbl);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
            
         }
         
         
         
         if(view2.getsearchCombo().getSelectedIndex()==2){
          
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    p = conn.prepareStatement("SELECT * FROM reservations   where nationality=?");
                    p.setString(1, view2.getSearchReservationText().getText());
                    rs = p.executeQuery();

                  //this clears table
                 view2.getModel().setRowCount(0);  
                    
                while(rs.next()){
                   view2.getModel().addRow(new String[]{
                   rs.getString("pName"),
                   rs.getString("roomNo"),
                   rs.getString("nationality"),
                   rs.getString("phoneNO"),
                   rs.getString("roomType"),
                   rs.getString("price"),
                   rs.getString("TimeIn"),  
                   rs.getString("TimeOut"),
                   });
                }
                //view2.getreservationTable().setModel(tbl);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
            
         }
         
         if(view2.getsearchCombo().getSelectedIndex()==3){
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    p = conn.prepareStatement("SELECT * FROM reservations   where phoneNO=?");
                    p.setString(1, view2.getSearchReservationText().getText());
                    rs = p.executeQuery();

        //this clears table
                 view2.getModel().setRowCount(0);            
                    
                while(rs.next()){
                   view2.getModel().addRow(new String[]{
                  rs.getString("pName"),
                   rs.getString("roomNo"),
                   rs.getString("nationality"),
                   rs.getString("phoneNO"),
                   rs.getString("roomType"),
                   rs.getString("price"),
                   rs.getString("TimeIn"),  
                   rs.getString("TimeOut"),
                   });
                }
                //view2.getreservationTable().setModel(tbl);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
           
         }
           
     
        
         if(view2.getsearchCombo().getSelectedIndex()==4){
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    p = conn.prepareStatement("SELECT * FROM reservations   where roomType=?");
                    p.setString(1, view2.getSearchReservationText().getText());
                    rs = p.executeQuery();

         //this clears table
                 view2.getModel().setRowCount(0);           
                    
                while(rs.next()){
                   view2.getModel().addRow(new String[]{
                   rs.getString("pName"),
                   rs.getString("roomNo"),
                   rs.getString("nationality"),
                   rs.getString("phoneNO"),
                   rs.getString("roomType"),
                   rs.getString("price"),
                   rs.getString("TimeIn"),  
                   rs.getString("TimeOut"),
                   });
                }
               //view2.getreservationTable().setModel(tbl);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
           
         } 
         
            
         
         if(view2.getsearchCombo().getSelectedIndex()==5){
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    p = conn.prepareStatement("SELECT * FROM reservations   where price=?");
                    p.setString(1, view2.getSearchReservationText().getText());
                    rs = p.executeQuery();

                 //this clears table
                 view2.getModel().setRowCount(0);   
                    
                while(rs.next()){
                   view2.getModel().addRow(new String[]{
                  rs.getString("pName"),
                   rs.getString("roomNo"),
                   rs.getString("nationality"),
                   rs.getString("phoneNO"),
                   rs.getString("roomType"),
                   rs.getString("price"),
                   rs.getString("TimeIn"),  
                   rs.getString("TimeOut"),
                   });
                }
                //view2.getreservationTable().setModel(tbl);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
           
         } 
         
         
         
          if(view2.getsearchCombo().getSelectedIndex()==6){
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    p = conn.prepareStatement("SELECT * FROM reservations   where TimeIn=?");
                    p.setString(1, view2.getSearchReservationText().getText());
                    rs = p.executeQuery();
                    
                  //this clears table
                 view2.getModel().setRowCount(0);  
                    
                while(rs.next()){
                   view2.getModel().addRow(new String[]{
                   rs.getString("pName"),
                   rs.getString("roomNo"),
                   rs.getString("nationality"),
                   rs.getString("phoneNO"),
                   rs.getString("roomType"),
                   rs.getString("price"),
                   rs.getString("TimeIn"),  
                   rs.getString("TimeOut"),
                   });
                }
                //view2.getreservationTable().setModel(tbl);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
           
         }
        
        
        
        
        
          if(view2.getsearchCombo().getSelectedIndex()==7){
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    p = conn.prepareStatement("SELECT * FROM reservations   where TimeOut=?");
                    p.setString(1, view2.getSearchReservationText().getText());
                    rs = p.executeQuery();

            //this clears table
                 view2.getModel().setRowCount(0);        
                    
                    
                while(rs.next()){
                   view2.getModel().addRow(new String[]{
                  rs.getString("pName"),
                   rs.getString("roomNo"),
                   rs.getString("nationality"),
                   rs.getString("phoneNO"),
                   rs.getString("roomType"),
                   rs.getString("price"),
                   rs.getString("TimeIn"),  
                   rs.getString("TimeOut"),
                   });
                }
                //reservationTable.setModel(tbl);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
           
         }
        
        
        
        
        
        
        
    
    
    }
}
