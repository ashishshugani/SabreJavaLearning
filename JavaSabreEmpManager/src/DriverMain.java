
import java.util.Arrays;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class DriverMain {

    public static void main(String args[]){

        Employee[] empObjArray = new Employee[10];
        EmpPersonalInformation empPersonalObj=new EmpPersonalInformation();
        EmpOtherInformation empOtherObj = new EmpOtherInformation();

        Scanner input = new Scanner(System.in);

        int idFlagEmp=-1;
        int numberInput;

        do{

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

            switch(numberInput){

                case 1:{
                    System.out.println("Enter Employee ID : \n");
                    String empID = input.next();
                    System.out.println("Enter Employee Type : \n");
                    String emptype = input.next().toLowerCase();
                    System.out.println("Enter FirstName : \n");
                    String empfirstname = input.next();
                    System.out.println("Enter Lastname : \n");
                    String emplastname= input.next();
                    System.out.println("Enter Phone Number : \n");
                    String empphone = input.next();

                    idFlagEmp++;
                    empObjArray[idFlagEmp] = new Employee();

                    empPersonalObj.setFirstName(empfirstname);
                    empPersonalObj.setPhone(empphone);

                    empOtherObj.setType(emptype);

                    empObjArray[idFlagEmp].setEmployeeID(empID);
                    empObjArray[idFlagEmp].setLastName(emplastname);
                    empObjArray[idFlagEmp].setEmpPersonalobj(empPersonalObj);
                    empObjArray[idFlagEmp].setEmpOtherObj(empOtherObj);

                    break;
                }
                case 2:{

                    System.out.println("Enter Employee ID :");
                    String empIDInput = input.next();

                    Arrays.stream(empObjArray)
                            .filter(y -> y!=null)
                            .filter(y -> empIDInput.equals(y.getEmployeeID()))
                            .forEach(z -> {
                                System.out.println(z.getEmployeeID());
                                System.out.println(z.getEmpPersonalobj().getFirstname() + " " + z.getLastName());
                                System.out.println(z.getEmpPersonalobj().getPhone());
                                System.out.println(z.getEmpOtherobj().getDept());
                                System.out.println(z.getEmpOtherobj().getType());
                    });


                    break;

                }
                case 3:{

                    break;
                }
                case 4:{

                    break;
                }
                case 5:{

                    break;
                }
                case 6:{


                    break;
                }
                case 7:{

                    break;
                }
                case 8:{

                    break;
                }
                case 9:{

                    break;
                }
                case 10:{

                    break;
                }
                case 0:{
                    exit();
                }
            }

        }while(numberInput!=0);

    }
}
