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

%>




<div class="container">

    <div class="jumbotron">

        <h1 class="display-4">Hello <% out.print(user.getUsername()); %>!</h1>

        <hr>

        <p class="lead">Create new CupCake piece</p>

        <hr>

            <form class="mb-2" name="create_cupcake_piece" method="post">
                <div class="form-row mb-2">
                    <div class="col-12 col-md-7 col-lg-4">
                        <input type="text" class="form-control" placeholder="Name..." required name="name">
                    </div>
                    <div class="col-12 col-md-7 col-lg-4">
                        <input class="form-control" type="number" min="1" max="100" name="price" required placeholder="Price...">
                    </div>

                    
                    <div class="col-12 col-md-7 col-lg-4">
                        
                        
                        <select class="custom-select" id="type" name="type" placeholder="Type">
                            
                            <option value="bottom">Bottom</option>
                            <option value="topping">Topping</option>
                           
                        </select>
                        
                    </div>
                </div>
            <button type="submit" class="btn btn-primary" name="action" value="newPiece">Create</button>
            </form>
        
    </div>
</div>

<%@include file="footer.jsp" %>