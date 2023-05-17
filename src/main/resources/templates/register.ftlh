<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
</head>
<body>
<form action="/register" method="post">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    <label for="firstName">First Name</label><br>
    <input type="text" id="firstName" name="firstName" required><br><br>

    <label for="lastName">Last Name</label><br>
    <input type="text" id="lastName" name="lastName" required><br><br>

    <label for="email">Email</label><br>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Password</label><br>
    <input type="password" id="password" name="password" required><br><br>

    <label for="address">Address</label><br>
    <input type="text" id="address" name="address"><br><br>

    <label for="username">Username</label><br>
    <input type="text" id="username" name="username"><br><br>

    <input type="hidden" id="active" name="active" value="true">
    <input type="hidden" id="role" name="role" value="USER">

    <input type="submit" value="Register">
</form>

</body>
</html>