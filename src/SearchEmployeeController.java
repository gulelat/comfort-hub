
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class SearchEmployeeController {
    
     Connection conn = null;
    PreparedStatement p = null;
    ResultSet rs = null;
    private SearchEmployee view;
    private ActionListener actionListener;

    public SearchEmployeeController(SearchEmployee v) {
        view = v;
        view.setVisible(true);
    }

    public void control() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost/comfort_hub?user=root&password=root");
            //System.out.println("passes");
        } catch (Exception e) {
            System.out.println("exception in control " + e.toString());
            System.out.println(" NO PASSWORD EMP");
        }


        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == view.getCLOSEButton()) {
                    view.dispose();

                                } else if (e.getSource() == view.getSEARCHButton()) {
                    Employee();
                }


            }
        };
        view.getCLOSEButton().addActionListener(actionListener);
        view.getSEARCHButton().addActionListener(actionListener);

    }

    public void showNewForm() {
        new SearchSuite().setVisible(true);
    }

    public void Employee() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/comfort_hub?zeroDateTimeBehavior=convertToNull", "root", "root");
            //System.out.println("passes");
        } catch (Exception e) {
            System.out.println("exception in control " + e.toString());
            System.out.println(" NO PASSWORD EMP");
        }



        if (view.getSearchEmployeeText().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "please fill search field");
        }
        if (view.getsearchCombo().getSelectedIndex() == 0) {
            view.getmsgLabel().setText("Enter Employee details");
            
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try {
                p = conn.prepareStatement("SELECT * FROM employees  where eId=?");
                p.setString(1, view.getSearchEmployeeText().getText());
                rs = p.executeQuery();
                
                //this clears table
                 view.getModel().setRowCount(0);
                
                while (rs.next()) {
                    view.getModel().addRow(new String[]{
                                rs.getString("eId"),
                                rs.getString("eName"),
                                rs.getString("email"),
                                rs.getString("password"),});
                }
                //employeeTable.setModel(tbl);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(null, "entry cannot be found");
            }

        }


        if (view.getsearchCombo().getSelectedIndex() == 1) {
            view.getmsgLabel().setText("Enter eName");
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try {
                p = conn.prepareStatement("SELECT * FROM employees  where eName=?");
                p.setString(1, view.getSearchEmployeeText().getText());
                rs = p.executeQuery();

                //this clears table
                 view.getModel().setRowCount(0);  
                
                while (rs.next()) {
                    view.getModel().addRow(new String[]{
                                rs.getString("eId"),
                                rs.getString("eName"),
                                rs.getString("email"),
                                rs.getString("password"),});
                }
                //employeeTable.setModel(tbl);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(null, "entry cannot be found");
            }

        }



        if (view.getsearchCombo().getSelectedIndex() == 2) {
            
            try {
                p = conn.prepareStatement("SELECT * FROM employees  where email=?");
                p.setString(1, view.getSearchEmployeeText().getText());
                rs = p.executeQuery();

                 //this clears table
                 view.getModel().setRowCount(0); 
                
                while (rs.next()) {
                    view.getModel().addRow(new String[]{
                                rs.getString("eId"),
                                rs.getString("eName"),
                                rs.getString("email"),
                                rs.getString("password"),});
                }
                //employeeTable.setModel(tbl);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(null, "entry cannot be found");
            }

        }

        if (view.getsearchCombo().getSelectedIndex() == 3) {
            //DefaultTableModel tbl = new DefaultTableModel (colname, 0);
            try {
                p = conn.prepareStatement("SELECT * FROM employees  where password=?");
                p.setString(1, view.getSearchEmployeeText().getText());
                rs = p.executeQuery();

                 //this clears table
                 view.getModel().setRowCount(0);           
                
                while (rs.next()) {
                    view.getModel().addRow(new String[]{
                                rs.getString("eId"),
                                rs.getString("eName"),
                                rs.getString("email"),
                                rs.getString("password"),});
                }
                //employeeTable.setModel(tbl);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(null, "entry cannot be found");
            }

        }


    }
}
