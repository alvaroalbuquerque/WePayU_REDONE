package Methods.ClassMethods;

import AllDataPackage.AllData;
import AllDataPackage.SavingState;
import Print.Message;

public class SavingStateMethods {
    SavingState savingState;
    AllData allData;
    Message message;

    public SavingStateMethods(SavingState savingState, AllData allData, Message message) {
        this.savingState = savingState;
        this.allData = allData;
        this.message = message;
    }

    public void saveSystemState(){
        savingState.addState(allData);
    }

    public void undoState(){
        if(savingState.prevState(allData)){
            message.showUndoSuccess();
        }else{
            message.showUndoError();
        }
    }
    public void redoState(){
        if(savingState.nextState(allData)){
            message.showRedoSuccess();
        }else{
            message.showRedoError();
        }
    }
}
