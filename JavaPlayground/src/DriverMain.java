import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class DriverMain {
    public static void main(String args[]){
        System.out.println(" \n1.Create New Employee \n");
        System.out.println("2.Display Employee \n");
        System.out.println("3.Delete Employee \n");
        System.out.println("4.Get Employee Type\n");
        System.out.println("5.Get Employee Name\n");
        System.out.println("6.Create New Manager\n");
        System.out.println("7.Delete Manager\n");
        System.out.println("8.Associate Employee With Manager\n");
        System.out.println("9.Display All Managers\n");
        System.out.println("10.Delete Manager Associate Employees to New Manager\n");
        System.out.println("0.Exit\n");

        EmployeePersonalInformation[] empPersonalInfoArray = new EmployeePersonalInformation[7];
        EmployeeInformation[] empInfoArray = new EmployeeInformation[7];
        Manager[] managerInfoArray=new Manager[4];

        Scanner input = new Scanner(System.in);

        int IdFlagEmp=0;
        int IdFlagManager=0;

        int numberInput = input.nextInt();

        while(numberInput!=0){

            switch(numberInput){
                case 1:{

                    System.out.println("Enter Employee Type : \n");
                    String emptype = input.next().toLowerCase();
//
//                    if(emptype!="senior" || emptype!="fresher" || emptype!="experienced"){
//                        System.out.println("Invalid Type");
//                        break;
//                    }

                    System.out.println("Enter FirstName : \n");
                    String empfirstname = input.next();
                    System.out.println("Enter Lastname : \n");
                    String emplastname= input.next();
                    System.out.println("Enter Phone Number : \n");
                    String empphone = input.next();

                    int employeeNumber = ++IdFlagEmp;


                    try{
                        if(empInfoArray[employeeNumber]== null){
                            empInfoArray[employeeNumber] = new EmployeeInformation(employeeNumber);
                            empInfoArray[employeeNumber].createEmployeeInformation(emptype,emplastname);

                            empPersonalInfoArray[employeeNumber] = new EmployeePersonalInformation();
                            empPersonalInfoArray[employeeNumber].createEmployeePersonalInformation(empfirstname,empphone,emplastname);

                        }
                        else{
                            System.out.println("Already Exist");
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Out Of Bound");
                    }



                    break;
                }
                case 2:{

                    System.out.println("Enter Employee ID :");
                    int empNumberInput = input.nextInt();
                    try{
                        empPersonalInfoArray[empNumberInput].readEmployeePersonalInformation();
                        empInfoArray[empNumberInput].readEmployeeInformation();
                    }
                    catch(NullPointerException e){
                        System.out.println("NO DATA");
                    }

                    break;

                }
                case 3:{
                    System.out.println("Enter Employee ID :");
                    int empNumberInput = input.nextInt();

                    try{
                        empPersonalInfoArray[empNumberInput]= null;
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Out Of Bound");
                    }

                    break;
                }
                case 4:{
                    System.out.println("Enter Employee ID :");
                    int empNumberInput = input.nextInt();
                    try{
                        System.out.println(empInfoArray[empNumberInput].getType());
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Out Of Bound");
                    }
                    catch(NullPointerException e){
                        System.out.println("Not Found");
                    }

                    break;
                }
                case 5:{
                    System.out.println("Enter Employee ID :");
                    int empNumberInput = input.nextInt();
                    System.out.println("Press 1 for last name , 2 for Full Name ");
                    int nameChoice = input.nextInt();

                    try{
                        System.out.println(empPersonalInfoArray[empNumberInput].getName(nameChoice));

                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Out Of Bound");
                    }
                    catch(NullPointerException e){
                        System.out.println("Not Found");
                    }
                    break;
                }
                case 6:{

                    int managerNumber = ++IdFlagManager;
                    System.out.println("Enter Name : \n");
                    String managerName = input.next();
                    try{
                        if(managerInfoArray[managerNumber]== null){
                           managerInfoArray[managerNumber]= new Manager(managerNumber);
                           managerInfoArray[managerNumber].createManager(managerName);
                        }
                        else{
                            System.out.println("Already Exist");
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Out Of Bound");
                    }

                    break;
                }
                case 7:{
                    System.out.println("Enter Manager ID :");
                    int managerIDInput = input.nextInt();
                    ArrayList<String> empIDs = new ArrayList<String>();

                    try{
                        empIDs = managerInfoArray[managerIDInput].returnManagerAssociatedEmployees(managerIDInput);
                        managerInfoArray[managerIDInput]= null;
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Out Of Bound");
                    }
                    finally {
                        if(empIDs!=null){
                            try{
                                for(String empID: empIDs){
                                    empPersonalInfoArray[Integer.parseInt(empID)]= null;
                                }

                            }
                            catch(ArrayIndexOutOfBoundsException e){
                                System.out.println("Out Of Bound");
                            }
                        }
                    }
                    break;
                }
                case 8:{
                    System.out.println("Enter Manager ID :");
                    int managerIDInput = input.nextInt();
                    System.out.println("Enter Employee ID :");
                    int empIDInput = input.nextInt();
                    managerInfoArray[managerIDInput].associateEmployeeWithManager(managerIDInput,Integer.toString(empIDInput));
                    empInfoArray[empIDInput].employeeDepartment = Character.toString(managerInfoArray[managerIDInput].assignDepartment());
                    break;
                }
                case 9:{
                    try{
                        for(int i=0;i<4;i++){
                            if(managerInfoArray[i]!=null) {
                                System.out.println("ManagerID:" + i);
                                System.out.println("Manager Name:" +managerInfoArray[i].getManagerName());
                                System.out.println("Employees Associated:" + managerInfoArray[i].getAssociatedEmployees(i));
                            }
                        }
                    }
                    catch(NullPointerException e){
                        System.out.println("NO DATA");
                    }
                    break;
                }
                case 10:{
                    System.out.println("Enter Manager ID :");
                    int managerIDInput = input.nextInt();
                    ArrayList<String> empIDs = new ArrayList<String>();
                    ArrayList<String> managerIDs = new ArrayList<String>();

                    try{
                        empIDs = managerInfoArray[managerIDInput].returnManagerAssociatedEmployees(managerIDInput);
                        managerInfoArray[managerIDInput]= null;
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("Out Of Bound");
                    }
                    finally {
                        Random random = new Random();
                        for(int i=0;i<4;i++){
                            if(managerInfoArray[i]!=null) {
                                managerIDs.add(Integer.toString(i));
                            }
                        }
                        if(empIDs!=null){
                            try{
                                for(String empID: empIDs){
                                    String newManager = managerIDs.get(random.nextInt(managerIDs.size()));
                                    managerInfoArray[Integer.parseInt(newManager)].associateEmployeeWithManager(Integer.parseInt(newManager),empID);
                                }

                            }
                            catch(ArrayIndexOutOfBoundsException e){
                                System.out.println("Out Of Bound");
                            }
                        }
                    }
                    break;
                }
                case 0:{
                    exit();
                }
            }
            System.out.println("\n1. Create New Employee \n");
            System.out.println("2. Display Employee \n");
            System.out.println("3. Delete Employee \n");
            System.out.println("4. Get Employee Type\n");
            System.out.println("5. Get Employee Name\n");
            System.out.println("6. Create New Manager\n");
            System.out.println("7. Delete Manager\n");
            System.out.println("8. Associate Employee With Manager\n");
            System.out.println("9. Display All Managers\n");
            System.out.println("10. Delete Manager Associate Employees to New Manager\n");
            System.out.println("0. Exit \n");

            numberInput = input.nextInt();
        }

    }
}
