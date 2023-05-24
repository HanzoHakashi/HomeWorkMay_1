<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Reset Page</title>
</head>
<body>
<h2>Forgot Password</h2>
<title>Reset Your Password</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h2>${title}</h2>
<form action="/reset_password" method="post">
    <div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <label for="token">Token:</label>
        <input type="text" id="token" name="token" required />
    </div>
    <div>
        <label for="password">New Password:</label>
        <input type="password" id="password" name="password" required />
    </div>
    <div>
        <input type="submit" value="Change Password" />
    </div>
</form>
<p>${message}</p>
</body>
</html>