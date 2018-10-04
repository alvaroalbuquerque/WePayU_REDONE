package Methods.ChainOfResponsability.MenuChainPackage;

import Methods.ChainOfResponsability.MenuChain;
import MySystem.MySystem;

public class Menu7 implements MenuChain {
    final int ID = 7;
    MenuChain nextMenu;
    @Override
    public void execute(int command, MySystem mySystem) {
        if(command == ID) {
            mySystem.allDataMethods.runPayRoll(mySystem);
            mySystem.allDataMethods.payTodayEmployees(mySystem);
            mySystem.allDataMethods.passDay(mySystem.allData.getMyCalendar());
        }else if (nextMenu != null){
            nextMenu.execute(command, mySystem);
        }

    }

    @Override
    public void setNextMenu(MenuChain menuChain) {
        this.nextMenu = menuChain;
    }
}
