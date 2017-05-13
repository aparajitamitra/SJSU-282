package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import connectivity.DatabaseConnectivity;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PostServlets")
public class PostServlets extends HttpServlet {
	
	
private DatabaseConnectivity myClass;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		 myClass = new connectivity.DatabaseConnectivity();
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String query;
	        String button = req.getParameter("buttoncategory");
	        String category= req.getParameter("inputCategory");
	        String parentcategory;
	        if(req.getParameter("optionParentCategory")!=null)
	        	parentcategory=req.getParameter("optionParentCategory") ;
	        else
	        	parentcategory="0";
	        

	        if (button.equals("add")) {
	        	
	        	if(parentcategory!=null)
	        	{
	        		String pk;
	        		try{
	        		pk=myClass.getLastPkID("product_cateogories", "category_ID");
	        		query="insert into `cloudtrade1`.`product_cateogories` (`category_ID`, `category_Name`, `parent_ID`, `is_Active`,`created_Date`) values ('" + pk + "','" + category + "','" + parentcategory +"', 1,'" + timeStamp +"')";
	        		if(myClass.crud(query)>0)
	        		{
	        			
	        			resp.sendRedirect("/CloudTrade/admin/AddCategory.jsp");
	        			return;
	        		}
	        		}catch(Exception e)
	        		{
	        			
	        		}
	        		
	        	}
	          
	        } else if (button.equals("cancel")) {
	            
	        } 
		
	}
	
	

}
