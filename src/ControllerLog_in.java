
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
public class ControllerLog_in {
    
    Connection conn=null;
    String querry;
    Statement st=null;
    public Log_in login;
    private ActionListener actionListener;  
    
    
     public ControllerLog_in( ){
        login = new Log_in();
        login.setVisible(true);
                          
    }
     
     public void showEmployee(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/jetwingdb?zeroDateTimeBehavior=convertToNull","root","");
        querry="SELECT * FROM Employees WHERE eName like '%"+login.getUsernameField().getText()+"%' AND password like '%"+login.getPasswordField().getText()+"%' ;" ;
        st=conn.prepareStatement(querry);
        st.execute("USE jetwingdb;");

        ResultSet rs= st.executeQuery(querry);
        if (!rs.next() ) {
                JOptionPane.showMessageDialog(null," Invalid Username or Password ");
                HomePage home = new HomePage();
                home.setVisible(false);
        }
        else {

            do {
                    ControllerHomePage homepage= new ControllerHomePage();  
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
     
      public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==login.getLoginButton()){
                      if ((login.getPasswordField().getText().equals("visitor"))&&(login.getUsernameField().getText().equals("visitor"))){
                      ControllerHomePage homepage= new ControllerHomePage();  
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