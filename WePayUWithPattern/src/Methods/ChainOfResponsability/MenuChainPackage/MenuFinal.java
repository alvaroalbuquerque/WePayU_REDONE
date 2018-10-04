package Methods.ChainOfResponsability.MenuChainPackage;

import Methods.ChainOfResponsability.MenuChain;
import MySystem.MySystem;

public class MenuFinal implements MenuChain {
    MenuChain nextMenu;
    @Override
    public void execute(int command, MySystem mySystem) {
        mySystem.message.showInvalidInput();
    }

    @Override
    public void setNextMenu(MenuChain menuChain) {
        this.nextMenu = menuChain;
    }
}
