
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.print.*;
import javax.swing.JFrame;
import javax.swing.UIManager;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dorothy
 */
public class ControllerPrintBill implements Printable{
    
     /**
     * constructor to instantiate objects
     * creates a new print bill list
    */
    public ControllerPrintBill( ){
     listSt = new PrintBill();
     listSt.setVisible(true);       
                          
    }
     /**
     * declaring variables that are used to connect to the database
     */
    Connection conn=null;
    String querry;
    String printed;
    String data;
    Statement st=null;
    public PrintBill listSt; 
    private ActionListener actionListener; 
     
    /**
     * Method displays data on total bills of customers
     */
    public void showOrders(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
        printed="SELECT * FROM bill ;" ;
        st=conn.prepareStatement(printed);
        st.execute("USE comfort_hub;");

        ResultSet rs= st.executeQuery(printed);
   while(rs.next()){ 
   Object[] temp = {rs.getString("name"), rs.getString("priceperday"),rs.getString("numofdays"),
       rs.getString("pmode"),rs.getString("tots")};
   listSt.getTable().addRow(temp);
   data = rs.getString("name") + " " + rs.getString("priceperday")+ " " + rs.getString("numofdays")+
      " " +  rs.getString("pmode") + " " +rs.getString("tots") ;
   }
   st.close();
   conn.close();
  
    }  
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    }
        }
     /**
      * method that displays a list model of the bills
      * @return listmodel table
      */   
    public DefaultTableModel printBill (){
       
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  JOptionPane.showMessageDialog(null,"Beginning Printing");
                  job.print();
                  
                   JOptionPane.showMessageDialog(null,"Printing Succesful");
             } catch (PrinterException ex) {
              JOptionPane.showMessageDialog(null,ex);
             }
         }
        
    return listSt.getTable();    
    }
     /**
     * Method to get source of button clicked using action listener
     */
     public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) {  
                  if(actionEvent.getSource()==listSt.getListButton()){
                        showOrders();
                  }
                  if(actionEvent.getSource()==listSt.getPrintButton()){
                        printBill();
                  }
                  if(actionEvent.getSource()==listSt.getCloseButton()){
                  listSt.setVisible(false);
                  
                  }
              }    
        };                
        listSt.getListButton().addActionListener(actionListener);
        listSt.getCloseButton().addActionListener(actionListener);
        listSt.getPrintButton().addActionListener(actionListener);
    }

/**
 * abstract method that overrides the print method
 * @param graphics
 * @param pageFormat
 * @param pageIndex
 * @return
 * @throws PrinterException 
 */
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
      graphics.drawString("LIST OF TOTAL BILLS PAID BY CLIENTS",150,20 ); 
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull","root","root");
        printed="SELECT * FROM bill ;" ;
        st=conn.prepareStatement(printed);
        st.execute("USE comfort_hub;");
        int c=40;
        
        ResultSet rs= st.executeQuery(printed);
         while(rs.next()){ 
     
   data =  "Name: "+ rs.getString("name") + "   " + "Unit Price Of Room: " + rs.getString("priceperday")+ "   " +"Days Spent: " + rs.getString("numofdays")+
      "   " + "Payment Mode: "+ rs.getString("pmode") + "   " + "Total: " +rs.getString("tots")+"\r\n" ;  
     
  graphics.drawString(data,20,c );
   c=c+20; 
   }
    st.close();
   conn.close();
  
    }  
    catch(Exception e){
    JOptionPane.showMessageDialog(null,e);
    } 
      System.out.println(data);
       return 0;
    }
}
      
