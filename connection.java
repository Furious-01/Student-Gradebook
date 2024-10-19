import java.sql.*;
public class connection {
    Connection connection;
    Statement statement;
    public connection(){
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gradeBook", "root", "9838888558");
            statement = connection.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new connection();
    }
}