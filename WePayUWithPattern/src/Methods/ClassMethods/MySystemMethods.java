package Methods.ClassMethods;

import MySystem.MySystem;

public class MySystemMethods {
    MySystem mySystem = new MySystem();

    public void runMySystem(){
        mySystem.menuMethods.showGeneralMenu(mySystem);
    }
}
