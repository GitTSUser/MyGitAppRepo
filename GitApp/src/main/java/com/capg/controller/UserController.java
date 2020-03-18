package com.capg.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capg.dao.UserDao;

@WebServlet("/login")
public class UserController extends HttpServlet {

	private UserDao dao = new UserDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("UserController.doPost()");
		HashMap<String, String> users = dao.getUsers();
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("upwd");

		PrintWriter out = resp.getWriter();
		System.out.println("UserController.doPost()");
		resp.setContentType("text/html");
		out.println("<html><body><b>");
		if (users.containsKey(uname)) {

			if (users.get(uname).equals(pwd)) {

				out.println("Welcome to Browse");

			} else {
				out.println("Invalid details");
			}
		}

		out.println("</b></body></html>");

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
