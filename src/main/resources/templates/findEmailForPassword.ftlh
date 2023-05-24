<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ForgotPassword</title>
</head>
<body>
<h2>Forgot Password</h2>
<form action="/user/forgotPassword" method="post">
    <label for="email">Email:</label>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="email" id="email" name="email" required>
    <br><br>
    <input type="submit" value="Generate Token">
</form>
<hr>

</body>
</html>