package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import src.Modules.CEOs.ceo;
import src.Modules.CEOs.ceoLogin;
import src.Modules.Employees.Employee;
import src.Modules.Employees.EmployeeLogin;
import src.Modules.HelperModules.Helper;
import src.Modules.Managers.Manager;
import src.Modules.Managers.ManagerLogin;
import src.Modules.PreLoaderDB.Preloader;

public class Main {
        public static void main(String[] args) {

                ArrayList<Employee> Employees = new ArrayList<>();
                ArrayList<Manager> Managers = new ArrayList<>();
                ArrayList<ceo> ceos = new ArrayList<>();
                HashMap<String, List<String>> tasks = new HashMap<>();

                Preloader.PreloadEmployees(Employees);
                Preloader.PreloadManagers(Managers);
                Preloader.PreloadCEO(ceos);
                Preloader.PreloadTasks(tasks);

                System.out.println("\n======================= Texses Private Limited =======================\n");
                Scanner input = new Scanner(System.in);
                boolean valid = true;

                while (valid) {
                        Helper.StartHelper();
                        System.out.print("Enter your Choice: ");
                        int EmpType = input.nextInt();
                        input.nextLine();
                        switch (EmpType) {
                                case 1:
                                        EmployeeLogin.EmpLogin(input, Employees, tasks);
                                        break;
                                case 2:
                                        ManagerLogin.MngrLogin(input, Managers, Employees, tasks);
                                        break;
                                case 3:
                                        ceoLogin.CEOLogin(input, Employees, Managers, ceos, tasks);
                                        break;
                                case 4:
                                        System.out.println("================ Thanks for visiting ================");
                                        valid = false;
                                        break;
                                default:
                                        System.out.println("please, enter valid option");
                        }
                }
        }
}