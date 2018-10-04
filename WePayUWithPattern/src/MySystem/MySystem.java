package MySystem;

import AllDataPackage.AllData;
import AllDataPackage.SavingState;
import Methods.*;
import Methods.ClassMethods.*;
import Methods.ClassMethods.EmployeeMethodsPackage.CommissionedMethods;
import Methods.ClassMethods.EmployeeMethodsPackage.HourlyMethods;
import Methods.ClassMethods.EmployeeMethodsPackage.SalariedMethods;
import Print.AllDataPrint;
import Print.Menu;
import Print.Message;

public class MySystem {

    public boolean doneGeneral = false;
    public Message message = new Message();
    public Utility utility = new Utility();
    public AllData allData = new AllData();
    public SavingState savingState = new SavingState(allData);
    public SavingStateMethods savingStateMethods = new SavingStateMethods(savingState,allData,message);
    public AllDataMethods allDataMethods = new AllDataMethods(allData,message,utility);
    public AllDataPrint allDataPrint = new AllDataPrint();
    public Menu menu = new Menu();
    public MenuMethods menuMethods = new MenuMethods();
    public PaymentTypeMethods paymentTypeMethods = new PaymentTypeMethods();
    public SyndicateMethods syndicateMethods = new SyndicateMethods(message,allData,utility);

    public CommissionedMethods comissionedMethods = new CommissionedMethods(allData,utility,message,allDataMethods,syndicateMethods);
    public HourlyMethods hourlyMethods = new HourlyMethods(allData,utility,message,allDataMethods,syndicateMethods);
    public SalariedMethods salariedMethods = new SalariedMethods(allData,utility,message,allDataMethods,syndicateMethods);
}
