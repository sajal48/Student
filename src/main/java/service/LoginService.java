package service;

import beans.ClassesBean;
import beans.EnrollBean;
import beans.Student;
import dbutils.MyDButil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoginService {
    MyDButil myDButil = new MyDButil();
    public List<EnrollBean> enrolledClasses = new ArrayList<>();


    public Student validateSsn(String ssn){
        myDButil.connectDB();
        String QUERY_FOR_SSN = "SELECT * FROM STUDENTS WHERE ssn=";
        ResultSet resultSet=  myDButil.getQuery(QUERY_FOR_SSN +ssn);
        try {
            resultSet.next();
            String fname =resultSet.getString("firstName");
            String mname =resultSet.getString("mi");
            String lname = resultSet.getString("lastName");
            Date dob =resultSet.getDate("birthDate");
            String address =resultSet.getString("street");
            String phone = resultSet.getString("phone");
            String zip =resultSet.getString("zipcode");
            String deptId =resultSet.getString("deptId");
            myDButil.closeConn();
            System.out.println("ssn found on database");
            return   new Student(ssn, fname, mname, lname, dob.toString(), address, phone, zip, deptId);

        }catch (Exception e){
            System.out.println("error :" + e.getMessage());
            return null;
        }

    }


    public  List<ClassesBean> getAllClasses(){
        myDButil.connectDB();
        String QUERY_FOR_All_CLASSES = "SELECT * FROM COURSE ";
        ResultSet resultSet =myDButil.getQuery(QUERY_FOR_All_CLASSES );
        List<ClassesBean> classesBeanList = new ArrayList<>();
        try {
            while (resultSet.next()){
                String courseId = resultSet.getString("courseID");
                String title = resultSet.getString("title");
                classesBeanList.add(new ClassesBean(courseId,title));
            }
            myDButil.closeConn();
        }
        catch (Exception e){
            System.out.println("error: "+ e.getMessage());
        }
        return classesBeanList;

    }
    public void getMyClasses(String ssn){
        myDButil.connectDB();
        String QUERY_FOR_MY_CLASSES = "SELECT * FROM ENROLLMENT WHERE ssn=";
        ResultSet resultSet =myDButil.getQuery(QUERY_FOR_MY_CLASSES +ssn);
//        final private String courseID, title, grade;
        try {
            while (resultSet.next()){
                String courseID = resultSet.getString("courseId");
                ClassesBean classesBean = getClassDetails(courseID);
                String grade = resultSet.getString("grade");
                EnrollBean enrollBean = new EnrollBean(courseID,classesBean.getTitle(),grade);
                enrolledClasses.add(enrollBean);
            }
            myDButil.closeConn();

        }catch (Exception e){
            System.out.println("error :" + e.getMessage());
        }
    }
    public ClassesBean getClassDetails(String courseID){
        String QUERY_FOR_CLASS_DETAILS = "SELECT * FROM Course";
        ResultSet r = myDButil.getQuery(QUERY_FOR_CLASS_DETAILS);
        try {
            while (r.next()){
                String id = r.getString("courseID");
                String title = r.getString("title");
                if(id.equals(courseID)){
                    return  new ClassesBean(courseID,title);
                }
            }

        }
        catch (Exception e){
            System.out.println("error :" + e.getMessage());

        }

        return null;
    }



}
