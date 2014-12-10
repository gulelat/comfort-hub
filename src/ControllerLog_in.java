
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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
public class ControllerLog_in {
    /**
     * method to declare and instantiate variables
     */
    Connection conn=null;
    String querry;
    Statement st=null;
    public log_in login;
    private ActionListener actionListener;  
   
    
   
    /**
     * constructor to create a new form
     */
     public ControllerLog_in( ){
        login = new log_in();
        login.setVisible(true);
                          
    }
     
     /**
      * method to display employees data
      */
     public void showEmployee(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
        querry="SELECT * FROM employees WHERE eName like '%"+login.getUsernameField().getText()+"%' AND password like '%"+login.getPasswordField().getText()+"%' ;" ;
        st=conn.prepareStatement(querry);
        st.execute("USE comfort_hub;");

       
        ResultSet rs= st.executeQuery(querry);
        if (!rs.next() ) {
                JOptionPane.showMessageDialog(null," Invalid Username or Password ");
                HomePage home = new HomePage();
                home.setVisible(false);
        }
        else {

            do {
                    HomePageController homepage= new HomePageController();  
                    homepage.control();
                    login.setVisible(false);
            } while (rs.next());
        }
   st.close();
   conn.close();
  
    }  
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
     }
     
    
     /**
      * method to perform actions of events
      */
      public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==login.getLoginButton()){
                      if ((login.getPasswordField().getText().equals("visitor"))&&(login.getUsernameField().getText().equals("visitor"))){
                      HomePageController homepage= new HomePageController();  
                      homepage.control();
                      login.setVisible(false);
                      }
                      else{
                       showEmployee();
                      }
                      
                  }
                  if(actionEvent.getSource()==login.getVisitorButton()){
                        JOptionPane.showMessageDialog(null,"Dafault login: Username:- visitor & Password:- visitor");
                  }
                  
              }
              
        };                
        login.getLoginButton().addActionListener(actionListener);
        login.getVisitorButton().addActionListener(actionListener);
    }
}
