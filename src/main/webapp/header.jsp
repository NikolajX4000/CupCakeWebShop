<%-- 
    Document   : header
    Created on : 27-02-2018, 16:28:03
    Author     : super
--%>

<%@page import="java.net.URL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    String a = (String)session.getAttribute("curPage");

    String b = " active";
%>



<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css'>
        <style>
            body {
                font-family: 'Oswald', sans-serif !important;
            }
        </style>
        <title>Cupcakes</title>
    </head>
    <body>


        <div class="navbar navbar-dark navbar-expand-sm" style="background-color:chocolate">
            <div class="container">
                <a href="welcome" class="navbar-brand">Cupcakes</a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMenu">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a href="welcome" class="nav-link<% if(a.equals("welcome"))out.print(b);%>">Home</a>
                        </li>
                        <li class="nav-item">
                            <a href="users" class="nav-link<% if(a.equals("users"))out.print(b);%>">My Orders</a>
                        </li>
                        <li class="nav-item">
                            <a href="adminOrder" class="nav-link<% if(a.equals("adminOrder"))out.print(b);%>">Admin</a>
                        </li>
                        <li class="nav-item">
                            <a href="logout.jsp" class="nav-link<% if(a.equals("logout"))out.print(b);%>">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
</html>
