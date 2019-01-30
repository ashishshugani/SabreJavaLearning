import java.util.HashMap;

public class EmployeePersonalInformation extends Employee{

    public HashMap<String,String> personalInformation;

    EmployeePersonalInformation(){

        personalInformation= new HashMap<String,String>();

        personalInformation.put("Fullname","");
        personalInformation.put("Phone Number","");
    }

    public void createEmployeePersonalInformation(String firstName,String phone,String lastName){

        employeelastName=lastName;
        personalInformation.put("Fullname",lastName + " " + firstName);
        personalInformation.put("Phone Number",phone);
    }

    public void readEmployeePersonalInformation(){

        System.out.println("Employee Name : " + personalInformation.get("Fullname"));
        System.out.println("Employee Phone Number : " + personalInformation.get("Phone Number"));
    }

    public String getName(int flag){

        String FName;
        if(flag==1){
            FName =personalInformation.get("Fullname");
            String[] words = FName.split(" ");
            return words[0];

        }
        else{
            FName=personalInformation.get("Fullname");
            return FName;
        }
    }
}
