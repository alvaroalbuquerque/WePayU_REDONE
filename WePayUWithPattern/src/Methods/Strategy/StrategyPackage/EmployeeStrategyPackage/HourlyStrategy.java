package Methods.Strategy.StrategyPackage.EmployeeStrategyPackage;

import AllDataPackage.AllData;
import Methods.Strategy.StrategyPackage.EmployeeStrategy;
import Methods.ClassMethods.SyndicateMethods;
import Model.Employee;
import Model.EmployeePackage.Hourly;

public class HourlyStrategy extends EmployeeStrategy {
    double normalTax;

    @Override
    public void edittingEmployee(AllData allData,Employee editingEmployee, SyndicateMethods syndicateMethods) {

        message.showEdittingX("hourly employee");
        super.edittingEmployee(allData,editingEmployee, syndicateMethods);
        boolean done = false;
        while(!done) {
            try {
                message.showInsertXCurrent("the new normal tax", Double.toString(((Hourly)editingEmployee).getNormalTax()));
                normalTax = utility.readDouble();
                if(normalTax >= 0){

                    allData.getEmployees().set(allData.getEmployees().indexOf(editingEmployee),
                            new Hourly.HourlyBuilder()
                                    .setName(editedEmployee.getName())
                                    .setAddress(editedEmployee.getAddress())
                                    .setPaymentType(editedEmployee.getPaymentType())
                                    .setSyndicate(editedEmployee.getSyndicate())
                                    .setSyndicateMember(editedEmployee.isSyndicateMember())
                                    .setNormalTax(normalTax)
                                    .setBanked(editingEmployee.getBanked())
                                    .setTotalToBePaid(((Hourly) editingEmployee).getTotalToBePaid())
                                    .setTimeCard(((Hourly) editingEmployee).getTimeCard())
                                    .setStrategy(new HourlyStrategy())
                                    .build());

                    done = true;
                    message.showSuccessMessage();
                }else{
                    message.showXInvalid("normal tax number");
                    message.showAnErrorOcurredTryAgain();
                }

            } catch (NumberFormatException e) {
                message.showAnErrorOcurredTryAgain();
            }
        }
    }

    @Override
    public void payEmployee(Employee payingEmployee) {
        double totalToBePaid = ((Hourly)payingEmployee).getTotalToBePaid();
        ((Hourly)payingEmployee).setTotalToBePaid(0);
        if(payingEmployee.isSyndicateMember()){
            totalToBePaid  -= payingEmployee.getSyndicate().getSyndicateTax();
        }
        payingEmployee.setBanked(payingEmployee.getBanked()+totalToBePaid);
    }

    @Override
    public void getEndOfDayInfoEmployee(Employee employee) {
        message.runningXPayRoll(employee.getName());
        boolean done = false;
        while(!done) {
            message.showInsertX("how many hours he/she worked");
            try {
                int timeCard = utility.readInteger();
                ((Hourly)employee).getTimeCard().setHoursWorked(timeCard);
                done = true;
            }catch(NumberFormatException e){
                message.showInvalidInput();
            }

        }
    }

    @Override
    public void rollDailyPaymentEmployee(Employee employee) {
        Hourly hourly = (Hourly)employee;
        double extraHours = hourly.getTimeCard().getHoursWorked() - 8;
        double total = 0;
        if(extraHours > 0){
            total += 8*hourly.getNormalTax() + extraHours*hourly.getNormalTax()*1.5;
        }else{
            total += hourly.getTimeCard().getHoursWorked()*hourly.getNormalTax();
        }
        //reset the timecard
        hourly.getTimeCard().setHoursWorked(0);
        hourly.setTotalToBePaid(hourly.getTotalToBePaid() + total);
    }
}
