package controller;

import beans.ClassesBean;
import beans.Student;
import service.LoginService;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/validate_login")
public class ValidateLogin extends HttpServlet {
    LoginService loginService = new LoginService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.html");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ssn = request.getParameter("ssn");
        Student student = loginService.validateSsn(ssn);
        if(student == null){
            request.getSession().setAttribute("ssn",ssn);
            request.getRequestDispatcher("/loginError.jsp").forward(request, response);
        }else {
            loginService.getMyClasses(student.getSsn());
            request.getSession().setAttribute("enrolled", loginService.enrolledClasses);
            List<ClassesBean> allClasses = loginService.getAllClasses();
            request.getSession().setAttribute("allClasses",allClasses);
            request.getSession().setAttribute("student",student);
            request.getRequestDispatcher("/myRegist.jsp").forward(request, response);
        }
    }


}
