<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="espproject.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.nio.file.*" %>

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
				<form action="#" class="form-inline" >
					<div style="line-height: 3.4em;">
						<label for="purge tables">Product Name:</label> <input type="text" id="productname" name="productname" class="form-control" value=<%= request.getParameter("productname") == null ? "" : request.getParameter("productname") %>>
						<br/>
						 <input type="submit" value="Add Product" class="btn btn-primary"> 
					</div>
					<%
						String productname = request.getParameter("productname");							
						System.out.println("product name - " + productname);
						if (productname != null) {							
							callTwitterApi obj1=new callTwitterApi();
							SearchTweets tweetsLoaded = obj1.getTweetsUsingSearch(productname, request.getServletContext());
						
					%>
					
					<h3>Tweets Loaded in database</h3>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Tweet Ids</th>
								<th>Timezone</th>
								<th>Created At</th>
								<th>Retweet Count</th>
								<th>Favorite Count</th>
								<th>Score</th>
								<th>Text</th>
							</tr>
						</thead>
						<tbody>
						<%
						sentimentAnalysis calScore=new sentimentAnalysis();
						List<Status> statuses = tweetsLoaded.getStatuses();
						for(Status status : statuses)
						{
							double score=calScore.calSentimentScore(status.getText(),status.getRetweetCount().intValue() , status.getFavoriteCount().intValue(), getServletContext());
						%>
						
							<tr>
								<td><%= status.getId().toString() %></td>
								<td><%= status.getUser().getTimeZone() %></td>
								<td><%= status.getCreatedAt() %></td>
								<td><%= status.getRetweetCount() %></td>
								<td><%= status.getFavoriteCount() %></td>
								<td><%= score %></td>
								<td><%= status.getText() %></td>
							</tr>
							<%
						}
							%>
						</tbody>
					</table>
					
					
					<%
						}
					%>
					</form>
				</div>
	</div>

	
			<%
			
		%>
		</div>
	</div>

</body>
</html>

