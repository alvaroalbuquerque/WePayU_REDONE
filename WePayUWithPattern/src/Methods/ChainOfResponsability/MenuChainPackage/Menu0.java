package Methods.ChainOfResponsability.MenuChainPackage;

import Methods.ChainOfResponsability.MenuChain;
import MySystem.MySystem;

public class Menu0 implements MenuChain {
    final int ID = 0;
    MenuChain nextMenu;
    @Override
    public void execute(int command, MySystem mySystem) {
        if(command == ID){
            mySystem.doneGeneral = true;
        }else if(nextMenu != null){
            nextMenu.execute(command, mySystem);
        }

    }

    @Override
    public void setNextMenu(MenuChain menuChain) {
        this.nextMenu = menuChain;
    }
}
