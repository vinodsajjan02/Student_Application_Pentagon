package in.ps.studentapp.index;

import java.util.Scanner;

import in.ps.studentapp.dao.studentDAO;
import in.ps.studentapp.dao.studentDAOimp;
import in.ps.studentapp.dto.Student;

public class Signup {
	public static void signup() {
		Scanner sc=new Scanner(System.in);
		studentDAOimp sdao=new studentDAOimp();
		Student s=new Student();
		System.out.println("<---Student Signup-->");
		System.out.println("enter the name");
		s.setName(sc.next());
		System.out.println("enter the phon");
		s.setPhone(sc.nextLong());
		System.out.println("enter the mail");
		s.setMail(sc.next());
		System.out.println("enter the branch");
		s.setBranch(sc.next());
		System.out.println("enter the loc");
		s.setLoc(sc.next());
		System.out.println("Set a new password");
		String password=sc.next();
		System.out.println("confirm the password");
		String confirmPassword=sc.next();
		if(password.equals(confirmPassword)) {
			s.setPassword(confirmPassword);
			boolean res=sdao.insertStudent(s);
			if(res) {
				System.out.println("Data Added Successfully");
			}
			else {
				System.out.println("Failed to Create a Account");
			}
		}
		else {
			System.out.println("Password mismatch!");
		}
		
	}

}
