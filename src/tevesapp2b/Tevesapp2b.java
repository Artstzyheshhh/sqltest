package tevesapp2b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Tevesapp2b {

    //Connection Method to SQLITE
public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:movieapp.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       connectDB();
        System.out.println("Enter first name: ");
        String fn = sc.next();
        System.out.println("Enter lsst name: ");
        String ln = sc.next();
        System.out.println("Enter email: ");
        String em = sc.next();
        System.out.println("Enter status");
        String st = sc.next();
        
        String sql = "INSERT INTO tbl_students (s_fname, s_lname, s_email, s_status) VALUES (?,?,?,?)";
        
        try{
        Connection con = connectDB();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,fn);
        pst.setString(2,ln);
        pst.setString(3,em);
        pst.setString(4,st);
        pst.executeUpdate();
            System.out.println("iNSERTED SUCCESSFUL");
            
        }catch(SQLException ex){
            System.out.println("CONNECTION ERROR"+ex.getMessage());
        }
    }
    
}
