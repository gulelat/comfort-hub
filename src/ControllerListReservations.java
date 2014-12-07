
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
public class ControllerListReservations {
  
    /**
     * variables and object declarations
     */
    Connection conn=null;
    String deleteStudent;
    String showStudent;
    Statement st=null;
    //public DeleteOrder deleteOrder;
    public ListReservations listOrder;
    private ActionListener actionListener;
    
    /**
     * constructor to instantiate objects
     */
    public ControllerListReservations( ){
        listOrder = new ListReservations();
        listOrder.setVisible(true);
                          
    }
    
    /**
     * Method displays data on orders placed
     */
    public void showOrders(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub_db?zeroDateTimeBehavior=convertToNull","root","root");
        showStudent="SELECT * FROM reservations ;" ;
        st=conn.prepareStatement(showStudent);
        st.execute("USE comfort_hub_db;");

        ResultSet rs= st.executeQuery(showStudent);
   while(rs.next()){ 
   Object[] temp = {rs.getString("pName"), rs.getString("roomNo"),rs.getString("nationality"),rs.getString("phoneNO"),rs.getString("roomType"),
                    rs.getString("price"),rs.getString("TimeIn"),rs.getString("TimeOut")};
   listOrder.getTable().addRow(temp);
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
     public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==listOrder.getListButton()){
                        showOrders();
                  }
                  if(actionEvent.getSource()==listOrder.getCloseButton()){
                  listOrder.setVisible(false);
                  
                  }
              }
              
        };                
        listOrder.getListButton().addActionListener(actionListener);
        listOrder.getCloseButton().addActionListener(actionListener);
    }
}
