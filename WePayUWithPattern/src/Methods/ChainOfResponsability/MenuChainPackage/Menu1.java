package Methods.ChainOfResponsability.MenuChainPackage;

import Methods.ChainOfResponsability.MenuChain;
import MySystem.MySystem;

public class Menu1 implements MenuChain {
    final int ID = 1;
    MenuChain nextMenu;
    @Override
    public void execute(int command, MySystem mySystem) {
        if(command == ID) {
            mySystem.message.showAddingEmployeeChooseCategory();
            mySystem.menu.showMenuEmployeeCategory();
            try {
                int commandAux = mySystem.utility.readInteger();
                switch (commandAux) {
                    case 1:
                        mySystem.salariedMethods.addingEmployee();
                        mySystem.savingStateMethods.saveSystemState();
                        break;
                    case 2:
                        mySystem.comissionedMethods.addingEmployee();
                        mySystem.savingStateMethods.saveSystemState();
                        break;
                    case 3:
                        mySystem.hourlyMethods.addingEmployee();
                        mySystem.savingStateMethods.saveSystemState();
                        break;
                    default:
                        mySystem.message.showInvalidInput();
                        break;
                }
            } catch (NumberFormatException e) {
                mySystem.message.showInvalidInput();
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
