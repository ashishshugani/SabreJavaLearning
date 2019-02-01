public class Employee {

    public String employeeID;
    public String lastName;

    public EmpOtherInformation empotherobj;
    public EmpPersonalInformation emppersonalobj;


    public void setEmployeeID(String employeeID){
        this.employeeID=employeeID;
    }

    public String getEmployeeID(){
        return employeeID;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setEmpPersonalobj(EmpPersonalInformation ep){
        this.emppersonalobj=ep;
    }

    public EmpPersonalInformation getEmpPersonalobj(){
        return emppersonalobj;
    }

    public void setEmpOtherObj(EmpOtherInformation eo){
        this.empotherobj= eo;
    }

    public EmpOtherInformation getEmpOtherobj(){
        return empotherobj;
    }

}
