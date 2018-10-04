package Methods.ChainOfResponsability.MenuChainPackage;

import Methods.ChainOfResponsability.MenuChain;
import MySystem.MySystem;

public class Menu3 implements MenuChain {
    final int ID = 3;
    MenuChain nextMenu;

    @Override
    public void execute(int command, MySystem mySystem) {
        if(command == ID) {
            if (mySystem.utility.thereIsEmployee(mySystem.allData.getEmployees())) {
                mySystem.message.showTitleMenuFULL("Employees List");
                mySystem.allDataPrint.printingEmployeeList(mySystem.allData.getEmployees());
                mySystem.message.showRemovingEmployeeList();
                String name = mySystem.utility.readString();
                int id = mySystem.utility.employeeID(name, mySystem.allData.getEmployees());
                if (id != -9999) {
                    mySystem.message.showAreYouSureMessage("remove " + mySystem.allData.getEmployees().get(id).getName(), "1 - CONFIRM");
                    int aux = mySystem.utility.readInteger();
                    if (aux == 1) {
                        if (mySystem.allData.getEmployees().get(id).isSyndicateMember()) {
                            int idSyndicate = mySystem.utility.employeeID(name, mySystem.allData.getSyndicateEmployee());
                            mySystem.allData.getSyndicateEmployee().remove(idSyndicate);
                            mySystem.savingStateMethods.saveSystemState();
                        }
                        mySystem.allData.getEmployees().remove(id);
                        mySystem.message.showSuccessMessage();
                    } else {
                        mySystem.message.showProcessCanceled();
                    }
                } else {
                    mySystem.message.showThereIsntXEmail("employee");
                }
            } else {
                mySystem.message.showThereIsntX("employees");
            }
        }else if (nextMenu != null){
            nextMenu.execute(command, mySystem);
        }

    }

    @Override
    public void setNextMenu(MenuChain menuChain) {
        this.nextMenu = menuChain;

    }
}
