import java.util.HashMap;

public class EmployeeInformation extends Employee{

    public HashMap<String,String> employeeInformation;

    EmployeeInformation(int IdFlag){

        employeeInformation=new HashMap<String,String>();
        employeeInformation.put("EmployeeID",Integer.toString(IdFlag));
    }

    public void createEmployeeInformation(String empType,String emplastname){

        employeeType=empType;
        employeelastName=emplastname;

    }

    public void readEmployeeInformation(){

        System.out.println("EmployeeType :" + employeeType);
        System.out.println("Employee Department : " + employeeDepartment);
        System.out.println("Employee Employee ID : " + employeeInformation.get("EmployeeID") );
    }

    public String getType(){
        return employeeType;
    }
}
