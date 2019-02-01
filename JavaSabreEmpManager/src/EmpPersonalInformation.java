import java.util.HashMap;

public class EmpPersonalInformation extends Employee{

    public String firstName;
    public String phone;

    public  void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getFirstname(){
        return firstName;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    public String getPhone(){
        return phone;
    }

}
