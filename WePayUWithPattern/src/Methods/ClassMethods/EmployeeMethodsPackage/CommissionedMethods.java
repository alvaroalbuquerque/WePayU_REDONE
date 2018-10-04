package Methods.ClassMethods.EmployeeMethodsPackage;

import AllDataPackage.AllData;
import Methods.*;
import Methods.ClassMethods.AllDataMethods;
import Methods.ClassMethods.EmployeeMethods;
import Methods.ClassMethods.SyndicateMethods;
import Methods.Strategy.StrategyPackage.EmployeeStrategyPackage.CommissionedStrategy;
import Model.EmployeePackage.Commissioned;
import Model.PaymentType;
import Print.Message;

public class CommissionedMethods extends EmployeeMethods {
    double comissionTax, salary;
    CommissionedStrategy commissionedStrategy = new CommissionedStrategy();

    public CommissionedMethods(AllData allData, Utility utility, Message message, AllDataMethods allDataMethods, SyndicateMethods syndicateMethods) {
        super(allData, utility, message, allDataMethods, syndicateMethods);
    }

    @Override
    public void addingEmployee() {
        message.showAddingX("commissioned employee");
        super.addingEmployee();
        boolean done = false;
        while(!done) {
            try {
                message.showInsertX("fixed salary");
                salary = utility.readDouble();
                message.showInsertX("commission tax");
                comissionTax = utility.readDouble();
                done = true;
                allDataMethods.addEmployee(new Commissioned.CommissionedBuilder()
                        .setName(employee.getName())
                        .setAddress(employee.getAddress())
                        .setPaymentType(new PaymentType.PaymentTypeBuilder().setMonthlyORweekly("WEEKLY").setExtra("2").setDayOfWeek("FRIDAY").build())
                        .setComissionTax(comissionTax)
                        .setSalary(salary)
                        .setStrategy(commissionedStrategy)
                        .build());


            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
    }
}
