package Print;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Message {
    public void showTodayDate(Calendar calendar, SimpleDateFormat simpleDateFormat){
        String formatted = simpleDateFormat.format(calendar.getTime());
        System.out.println("Today is " +  formatted + ".");
    }
    public void showInvalidInput(){
        System.out.println(" >> Invalid input.");
    }
    public void showSuccessMessage(){
        System.out.println(" >> Operation finished successfully.");
    }
    public void showInsertX(String attribute){
        System.out.print("Insert " + attribute +":\t");
    }
    public void showInsertXCurrent(String attribute, String current){
        System.out.println("Insert " + attribute +" (Current: " + current + "):\t");
    }
    public void showXInvalid(String string){
        System.out.println(" >> Invalid " + string + ".");
    }

    public void showAddingX(String string){
        System.out.println("Adding " + string + ":");
    }
    public void showEdittingX(String string){
        System.out.println("Editing " + string + ".\nCurrent Info:");
    }
    public void showThereIsntX(String string){
        System.out.println(" >> There is no " + string + " registered.\n");
    }
    public void showThereIsntXEmail(String string){
        System.out.println(" >> There is no " + string + " registered with this name.");
    }

    public void showAddingEmployeeChooseCategory(){
        System.out.println(" >> Adding Employee. Choose one of the categories below:");
    }
    public void showEditingEmployeeList(){
        System.out.print(" >> Editing Employee. Insert the name of an employee above:\t");
    }
    public void showEditingEmployeePaymentList(){
        System.out.print(" >> Editing Employee's Payment Type. Insert the name of an employee above:\t");
    }
    public void showRemovingEmployeeList(){
        System.out.print(" >> Removing Employee. Insert the name of an employee above:\t");
    }
    public void showAnErrorOcurredTryAgain(){
        System.out.println(" >> An error has ocurred. Try again.");
    }
    public void showNoSyndicateWouldLikeEdit(){
        System.out.println("This employee is not on a Syndicate. Would you like to change that?\n1 - CONFIRM");
    }
    public void showThereIsSyndicateWouldLikeEdit(){
        System.out.println("This employee is on a Syndicate. Would you like to change that?\n1 - CONFIRM");
    }
    public void showNotSyndicateMemberAnymore(String name){
        System.out.println(" >> " + name + " is not a syndicate member anymore.");
    }
    public void showIsNowSyndicateMember(String name){
        System.out.println(" >> " + name + " is now a syndicate member.");
    }
    public void showWouldYouLikeToEdit(String attribute, String current){
        System.out.println("Would you like to edit " + attribute + "? (Current: " + current + ").\n1 - CONFIRM");
    }
    public void showTitleMenuFULL(String string){
        System.out.println("\n\n\n            " + string);
    }

    public void showProcessCanceled(){
        System.out.println(" >> Process canceled.");
    }
    public void showAreYouSureMessage(String process, String command){
        System.out.println(" >> Are you sure you want to " + process + "?\n" + command);
    }
    public void runningXPayRoll(String x){
        System.out.println("Running " + x + " pay roll:");
    }

    public void showUndoSuccess(){
        System.out.println("'Undo' successfully done!");
    }
    public void showUndoError(){
        System.out.println("Error occurred. Couldn't 'Undo'");
    }
    public void showRedoSuccess(){
        System.out.println("'Redo' successfully done!");
    }
    public void showRedoError(){
        System.out.println("Error occurred. Couldn't 'Redo'");
    }
}
