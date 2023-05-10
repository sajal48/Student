package controller;

import beans.ClassesBean;
import beans.Student;
import service.LoginService;
import service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/registerServlet")
public class RegisterServlet  extends HttpServlet {
    RegisterService registerService = new RegisterService();
    LoginService loginService = new LoginService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = (Student) req.getSession().getAttribute("student");
        String courseId = (String) req.getParameter("course");
        String grade = (String) req.getParameter("grade");
        boolean result =registerService.alreadyExist(student.getSsn(),courseId);
        if(result){
            req.getRequestDispatcher("/enrollRegisterError.jsp").forward(req, resp);
        }else{
            registerService.registerCourse(student.getSsn(),courseId,grade);
            loginService.getMyClasses(student.getSsn());
            req.getSession().setAttribute("enrolled", loginService.enrolledClasses);
            req.getRequestDispatcher("/myRegist.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get called");
    }
}
