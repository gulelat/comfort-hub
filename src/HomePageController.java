
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dorothy
 */
public class HomePageController {
   public HomePage home;
    private ActionListener actionListener;
    
    
    
    public HomePageController(){
        home = new HomePage();
        home.setVisible(true);
    }
   
}
