<%-- 
    Document   : userOrdersPage
    Created on : 01-03-2018, 11:20:51
    Author     : Hupra Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="Data.User"%>

<%@include file="header.jsp" %>


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
                <tr class="clickable-row" data-href='?o=1'>
                <td>420</td>
                <td>25 Febuaray, 16:42</td>
                </tr>
                <tr class="clickable-row" data-href='?o=2'>
                <td>420</td>
                <td>25 Febuaray, 16:42</td>
                </tr>
                <tr class="clickable-row" data-href='?o=3'>
                <td>420</td>
                <td>25 Febuaray, 16:42</td>
                </tr>
                <tr class="clickable-row" data-href='?o=4'>
                <td>420</td>
                <td>25 Febuaray, 16:42</td>
                </tr>
                <tr class="clickable-row" data-href='?o=5'>
                <td>420</td>
                <td>25 Febuaray, 16:42</td>
                </tr>
                <tr class="clickable-row" data-href='?o=6'>
                <td>420</td>
                <td>25 Febuaray, 16:42</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

<%@include file="footer.jsp" %>
