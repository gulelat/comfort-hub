
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


public class ControllerGetLog {
    
    /**
     * declaring variables that will be used in method to connect to database
     */
   Connection conn=null;
    String querry;
    Statement st=null;
    public log_in login;
    public LOGINS logs;
    private ActionListener actionListener;  
    int time = 0;
    
    /**
     * instantiating a linked list 
     */
    List lnkLst = new LinkedList();
   
    /**
     * a method to get the names of users that log in to program
     */
   public void show(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
        querry="SELECT * FROM employees WHERE eName like '%"+login.getUsernameField().getText()+"%' AND password like '%"+login.getPasswordField().getText()+"%' ;" ;
        st=conn.prepareStatement(querry);
        st.execute("USE comfort_hub;");

        
            lnkLst.add(login.getUsernameField().getText());   
        
        
        ResultSet rs= st.executeQuery(querry);

   st.close();
   conn.close();
  
    }  
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
     }
   
   /**
    * a method that displays the names in the linked list
    * @param lnkLst 
    */
   public void display(Collection lnkLst) {
      Iterator itr = lnkLst.iterator();
      while (itr.hasNext()) {
         String str = (String) itr.next();
         System.out.print(str + " ");
      }
      System.out.println();
   }
   
    /**
      * method to perform actions of events
      */
      public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==logs.getLogs()){
                       show();
                        display(lnkLst);                
                  }
                  if(actionEvent.getSource()==logs.getCloseButton()){
                      logs.setVisible(false); 
                  }
                  
              }
              
        };                
        logs.getLogs().addActionListener(actionListener);
        logs.getCloseButton().addActionListener(actionListener);
    }
}
