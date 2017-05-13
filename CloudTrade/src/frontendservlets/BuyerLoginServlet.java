package frontendservlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectivity.DatabaseConnectivity;;

@WebServlet("/BuyerLoginServlet")
public class BuyerLoginServlet extends HttpServlet{
	
	private DatabaseConnectivity myClass;
	
	public HttpSession session;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		myClass = new connectivity.DatabaseConnectivity();
		int row=0;
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String query;
	        
	     String buttonclick=req.getParameter("buttonbuyerlogin");   
		 String username= req.getParameter("Username");
	        String password=req.getParameter("Password");
	        String email=req.getParameter("Email");
	        String customertype=req.getParameter("CustomerType");
	         String pk;
	         if(buttonclick.equals("Register"))
	         {
	        		try{
	        		pk=myClass.getLastPkID("customers", "customer_ID");
	        		query="insert into `cloudtrade1`.`customers` (`customer_ID`, `customer_USERNAME`, `password`,`email`, `customer_TYPE`,`created_Date`) values ('" + pk + "','" + username + "','" + password +"','" + email +"'," + customertype+ ",'" + timeStamp +"')";
	        		if(myClass.crud(query)>0)
	        		{
	        			
	        			resp.sendRedirect("/CloudTrade/WebContent/frontend/Index.jsp");
	        			return;
	        		}
	        		}catch(Exception e)
	        		{
	        			
	        		}
	         }
	         else if(buttonclick.equals("Login"))
	         {
	        	 
	        	 try{
	        		
	        		query="select * from customers where customer_USERNAME='" + username + "' and password='" + password + "'";
	        		
	        		 
	        		ResultSet r=myClass.query(query);
	        		while(r.next())
	        		{
	        			
	        			session= req.getSession();
	        			session.setAttribute("CusID", r.getString(1));
	        			
	        			session.setAttribute("LoggedInCustomer", username);
	        			resp.sendRedirect("/CloudTrade/Index.jsp");
	        		}
	        		        		 
	        		 
	        	 }catch(Exception e)
	        	 {
	        		 
	        	 }
	         }
	        		
	        	
	          
	        
	}
	
	
	
	

}
