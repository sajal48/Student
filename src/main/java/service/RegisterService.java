package service;

import dbutils.MyDButil;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RegisterService {
    MyDButil dButil = new MyDButil();

    public boolean alreadyExist(String ssn, String courseID){
        String QUERY_FOR_CHECKING_ENROLLMENT ="SELECT * FROM Enrollment WHERE ssn = '"+ssn+"' AND courseId = '"+ courseID+"'";
        dButil.connectDB();
        try {
            ResultSet resultSet = dButil.getQuery(QUERY_FOR_CHECKING_ENROLLMENT);
            if(resultSet.next()){
                return true;
            }
        }
        catch (Exception e){
            System.out.println("error:" + e.getMessage());
        }
        return false;
    }
    public boolean registerCourse(String ssn, String courseId, String grade){
        System.out.println(ssn+courseId+grade);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);

        String QUERY_FOR_ENROLLMENT ="INSERT INTO Enrollment (ssn,courseId,grade,dateRegistered) VALUES('"+ssn+"','"+courseId+"','"+grade+"','"+ formattedDate+"')";
        dButil.connectDB();
        try {
            dButil.updateValues("Enrollment",QUERY_FOR_ENROLLMENT);
            return true;
        }
        catch (Exception e){
            System.out.println("error:" + e.getMessage());
        }
        return false;
    }

}
