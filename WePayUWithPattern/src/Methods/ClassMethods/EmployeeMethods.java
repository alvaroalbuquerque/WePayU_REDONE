package Methods.ClassMethods;

import AllDataPackage.AllData;
import Methods.Utility;
import Model.Address;
import Model.Employee;
import Print.Message;

public class EmployeeMethods {
    protected AllData allData;
    protected Utility utility;
    protected Message message;
    protected AllDataMethods allDataMethods;
    protected SyndicateMethods syndicateMethods;
    protected Employee employee = new Employee.EmployeeBuilder().build();

    public EmployeeMethods(AllData allData, Utility utility,
                           Message message, AllDataMethods allDataMethods, SyndicateMethods syndicateMethods) {
        this.allData = allData;
        this.utility = utility;
        this.message = message;
        this.allDataMethods = allDataMethods;
        this.syndicateMethods = syndicateMethods;
    }


    public void addingEmployee(){
        message.showInsertX("name");
        employee.setName(utility.readString());
        boolean done = false;
        while (!done) {
            try {

                message.showInsertX("number address");
                int nNumber = utility.readInteger();
                done = true;
                message.showInsertX("street address");
                String nStreet = utility.readString();
                employee.setAddress(new Address(nNumber,nStreet));
            } catch (NumberFormatException e) {
                message.showInvalidInput();
            }
        }
    }
}
