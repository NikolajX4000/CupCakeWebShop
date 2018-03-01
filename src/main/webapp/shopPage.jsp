<%-- 
    Document   : shop
    Created on : 27-02-2018, 14:07:11
    Author     : Hupra Laptop
--%>

<%@page import="DBConnection.DAO"%>
<%@page import="Data.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.CupCakePiece"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% User user = (User) session.getAttribute("user");
    ArrayList<CupCakePiece> toppings = (ArrayList) request.getAttribute("toppings");
    ArrayList<CupCakePiece> bottoms = (ArrayList) request.getAttribute("bottoms");
%>

<%@include file="header.jsp" %>

<div class="container">
    <div class="jumbotron">
        <div class="col-12">
            <p class="text-right">Balance: <% out.print(user.getBalance());%>$</p>
        </div>
        <h1 class="display-4">Hello <% out.print(user.getUsername());%>!</h1>
        <p class="lead">Add your own cakes to the cart and they will magically be ready instantly to pickup at our store!</p>
        <hr>
        <form class="mb-2" name="create_form" >
            <div class="input-group mb-3">
                <div class="col-12 col-md-7 mb-3">
                    <p>Add cupcakes to your cart!</p>
                    <div class="input-group-prepend mb-3">
                        <label class="input-group-text" for="bottoms">Bottom</label>
                        <select class="custom-select" id="bottoms" name="bottom">
                            <option selected>Choose...</option>
                            <% for (CupCakePiece cp : bottoms) { %>
                            <option value="<%out.print(cp.getId());%>"><%out.print(cp.getFlavor());%></option><%
                                    } %>
                        </select>
                    </div>
                    <div class="input-group-prepend mb-3">
                        <label class="input-group-text" for="toppings">Topping</label>
                        <select class="custom-select" id="toppings" name="topping">
                            <option selected>Choose...</option>
                            <% for (CupCakePiece cp : toppings) { %>
                            <option value="<%out.print(cp.getId());%>"><%out.print(cp.getFlavor());%></option><%
                                    }%>
                        </select>
                    </div>
                    <div class="input-group-prepend mb-3">
                        <label class="input-group-text" for="toppings">Amount</label>
                        <input class="form-control" type="number" min="1" max="100" name="amount">
                    </div>
                    <button type="submit" class="btn btn-primary mb-3" name="action" value="addToOrder" >Add to cart</button>
                </div>
                <div class="col-12 col-md-5">
                    <p>Shopping Cart</p>
                    <table class="table table-striped" style="background-color: white;">
                        <thead>
                            <tr>
                                <th scope="col">Bottom</th>
                                <th scope="col">Topping</th>
                                <th scope="col">Amount</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Vanilla</td>
                                <td>Chocolate</td>
                                <td>5</td>
                                <td>x</td>
                            </tr>
                            <tr>
                                <td>Onion</td>
                                <td>Salt</td>
                                <td>2</td>
                                <td>x</td>
                            </tr>
                            <tr>  
                                <td>Pizza</td>
                                <td>Burger</td>
                                <td>420</td>
                                <td>x</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </form>
    </div>
</div>
                        
    <%@include file="footer.jsp" %>