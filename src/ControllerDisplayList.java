
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
public class ControllerDisplayList {
   
    /**
     * Variable declarations
     * Object declarations
    */
    Connection connect = null;
    String list;
    Statement stmt = null;
    public DisplayList  displayList;
    private ActionListener actionListener;

    
    /**
     * Constructor for instantiating declared objects
     */
    public ControllerDisplayList(){
        displayList = new DisplayList();
        displayList.setVisible(true);
    }
    
    /**
     * ListOrders display customer orders in database
     * onto a list model
     */
    public void listOrders(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //jdbc:mysql://localhost:3306/jetwingdb?zeroDateTimeBehavior=convertToNull [root on Default schema]
            connect =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
            list="SELECT * FROM reservations ;" ;
            stmt=connect.prepareStatement(list);
            stmt.execute("USE comfort_hub;");

            ResultSet rs= stmt.executeQuery(list);
            
            while(rs.next()){
                displayList.listModel.addElement(rs.getString("pName") + "  " + rs.getString("roomNo") + "  "+ rs.getString("nationality") +
                        "  " + rs.getString("phoneNO") + "  " + rs.getString("roomType") + "  " + rs.getString("price") + 
                        "  " + rs.getString("TimeIn") + "  " + rs.getString("TimeOut"));
            }
            stmt.close();
            connect.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
    /**
     * Control listens to button clicked for action
     */
     public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==displayList.getListButton()){
                        listOrders();
                  }
                  if(actionEvent.getSource()==displayList.getCloseButton()){
                  displayList.setVisible(false);
                  }
              }
              
        };                
        displayList.getListButton().addActionListener(actionListener);
        displayList.getCloseButton().addActionListener(actionListener);
    }
}
