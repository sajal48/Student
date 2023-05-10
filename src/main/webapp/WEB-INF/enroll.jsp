<%@ page import="java.util.List" %>
<%@ page import="beans.ClassesBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enroll Page</title>
    <style>
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 50px;
        }
        form{
            padding: 20px;
        }
        body {
            align-items: center;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        h1 {
            color: #333;
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
        .form-container {
            display: flex;
            flex-direction: row;
            align-items: center;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        select {
            padding: 10px;
            margin: 20px ;
            max-width: 400px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 5px #ccc;
        }
        option{
            padding: 10px;
            margin: 20px ;
        }

    </style>
</head>
<body>
<% List<ClassesBean>  classesBeanList = (List<ClassesBean>) request.getSession().getAttribute("allClasses");%>
<div class="container">
    <h1>Enrollment</h1>
    <div class="form-container">
    <form>
    <select id="course" name="course">
        <option value= "">Select a value</option>
        <% for ( ClassesBean classBean : classesBeanList){
            %>
        <option value= <%= classBean.getCourseID()%>> <%= classBean.getTitle()%></option>
        <%
        }
        %>
    </select>

    <select id="grade" name="grade">
        <option value="">Select a Value</option>
        <option value="A">A</option>
        <option value="B">B</option>
        <option value="C">C</option>
        <option value="D">D</option>
        <option value="E">E</option>
        <option value="F">F</option>
    </select>


            <input type="submit"  formaction="myRegist.jsp" formmethod="get" value="Exit">

            <input type="submit" value="Drop" formaction="">

            <input type="submit" value="Enroll" formaction="registerServlet" formmethod="post">


    </form>
</div>

</div>



</body>
</html>
