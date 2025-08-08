package in.ps.studentapp.index;

import java.util.Scanner;

import in.ps.studentapp.dao.studentDAO;
import in.ps.studentapp.dao.studentDAOimp;
import in.ps.studentapp.dto.Student;

public class Update {
	public static void update(Student s) {
		Scanner sc = new Scanner(System.in);
		studentDAO sdao=new studentDAOimp();
		System.out.println("<---Update Account--->");
		int choice=0;
		do {
			System.out.println("Enter the field to be Updateed");
			System.out.println("1.Name");
			System.out.println("2.Phone");
			System.out.println("3.Mail");
			System.out.println("4.Branch");
			System.out.println("5.Password");
			System.out.println("6.Go back to DashBoard");
			choice = sc.nextInt ();
			switch (choice) {
			case 1:
			System.out.println("Enter the new name: ");
			s. setName (sc.next());
			break;
			case 2:
			System.out.println("Enter the Phone number: ");
			s. setPhone (sc. nextLong()) ;
			break;
			case 3:
			System.out.println("Enter the Mail ID: ");
			s. setMail(sc.next());
			break;
			case 4:
			System.out.println("Enter the Branch");
			s. setBranch(sc.next());
			break;
			case 5:
			System.out.println("Enter the Location");
			s. setLoc(sc.next());
			break;
			case 6:
			System.out.println("Enter the Password");
			s. setPassword(sc.next());
			break;
			default:
				System.out.println("Invalid Choice,Please choose correct");
		}
			boolean res=sdao.updateStudent(s);
	}while(choice!=6);
	}

}
