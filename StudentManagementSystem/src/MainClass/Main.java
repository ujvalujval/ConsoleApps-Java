package MainClass;

import DBConnection.DAO;
import HelperClasses.Helper;
import VerificationProcess.AthunticationProcess;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		DAO dao = new DAO();
		
		System.out.println("\t========== Hindusthan College of Engineering and Technology ==========");
		System.out.println("\t\t\tDepartment of Information Technology\n");
		
		boolean LoginBegin = true;
		try {
		while(LoginBegin) {
			Helper.MainDashboard();
			System.out.print("Enter your Role : ");
			int role = input.nextInt();
			input.nextLine();
			switch(role) {
				case 1: 
					AthunticationProcess.Forfaculty(dao, input);
					break;
				case 2:
					System.out.println("\nI am a Student\n");
					break;
				case 3:
					LoginBegin = false;
					System.out.println("\n\t\t========== Thank you ==========");	
			}
		}
		}
		catch(Exception e) {
			System.out.println("Something went wrong.try again!");
		}
		input.close();
	}
}