import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Manager implements ManagerImplementation{

    public String managerID;
    public String managerName;
    public HashMap<String,ArrayList<String>> managerAssociatedEmployees;

    Manager(int IdFlag){
        managerID=Integer.toString(IdFlag);
        managerAssociatedEmployees = new HashMap<String,ArrayList<String>>();
        managerAssociatedEmployees.put(Integer.toString(IdFlag),new ArrayList<String>());
    }

     @Override
     public void createManager(String managerName){
        this.managerName=managerName;
     }

     @Override
     public ArrayList<String> returnManagerAssociatedEmployees(int managerID){

       return managerAssociatedEmployees.get(Integer.toString(managerID));
     }

     @Override
     public void associateEmployeeWithManager(int managerID, String empID){
        ArrayList<String> tempEmpID =managerAssociatedEmployees.get(Integer.toString(managerID));
        tempEmpID.add(empID);
        managerAssociatedEmployees.put(Integer.toString(managerID),tempEmpID);
     }

     @Override
     public String getManagerName(){
        return managerName;
     }

     @Override
     public ArrayList<String> getAssociatedEmployees(int managerID) {
        return managerAssociatedEmployees.get(Integer.toString(managerID));
     }

    @Override
    public char assignDepartment() {

        Random r = new Random();
        int departmentNumber = r.nextInt(3);
        char departmentName = (char)(departmentNumber+65);

        return departmentName;
    }
}
