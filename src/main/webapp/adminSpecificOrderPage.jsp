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

        <p>Currently inspecting order: <% out.print(order.getId()); %></p>
        <p>Ordered by user_id: <% out.print(order.getOrderlines().get(0).getUserId()); %></p>
        <form class="mb-2" name="update_form" action="updateInvoice" method="get">
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
                        for (int i = 0; i < items.size(); i++)
                        {
                            out.println("<tr>");
                    %>
                <td style="width:1%;white-space: nowrap">
                    <input type="text" style="width:50px" value="<%out.println(items.get(i).getCupCake().getAmount());%>" name="<%out.print(i);%>">
                </td>
                <%
                        out.println("<td>" + items.get(i).getCupCake().getBottom().getFlavor() + "</td>");
                        out.println("<td>" + items.get(i).getCupCake().getTopping().getFlavor() + "</td>");
                        out.println("<td>" + items.get(i).getCupCake().getPrice() * items.get(i).getCupCake().getAmount() + "</td>");
                        out.println("</tr>");

                        price += (items.get(i).getCupCake().getPrice() * items.get(i).getCupCake().getAmount());

                    }
                %>

                </tbody>
            </table>
            <button type="submit" class="btn btn-primary mb-3" name="orderID" value="<%out.print(order.getId());%>" >Update</button>
        </form>

        <% out.println("<h4>Total price: " + price + "</h4>");%>

        <a href="adminOrder" class="btn btn-primary mb-3 mt-3">Go Back</a>
    </div>
</div>

<%@include file="footer.jsp" %>

