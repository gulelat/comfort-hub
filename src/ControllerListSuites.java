
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class ControllerListSuites {
   /**
     * variable ad objects declarations
     */
    Connection conn=null;
    String querry;
    Statement st=null;
    public ListSuites listSt; 
    private ActionListener actionListener; 
    
    /**
     * constructor to instantiate objects
     */
    public ControllerListSuites( ){
        listSt = new ListSuites();
        listSt.setVisible(true);
            
                          
    }
    
    /**
     * Method to display available flights in database
     */
    public void showSuites(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/jetwingdb?zeroDateTimeBehavior=convertToNull","root","root");
        querry="SELECT * FROM Flights ;" ;
        st=conn.prepareStatement(querry);
        st.execute("USE jetwingdb;");

        ResultSet rs= st.executeQuery(querry);
   while(rs.next()){
  
   Object[] temp = {rs.getString("fName"), rs.getString("fFrom"),rs.getString("destination"),rs.getString("price"),
                    rs.getString("fCapacity"),rs.getString("depatureTime"),rs.getString("arrivalTime")};
   listSt.getTable().addRow(temp);
   }
   st.close();
   conn.close();
  
    }  
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
    
    }
    
     /**
     * Method to get source of button clicked using action listener
     */
     public void contol(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==listSt.getListButton()){
                        showSuites();
                  }
                  if(actionEvent.getSource()==listSt.getCloseButton()){
                  listSt.setVisible(false);
                  
                  }
              }
              
        };                
        listSt.getListButton().addActionListener(actionListener);
        listSt.getCloseButton().addActionListener(actionListener);
    }
}
