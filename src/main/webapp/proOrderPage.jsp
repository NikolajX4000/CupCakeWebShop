
<%@page import="Data.Orderline"%>
<%@page import="Data.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Data.User"%>

<%@include file="header.jsp" %>


<%
User user = (User) session.getAttribute("user");
ArrayList<Order> orders = (ArrayList<Order>)request.getAttribute("usersOrders");
    
Order order = (Order) request.getAttribute("orderDetails");

ArrayList<Orderline> items = order.getOrderlines();

%>




<div class="container" style="display: flex;flex-wrap: wrap; margin-top: 20px; background: whitesmoke;">


        <div class="col-6">
            
        

        <h1 class="display-4">Hello <% out.print(user.getUsername()); %>!</h1>

        <h3>Balance: <% out.print(user.getBalance()); %>$</h3>

        <hr>

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
            
        <div class='col-6'>
        
            
            <h2>Current order</h2>

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
        </div>
    
</div>

<%@include file="footer.jsp" %>