package in.ps.studentapp.index;

import java.util.ArrayList;
import java.util.Scanner;

import in.ps.studentapp.dao.studentDAO;
import in.ps.studentapp.dao.studentDAOimp;
import in.ps.studentapp.dto.Student;

public class login {
	public static void login() {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		studentDAO sdao=new studentDAOimp(); 
		System.out.println( "<--Login-->");
		System.out.println("Enter the mail id");
		String mail=sc.next();
		System.out.println("Enter the Password");
		String password=sc.next();
		Student a=sdao.getStudent(mail,password);
		if(a!=null) {
			System.out.println("login sucessfull");
			do {
				System.out.println("1.view data");
				System.out.println("2.Search Users");
				System.out.println("3.Update account");
				System.out.println("4.Reset Password");
				System.out.println("5.Back to main menu");
				if(a.getId()==2) { //admin
					System.out.println("6.View all users");
					System.out.println("7.Delete the user");
				}
			choice = sc.nextInt();
			switch(choice) {
			case 1: System.out.println(a);
			break;
			case 2: System.out.println("Enter the Student name:");
			        String name=sc.next();
			        ArrayList<Student> sL1=sdao.getStudent(name);
			       /* if(Student.isEmpty) {
			        	System.out.println("No name found");
			        }
			        else {*/
			        	
			        for(Student s3 : sL1) {
			        	System.out.println("Student id:"+s3.getId());
			        	System.out.println("Student name:"+s3.getName());
			        	System.out.println("Student branch:"+s3.getBranch());
			        	System.out.println("Student location:"+s3.getLoc());
			       // }
			}
			break;
			case 3: Update.update(a);
			/*boolean Update=sdao.updateStudent(a);
			if(updated) {
				System.out.println("Update successfully");
			}
			else {
				System.out.println("Update failed");
			}*/
			break;
//			case 4: password.reset(a);
//			break;
			case 5: System.out.println("going back to main manu...");
			break;  
			case 6:System.out.println("Our user..");//view all user
			ArrayList<Student>sL=sdao.getStudent();
					for(Student s:sL) {
						System.out.println(s);
					}
			break;
			case 7: //Delete user logic
			break;
			default:System.out.println("Invalid choice! try again");
			}
			}while(choice!=5);
		}
		else {
			System.out.println("failed to login");
		}
		
	}

}
