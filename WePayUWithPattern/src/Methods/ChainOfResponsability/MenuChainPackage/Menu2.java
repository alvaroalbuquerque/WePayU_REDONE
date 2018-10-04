package Methods.ChainOfResponsability.MenuChainPackage;

import Methods.ChainOfResponsability.MenuChain;
import MySystem.MySystem;

public class Menu2 implements MenuChain {
    final int ID = 2;
    MenuChain nextMenu;
    @Override
    public void execute(int command, MySystem mySystem) {
        if(command == ID) {
            if (mySystem.utility.thereIsEmployee(mySystem.allData.getEmployees())) {
                mySystem.message.showTitleMenuFULL("Employees List");
                mySystem.allDataPrint.printingEmployeeList(mySystem.allData.getEmployees());
                mySystem.message.showEditingEmployeeList();
                String name = mySystem.utility.readString();
                int id = mySystem.utility.employeeID(name, mySystem.allData.getEmployees());
                if (id != -9999) {
                    mySystem.allData.getEmployees().get(id).getStrategy().edittingEmployee(mySystem.allData,
                            mySystem.allData.getEmployees().get(id),
                            mySystem.syndicateMethods);
                    mySystem.savingStateMethods.saveSystemState();
                } else {
                    mySystem.message.showThereIsntXEmail("employee");
                }
            } else {
                mySystem.message.showThereIsntX("employees");
            }
        }else if (nextMenu != null){
            nextMenu.execute(command,mySystem);
        }

    }

    @Override
    public void setNextMenu(MenuChain menuChain) {
        this.nextMenu = menuChain;

    }
}
