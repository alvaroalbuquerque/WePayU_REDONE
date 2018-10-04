package Methods.ClassMethods.EmployeeMethodsPackage;

import AllDataPackage.AllData;
import Methods.ClassMethods.AllDataMethods;
import Methods.ClassMethods.EmployeeMethods;
import Methods.Strategy.StrategyPackage.EmployeeStrategyPackage.SalariedStrategy;
import Methods.ClassMethods.SyndicateMethods;
import Methods.Utility;
import Model.EmployeePackage.Salaried;
import Model.PaymentType;
import Print.Message;

public class SalariedMethods extends EmployeeMethods {
    double salary;
    SalariedStrategy salariedStrategy = new SalariedStrategy();
    public SalariedMethods(AllData allData, Utility utility, Message message, AllDataMethods allDataMethods, SyndicateMethods syndicateMethods) {
        super(allData, utility, message, allDataMethods, syndicateMethods);
    }

    @Override
    public void addingEmployee() {
        message.showAddingX("salaried employee");
        super.addingEmployee();
        boolean done = false;
        while(!done){
            try{
                message.showInsertX("salary");
                salary = utility.readDouble();
                done = true;
                allDataMethods.addEmployee(new Salaried.SalariedBuilder()
                        .setName(employee.getName())
                        .setAddress(employee.getAddress())
                        .setPaymentType(new PaymentType.PaymentTypeBuilder().setMonthlyORweekly("MONTHLY").setExtra("$").build())
                        .setSalary(salary)
                        .setStrategy(salariedStrategy)
                        .build());

            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
    }
}
