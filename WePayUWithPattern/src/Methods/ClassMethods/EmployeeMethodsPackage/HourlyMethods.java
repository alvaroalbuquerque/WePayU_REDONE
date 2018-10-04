package Methods.ClassMethods.EmployeeMethodsPackage;

import AllDataPackage.AllData;
import Methods.ClassMethods.AllDataMethods;
import Methods.ClassMethods.EmployeeMethods;
import Methods.Strategy.StrategyPackage.EmployeeStrategyPackage.HourlyStrategy;
import Methods.ClassMethods.SyndicateMethods;
import Methods.Utility;
import Model.EmployeePackage.Hourly;
import Model.PaymentType;
import Print.Message;

public class HourlyMethods extends EmployeeMethods {
    double normalTax;
    HourlyStrategy hourlyStrategy = new HourlyStrategy();
    public HourlyMethods(AllData allData, Utility utility, Message message, AllDataMethods allDataMethods, SyndicateMethods syndicateMethods) {
        super(allData, utility, message, allDataMethods, syndicateMethods);
    }

    @Override
    public void addingEmployee() {

        message.showAddingX("hourly employee");
        super.addingEmployee();
        boolean done = false;
        while(!done){
            try{
                message.showInsertX("the $/hour");
                normalTax = utility.readDouble();
                done = true;
                allDataMethods.addEmployee(new Hourly.HourlyBuilder()
                        .setName(employee.getName())
                        .setAddress(employee.getAddress())
                        .setPaymentType(new PaymentType.PaymentTypeBuilder().setMonthlyORweekly("WEEKLY").setExtra("1").setDayOfWeek("FRIDAY").build())
                        .setNormalTax(normalTax)
                        .setStrategy(hourlyStrategy)
                        .build());

            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
    }
}
