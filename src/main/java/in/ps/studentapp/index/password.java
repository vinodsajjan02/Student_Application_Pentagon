package in.ps.studentapp.index;

import java.util.Scanner;

import in.ps.studentapp.dao.studentDAO;
import in.ps.studentapp.dao.studentDAOimp;
import in.ps.studentapp.dto.Student;

public class password {
	public static void reset(Student s) {
		Scanner sc = new Scanner(System.in);
		studentDAO sdao=new studentDAOimp();
		System.out.println("Enter the phone numner:");
		long phone=sc.nextLong();
		
		System.out.println("Enter the mail id");
		String mail=sc.next();
		
		if(s.getPhone()==phone && s.getMail().equals(mail)) {
			System.out.println("Set the new pasword");
			String password=sc.next();
			
			System.out.println("Confirm the password");
			String confirm=sc.next();
			if(password.equals(confirm)) {
				s.setPassword(password);
				boolean res=sdao.updateStudent(s);
				if(res) {
					System.out.println("password updated successfully");
				}
			else {
				System.out.println("Update failed");
			}				
			}
			else {
				System.out.println("password mismatch");
			}
		}
		else {
			System.out.println("Incorrect phone or Mail id");
		}
	}

}
