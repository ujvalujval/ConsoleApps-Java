package src.Modules.CEOs;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;
import src.Modules.Employees.Employee;
import src.Modules.HelperModules.Helper;
import src.Modules.HelperModules.IDGenerator;
import src.Modules.Managers.Manager;
import src.Modules.Managers.ManagerDisplay;
import src.Modules.PreLoaderDB.Preloader;

public class ceoDisplay extends ManagerDisplay {

    // getProfile
    protected static void getProfileDetails(ArrayList<ceo> ceos) {
        for (ceo c : ceos) {
            System.out.println(
                    "      ============================================== CEOs Profile ==============================================");
            Preloader.printTableHeaderCEODetails();
            c.displayFullEmployeeDetails();
            System.out.println(
                    "+---------------------------------------------------------------------------------------------------------------------------+\n");
        }
    }

    // getEditProfile
    protected static void getEditProfileDetails(Scanner input, String OriginalCEOID, ArrayList<ceo> ceos) {
        boolean editVerify = true;
        while (editVerify) {
            System.out.print("Enter your ID: ");
            String CEOID = input.nextLine();
            boolean found = false;
            for (ceo c : ceos) {
                if (c.getID().equals(CEOID)) {
                    System.out.print("Enter Name: ");
                    String newName = input.nextLine();
                    System.out.print("Enter PhoneNo: ");
                    String newPhoneNo = input.nextLine();
                    System.out.print("Enter Qualification: ");
                    String newQualify = input.nextLine();
                    c.setName(newName);
                    c.setPhoneNo(newPhoneNo);
                    c.setQualification(newQualify);
                    System.out.println(
                            "                                    =============== Profile Updated ===============");
                    getProfileDetails(ceos);
                    found = true;
                    editVerify = false;
                    break;
                }
            }
            if (!found)
                System.out.println("Invalid CEOID. Please try again.\n");
        }
    }

    // getAllEmployeeProfiles
    protected static void getAllEmployeeDetails(ArrayList<ceo> ceos, ArrayList<Employee> emps,
            ArrayList<Manager> Mngrs) {
        getProfileDetails(ceos);
        ManagersProfiles(Mngrs);
        EmployeeProfile(emps);
    }

    // Assign Task to Employees
    protected static void AssignTasks(Scanner input, HashMap<String, List<String>> tasks, ArrayList<Employee> Emps,
            ArrayList<Manager> Mngrs) {

        System.out.println("---------------- Assign Task ----------------");
        System.out.print("Enter Employee ID   : ");
        boolean CheckEmployee = true;
        int EntryPoint = 1;
        String EmpName = null;
        while (CheckEmployee) {
            String EmpID = input.nextLine();
            if (IDGenerator.findEmployeeById(EmpID, Emps) != null
                    || IDGenerator.findManagerById(EmpID, Mngrs) != null) {
                System.out.print("Enter Task          : ");
                String task = input.nextLine();
                tasks.putIfAbsent(EmpID, new ArrayList<>());
                tasks.get(EmpID).add(task);
                if (IDGenerator.findEmployeeById(EmpID, Emps) != null)
                    EmpName = IDGenerator.EmpName;
                if (IDGenerator.findManagerById(EmpID, Mngrs) != null)
                    EmpName = IDGenerator.MngrName;
                System.out.println("  \nTask assigned successfully to: " + EmpName + "\n");
                System.out.println("Returning to CEO Dashboard...\n");
                CheckEmployee = false;
            } else {
                EntryPoint++;
                if (EntryPoint <= 4) {
                    System.out.println("Employee Not Found\n");
                    System.out.print("Enter the EmpID : ");
                } else {
                    System.out.println("To many attempts, try again later");
                    CheckEmployee = false;
                }
            }
        }
    }

    // Introducing a new Employee
    protected static void newEmployee(Scanner input, ArrayList<Employee> Emps) {
        Helper.EmployeeManagement();
        System.out.print("Enter your Choice: ");
        int CheckVerify = input.nextInt();
        input.nextLine();
        if (CheckVerify == 1) {
            System.out.println("Require new Employee Details\n");
            input.nextLine();
            System.out.print("Enter Employee Name: ");
            String newName = input.nextLine();
            System.out.print("Employee PhoneNo: ");
            String PhoneNo = input.nextLine();
            System.out.print("Employee Qualificaton: ");
            String Qualification = input.nextLine();
            System.out.print("Employee Resignation: ");
            String Resignation = input.nextLine();
            System.out.print("Employee WorkingTime: ");
            String DutyTiming = input.nextLine();
            System.out.print("Employee's Salary: ");
            String Salary = input.nextLine();
            System.out.print("Employee Status: ");
            String CreditedOrNot = input.nextLine();
            Employee newEmployee = new Employee(newName, IDGenerator.IDGenerate_E(), PhoneNo, Qualification,
                    Resignation, DutyTiming, Salary, CreditedOrNot);
            Emps.add(newEmployee);
            System.out.println("=========== Employee Added Successfully ===========\n");
            System.out.println("Employeee Name : " + newEmployee.getName());
        } else if (CheckVerify == 2) {
            System.out.print("Enter the EmpID for further process: ");
            String EmpID = input.nextLine();
            boolean found = false;
            for (Employee Em : Emps) {
                if (Em.getID().equals(EmpID)) {
                    System.out.println("Employee ID Found, Need Confirmation");
                    System.out.print("Enter Y/N to Continue: ");
                    String ch = input.nextLine();
                    if (ch.equals("Y") || ch.equals("y")) {
                        Em.setID(null);
                        IDGenerator.setEmployeeCount(IDGenerator.getEmployeeCount() - 2);
                        System.out.println("Employee " + Em.getName() + " Laid off!\n");
                        found = true;
                        break;
                    } else
                        break;
                }
            }
            if (found == false)
                System.out.println("Employee ID not found.\n");
        }

    }

    // getFullDetails
    protected static void getDisplayDetails(Scanner input, ArrayList<Employee> Emps, ArrayList<Manager> Mngrs,
            ArrayList<ceo> ceos, HashMap<String, List<String>> tasks, String OriginalCEOID) {

        boolean CEOStatus = true;
        while (CEOStatus) {
            Helper.CEOHelper();
            System.out.print("Enter your choice: ");
            int CEOChoice = input.nextInt();
            System.out.println("\n");
            switch (CEOChoice) {
                case 1:
                    getProfileDetails(ceos);
                    break;
                case 2:
                    input.nextLine();
                    getEditProfileDetails(input, OriginalCEOID, ceos);
                    break;
                case 3:
                    getAllEmployeeDetails(ceos, Emps, Mngrs);
                    break;
                case 4:
                    newEmployee(input, Emps);
                    break;
                case 5:
                    input.nextLine();
                    AssignTasks(input, tasks, Emps, Mngrs);
                    break;
                case 6:
                    CEOStatus = false;
                    System.out.println("============================ Thank you ============================");
                    break;
            }
        }
    }
}