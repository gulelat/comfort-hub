
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class ControllerBillings {
    /**
     * declaring variables for class
     * declaring variables that connect to the database
     */
   Connection conn=null;
   String check="";
  
    String querry;
    Statement st=null;
    public Billings addBill; 
    private ActionListener actionListener; 
    
      /**
     * constructor to instantiate objects declared
     */
    public ControllerBillings( ){
        addBill = new Billings();
        addBill.setVisible(true);
                          
    }
    /**
     * 
     * @return check
     */
    public String getMode(){
        return check;
    }
    /**
     * method to calculate total cost
     * @return tot
     */
    int tot;
    public int getTotal(){
      tot =Integer.parseInt(addBill.getNumday().getText())* Integer.parseInt(addBill.getPrice().getText());
      
      addBill.setTotal(tot);
      return tot;
    }
    
      
    /**
     * Method to add bills of customers
     */
    public void addBill(){
    try{
       Class.forName("com.mysql.jdbc.Driver");
       conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
       
        querry=("INSERT INTO bill SET name=? ,priceperday =?,numofdays =?,pmode =?,tots=?;");
        
    PreparedStatement p =conn.prepareStatement(querry);
   
    p.setString(1, addBill.getCustomer().getText());
    p.setString(2, addBill.getPrice().getText());
    p.setString(3, addBill.getNumday().getText());
    p.setString(4, addBill.getPay().getSelectedItem().toString());
    p.setInt(5, tot);
    p.execute();
        
    p.close();
   conn.close();
  JOptionPane.showMessageDialog(null, "Bill has been prepared succesfully");
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
                  if(actionEvent.getSource()==addBill.getSaveButton()){
                        addBill();
                  }
                  if(actionEvent.getSource()==addBill.getTots()){
                        getTotal();
                  }
                 
                  if(actionEvent.getSource()==addBill.getCloseButton()){
                  addBill.setVisible(false);
                  System.out.println("checking");
                  }
                  if(actionEvent.getSource()==addBill.getPay()){
                  addBill.setEnabled(true);
                  System.out.println("checking");
                  }
             }
        
                };
        addBill.getSaveButton().addActionListener(actionListener);
        addBill.getCloseButton().addActionListener(actionListener);
        addBill.getPay().addActionListener(actionListener);
        addBill.getTots().addActionListener(actionListener);
    }
}

