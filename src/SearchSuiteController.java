
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
public class SearchSuiteController {
   
        Connection conn = null;
        PreparedStatement p = null;
        ResultSet rs = null;
    
        
        
    private SearchSuite view1;
    
    private ActionListener actionListener;
    
    
    public SearchSuiteController(SearchSuite v){
        view1 = v;
        view1.setVisible(true);
    }
    
    
    
    public void control(){
        try{
                   Class.forName("com.mysql.jdbc.Driver").newInstance();
                    conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/comfort_hub?user=root&password=root");
                    //System.out.println("passes");
        }catch (Exception e){
            System.out.println("exception in control "+e.toString());
        }
    actionListener= new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==view1.getSearchButtonSuite()){
                    
                    searchSuite();
                }
                else if(e.getSource()==view1.getSEARCHButtonReservation()){
                    showNewForm2();
                    
                }
                
                 else if(e.getSource()==view1.getSEARCHButtonEmployee()){
                    showNewForm1();
                    
                }
                else if(e.getSource()==view1.getCLOSEButton()){
//                    HomePage home= new HomePage();
//                    home.setVisible(true);
                 view1.dispose();
                }
                 
                   
            }
        };
    view1.getSEARCHButtonEmployee().addActionListener(actionListener);
    view1.getCLOSEButton().addActionListener(actionListener);
    view1.getSEARCHButtonReservation().addActionListener(actionListener);
    view1.getSearchButtonSuite().addActionListener(actionListener);
   
    }
    

    
    public void showNewForm1() {

        SearchEmployee view = new SearchEmployee();
        SearchEmployeeController controller = new SearchEmployeeController(view);

        controller.control();
    }


     public void showNewForm2(){
         
            SearchReservations view2= new SearchReservations();
            SearchReservationsController controller2 = new SearchReservationsController(view2);
            
            controller2.control();
    }

    
     
     
       public void searchSuite(){
           
            try{
                   Class.forName("com.mysql.jdbc.Driver").newInstance();
                    conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/comfort_hub?user=root&password=root");
                    //System.out.println("passes");
        }catch (Exception e){
            System.out.println("exception in control "+e.toString());
        } 
           
           
           
           
         if(view1.getSearchSuiteText().getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"please fill search field");
        }
         
         if(view1.getsearchCombo().getSelectedIndex()==0){
              view1.getmsgLabel().setText("Enter suite name");
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    
                    p = conn.prepareStatement("SELECT * FROM suites  where sName=?");                    
                    p.setString(1, view1.getSearchSuiteText().getText());
                    rs = p.executeQuery();
                    //this clears table
                 view1.getModel().setRowCount(0);
                    
                while(rs.next()){
                   // System.out.println("inside");
                   view1.getModel().addRow(new String[]{
                   rs.getString("sName"),
                   rs.getString("sNum"),
                   rs.getString("type"),
                   rs.getString("sPrice"),
                   rs.getString("availability"),  
                   });
                }
               
                }catch(Exception e){
                    System.out.println("Exception "+e.getMessage());
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
            
         }
        
         
         if(view1.getsearchCombo().getSelectedIndex()==1){
             view1.getmsgLabel().setText("Enter from");
           
            try{
                  
                    p = conn.prepareStatement("SELECT * FROM suites  where sNum=?");
                    p.setString(1, view1.getSearchSuiteText().getText());
                    rs = p.executeQuery();

                    //this clears table
                 view1.getModel().setRowCount(0);
                     
                    
                while(rs.next()){
                   view1.getModel().addRow(new String[]{
                   rs.getString("sName"),
                   rs.getString("sNum"),
                   rs.getString("type"),
                   rs.getString("sPrice"),
                   rs.getString("availability"),        
                   });
                }
                //flightTable.setModel(tbl);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
            
         }
         
         
         
         if(view1.getsearchCombo().getSelectedIndex()==2){
            //view1.getmsgLabel().setText("HR, FIN,IT, BB, SC, Foods, ENG, CD,LAB, QTY, SFTY");
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    p = conn.prepareStatement("SELECT * FROM suites  where type=?");
                    p.setString(1, view1.getSearchSuiteText().getText());
                    rs = p.executeQuery();

                 //this clears table
                 view1.getModel().setRowCount(0);
                        
                    
                while(rs.next()){
                   view1.getModel().addRow(new String[]{
                   rs.getString("sName"),
                   rs.getString("sNum"),
                   rs.getString("type"),
                   rs.getString("sPrice"),
                   rs.getString("availability"),
                   });
                }
                //flightTable.setModel(tbl);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
            
         }
         
         if(view1.getsearchCombo().getSelectedIndex()==3){
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    p = conn.prepareStatement("SELECT * FROM suites  where sPrice=?");
                    p.setString(1, view1.getSearchSuiteText().getText());
                    rs = p.executeQuery();

                    
                //this clears table
                 view1.getModel().setRowCount(0);     
                    
                while(rs.next()){
                  view1.getModel().addRow(new String[]{
                   rs.getString("sName"),
                   rs.getString("sNum"),
                   rs.getString("type"),
                   rs.getString("sPrice"),
                   rs.getString("availability"),
                   });
                }
                //flightTable.setModel(tbl);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                     JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
           
         }
           
     
        
         if(view1.getsearchCombo().getSelectedIndex()==4){
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try{
                    p = conn.prepareStatement("SELECT * FROM suites  where availability=?");
                    p.setString(1, view1.getSearchSuiteText().getText());
                    rs = p.executeQuery();

                  //this clears table
                 view1.getModel().setRowCount(0);
                       
                    
                while(rs.next()){
                   view1.getModel().addRow(new String[]{
                   rs.getString("sName"),
                   rs.getString("sNum"),
                   rs.getString("type"),
                   rs.getString("sPrice"),
                   rs.getString("availability"),
                   });
                }
                //flightTable.setModel(tbl);
                }catch(Exception e){
                     JOptionPane.showMessageDialog(null, e.getMessage());
                     JOptionPane.showMessageDialog(null, "entry cannot be found");
                }
           
         } 
         
            
         
           
         
    }   
}
