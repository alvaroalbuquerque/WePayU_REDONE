package Methods.ChainOfResponsability.MenuChainPackage;

import Methods.ChainOfResponsability.MenuChain;
import MySystem.MySystem;

public class Menu6 implements MenuChain {
    final int ID = 6;
    MenuChain nextMenu;
    @Override
    public void execute(int command, MySystem mySystem) {
        if(command == 6) {
            mySystem.message.showTitleMenuFULL("SYNDICATE EMPLOYEES REPORT");
            mySystem.allDataMethods.reportingArray(mySystem, mySystem.allData.getSyndicateEmployee());
        }else if (nextMenu != null){
            nextMenu.execute(command, mySystem);
        }
    }

    @Override
    public void setNextMenu(MenuChain menuChain) {
        this.nextMenu = menuChain;
    }
}
