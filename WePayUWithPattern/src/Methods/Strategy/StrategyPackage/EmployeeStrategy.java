package Methods.Strategy.StrategyPackage;

import AllDataPackage.AllData;
import Methods.*;
import Methods.ClassMethods.SyndicateMethods;
import Methods.Strategy.Strategy;
import Model.*;
import Print.Message;

public class EmployeeStrategy implements Strategy {
    protected Message message = new Message();
    protected Utility utility = new Utility();
    protected Employee editedEmployee;

    @Override
    public void edittingEmployee(AllData allData,Employee editingEmployee, SyndicateMethods syndicateMethods) {
        editedEmployee = new Employee.EmployeeBuilder().setPaymentType(editingEmployee.getPaymentType())
                .setAddress(new Address(0,null))
                .setSyndicateMember(editingEmployee.isSyndicateMember())
                .setSyndicate(new Syndicate(editingEmployee.getSyndicate().getSyndicateTax()))
                .build();
        message.showInsertXCurrent("name", editingEmployee.getName());
        editedEmployee.setName(utility.readString());
        boolean done = false;
        while(!done) {
            try {
                message.showInsertXCurrent("Address Number", Integer.toString(editingEmployee.getAddress().getNumber()));
                editedEmployee.getAddress().setNumber(utility.readInteger());
                done = true;
            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
        message.showInsertXCurrent("Street Address", editingEmployee.getAddress().getStreet());
        editedEmployee.getAddress().setStreet(utility.readString());
        syndicateMethods.editSyndicateMemberEmployee(editingEmployee,editedEmployee);

    }

    @Override
    public void payEmployee(Employee payingEmployee) {

    }

    @Override
    public void getEndOfDayInfoEmployee(Employee employee) {

    }

    @Override
    public void rollDailyPaymentEmployee(Employee employee) {

    }
}
