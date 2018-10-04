package Methods.ChainOfResponsability;

import MySystem.MySystem;

public interface MenuChain {
    void execute(int command, MySystem mySystem);
    void setNextMenu(MenuChain menuChain);
}
