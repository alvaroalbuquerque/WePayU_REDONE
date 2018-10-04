package Print;

import Model.Employee;
import Model.EmployeePackage.Commissioned;
import Model.EmployeePackage.Hourly;
import Model.EmployeePackage.Salaried;

import java.util.ArrayList;

public class AllDataPrint {
    public void printingEmployeeList(ArrayList<Employee> employees){
        if(!employees.isEmpty()) {
            for (Employee object : employees) {
                if (object instanceof Commissioned) {
                    Commissioned aux = (Commissioned) object;
                    System.out.println(aux);
                } else if (object instanceof Salaried) {
                    Salaried aux = (Salaried) object;
                    System.out.println(aux);
                } else {
                    Hourly aux = (Hourly) object;
                    System.out.println(aux);
                }
            }
        }
    }
}
