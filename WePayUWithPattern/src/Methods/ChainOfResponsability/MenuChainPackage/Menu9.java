package Methods.ChainOfResponsability.MenuChainPackage;

import Methods.ChainOfResponsability.MenuChain;
import MySystem.MySystem;

public class Menu9 implements MenuChain {
    final int ID = 9;
    MenuChain nextMenu;
    @Override
    public void execute(int command, MySystem mySystem) {
        if(command == ID){
            mySystem.savingStateMethods.redoState();
        }else if (nextMenu != null){
            nextMenu.execute(command, mySystem);
        }
    }

    @Override
    public void setNextMenu(MenuChain menuChain) {
        this.nextMenu = menuChain;
    }
}
