<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
</head>
<body>
< <h2>Enter the Realm of Registration</h2>
<form action="/register" method="POST">
    <label for="firstName">First Name (or secret codename):</label><br>
    <input type="text" id="firstName" name="firstName" required><br><br>

    <label for="lastName">Last Name (or nom de guerre):</label><br>
    <input type="text" id="lastName" name="lastName" required><br><br>

    <label for="email">Email (your digital pigeon's address):</label><br>
    <input type="email" id="email" name="email" required><br><br>

    <label for="password">Password (the key to your secret vault):</label><br>
    <input type="password" id="password" name="password" required><br><br>

    <label for="address">Address (optional, we promise not to stalk you):</label><br>
    <input type="text" id="address" name="address"><br><br>

    <label for="username">Username (your virtual alter ego):</label><br>
    <input type="text" id="username" name="username"><br><br>

    <input type="submit" value="Register (and join the League of Extraordinary Individuals)">
</form>
</form>
</body>
</html>