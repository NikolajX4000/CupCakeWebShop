<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<style type="text/css">
    
    @import url('https://fonts.googleapis.com/css?family=Raleway');

    .dContainer{
        font-family: 'Raleway', sans-serif;
    }

    .dForm{
        background-color: #636363;
        color: white;
        padding: 20px;
        border-radius: 3px;
        display: inline-block;
        box-shadow: inset 0px 0px 5px 0px black;
    }

    .dP{

        font-size: 16px;
        margin-bottom: 0;
    }
    .dInput{
        padding: 5px 10px;
        border: 1px solid orange;
        border-radius: 3px;
        width: 100%;
        min-width: 300px;
        max-width: 400px;
        margin-bottom: 15px;
    }
    .dInput:focus{  
        outline-color: green;
    }

    .dBtn{
        padding: 10px 10px;
        background-color: lightgreen;
        border-radius: 10px;
        border: 1px solid black;
        cursor: pointer;
    }
    .dErr{
        color: red;
        padding: 10px;
    }
</style>




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
