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

@WebServlet("/Reset")
public class Reset extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		studentDAO sdao=new studentDAOimp();
		PrintWriter out=resp.getWriter();
		Student s=sdao.getStudent(Long.parseLong(req.getParameter("phone")),req.getParameter("email"));
		
		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
		s.setPassword(req.getParameter("password"));
		boolean res=sdao.updateStudent(s);
		if(res) {
			//out.println("<h1>Password updated successfully</h1>");
			req.setAttribute("success", "Password updated successfully");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
		else {
			//out.println("<h1>Failed to update the password</h1>");
			req.setAttribute("error", "Failed to update the password");
			RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
			rd.forward(req, resp);
		}
	}
	else {
		//out.println("<h1>password mismatch!</h1>");
		req.setAttribute("error", "password mismatch!");
		RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
		rd.forward(req, resp);
	}
	}
}
