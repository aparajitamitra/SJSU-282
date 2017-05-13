package frontendservlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectivity.DatabaseConnectivity;

@WebServlet("/AddProductsServlet")
public class AddProductsServlet extends HttpServlet {
	
	private DatabaseConnectivity myClass;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		myClass = new connectivity.DatabaseConnectivity();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String buttonclick=req.getParameter("buttonaddproduct");
		String productname=req.getParameter("ProductName");
		String productcategory=req.getParameter("OptionProductCategory");
		String productlistingdescription=req.getParameter("ProductListingDescription");
		String productdetaildescription=req.getParameter("ProductDetailDescription");
		String productprice=req.getParameter("ProductPrice");
		 String query;
		 String pk;
		
		if(buttonclick.equals("Add Product"))
		{
			try{
        		pk=myClass.getLastPkID("products", "product_ID");
        		query="insert into `cloudtrade1`.`products` (`product_ID`, `customer_ID`, `category_ID`,`product_NAME`,`listing_Description`, `detail_Description`, `product_Price`, `created_Date`) values ('" + pk + "','" + req.getSession().getAttribute("CusID").toString() + "','" ;
        		query=query + productcategory +"','" + productname +"','" + productlistingdescription + "','" + productdetaildescription +"'," + productprice + ",'" + timeStamp + "')";
        		if(myClass.crud(query)>0)
        		{
        			
        			resp.sendRedirect("/CloudTrade/AddProduct.jsp");
        			
        		}
        		}catch(Exception e)
        		{
        			
        		}
		}
		
		
	}
	
	

}
