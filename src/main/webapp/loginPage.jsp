<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-4">Welcome to Cupcakes!</h1>
        <p class="lead">The best cupcake webshop in the world.</p>
        <hr class="my-4">
        <p>Login below to start ordering some delicious cupcakes.</p>

        <form class="mb-2" name="login_form" action="loginRegi" method="post">
                <div class="form-row mb-2">
                    <div class="col-12 col-md-6 col-lg-4">
                        <input type="text" class="form-control" placeholder="Username" name="username">
                    </div>
                    <div class="col-12 col-md-6 col-lg-4">
                        <input type="password" class="form-control" placeholder="Password" name="password">
                    </div>
                </div>
            <button type="submit" class="btn btn-primary" name="action" value="login">Sign in</button>
            </form>
            <a class="" href="createUserPage.jsp" role="button">No account? click here to register.</a>
            
    </div>
</div>