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
User user = (User) session.getAttribute("user");
ArrayList<Order> orders = (ArrayList<Order>)request.getAttribute("allOrders");

%>




<div class="container">

    <div class="jumbotron">

        <a href="createPiece">create new topping/bottom</a>

        <h1 class="display-4">Hello <% out.print(user.getUsername()); %>!</h1>

        <h3>Balance: <% out.print(user.getBalance()); %>$</h3>

        <hr>

        <p class="lead">Below you can see all orders. Click on them to get the invoice of that order!</p>

        <hr>

        <p>Your Orders</p>
        <table class="table table-striped" style="background-color: white;">
            <thead>
                <tr >
                <th scope="col">Order Number</th>
                <th scope="col">Customer ID</th>
                <th scope="col">Date</th>
                </tr>
            </thead>
            <tbody>
                
                
                <%
                
                for(Order o : orders){
                    
                    out.println("<tr class='clickable-row' data-href='?id=" + o.getId() + "'>");
                    out.println("<td>" + o.getId() + "</td>");
                    
                    
                    out.println("<td>");
                    if(!o.getOrder().isEmpty()){
                        
                        out.println(o.getOrder().get(0).getUserId());
                        
                    }
                    out.println("</td>");
                    out.println("<td>" + o.getDateTime() + "</td>");
                    
                    out.println("</tr>");
                    
                }
                
                %>
            </tbody>
        </table>
    </div>
</div>

<%@include file="footer.jsp" %>