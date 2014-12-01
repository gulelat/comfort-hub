
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
public class ControllerModifyRes {
     /**
     * Objects and variable declarations
     */
    Connection connection=null;
    String deleteStudent;
    String query;
    Statement stmt=null;
    public ModifyRes modifyOrder;
    private ActionListener actionListener;
    
    
    /**
     * Creates a new ControllerModifyOrder form
     */
    public ControllerModifyRes(){
        modifyOrder = new ModifyRes();
        modifyOrder.setVisible(true);
    }
    
    /**
     * Method displays all data in  database for modification
     */
    public void showAllDetails(){
        String key="";
        key = modifyOrder.getPNum().getText();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/jetwingdb?zeroDateTimeBehavior=convertToNull","root","root");
            query="SELECT * FROM Orders  WHERE passPortNo LIKE'%"+key+"%'";
            stmt=connection.prepareStatement(query);
            stmt.execute("USE jetwingdb;");

            ResultSet rs= stmt.executeQuery(query);
        
            while(rs.next()){
 
                modifyOrder.getSearch().setText(rs.getString("name"));
                modifyOrder.getPNum().setText(rs.getString("passPortNo"));
                modifyOrder.getNationality().setText(rs.getString("email"));
                modifyOrder.getNameField().setText(rs.getString("phoneNO"));
                modifyOrder.getPriceField().setText(rs.getString("flightNo"));
                modifyOrder.getRNum().setText(rs.getString("seatNo"));
                modifyOrder.getRoomType().setText(rs.getString("fFrom"));
                modifyOrder.getTIMEIN().setText(rs.getString("destination"));
                modifyOrder.getTIMEOUT().setText(rs.getString("depatureTime")); 
                
        }
  
        stmt.close();
        connection.close();
        } 
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
    
     /**
     * Method writes back changes to database
     */
    public void insertChanges(){
        String key="";
        key = modifyOrder.getPNum().getText();
    try{
        Class.forName("com.mysql.jdbc.Driver");
        //jdbc:mysql://localhost:3306/jetwingdb?zeroDateTimeBehavior=convertToNull [root on Default schema]
        connection =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/jetwingdb?zeroDateTimeBehavior=convertToNull","root","root");
        query="UPDATE Orders SET name=?, passPortNo=?, email=?, phoneNo=?, flightNo=?, seatNo=?, fFrom=?, destination=?, depatureTime=?, arrivalTime=?"
                + "where passPortNo like '%"+ key +"%';";
//        querry = "update flights set fName =?,ffrom=?,destination=?,Price=?,fCapacity=?,depatureTime=?,arrivalTime=?"
//                    + "where fName like '%" + ky + "%'";
        PreparedStatement st=connection.prepareStatement(query);
        st.execute("USE jetwingdb;");

   st.setString(1, modifyOrder.getSearch().getText());
   st.setString(2, modifyOrder.getPNum().getText());
   st.setString(3, modifyOrder.getNationality().getText());
   st.setString(4, modifyOrder.getNameField().getText());
   st.setString(5, modifyOrder.getPriceField().getText());
   st.setString(6, modifyOrder.getRNum().getText());
   st.setString(7, modifyOrder.getRoomType().getText());
   st.setString(8, modifyOrder.getTIMEIN().getText());
   st.setString(9, modifyOrder.getTIMEOUT().getText());
  
   st.execute();
   JOptionPane.showMessageDialog(null, "Order modified succesfully");
   stmt.close();
   connection.close();
  
    }  
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    
    }
    
     
    /**
     * Method to get source of button clicked using the action listener
     */
    public void control(){        
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {  
                if(actionEvent.getSource()==modifyOrder.getSaveButton()){
                    insertChanges();
                }
                if(actionEvent.getSource()==modifyOrder.getCloseButton()){
                    modifyOrder.setVisible(false);
                }
                if(actionEvent.getSource()==modifyOrder.getSearchButton()){
                  showAllDetails();  
                }
            }
    };               
        modifyOrder.getSaveButton().addActionListener(actionListener);
        modifyOrder.getCloseButton().addActionListener(actionListener);
        modifyOrder.getSearchButton().addActionListener(actionListener);
    }
}
