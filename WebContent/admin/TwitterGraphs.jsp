
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="connectivity.DatabaseConnectivity" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Opinion Mining</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">

<!--Icons-->
<script src="js/lumino.glyphs.js"></script>

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Cloud Trade </span>Admin</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> <%=request.getSession().getAttribute("LoggedInUser").toString() %> <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<!--li><a href="#"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Profile</a></li>
							<li><a href="#"><svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg> Settings</a></li-->
							<li><a href="LogOut.jsp"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<form role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
		</form>
		<ul class="nav menu">
			<!--li class="active"><a href="index.html"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg> Add Product Categories</a></li>
			<li><a href="widgets.html"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg>Manage Product Categories</a></li>
			<li><a href="charts.html"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg>Suppliers</a></li>
			<li><a href="tables.html"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg>Buyers</a></li>
			<li><a href="forms.html"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg>Suppliers&Buyers</a></li>
			<li><a href="panels.html"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg>Add FAQs</a></li>
			<li><a href="icons.html"><svg class="glyph stroked star"><use xlink:href="#stroked-star"></use></svg>Manage FAQs</a></li-->
			<li class="parent ">
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-1"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg></span>Product Categories 
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li>
						<a class="" href="AddCategory.jsp">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Add Categories
						</a>
					</li>
					<li>
						<a class="" href="ManageCategory.jsp">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Manage Categories
						</a>
					</li>
					
				</ul>
			</li>
			<li class="parent ">
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-3"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg></span>Twitter Review 
				</a>
				<ul class="children collapse" id="sub-item-3">
					<li>
						<a class="" href="TwitterReviews.jsp">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Reviews
						</a>
					</li>
					<li>
						<a class="" href="TwitterGraphs.jsp">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Graphs
						</a>
					</li>
					
				</ul>
			</li>
			
			<li class="parent ">
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-2"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg></span>Suppliers 
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li>
						<a class="" href="#">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Add Categories
						</a>
					</li>
					<li>
						<a class="" href="#">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Manage Categories
						</a>
					</li>
					
				</ul>
			</li>
			<li class="parent ">
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-3"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg></span>Suppliers & Buyers 
				</a>
				<ul class="children collapse" id="sub-item-3">
					<li>
						<a class="" href="#">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Add Categories
						</a>
					</li>
					<li>
						<a class="" href="#">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Manage Categories
						</a>
					</li>
					
				</ul>
			</li>
			<li class="parent ">
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-4"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg></span>Buyers 
				</a>
				<ul class="children collapse" id="sub-item-4">
					<li>
						<a class="" href="#">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Add Categories
						</a>
					</li>
					<li>
						<a class="" href="#">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Manage Categories
						</a>
					</li>
					
				</ul>
			</li>
			<li class="parent ">
				<a href="#">
					<span data-toggle="collapse" href="#sub-item-5"><svg class="glyph stroked chevron-down"><use xlink:href="#stroked-chevron-down"></use></svg></span>FAQs 
				</a>
				<ul class="children collapse" id="sub-item-5">
					<li>
						<a class="" href="#">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Add FAQs
						</a>
					</li>
					<li>
						<a class="" href="#">
							<svg class="glyph stroked chevron-right"><use xlink:href="#stroked-chevron-right"></use></svg>Manage FAQs
						</a>
					</li>
					
				</ul>
			</li>
			<li role="presentation" class="divider"></li>
			<!--li><a href="login.html"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Login Page</a></li-->
		</ul>

	</div>
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">

		<div class="panel panel-primary">
			
			<div class="panel-body">
				<br>
				<form action="TwitterGraphs.jsp" class="form-inline" method="POST">
					<input type="hidden" name="s"/>
					<div style="line-height: 3.4em;">
<div class="form-group">
							<label>Select product : </label>
							<%
								
								DatabaseConnectivity myClass=new DatabaseConnectivity();
								ResultSet r=myClass.query("select * from tweetstable");
								

								List<String> Products= new ArrayList<String>();
								while(r.next())
								{
									
									Products.add(r.getString(8).toString());
									
								}
								
								
							%>
							<select name="product_name" class="form-control">
								<%
									for (String temp : Products) {
								%>
								<option value="<%=temp%>"><%=temp%></option>

								<%
									}
								%>
							</select>
							<%
								
							%>
							
						 <input type="submit" value="See Usage Statistics" class="btn btn-primary"> 
						</div>
					</div>
					
					<br/><br/>
					<%
						if(request.getParameter("s") != null) {
					%>
					<div class="canvas-wrapper">
						<canvas class="main-chart" id="bar-chart" height="200" width="600"></canvas>
					</div>
					<%
						}
					%>
				</form>
			</div>
	</div>
		
		</div>
	</div>
	
	
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	

</body>
</html>

