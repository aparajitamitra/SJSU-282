package servlets;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectivity.DatabaseConnectivity;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private DatabaseConnectivity myClass;
public HttpSession session;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	super.doGet(req, resp);
		
		String buttonclick=req.getParameter("buttoncategory");
		String query;
		
		String username=req.getParameter("email");
		String password=req.getParameter("password");
		myClass=new connectivity.DatabaseConnectivity();
		
		if(buttonclick.equals("Login"))
		{
			try{
			query="select * from admin_users where user_NAME='" + username + "' and password='" + password + "'";
    		
   		 
    		ResultSet r=myClass.query(query);
    		while(r.next())
    		{
    			session= req.getSession();
    			session.setAttribute("LoggedInUser", username);
    			resp.sendRedirect("/CloudTrade/admin/Index.jsp");
    		}
		}catch(Exception e)
			{
			
			}
		}
		
		
		
	}
	

}
