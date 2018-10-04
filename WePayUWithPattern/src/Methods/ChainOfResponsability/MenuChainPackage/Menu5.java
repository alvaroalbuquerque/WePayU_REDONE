package Methods.ChainOfResponsability.MenuChainPackage;

import Methods.ChainOfResponsability.MenuChain;
import MySystem.MySystem;

public class Menu5 implements MenuChain {
    final int ID = 5;
    MenuChain nextMenu;
    @Override
    public void execute(int command, MySystem mySystem) {
        if(command == ID) {

            mySystem.message.showTitleMenuFULL("EMPLOYEES REPORT");
            mySystem.allDataMethods.reportingArray(mySystem, mySystem.allData.getEmployees());
        }else if(nextMenu != null){
            nextMenu.execute(command, mySystem);
        }
    }

    @Override
    public void setNextMenu(MenuChain menuChain) {
        this.nextMenu = menuChain;
    }
}
