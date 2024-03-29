
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
public class ControllerAddSuite {
   Connection conn=null;
   String check="";
   String type="";
    String querry;
    Statement st=null;
    public AddSuite addSt; 
    private ActionListener actionListener;  
    
    
     /**
     * constructor to instantiate objects declared
     */
    public ControllerAddSuite( ){
        addSt = new AddSuite();
        addSt.setVisible(true);
                          
    }
    /**
     * 
     * @return check,type
     */
    public String getAvail(){
        return check;
    }
    public String getSType(){
        return type;
    }
    
   
    
    /**
     * Method to add rooms
     */
    public void addSuites(){
    try{
       Class.forName("com.mysql.jdbc.Driver");
       conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
       
        querry=("INSERT INTO suites SET sNum=? ,type =?,sPrice =?,availability =?;");
        
    PreparedStatement p =conn.prepareStatement(querry);
   
    p.setString(1, addSt.getNumber().getText());
    p.setString(2, addSt.getSType().getSelectedItem().toString());
    p.setString(3, addSt.getPrice().getText());
    p.setString(4, addSt.getAvail().getSelectedItem().toString());
    p.execute();
        
    p.close();
   conn.close();
  JOptionPane.showMessageDialog(null, "Suite has been succesfully added");
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
                  if(actionEvent.getSource()==addSt.getSaveButton()){
                        addSuites();
                  }
                  if(actionEvent.getSource()==addSt.getCloseButton()){
                  addSt.setVisible(false);
                  
                  }
                  if(actionEvent.getSource()==addSt.getAvail()){
                  addSt.setEnabled(true);
                  
                  }
                  if(actionEvent.getSource()==addSt.getSType()){
                  addSt.setEnabled(true);
                  
                  }
                  
              }
              
        };                
        addSt.getSaveButton().addActionListener(actionListener);
        addSt.getCloseButton().addActionListener(actionListener);
        addSt.getAvail().addActionListener(actionListener);
    }
}
