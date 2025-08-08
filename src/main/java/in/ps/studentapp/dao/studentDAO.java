package in.ps.studentapp.dao;

import java.util.ArrayList;

import in.ps.studentapp.dto.Student;

public interface studentDAO {
	
public boolean insertStudent(Student s);
public boolean updateStudent(Student s);
public boolean deleteStudent(int id);
public Student getStudent(String nail,String password);
public Student getStudent(long phone,String mail);
public ArrayList<Student>getStudent(String name);
public ArrayList<Student>getStudent();
}
