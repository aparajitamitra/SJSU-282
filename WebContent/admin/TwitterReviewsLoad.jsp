<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="espproject.callTwitterApi"%>

<%
	String productName = request.getParameter("productname");
	callTwitterApi obj1 = new callTwitterApi();
	obj1.getTweetsUsingSearch(productName, request.getServletContext());
%>