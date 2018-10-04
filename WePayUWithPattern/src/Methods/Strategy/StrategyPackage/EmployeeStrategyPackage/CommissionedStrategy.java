package Methods.Strategy.StrategyPackage.EmployeeStrategyPackage;

import AllDataPackage.AllData;
import Methods.Strategy.StrategyPackage.EmployeeStrategy;
import Methods.ClassMethods.SyndicateMethods;
import Model.Employee;
import Model.EmployeePackage.Commissioned;

public class CommissionedStrategy extends EmployeeStrategy {
    double comissionTax, salary;

    @Override
    public void edittingEmployee(AllData allData,Employee editingEmployee, SyndicateMethods syndicateMethods) {

        message.showEdittingX("commissioned employee");
        super.edittingEmployee(allData,editingEmployee, syndicateMethods);
        boolean done = false;
        while(!done) {
            try {
                message.showInsertXCurrent("the new comission tax", Double.toString(((Commissioned)editingEmployee).getComissionTax()));
                comissionTax = utility.readDouble();
                if(comissionTax >= 0){
                    message.showInsertXCurrent("the new salary", Double.toString(((Commissioned)editingEmployee).getSalary()));
                    salary = utility.readDouble();
                    if(salary >= 0){
                        allData.getEmployees().set(allData.getEmployees().indexOf(editingEmployee),
                                new Commissioned.CommissionedBuilder()
                                        .setName(editedEmployee.getName())
                                        .setAddress(editedEmployee.getAddress())
                                        .setPaymentType(editedEmployee.getPaymentType())
                                        .setSyndicate(editedEmployee.getSyndicate())
                                        .setSyndicateMember(editedEmployee.isSyndicateMember())
                                        .setComissionTax(comissionTax)
                                        .setBanked(editingEmployee.getBanked())
                                        .setTotalToBePaid(((Commissioned) editingEmployee).getTotalToBePaid())
                                        .setTotalSales(((Commissioned) editingEmployee).getTotalSales())
                                        .setStrategy(new CommissionedStrategy())
                                        .build());
                        done = true;
                        message.showSuccessMessage();
                    }else{
                        message.showXInvalid("salary number");
                        message.showAnErrorOcurredTryAgain();
                    }
                }else{
                    message.showXInvalid("comission tax number");
                    message.showAnErrorOcurredTryAgain();
                }

            } catch (NumberFormatException e) {
                message.showAnErrorOcurredTryAgain();
            }
        }
    }

    @Override
    public void payEmployee(Employee payingEmployee) {
        double totalToBePaid = ((Commissioned)payingEmployee).getSalary() + ((Commissioned)payingEmployee).getTotalToBePaid();
        ((Commissioned)payingEmployee).setTotalToBePaid(0);
        if (payingEmployee.isSyndicateMember()){
            totalToBePaid  -= payingEmployee.getSyndicate().getSyndicateTax();
        }
        payingEmployee.setBanked(payingEmployee.getBanked()+totalToBePaid);
    }

    @Override
    public void getEndOfDayInfoEmployee(Employee employee) {
        message.runningXPayRoll(employee.getName());
        boolean done = false;
        while(!done){
            try{
                message.showInsertX("the total of sales");
                double totalSales = utility.readDouble();
                ((Commissioned)employee).setTotalSales(totalSales);
                done = true;
            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
    }

    @Override
    public void rollDailyPaymentEmployee(Employee employee) {
        Commissioned commissioned = (Commissioned)employee;

        double total = (commissioned.getComissionTax()*commissioned.getTotalSales());
        //resets daily sales
        commissioned.setTotalSales(0);
        commissioned.setTotalToBePaid(commissioned.getTotalToBePaid() + total);
    }
}
