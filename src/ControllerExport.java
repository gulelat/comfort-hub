
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
public class ControllerExport {
  /**
     * variable and object declarations
     */
    PrintWriter outPutStream=null;
    String path="";
    File file=null;
    Connection conn=null;
    String querry;
    Statement st=null;

    
    /**
     * Default constructor
     */
    public void ControllerExport(){
    }
    
    /**
     * Method to get destination for the data to be exported 
     */
    private void getSaveLocation() {
   
    JFrame parentFrame = new JFrame();
 
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Specify a file to save");   
 
     int userSelection = fileChooser.showSaveDialog(parentFrame);
 
    if (userSelection == JFileChooser.APPROVE_OPTION) {
    File fileToSave = fileChooser.getSelectedFile();
    path=fileToSave.getAbsolutePath();
    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
    }
    file = new File(path);
    }
    
    /**
     * Method to list available orders
     */
    public void listOrders(){
    try{
        
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
        querry="SELECT * FROM reservations ;" ;
        st=conn.prepareStatement(querry);
        st.execute("USE comfort_hub;");

        try{
            getSaveLocation();
            outPutStream=new PrintWriter(new FileOutputStream(path, true));

        }
        catch(FileNotFoundException  e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        ResultSet rs= st.executeQuery(querry);
   while(rs.next()){ 
   outPutStream.println( rs.getString("pName")+"  "+ rs.getString("roomNo")+"  "+rs.getString("nationality")+"  "+rs.getString("phoneNO")
           +" " +rs.getString("roomType")+" " +rs.getString("price")+"  "+rs.getString("TimeIn")+" "+ rs.getString("TimeOut"));
   
   }
   JOptionPane.showMessageDialog(null,"Saving Completed");
        
    outPutStream.close();
   st.close();
   conn.close();
  
    }  
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
    
    }
}
