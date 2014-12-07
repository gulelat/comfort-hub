
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
public class ControllerDeleteHotEmp {
  
    Connection conn=null;
    String querry;
     Statement st=null;
    public DeleteHotEmp deleteEmp;
    private ActionListener actionListener;
    
    
    public ControllerDeleteHotEmp( ){
        deleteEmp = new DeleteHotEmp();
        deleteEmp.setVisible(true);
                          
    }
    
     public void deleteOrder(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
       System.out.println("The key is"+deleteEmp.getKey());
        querry="DELETE FROM employees where eId ="+deleteEmp.getKey()+";" ;
        st=conn.createStatement();
        st.execute("USE comfort_hub;");
        st.executeUpdate(querry);
        
        st.close();
        conn.close();
        JOptionPane.showMessageDialog(null,"Employee has been deleted");
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }
    }
    
   public void contol(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==deleteEmp.getDeleteButton()){
                        deleteOrder();
                  }
                  if(actionEvent.getSource()==deleteEmp.getCloseButton()){
                        deleteEmp.setVisible(false);
                  }
                  }
              
        };                
        deleteEmp.getDeleteButton().addActionListener(actionListener);
        deleteEmp.getCloseButton().addActionListener(actionListener);
        } 
}
