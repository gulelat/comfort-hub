
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class ControllerDeleteRes {
   
     /**
     * variable and objects declarations
     */
    Connection conn=null;
    String deleteOrd;;
    Statement st=null;
    public DeleteRes deleteOrder;
    private ActionListener actionListener;
    
    /**
     * Creates new form DeleteOrderController
     */
    public ControllerDeleteRes( ){
        deleteOrder = new DeleteRes();
        deleteOrder.setVisible(true);
                          
    }
    
     /**
     * Method to retrieve data from database and delete
     */
    public void deleteOrder(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub_db?zeroDateTimeBehavior=convertToNull","root","root");
        deleteOrd="DELETE FROM reservations where phoneNO ="+deleteOrder.getKey()+";" ;
        st=conn.createStatement();
        st.execute("USE comfort_hub_db;");
        st.executeUpdate(deleteOrd);
        
        st.close();
        conn.close();
        JOptionPane.showMessageDialog(null,"Order has been deleted");
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }
    }
    
    /**
     * Method to get sources of clicked button using action listener
     */
     public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==deleteOrder.getDeleteButton()){
                        deleteOrder();
                  }
                  if(actionEvent.getSource()==deleteOrder.getCloseButton()){
                        deleteOrder.setVisible(false);
                  }
                  }
              
        };                
        deleteOrder.getDeleteButton().addActionListener(actionListener);
        deleteOrder.getCloseButton().addActionListener(actionListener);
        }
}
