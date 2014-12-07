
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
public class ControllerAddHotEmp {
    
    /**
     * variables and objects declarations
     */
    Connection conn=null;
    String querry;
    Statement st=null;
    public Hotel_Employee enterEmp;
    private ActionListener actionListener;
    
    
    /**
     * constructor to instantiate declared objects
     */
    public ControllerAddHotEmp( ){
       // this.deleteOrder = delete;
        enterEmp = new Hotel_Employee();
        enterEmp.setVisible(true);
                          
    }
    
    /**
    * Method to add employees
    */
    public void addEmployee(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub_db?zeroDateTimeBehavior=convertToNull","root","root");
       
        querry=("INSERT INTO employees SET eId=?,eName=?,email=?,password=?;") ;
       PreparedStatement p =conn.prepareStatement(querry);
       p.setString(1,enterEmp.getTAKEID().getText());
       p.setString(2,enterEmp.getTAKENAME().getText());
       p.setString(3,enterEmp.getTAKEMAIL().getText());
       p.setString(4,enterEmp.getTAKEPASS().getText());
       p.execute();
       
        p.close();
        conn.close();
        JOptionPane.showMessageDialog(null,"Employee has been added");
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        
        
    }
    /**
     * Method to get source of button clicked using action listener
     * to save and close employee form
     */
     public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==enterEmp.getSAVE()){
                        addEmployee();
                  }
                  if(actionEvent.getSource()==enterEmp.getEXIT()){
                        enterEmp.setVisible(false);
                  }
                  }
              
        };                
        enterEmp.getSAVE().addActionListener(actionListener);
        enterEmp.getEXIT().addActionListener(actionListener);
        }
}

