<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 50px;
        }
        body {
            align-items: center;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        h1 {
            color: #333;
        }

        form {
            margin: 20px auto;
            max-width: 400px;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 5px #ccc;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #333;
            font-size: 18px;
            font-weight: bold;
        }

        input[type="text"] {
            padding: 10px;
            font-size: 18px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 20px;
            width: 100%;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            font-size: 18px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
<h1>Login</h1>
<form action="validate_login" method="POST">
    <label for="ssn">SSN:</label>
    <input type="text" id="ssn" name="ssn" required>
    <input type="submit" value="Login">
</form>
    </div>
</body>
</html>
