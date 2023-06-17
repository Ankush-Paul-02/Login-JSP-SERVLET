package com.paul;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.paul.dao.LoginDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("pass");
		
		LoginDao dao = new LoginDao();
		
		/*
		if (username.equals("Ankush") && password.equals("123456")) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("welcome.jsp");
		} else {
			response.sendRedirect("login.jsp");
		} */
		
		if(dao.check(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("welcome.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}

	}

}
