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

@WebServlet("/ManCategoriesServlet")
public class ManCategoriesServlet extends HttpServlet {
	
	
private DatabaseConnectivity myClass;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		 myClass = new connectivity.DatabaseConnectivity();
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String inputtext=null, isactive=null;
		 String pk=null;
		 String query;
	        String button = req.getParameter("buttoncategory");
	       
	        if(req.getParameter("optionsRadios").equals("Parent"))
	        {
	        	inputtext=req.getParameter("nmparentCategory");
	        	isactive=req.getParameter("optionsParentRadios");
	        	pk=req.getParameter("optionParentCategory");
	        	
	        }
	        else if(req.getParameter("optionsRadios").equals("Child"))
	        {
	        	inputtext=req.getParameter("nmchildCategory");
	        	isactive=req.getParameter("optionsChildRadios");
	        	pk=req.getParameter("optionChildCategory");
	        	
	        }
	        

	        if (button.equals("Update")) {
	        	
	        	
	        	String[] pkarr=pk.split(",");
        		try{
        		
        		query="update `cloudtrade1`.`product_cateogories` set category_Name='" + inputtext + "', is_Active=" + isactive + " where category_ID='" + pkarr[0] + "'";
        		
        		if(myClass.crud(query)>0)
        		{
        			
        			resp.sendRedirect("/CloudTrade/admin/ManageCategory.jsp");
        			return;
        		}
        		}catch(Exception e)
        		{
        			
        		}
	        	
	        	
	          
	        } else if (button.equals("cancel")) {
	            
	        } 
		
	}
	
	

}

