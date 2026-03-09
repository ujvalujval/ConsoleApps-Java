package Staff;

import DefaultsAndOptions.Options;
import java.util.*;

public class StaffOperations {
    
    //Staff Operations
    public static void staffOPs(Scanner input, String accountNumber, List<newCustomer> users){
            newCustomer existing = null;
            while (true) {
                for(newCustomer user : users){
                        if(user.getAccountNumber().equals(accountNumber))
                            existing = user;
                }
                if(existing!= null){
                    input.nextLine();
                    Options.StaffAccessable(existing.getCustomerName());
                    System.out.print("\nEnter Option: ");
                    int staffOp = input.nextInt();
                    switch (staffOp) {
                        case 1:
                            checkBalance(existing.getDefaultAccountBalance());
                            input.nextLine();
                            break;
                        case 2:
                            displayCustomerProfile(existing);
                            input.nextLine();
                            break;
                        case 3:
                            depositAmount(input,existing);
                            input.nextLine();
                            break;
                        case 4:
                            withDrawAmount(input, existing);
                            input.nextLine();
                            break;
                        case 5:
                            System.out.println("\t======== Enter Transfer Details ========");
                            System.out.print("Enter Amount to Transfer: ");
                            int amount = input.nextInt();
                            input.nextLine();
                            System.out.print("Enter Account Number to Tranfer: ");
                            String toaccountNumber = input.nextLine();
                            transferAmount(users, existing, toaccountNumber, amount);
                            break;
                        case 6:
                            transferedHistory(existing);
                            break;
                        case 7:
                            return;
                }
            }
            else {
                System.out.println("Enter Valid AccountNumber!!");
                break;
            }
        }
    }

    //Customer Profile View Formate
    private static void ProfileViewFromate(){
         String line = "+-----------------------------------------------------------------------------------------+";
                System.out.println(line);
                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                                "UserID", "Name", "AccountNumber", "Address", "Balance");
                System.out.println(line);
    }

    //Staff Credentials Validation
    public static boolean verifyCredentials(String userId, String password, List<Staffs> staffs){
        boolean verifyformat = userId!= null && password != null && !userId.isEmpty() && !password.isEmpty();
        Staffs user = null;
        if(verifyformat){
            for(Staffs staff : staffs){
                if(staff.getStaffName().equals(userId) && staff.getPassword().equals(password)){
                     user = staff;
                }
            }
        }
        return user != null;
    }

    //Customer's Balance
    private static void checkBalance(Double Amount){
        System.out.println("Your Account Balance: "+Amount);
    }

    //Customer's Profile
    private static void displayCustomerProfile(newCustomer existing){
             System.out.println("========= Customer Profile =========");
            ProfileViewFromate();
            System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n", existing.getUserId(), existing.getCustomerName(), existing.getAccountNumber(), existing.getAddress(), existing.getDefaultAccountBalance());
            System.out.println("+-----------------------------------------------------------------------------------------+\n");
    }

    //Deposit Amount
    private static void depositAmount(Scanner input, newCustomer user){
            System.out.print("Enter Amount to Deposit: ");
            double Amount = input.nextDouble();
            if(Amount > 0){
                user.setDefaultAccountBalance(user.getDefaultAccountBalance()+Amount);
                System.out.println("Amount Deposited Sucessfully!!");
                System.out.println("Current Bal: "+user.getDefaultAccountBalance());
                customersHistory(user, Amount);
            }
            else System.out.println("Enter Valid Amount");
    }

    //WithDraw Amount
    private static void withDrawAmount(Scanner input, newCustomer user){
        System.out.print("Enter Amount to Withdraw: ");
        double Amount = input.nextDouble();
        if(!(Amount > user.getDefaultAccountBalance())){
            user.setDefaultAccountBalance(user.getDefaultAccountBalance()-Amount);
            System.out.println("Amount Withdrawed Successfully!!");
            System.out.println("Current Bal: "+user.getDefaultAccountBalance());
            List<CustomerTransactionHistory> history = customerHistory(user);
            history.add(new CustomerTransactionHistory(user.getAccountNumber(), "--", "Withdraw", Amount, user.getDefaultAccountBalance(), new Date().getTime()));
        }
        else System.out.println("Amount, Insufficent!!");
    }

    //Exixting All customers
    public static void displayAllCustomers(List<newCustomer> users){
        ProfileViewFromate();
        for(newCustomer user : users){
            System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s |\n", user.getUserId(), user.getCustomerName(), user.getAccountNumber(), user.getAddress(), user.getDefaultAccountBalance());
            System.out.println("+-----------------------------------------------------------------------------------------+");
        }
    }

    //Transfer Amount
    private static void transferAmount(List<newCustomer> users, newCustomer user,String toAccount, int Amount){
            newCustomer existinguser = null;
            for(newCustomer customer : users){
                System.out.println(customer.getAccountNumber()+" : "+toAccount);
                if(customer.getAccountNumber().equals(toAccount)){
                    existinguser = customer;
                    break;
                }
            }
            System.out.println(existinguser.getAccountNumber());
            if( existinguser != null && user.getDefaultAccountBalance() >= Amount){
                    user.setDefaultAccountBalance(user.getDefaultAccountBalance() - Amount);
                    existinguser.setDefaultAccountBalance(existinguser.getDefaultAccountBalance()+Amount);
                    System.out.println("Amount Transfered Successfully!!");
                    List<CustomerTransactionHistory> history = customerHistory(user);
                    history.add(new CustomerTransactionHistory(user.getAccountNumber(), toAccount, "Transfer", Amount, user.getDefaultAccountBalance(), new Date().getTime()));
            }
            else System.out.println("Enter Valid Credentials!!");
    }

    // Transfered History Details
    private static void transferedHistory(newCustomer user){
        String line = "+-----------------------------------------------------------------------------------------------------------+";
                System.out.println(line);
                System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                                "From", "To", "Mode", "Amount", "Balance", "Time");
                System.out.println(line);
        List<CustomerTransactionHistory> history = user.getCustomerTransactionHistory();
        for(CustomerTransactionHistory cus : history){
            System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                                cus.getFromAccountNumber(), cus.getToAccountNumber(), cus.getMode(), cus.getAmount(), cus.getBalance(), cus.getTime());
            System.out.println(line);
        }
    }

    private static void customersHistory(newCustomer user, double amount){
        List<CustomerTransactionHistory> history = customerHistory(user);
        history.add(new CustomerTransactionHistory(user.getAccountNumber(), "--", "Deposit", amount, user.getDefaultAccountBalance(), new Date().getTime()));
    }   

    private static List<CustomerTransactionHistory> customerHistory(newCustomer user){
            return user.getCustomerTransactionHistory();
    }
}