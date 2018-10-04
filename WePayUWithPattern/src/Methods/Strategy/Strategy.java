package Methods.Strategy;

import AllDataPackage.AllData;
import Methods.ClassMethods.SyndicateMethods;
import Model.Employee;

public interface Strategy {
    void edittingEmployee(AllData allData, Employee editingEmployee, SyndicateMethods syndicateMethods);
    void payEmployee(Employee payingEmployee);
    void getEndOfDayInfoEmployee(Employee employee);
    void rollDailyPaymentEmployee(Employee employee);
}
