package Methods.ClassMethods;

import Methods.ChainOfResponsability.MenuChainPackage.*;
import MySystem.MySystem;

public class MenuMethods {
    Menu0 menu0 = new Menu0();
    Menu1 menu1 = new Menu1();
    Menu2 menu2 = new Menu2();
    Menu3 menu3 = new Menu3();
    Menu4 menu4 = new Menu4();
    Menu5 menu5 = new Menu5();
    Menu6 menu6 = new Menu6();
    Menu7 menu7 = new Menu7();
    Menu8 menu8 = new Menu8();
    Menu9 menu9 = new Menu9();
    MenuFinal menuFinal = new MenuFinal();

    private void initMenuChain(){
        menu0.setNextMenu(menu1);
        menu1.setNextMenu(menu2);
        menu2.setNextMenu(menu3);
        menu3.setNextMenu(menu4);
        menu4.setNextMenu(menu5);
        menu5.setNextMenu(menu6);
        menu6.setNextMenu(menu7);
        menu7.setNextMenu(menu8);
        menu8.setNextMenu(menu9);
        menu9.setNextMenu(menuFinal);
    }
    public void showGeneralMenu(MySystem mySystem) {
        initMenuChain();
        while (!mySystem.doneGeneral) {
            mySystem.message.showTitleMenuFULL("WE PAY U");
            mySystem.menu.showMenuGeneral();
            mySystem.message.showTodayDate(mySystem.allData.getMyCalendar(), mySystem.allData.getSimpleDateFormat());
            try {
                int command = mySystem.utility.readInteger();
                menu0.execute(command, mySystem);
            } catch (NumberFormatException e) {
                mySystem.message.showInvalidInput();
            }
        }
    }
}
