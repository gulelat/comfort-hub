
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
public class ControllerDeleteSuite {
   
    /**
     * variables and object declarations
     */
    Connection conn=null;
    String deleteF;
    Statement st=null;
    public DeleteSuite deleteSt;
    private ActionListener actionListener;
    
    /**
     * constructor for instantiating objects
     */
    public ControllerDeleteSuite( ){
       // this.deleteOrder = delete;
        deleteSt = new DeleteSuite();
        deleteSt.setVisible(true);
                          
    }
    
     /**
    * Method to delete  suite
    */
    public void deleteSuite(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
        deleteF="DELETE FROM suites where sNum ='"+deleteSt.getKey()+"';" ;
        st=conn.createStatement();
        st.execute("USE comfort_hub;");
        st.executeUpdate(deleteF);
        
        st.close();
        conn.close();
        JOptionPane.showMessageDialog(null,"Suite has been deleted");
        }
        catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
        }
    }
    
    /**
     * Method to get sources of button clicked using the action listener
     */
     public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==deleteSt.getDeleteButton()){
                        deleteSuite();
                  }
                  if(actionEvent.getSource()==deleteSt.getCloseButton()){
                        deleteSt.setVisible(false);
                  }
                  }
              
        };                
        deleteSt.getDeleteButton().addActionListener(actionListener);
        deleteSt.getCloseButton().addActionListener(actionListener);
        } 
}

