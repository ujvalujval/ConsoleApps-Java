package PreloadData;

import Staff.Staffs;
import Staff.newCustomer;
import java.util.*;

public class DefaultUsers {
    
    // Default Users
    public static void defaultsCustomers(List<newCustomer> customers){
            customers.add(new newCustomer(getUserID(), "User 1", "12345678", "Hosur", 500));
            customers.add(new newCustomer(getUserID(), "User 2", "87654321", "Dharmapuri", 500));
            customers.add(new newCustomer(getUserID(), "User 3", "82487727", "Erode", 500));
    }

    // Default Staffs
    public static void defaultStaffs(List<Staffs> staffs){
            staffs.add(new Staffs(getStaffID(), "Staff 1", "123456"));
            staffs.add(new Staffs(getStaffID(), "Staff 2", "123456"));
    }


      // Customer and Staff Count
        private static int Customer_Count = 0;
        private static int Staffs_Count = 0;

    // UserIDs Generator
    public static String getUserID(){
        Customer_Count++;
        if(Customer_Count > 9){
            return "Customer"+Customer_Count;
        }
        return "Customer0"+Customer_Count;
    }

    public static String getStaffID(){
        Staffs_Count++;
        if(Staffs_Count > 9){
            return "Staff"+Staffs_Count;
        }
        return "Staff0"+Staffs_Count;
    }

    //Account Number Generator
    public static String  generateAccountNumber(){
        int min = 10000000; 
        int max = 99999999; 
        Random rand = new Random();
        int randomNumber = rand.nextInt(max - min + 1) + min;
        return String.valueOf(randomNumber).toString();
    }
}