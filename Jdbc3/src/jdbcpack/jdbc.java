package jdbcpack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class jdbc {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection
                ("jdbc:mysql://localhost/YOUR DATABASE","YOUR USER NAME","YOUR PASSWORD");
        PreparedStatement ps=con.prepareStatement("select * from users where userid=?");
        while(true) {
            Scanner scan=new Scanner(System.in);
            System.out.println("Please Enter Userid..:");
            int uid=scan.nextInt();
            ps.setInt(1, uid);
            ResultSet rs= ps.executeQuery();
            if(rs.next()) {
                System.out.println("The User Name is :"+rs.getString(2));
            }
            else {
                System.out.println("No User with that ID is Available");
            }
        }
    }
}