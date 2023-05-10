<!DOCTYPE html>
<html>
<head>
    <title>Login Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        h1 {
            color: #333;
        }

        p {
            color: #f00;
            font-size: 18px;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Login Error</h1>
<p><%= request.getSession().getAttribute("ssn") %> doesn't exist in our database.</p>
<a href="registLogin.jsp">Back to Login</a>
</body>
</html>
