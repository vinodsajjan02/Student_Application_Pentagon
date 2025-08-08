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
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		studentDAO sdao=new studentDAOimp();
		//creation of session object-[new]
		HttpSession session=req.getSession(true);
		//PrintWriter out=resp.getWriter();
		Student s=sdao.getStudent(req.getParameter("email"),req.getParameter("password"));
		if(s!=null) {
			//out.println("<h1>Login Successfull</h1>");
			session.setAttribute("student", s);
			req.setAttribute("success","Login successfull!");
			RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
		}
		else {
			//out.println("<h1>Failed to login</h1>");
			req.setAttribute("error", "Failed to Login!");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
	}

}
