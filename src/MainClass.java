/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dorothy
 */
public class MainClass {
   
       public static void main(String args[]) {
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){          
                
                SearchSuite view1= new SearchSuite();
                SearchSuiteController controller = new SearchSuiteController(view1);
               
                controller.control();
                
            }
        });
    }
}
