<%-- 
    Document   : logout
    Created on : 01-03-2018, 15:25:55
    Author     : Stephan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% session.invalidate();  %>
<% response.sendRedirect("welcome"); %>