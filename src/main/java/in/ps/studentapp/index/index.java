package in.ps.studentapp.index;

import java.util.Scanner;

public class index {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		System.out.println("Welcome to my Student application");
		do {
			System.out.println("1,SIGNUP");
			System.out.println("2,LOGIN");
			System.out.println("3,FORGOT PASSWORD");
			System.out.println("4,EXIT");
			
			choice=sc.nextInt();
			switch(choice) {
			case 1:Signup.signup();
			break;
			case 2:login.login();
			break;
			case 3:
			break;
			case 4:System.out.println("application is closed");
			break;
			case 5:System.out.println("invalid choice place enter valid data ");
			}
		}
		while(choice!=4);
			
			
		}

	}


