import java.util.ArrayList;
import java.util.List;

public interface ManagerImplementation {

    void createManager(String managerName);
    ArrayList<String> returnManagerAssociatedEmployees(int managerID);
    void associateEmployeeWithManager(int managerID, String empID);
    String getManagerName();
    ArrayList<String> getAssociatedEmployees(int managerID);
    char assignDepartment();

}
