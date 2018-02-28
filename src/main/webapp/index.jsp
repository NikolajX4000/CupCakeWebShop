<%-- 
    Document   : index
    Created on : 27-02-2018, 16:27:00
    Author     : super
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Data.User"%>

<%@include file="header.jsp" %>

<%
User user = (User)session.getAttribute("user");

if(user != null)
    %><jsp:include page="shopPage.jsp" flush="true"/><%
else
    %><jsp:include page="loginPage.jsp" flush="true"/><%
%>

<%@include file="footer.jsp" %>