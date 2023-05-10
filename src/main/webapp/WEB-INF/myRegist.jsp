<%@ page import="java.util.List" %>
<%@ page import="beans.EnrollBean" %>
<%@ page import="beans.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Results</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 50px;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            border: 1px solid #ccc;
        }

        th, td {
            text-align: left;
            padding: 8px;
            border: 1px solid #ccc;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }



        body {
            font-family: Arial, sans-serif;
            background-color: #fff;
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


        .enroll-form {
            margin-top: 10px;
            float: left;
            max-width: 400px;
            padding: 0px;
            background-color: #fff;
        }
        .form-container {
            max-width: 1000px;
        }

        .exit-form {
            margin-top: 10px;
            float: right;
            max-width: 400px;
            padding: 0px;
            background-color: #fff;
        }

    </style>
</head>
<body>
<h2>Student  Information</h2>
<div class="container">
<table>
    <tr>
        <th>Student full Name</th>
        <th>DOB</th>
        <th>Address</th>
        <th>Phone</th>
    </tr>
    <% Student student = (Student) request.getSession().getAttribute("student") ; %>
    <tr>
        <td><%= student.getFname()+" "+student.getLname() %></td>
        <td><%= student.getDob() %></td>
        <td><%=student.getAddress()+","+student.getZip() %></td>
        <td><%=student.getPhone() %></td>
    </tr>
</table>

<table>
    <tr>
        <th>Course ID</th>
        <th>Title</th>
        <th>Credit</th>
    </tr>
    <% for (EnrollBean enrollBean : (List<EnrollBean>)request.getSession().getAttribute("enrolled")) { %>
    <tr>
        <td><%= enrollBean.getCourseID() %></td>
        <td><%= enrollBean.getTitle() %></td>
        <td><%= enrollBean.getGrade() %></td>
    </tr>
    <% } %>
</table>
<div class="form-container">

    <form class="enroll-form" >
        <input type="submit" formmethod="GET" formaction="enroll.jsp" value="Enroll"></input>
        <input src="" type="submit" formmethod="POST" formaction="registLogin.jsp" value="Exit"></input>
    </form>


</div>
</div>
</body>
</html>
