package Methods.ClassMethods;

import AllDataPackage.AllData;
import Methods.Utility;
import Model.Employee;
import Print.Message;

public class SyndicateMethods {
    Message message;
    AllData allData;
    Utility utility;

    public SyndicateMethods(Message message, AllData allData, Utility utility) {
        this.message = message;
        this.allData = allData;
        this.utility = utility;
    }

    public void editSyndicateTaxEmployee(Employee editedEmployee, Employee edited2Employee){
        if(edited2Employee.isSyndicateMember()){
            if(edited2Employee.getSyndicate().getSyndicateTax() <= 0){
                boolean done = false;
                while (!done) {
                    message.showInsertX("new syndicate tax");
                    try{
                        double syndicateTax = utility.readDouble();
                        if(syndicateTax >= 0) {
                            edited2Employee.getSyndicate().setSyndicateTax(syndicateTax);
                            done = true;
                        }else{
                            message.showXInvalid("tax number. Try again");
                        }
                    }catch (NumberFormatException e){
                        message.showInvalidInput();
                    }
                }
            }else{
                message.showWouldYouLikeToEdit("syndicate tax",
                        Double.toString(editedEmployee.getSyndicate().getSyndicateTax()));
                boolean done = false;
                while(!done) {
                    try {
                        int command = utility.readInteger();
                        if (command == 1) {
                            message.showInsertX("new syndicate tax");
                            double syndicateTax = utility.readDouble();
                            if(syndicateTax >= 0) {
                                edited2Employee.getSyndicate().setSyndicateTax(syndicateTax);
                                done = true;
                            }else{
                                message.showXInvalid("tax number. Try again");
                            }

                        } else {
                            message.showProcessCanceled();
                            done = true;
                        }
                    } catch (NumberFormatException e) {
                        message.showInvalidInput();
                    }
                }
            }
        }
    }
    public void editSyndicateMemberEmployee(Employee editedEmployee,Employee edited2Employee){
        //not on a syndicate
        if(!edited2Employee.isSyndicateMember()){
            message.showNoSyndicateWouldLikeEdit();
            try{
                int command = utility.readInteger();
                if(command == 1){
                    edited2Employee.setSyndicateMember(true);
                    edited2Employee.getSyndicate().setSyndicateTax(0);
                    allData.getSyndicateEmployee().add(edited2Employee);
                    message.showIsNowSyndicateMember(edited2Employee.getName());
                }else{
                    message.showProcessCanceled();
                }
            }catch (NumberFormatException e){
                message.showInvalidInput();
                message.showProcessCanceled();
            }
        }
        //is on a syndicate
        else{
            message.showThereIsSyndicateWouldLikeEdit();
            try{
                int command = utility.readInteger();
                if(command == 1){
                    edited2Employee.setSyndicateMember(false);
                    edited2Employee.getSyndicate().setSyndicateTax(0);
                    //removing from syndicateList
                    int id = utility.employeeID(editedEmployee.getName(), allData.getSyndicateEmployee());
                    allData.getSyndicateEmployee().remove(id);
                    message.showNotSyndicateMemberAnymore(editedEmployee.getName());
                }
            }catch (NumberFormatException e){
                message.showInvalidInput();
            }
        }
        this.editSyndicateTaxEmployee(editedEmployee, edited2Employee);
    }
}
