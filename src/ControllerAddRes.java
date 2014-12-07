
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class ControllerAddRes {
    
     /**
     * variable and object declarations
     */
    Connection conn=null;
    String data="";
    String querry;
    Statement st=null;
    public AddRes EnterOrder;
    private ActionListener actionListener;
    
    /**
     * constructor for instantiating declared objects
     */
    public ControllerAddRes( ){
        EnterOrder = new AddRes();
        EnterOrder.setVisible(true);
        showSuites();                   
    }
    
    /**
     * 
     * @return data
     */
    public String getClickedFlight(){
        return data;
    }
    
    /**
     * Method to display available flights
     */
     public void showSuites(){
         
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
        querry="SELECT * FROM suites ;" ;
        st=conn.prepareStatement(querry);
        st.execute("USE comfort_hub;");

        ResultSet rs= st.executeQuery(querry);
   while(rs.next()){
   EnterOrder.getRnum().addItem(rs.getString("sNum"));
  
   }
   st.close();
   conn.close();
   rs.close();
    }  
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
    
    }
     
     /**
      * Method to add orders and write to database
      */
    public void addOrders(){
    try{
       Class.forName("com.mysql.jdbc.Driver");
       conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
       
        querry=("INSERT INTO reservations SET pName=?,roomNo=? ,nationality =?,phoneNO =?,roomType =?,price=? ,TimeIn =?,TimeOut =?;");
        
    PreparedStatement p =conn.prepareStatement(querry);
    p.setString(1, EnterOrder.getPName().getText());
    p.setString(2, (EnterOrder.getRnum().getSelectedItem()).toString());
    p.setString(3, EnterOrder.getPNation().getText());
    p.setString(4, EnterOrder.getPhoneNo().getText());
    p.setString(5, EnterOrder.getRoomType().getText());
    p.setString(6, EnterOrder.getPrice().getText());
    p.setString(7, EnterOrder.getTimeIn().getText());
    p.setString(8, EnterOrder.getTimeOut().getText());
   
    p.execute();
               
    p.close();
   conn.close();
  JOptionPane.showMessageDialog(null, "Order has been succesfully added");
    }  
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
    
    
    }
    
     /**
     * Method to get source of button clicked using action listener 
     * and display the in combo form
     */
    public void controlCombo(){        
        actionListener = new ActionListener() {
            
              public void actionPerformed(ActionEvent actionEvent) {  
                  if (EnterOrder.getRnum().getSelectedIndex() != -1) {                     
               data = (EnterOrder.getRnum().getItemAt(EnterOrder.getRnum().getSelectedIndex())).toString();
                setDetails(data);
            }
              }
              
        };                
        EnterOrder.getRnum().addActionListener(actionListener);
    }
    
    /**
     * 
     * @param d
     * Method to write passenger order details to database
     */
     public void setDetails(String d){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
        querry="SELECT price,TimeOut,TimeIn FROM reservations WHERE phoneNO LIKE '%"+d+"%';" ; 
        st=conn.prepareStatement(querry);
        st.execute("USE comfort_hub;");

        ResultSet rs= st.executeQuery(querry);
   while(rs.next()){
    //EnterOrder.getFrom().setText(rs.getString("fFrom"));
    EnterOrder.getPrice().setText(rs.getString("price"));
    EnterOrder.getTimeOut().setText(rs.getString("TimeOut"));
    EnterOrder.getTimeIn().setText(rs.getString("TimeIn"));
     
   }
   st.close();
   conn.close();
  
    }  
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
    
    }
     
     public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==EnterOrder.getSaveButton()){
                        addOrders();
                  }
                  if(actionEvent.getSource()==EnterOrder.getCloseButton()){
                  EnterOrder.setVisible(false);
                  
                  }
                  if(actionEvent.getSource()==EnterOrder.getRnum()){
                  showSuites();
                  
                  }
              }
              
        };                
        EnterOrder.getSaveButton().addActionListener(actionListener);
        EnterOrder.getCloseButton().addActionListener(actionListener);
        
    }
}
