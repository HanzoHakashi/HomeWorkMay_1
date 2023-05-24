<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>FeedBack</title>
</head>
<body>
<h1>Submit Feedback</h1>

<form method="post" action="/product/feedback/${productId}">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />

    <input type="hidden" name="productId" value="${productId}" />

    <label for="comment">Comment:</label><br>
    <textarea name="comment" id="comment" rows="4" cols="50"></textarea><br>

    <input type="submit" value="Submit Feedback" />
</form>
</body>
</html>