
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
public class ControllerListHotEmp {
  Connection conn=null;
    String querry;
    Statement st=null;
   public ListHotEmp listEmp; 
    private ActionListener actionListener;  
    
    
    public ControllerListHotEmp( ){
        listEmp = new ListHotEmp();
        listEmp.setVisible(true);
                          
    }
    
    /**
     * Method to display available orders in database
     */
    public void showOrders(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/jetwingdb?zeroDateTimeBehavior=convertToNull","root","root");
        querry="SELECT * FROM Employees ;" ;
        st=conn.prepareStatement(querry);
        st.execute("USE jetwingdb;");

        ResultSet rs= st.executeQuery(querry);
            while(rs.next()){
                Object[] temp = {rs.getString("eId"), rs.getString("eName"),rs.getString("email")};
                listEmp.getEmpTable().addRow(temp);
            }
            st.close();
            conn.close();

    }  
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }

    }
    
     public void contol(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==listEmp.getListButton()){
                        showOrders();
                  }
                  if(actionEvent.getSource()==listEmp.getCloseButton()){
                  listEmp.setVisible(false);
                  
                  }
              }
              
        };                
        listEmp.getListButton().addActionListener(actionListener);
        listEmp.getCloseButton().addActionListener(actionListener);
    }
}