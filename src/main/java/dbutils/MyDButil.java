package dbutils;

import java.sql.*;

public class MyDButil {
    private static Connection connection;
    private ResultSet resultset;

    // Open Connection to database
    public boolean connectDB(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("JDBC Driver loaded. Connecting to database....");
            connection = DriverManager.getConnection("jdbc:sqlserver://s16988308.onlinehome-server.com:1433;database=CUNY_DB;integratedSecurity=false;trustServerCertificate=true;",
                    "cst4713","password1");
            System.out.println("Database Connected.");
            return true;
        }catch(ClassNotFoundException |SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    // Run Query to get result set
    public ResultSet getQuery(String query)  {

        try{
            //connectDB();
            Statement statement = connection.createStatement();
            resultset = statement.executeQuery(query);
        }catch(SQLException ex){
            ex.getMessage();
            ex.printStackTrace();
        }

        return resultset;
    }



    // Insert values into database
    public void updateValues(String table, String query)throws SQLException, ClassNotFoundException {

        try{
            //connectDB();
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch(SQLException ex){
            ex.getMessage();
            ex.printStackTrace();
        }

    }

    // Closes database connection
    public void closeConn() throws SQLException{

        connection.close();
    }
}
