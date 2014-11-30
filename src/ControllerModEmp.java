
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
public class ControllerModEmp {
    /**
     * Objects and variable declarations
     */
   Connection conn = null;
    String querry;
    Statement st = null;
    public ModHotEmp modEmp;
    private ActionListener actionListener;
    
     /**
     * Constructor
     */
    public ControllerModEmp() {
        modEmp = new ModHotEmp();
        modEmp.setVisible(true);

    }
    
     /**
     * Method to update list
     */
    public void setList() {
        String ky = "";
        ky = modEmp.getSearchField().getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jetwingdb?zeroDateTimeBehavior=convertToNull", "root", "root");
            querry = "update Employees set eId =?,eName=?,email=?,password=?, "
                    + "where eId like '%" + ky + "%'";
            PreparedStatement stmt = conn.prepareStatement(querry);

            stmt.setString(1, modEmp.getIdField().getText());
            stmt.setString(2, modEmp.getNameField().getText());
            stmt.setString(3, modEmp.getEmailField().getText());
            stmt.setString(4, modEmp.getPasswordField().getText());
            stmt.execute();
            conn.close();
            JOptionPane.showMessageDialog(null, "Employee modified succesfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    /**
     * Method to display available flights
     */
    public void listEmps() {

        String ky = "";
        ky = modEmp.getSearchField().getText();
        System.out.println(ky);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jetwingdb?zeroDateTimeBehavior=convertToNull", "root", "root");
            querry = "SELECT * FROM Employees where eId like '%" + ky + "%'";
            st = conn.prepareStatement(querry);
            st.execute("USE jetwingdb;");

            ResultSet rs = st.executeQuery(querry);
            while (rs.next()) {

                modEmp.getIdField().setText(rs.getString("eId"));
                modEmp.getNameField().setText(rs.getString("eName"));
                modEmp.getEmailField().setText(rs.getString("email"));
                modEmp.getPasswordField().setText(rs.getString("Password"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
     /**
     * Method to get source of button clicked using action listener
     */
    public void control() {
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == modEmp.getSaveButton()) {
                    setList();
                }
                if (actionEvent.getSource() == modEmp.getCloseButton()) {
                    modEmp.setVisible(false);

                }
                if (actionEvent.getSource() == modEmp.getSearchButton()) {
                    listEmps();
                }
            }

        };
        modEmp.getSearchButton().addActionListener(actionListener);
        modEmp.getCloseButton().addActionListener(actionListener);
        modEmp.getSaveButton().addActionListener(actionListener);
    }
    
}