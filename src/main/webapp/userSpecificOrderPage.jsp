<%-- 
    Document   : userOrdersPage
    Created on : 01-03-2018, 11:20:51
    Author     : Hupra Laptop
--%>

<%@page import="Data.Order"%>
<%@page import="Data.Orderline"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Data.User"%>

<%@include file="header.jsp" %>


<%

User user = (User) session.getAttribute("user");
    
Order order = (Order) request.getAttribute("orderDetails");

ArrayList<Orderline> items = order.getOrderlines();

%>



<div class="container">

    <div class="jumbotron">


        <h1 class="display-4">Hello <% out.print(user.getUsername()); %>!</h1>

        <h3>Balance: <% out.print(user.getBalance()); %>$</h3>

        <hr>

        <p>Your Ordernumber: <% out.print(order.getId()); %></p>
        <table class="table table-striped" style="background-color: white;">
            <thead>
                <tr >
                <th scope="col">Amount</th>
                <th scope="col">Bottom</th>
                <th scope="col">Topping</th>
                <th scope="col">Price</th>
                </tr>
            </thead>
            <tbody>
                
                
                <%
                
                double price = 0;
                for(Orderline o : items){
                    out.println("<tr>");
                    out.println("<td>" + o.getCupCake().getAmount() + "</td>");
                    out.println("<td>" + o.getCupCake().getBottom().getFlavor() + "</td>");
                    out.println("<td>" + o.getCupCake().getTopping().getFlavor()+ "</td>");
                    out.println("<td>" + o.getCupCake().getPrice()*o.getCupCake().getAmount() + "</td>");
                    out.println("</tr>");
                    
                    price += (o.getCupCake().getPrice()*o.getCupCake().getAmount());
                    
                }
                %>
                
            </tbody>
        </table>
                
        <% out.println("<h4>Total price: " + price + "</h4>"); %>

        <a href="users" class="btn btn-primary mb-3 mt-3">Go Back</a>
    </div>
</div>

<%@include file="footer.jsp" %>
