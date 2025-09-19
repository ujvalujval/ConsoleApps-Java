package src.Modules.PreLoaderDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import src.Modules.CEOs.ceo;
import src.Modules.Employees.Employee;
import src.Modules.HelperModules.IDGenerator;
import src.Modules.Managers.Manager;

public class Preloader {

        // Table Formates -> Employees
        public static void printTableHeaderFullDetails() {
                String line = "+-----------------------------------------------------------------------------------------------------------------------+";
                System.out.println(line);
                System.out.printf("| %-5s | %-15s | %-12s | %-17s | %-15s | %-14s | %-8s | %-10s |\n",
                                "ID", "Name", "PhoneNo", "Qualification", "Domain", "Timing", "Salary", "Status");
                System.out.println(line);
        }

        public static void printTableHeaderDetails() {
                String line = "+------------------------------------------------------------------------------+";
                System.out.println(line);
                System.out.printf("| %-5s | %-15s | %-12s | %-17s | %-15s |\n",
                                "ID", "Name", "PhoneNo", "Qualification", "Domain");
                System.out.println(line);
        }

        // Table Formate -> Manager
        public static void printTableHeaderManagerDetails() {
                String line = "+----------------------------------------------------------------------------------------------------------------------------+";
                System.out.println(line);
                System.out.printf("| %-8s | %-15s | %-12s | %-15s | %-19s | %-14s | %-8s | %-10s |\n" +
                                "",
                                "ID", "Name", "PhoneNo", "Qualification", "Domain", "Timing", "Salary", "Status");
                System.out.println(line);
        }

        // Table Formate -> CEO
        public static void printTableHeaderCEODetails() {
                String line = "+---------------------------------------------------------------------------------------------------------------------------+";
                System.out.println(line);
                System.out.printf("| %-12s | %-15s | %-12s | %-15s | %-14s | %-14s | %-8s | %-10s |\n" +
                                "",
                                "ID", "Name", "PhoneNo", "Qualification", "Domain", "Timing", "Salary", "Status");
                System.out.println(line);
        }

        // Default Employeors
        public static void PreloadEmployees(ArrayList<Employee> Emp) {
                Emp.add(new Employee("Ujval M", IDGenerator.IDGenerate_E(), "8242772664", "B.Tech/IT", "Software Dev",
                                "9 AM - 5 PM", "55,000",
                                "Not yet"));
                Emp.add(new Employee("Poovarasan S", IDGenerator.IDGenerate_E(), "6381889512", "B.Tech/IT",
                                "FullStack Dev",
                                "7 AM - 4 PM", "65,000", "Not yet"));
                Emp.add(new Employee("Prithika S", IDGenerator.IDGenerate_E(), "7603015351", "B.E/CSE", "Java Dev",
                                "10 AM - 5 PM", "55,000", "Not yet"));
                Emp.add(new Employee("Yashwanth T", IDGenerator.IDGenerate_E(), "9240527416", "B.Tech/IT",
                                "FrontEnd Dev",
                                "9 AM - 5 PM", "60,000", "Not yet"));
                Emp.add(new Employee("Rishi T", IDGenerator.IDGenerate_E(), "7094931513", "B.Tech/IT", "DataBase Assoc",
                                "10 AM - 6 PM", "65,000", "Not yet"));
                Emp.add(new Employee("Naresh S", IDGenerator.IDGenerate_E(), "8148959133", "B.Tech/IT", "Java Dev",
                                "9 AM - 6 PM", "55,000", "Not yet"));
                Emp.add(new Employee("Sham Kumar S", IDGenerator.IDGenerate_E(), "6381511567", "B.Tech/IT", "Cyber Sec",
                                "6 AM - 9 PM", "75,000", "Not yet"));
                Emp.add(new Employee("Kameshwaren A", IDGenerator.IDGenerate_E(), "8148538075", "B.Tech/IT",
                                "UI/UX Designer",
                                "10 AM - 5 PM", "55,000", "Not yet"));
                Emp.add(new Employee("Ashok Kumar K", IDGenerator.IDGenerate_E(), "8748721348", "B.Tech/IT",
                                "Data Assoc",
                                "11 AM - 4 PM", "50,000", "Not yet"));
                Emp.add(new Employee("Raghul S", IDGenerator.IDGenerate_E(), "8484710270", "B.Tech/IT",
                                "Cyber Sec",
                                "11 AM - 4 PM", "60,000", "Not yet"));
        }

        // Default Managers
        public static void PreloadManagers(ArrayList<Manager> Mngr) {
                Mngr.add(new Manager("Ram Kumar S", IDGenerator.IDGenerate_M(), "9747432574", "Bsc CA", "Assist Professor",
                                "9.30AM - 5 PM",
                                "70,000", "Not yet"));
                Mngr.add(new Manager("Pavithra K", IDGenerator.IDGenerate_M(), "6371434912", "Bsc CA", "Professor",
                                "9.30AM - 5 PM",
                                "65,000", "Not yet"));

        }

        // Default Tasks Assigned
        public static void PreloadTasks(HashMap<String, List<String>> tasks) {
                String task1 = "Develop user login module";
                String task2 = "Fix reported bugs";
                String task3 = "Review code & update docs";
                String task4 = "Write unit tests";
                String task5 = "Optimize database queries";
                String task6 = "Improve UI/UX design";
                String task7 = "Gather client requirements";
                String task8 = "Deploy build to staging";
                String task9 = "Prepare weekly report";
                String task10 = "Research new API";
                String task11 = "Run security checks";
                String task12 = "Test data backup & recovery";
                String task13 = "Mentor new employees";
                String task14 = "Attend tech training";
                String task15 = "Add dark mode feature";
                String task17 = "Prepare team performance report";
                String task18 = "Conduct weekly stand-up meeting";
                String task19 = "Review employee progress updates";

                tasks.put("Emp01", new ArrayList<>());
                tasks.get("Emp01").add(task1);
                tasks.get("Emp01").add(task2);

                tasks.put("Emp04", new ArrayList<>());
                tasks.get("Emp04").add(task3);

                tasks.put("Emp03", new ArrayList<>());
                tasks.get("Emp03").add(task4);
                tasks.get("Emp03").add(task5);

                tasks.put("Emp10", new ArrayList<>());
                tasks.get("Emp10").add(task6);

                tasks.put("Emp08", new ArrayList<>());
                tasks.get("Emp08").add(task7);
                tasks.get("Emp08").add(task8);

                tasks.put("Emp05", new ArrayList<>());
                tasks.get("Emp05").add(task9);
                tasks.get("Emp05").add(task10);
                tasks.get("Emp05").add(task14);

                tasks.put("Emp03", new ArrayList<>());
                tasks.get("Emp03").add(task6);
                tasks.get("Emp03").add(task11);
                tasks.get("Emp03").add(task12);

                tasks.put("Emp02", new ArrayList<>());
                tasks.get("Emp02").add(task15);
                tasks.get("Emp02").add(task13);

                tasks.put("Mngr01", new ArrayList<>());
                tasks.get("Mngr01").add(task19);
                tasks.get("Mngr01").add(task18);

                tasks.put("Mngr02", new ArrayList<>());
                tasks.get("Mngr02").add(task17);
        }

        // CEO
        public static void PreloadCEO(ArrayList<ceo> ceos) {
                ceos.add(new ceo("Sunil M", IDGenerator.IDGenerate_C(), "8248059407", "M.Tech", "CEO", "9AM - 5PM",
                                "1,00,000", "Not yet"));
        }
}