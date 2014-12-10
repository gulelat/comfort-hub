
import java.awt.event.ActionEvent;
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
    
    /**
     * Object declarations ad instantiations
     */
    AddRes addOrder= new AddRes();
    ListReservations listOrder= new ListReservations();
    DeleteRes deleteOrder=new DeleteRes();
    ModifyRes modifyOrder=new ModifyRes();
    AddSuite enterFlight= new AddSuite();
    DeleteSuite deleteFlight = new DeleteSuite();
    ListSuites listFlight = new ListSuites();
    Hotel_Employee addEmployee = new Hotel_Employee();
    ListHotEmp listEmployee = new ListHotEmp();
    ModHotEmp modifyEmployee = new ModHotEmp();
    DeleteHotEmp deleteEmployee= new DeleteHotEmp();
    Billings  addBill = new Billings();
    PrintBill printing = new PrintBill();
    
    
    /**
     * constructor that creates a new homepage
     */
    
    public HomePageController(){
        home = new HomePage();
        home.setVisible(true);
    }
    
    /**
     * Method to get source of button clicked using action listener
     */
    public void control(){        
        actionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) { 
                  if(actionEvent.getSource()==home.gETADDEMP()){ 
                      ControllerAddHotEmp add= new ControllerAddHotEmp();
                         add.control();
                  }
                  if(actionEvent.getSource()==home.gETBILL()){
                      ControllerBillings b= new ControllerBillings();
                        b.control(); 
                  }
                                    
                  if(actionEvent.getSource()==home.getMODIFYEMP()){
                      ControllerModEmp c= new ControllerModEmp();
                        c.control(); 
                  }
                  if(actionEvent.getSource()==home.getDELETEMP()){
                      ControllerDeleteHotEmp delete= new ControllerDeleteHotEmp();
                        delete.contol();
                  }
                  if(actionEvent.getSource()==home.getLISTEMP()){
                      ControllerListHotEmp cE= new ControllerListHotEmp();
                        cE.contol();
                  }
                  if(actionEvent.getSource()==home.getADDSUITES()){  
                      ControllerAddSuite c= new ControllerAddSuite();
                     c.contol();
                  }
                  
                  if(actionEvent.getSource()==home.getDELETESUITES()){
                      ControllerDeleteSuite deleteF= new ControllerDeleteSuite();
                        deleteF.control();
                  }
                  if(actionEvent.getSource()==home.getLISTSUITE()){
                      ControllerListSuites cF= new ControllerListSuites();
                        cF.contol();
                  }
                  if(actionEvent.getSource()==home.getADDRES()){
                      ControllerAddRes Ao= new ControllerAddRes();
                      Ao.control();
                      Ao.controlCombo();
                  }
                  if(actionEvent.getSource()==home.getMODIFYRES()){
                       ControllerModifyRes c= new ControllerModifyRes();
                        c.control();
                  }
                  if(actionEvent.getSource()==home.getDELETERES()){
                      ControllerDeleteRes deleteO= new ControllerDeleteRes();
                        deleteO.control();
                  }
                  if(actionEvent.getSource()==home.getLISTALL()){
                      ControllerListReservations cLO= new ControllerListReservations();
                         cLO.control();
                  }
                                    
                   if(actionEvent.getSource()==home.getADDING()){ 
                      ControllerAddHotEmp add= new ControllerAddHotEmp();
                         add.control();
                  }
                  if(actionEvent.getSource()==home.getEDITEMPMENU()){
                       ControllerModEmp c= new ControllerModEmp();
                    c.control(); 
                  }
                  if(actionEvent.getSource()==home.getDELETEEMPMENU()){
                      ControllerDeleteHotEmp delete= new ControllerDeleteHotEmp();
                        delete.contol();
                  }
                  if(actionEvent.getSource()==home.getLISTEMPMENU()){
                      ControllerListHotEmp cE= new ControllerListHotEmp();
                        cE.contol();
                  }
                  if(actionEvent.getSource()==home.getBILLMENU()){
                      ControllerBillings tb= new ControllerBillings();
                        tb.control();
                  }
                   if(actionEvent.getSource()==home.getPRINT()){
                      ControllerPrintBill tb= new ControllerPrintBill();
                        tb.control();
                  }
                  if(actionEvent.getSource()==home.getADDROOMMENU()){  
                      ControllerAddSuite c= new ControllerAddSuite();
                     c.contol();
                  }
                  
                  if(actionEvent.getSource()==home.getDELETEROOMMENU()){
                      ControllerDeleteSuite deleteF= new ControllerDeleteSuite();
                        deleteF.control();
                  }
                  if(actionEvent.getSource()==home.getLISTROOMMENU()){
                      ControllerListSuites cF= new ControllerListSuites();
                        cF.contol();
                  }
                  if(actionEvent.getSource()==home.getADDBOOKINGMENU()){
                      ControllerAddRes Ao= new ControllerAddRes();
                      Ao.control();
                      Ao.controlCombo();
                  }
                  if(actionEvent.getSource()==home.getEDITBOOKINGMENU()){
                       ControllerModifyRes c= new ControllerModifyRes();
                      c.control();
                  }
                  if(actionEvent.getSource()==home.getDELETEBOOKINGMENU()){
                      ControllerDeleteRes deleteO= new ControllerDeleteRes();
                        deleteO.control();
                  }
                  if(actionEvent.getSource()==home.getLISTBOOKINGMENU()){
                      ControllerListReservations cLO= new ControllerListReservations();
                         cLO.control();
                  }
                  if(actionEvent.getSource()==home.getLISTRES()){
                     ControllerDisplayList c= new ControllerDisplayList();
                        c.control();
                  }
                  if(actionEvent.getSource()==home.getEXPORT()){
                     ControllerExport cont= new ControllerExport();
                     cont.listOrders();
                  }
                  if(actionEvent.getSource()==home.getSEARCH()){;
                       java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run(){ 
                      SearchSuite view1= new SearchSuite();
                        SearchSuiteController controller = new SearchSuiteController(view1);
               
                        controller.control();
                
            }
        });
                  }
                  
                  }
              
        };
        /**
         *  ActionListener buttons
         */
        home.gETADDEMP().addActionListener(actionListener);
        home.getMODIFYEMP().addActionListener(actionListener);
        home.getDELETEMP().addActionListener(actionListener);
        home.getLISTEMP().addActionListener(actionListener);
        home.getADDSUITES().addActionListener(actionListener);
        home.getDELETESUITES().addActionListener(actionListener);
        home.getLISTSUITE().addActionListener(actionListener);
        home.getADDRES().addActionListener(actionListener);
        home.getMODIFYRES().addActionListener(actionListener);
        home.getDELETERES().addActionListener(actionListener);
        home.getLISTALL().addActionListener(actionListener);
        home.gETBILL().addActionListener(actionListener);
       
   
        /**
         * MenuItems action listener
         */
        home.getADDING().addActionListener(actionListener);
        home.getBILLMENU().addActionListener(actionListener);
        home.getEDITEMPMENU().addActionListener(actionListener);
        home.getDELETEEMPMENU().addActionListener(actionListener);
        home.getLISTEMPMENU().addActionListener(actionListener);
        home.getADDROOMMENU().addActionListener(actionListener);
        home.getDELETEROOMMENU().addActionListener(actionListener);
        home.getLISTROOMMENU().addActionListener(actionListener);
        home.getADDBOOKINGMENU().addActionListener(actionListener);
        home.getEDITBOOKINGMENU().addActionListener(actionListener);
        home.getDELETEBOOKINGMENU().addActionListener(actionListener);
        home.getLISTBOOKINGMENU().addActionListener(actionListener);
        home.getLISTRES().addActionListener(actionListener);
        home.getEXPORT().addActionListener(actionListener);
        home.getSEARCH().addActionListener(actionListener);
        home.getPRINT().addActionListener(actionListener);
        
        }
   
}
