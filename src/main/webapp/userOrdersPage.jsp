<%-- 
    Document   : userOrdersPage
    Created on : 01-03-2018, 11:20:51
    Author     : Hupra Laptop
--%>

<%@page import="Data.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Data.User"%>

<%@include file="header.jsp" %>


<%
     
ArrayList<Order> orders = (ArrayList<Order>)request.getAttribute("usersOrders");

%>

<div class="container">

    <div class="jumbotron">


        <h1 class="display-4">Hello Daniel!</h1>

        <h3>Balance: 45$</h3>

        <p class="lead">Below you can see all your orders. Click on them to get the invoice of that order!</p>

        <hr>

        <p>Your Orders</p>
        <table class="table table-striped" style="background-color: white;">
            <thead>
                <tr >
                <th scope="col">Order Number</th>
                <th scope="col">Date</th>
                </tr>
            </thead>
            <tbody>
                
                
                <%
                
                for(Order o : orders){
                    out.println("<tr class='clickable-row' data-href='?id=" + o.getId() + "'>");
                    out.println("<td>" + o.getId() + "</td>");
                    out.println("<td>" + o.getDateTime() + "</td>");
                    out.println("</tr>");
                    
                }
                
                %>
            </tbody>
        </table>
    </div>
</div>

<%@include file="footer.jsp" %>
