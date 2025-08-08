package in.ps.studentapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.ps.studentapp.dao.studentDAO;
import in.ps.studentapp.dao.studentDAOimp;
import in.ps.studentapp.dto.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//creating the object of POJO class
		Student s=new Student();
		//creating ref object of StudentDAO
		studentDAO sdao=new studentDAOimp();
		//Creating printWriter class object
		PrintWriter out=resp.getWriter();
		//collecting the data from the UI
		//String name=req.getParameter("name");
		//s.setName(name);
		s.setName(req.getParameter("name"));
		
		//String s_p=req.getParameter("phone");
		//long phone=Long.parseLong(s_p);
		//s.setPhone(phone);
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("loc"));
		
		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
			s.setPassword(req.getParameter("password"));
			boolean res=sdao.insertStudent(s);
			if(res) {
				//out.println("<h1> Data added successfully</h1>");
				req.setAttribute("success", "Data added successfully!");
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
			}
			else {
				//out.println("<h1> failed to signup </h1>");
				req.setAttribute("error", "Failed to signup");
				RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
				rd.forward(req, resp);
			}
		}
		else {
			//out.println("<h1>Password mismatch</h1>");
			req.setAttribute("error", "Password mismatch");
			RequestDispatcher rd=req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
		}
	}

}
