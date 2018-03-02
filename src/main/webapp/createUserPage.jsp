<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Welcome to Cupcakes!</h1>
        <p class="lead">Create a user to start ordering cupcakes today!</p>
        <form class="mb-2" name="create_form" method="post">
            <div class="form-row mb-2">
                <div class="col-12 col-md-6 col-lg-4">
                    <p>Username</p>
                    <input name="username" type="text" class="form-control" placeholder="Username">
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <p>Password</p>
                    <input name="password" type="password" class="form-control" placeholder="Password">
                </div>
                <div class="col-12 col-md-6 col-lg-4">
                    <p>Repeat Password</p>
                    <input name="password2" type="password" class="form-control" placeholder="Password">
                </div>
            </div>
            <button type="submit" class="btn btn-primary" name="action" value="register">Sign up</button>

        </form>
        <a class="" href="welcome" role="button">Already have an account? click here to log in.</a>
    </div>
</div>
<%@include file="footer.jsp" %>