package Methods.ChainOfResponsability.MenuChainPackage;

import Methods.ChainOfResponsability.MenuChain;
import MySystem.MySystem;

public class Menu8 implements MenuChain {
    final int ID = 8;
    MenuChain nextMenu;
    @Override
    public void execute(int command, MySystem mySystem) {
        if(command == ID) {
            mySystem.savingStateMethods.undoState();
        }else if (nextMenu != null){
            nextMenu.execute(command,mySystem);
        }

    }

    @Override
    public void setNextMenu(MenuChain menuChain) {
        this.nextMenu = menuChain;
    }
}
