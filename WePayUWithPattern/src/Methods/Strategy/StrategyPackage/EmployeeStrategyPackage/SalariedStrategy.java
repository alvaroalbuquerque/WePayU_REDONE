package Methods.Strategy.StrategyPackage.EmployeeStrategyPackage;

import AllDataPackage.AllData;
import Methods.Strategy.StrategyPackage.EmployeeStrategy;
import Methods.ClassMethods.SyndicateMethods;
import Model.Employee;
import Model.EmployeePackage.Salaried;

public class SalariedStrategy extends EmployeeStrategy {
    @Override
    public void edittingEmployee(AllData allData, Employee editingEmployee, SyndicateMethods syndicateMethods) {
        double salary;

        message.showEdittingX("salaried employee");
        super.edittingEmployee(allData,editingEmployee, syndicateMethods);
        boolean done = false;
        while(!done) {
            try {
                message.showInsertXCurrent("the new salary",
                        Double.toString(((Salaried)editingEmployee).getSalary()));
                salary = utility.readDouble();
                if(salary >= 0){
                    done = true;
                    allData.getEmployees().set(allData.getEmployees().indexOf(editingEmployee),
                            new Salaried.SalariedBuilder()
                                    .setName(editedEmployee.getName())
                                    .setAddress(editedEmployee.getAddress())
                                    .setPaymentType(editedEmployee.getPaymentType())
                                    .setSyndicate(editedEmployee.getSyndicate())
                                    .setSyndicateMember(editedEmployee.isSyndicateMember())
                                    .setSalary(salary)
                                    .setBanked(editingEmployee.getBanked())
                                    .setPaymentTotal(((Salaried) editingEmployee).getPaymentTotal())
                                    .setStrategy(new SalariedStrategy())
                                    .build());
                    message.showSuccessMessage();

                }else{
                    message.showXInvalid("salary number");
                    message.showAnErrorOcurredTryAgain();
                }

            } catch (NumberFormatException e) {
                message.showAnErrorOcurredTryAgain();
            }
        }
    }

    @Override
    public void payEmployee(Employee payingEmployee) {
        double totalToBePaid = ((Salaried)payingEmployee).getSalary();
        if (payingEmployee.isSyndicateMember()){
            totalToBePaid -= payingEmployee.getSyndicate().getSyndicateTax();
        }
        payingEmployee.setBanked(payingEmployee.getBanked() + totalToBePaid);
    }

    @Override
    public void getEndOfDayInfoEmployee(Employee employee) {

    }

    @Override
    public void rollDailyPaymentEmployee(Employee employee) {
    }
}
