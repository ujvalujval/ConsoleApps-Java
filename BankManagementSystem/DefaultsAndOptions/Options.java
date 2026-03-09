package DefaultsAndOptions;

public class Options {
    
    public static void OptionsForStaff(String name){
        String line = "+===============================+";
        String underline = "+-------------------------------+";
        System.out.println(line);
        System.out.printf("| %-29s |\n", "Welcome, "+name);
        System.out.println(line);
        System.out.printf("| %-29s |\n", "1. Register a new Customer");
        System.out.println(underline);
        System.out.printf("| %-29s |\n", "2. Existing customers");
        System.out.println(underline);
        System.out.printf("| %-29s |\n", "3. Logout");
        System.out.println(line+"\n");
    }

    public static void StaffAccessable(String name){

        String line = "+============================+";
        String underline = "+----------------------------+";
        System.out.println(line);
        System.out.printf("| %-26s |\n", "CustomerName, "+name);
        System.out.println(line);
        System.out.printf("| %-26s |\n", "1. View Balance");
        System.out.println(underline);
        System.out.printf("| %-26s |\n", "2. View Profile");
        System.out.println(underline);
        System.out.printf("| %-26s |\n", "3. Deposit Amount");
        System.out.println(underline);
        System.out.printf("| %-26s |\n", "4. WithDraw Amount");
        System.out.println(underline);
        System.out.printf("| %-26s |\n", "5. Transfer Amount");
        System.out.println(underline);
        System.out.printf("| %-26s |\n", "6. History of Transcations");
        System.out.println(underline);
        System.out.printf("| %-26s |\n", "8. Exit");
        System.out.println(underline);
    }
}
