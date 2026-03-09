import java.util.*;

import DefaultsAndOptions.Options;
import PreloadData.DefaultUsers;
import Staff.StaffOperations;
import Staff.Staffs;
import Staff.newCustomer;

public class bankManagementSystem {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        List<newCustomer> users = new ArrayList<>();
        List<Staffs> staffs = new ArrayList<>();

        DefaultUsers.defaultsCustomers(users);
        DefaultUsers.defaultStaffs(staffs);
        
        System.err.println("========== BANK MANAGEMENT SYSTEM ==========");
        
        while (true) {
            System.out.print("Enter your Name: ");
            String name = input.nextLine();
            System.out.print("Enter your Password: ");
            String password = input.nextLine();
            while (true) {
                if(StaffOperations.verifyCredentials(name, password, staffs)){
                    Options.OptionsForStaff(name);
                    System.out.print("Enter option to perform: ");
                    int staffop = input.nextInt();
                    input.nextLine();
                    switch (staffop) {
                        case 1:
                            System.out.println("\n Enter Details of the new customer");
                            System.out.print("Enter Customer Name: ");
                            String staffname = input.nextLine();
                            System.out.print("Enter Address: ");
                            String address = input.nextLine();
                            newCustomer newuser = new newCustomer(DefaultUsers.getUserID(), staffname, DefaultUsers.generateAccountNumber(), address, 500);
                            users.add(newuser);
                            System.out.println("Customer Added Successfully!!");
                            input.nextLine();
                            break;
                        case 2:
                            System.out.println("\t\t\t======== Existing ALL CUSTOMERS ========");
                            StaffOperations.displayAllCustomers(users);
                            input.nextLine();
                            System.out.print("Enter Account Number: ");
                            String existingAccNumber = input.nextLine();
                            StaffOperations.staffOPs(input, existingAccNumber, users);
                            break;
                        case 3:
                            System.out.println("\n======== Thanks for Visiting ========\n");
                            return;
                    }
                }
                else{
                    System.out.println("Enter valid Credentials!!\n");
                    break;
                }
            }
        }
    }    
}