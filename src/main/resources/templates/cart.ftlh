<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<h1>Shopping Cart</h1>

<form action="/cart/add" method="post">
    <label for="productId">Product ID:</label>
    <input type="text" id="productId" name="productId" required>
    <button type="submit">Add to Cart</button>
</form>
</body>
<script>
        const form = document.getElementById('cartForm');
        const messageDiv = document.getElementById('message');

        form.addEventListener('submit', async (e) => {
            e.preventDefault();

            const productIdInput = document.getElementById('productId');
            const productId = productIdInput.value;

            const csrfToken = document.querySelector('meta[name="_csrf"]').content;
            const csrfHeader = document.querySelector('meta[name="_csrf_header"]').content;

            const headers = new Headers();
            headers.append('Content-Type', 'application/json');
            headers.append(csrfHeader, csrfToken);

            const body = JSON.stringify({ productId });

            const response = await fetch('/cart/add', {
                method: 'POST',
                headers,
                body,
            });

            if (response.ok) {
                // Display success message
                messageDiv.textContent = 'Product added to the cart!';
            } else {
                // Display error message
                messageDiv.textContent = 'Failed to add the product to the cart.';
            }

            // Clear the input field
            productIdInput.value = '';
        });
    </script>
</html>