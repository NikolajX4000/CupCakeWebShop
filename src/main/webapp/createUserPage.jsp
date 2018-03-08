<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>



    <div class="container dContainer">


        <h1 class="dH1">Welcome to cupcakes - now with custom CSS</h1>

        <h2 class="dH2">It's time to create a user and start ordering some CuPcAkEs</h2>


        <form class="dForm" name="create_form" method="post">
            <p class="dP">Awesome username</p>
            <input name="username" type="text" class="dInput" placeholder="Username" value="${un}">

            <p class="dP">Make a cute password</p>
            <input name="password" type="password" class="dInput" placeholder="Password" value="${pw}">

            <p class="dP">Repeat password</p>
            <input name="password2" type="password" class="dInput" placeholder="Password" value="${pw2}">

            <div>
                <button type="submit" class="dBtn" name="action" value="register">Sign up</button>
            </div>
            
        </form>

        <div class="dErr">${err}</div>

    </div>
<%@include file="footer.jsp" %>
