/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Farah
 */
public class SQLConnection {
    public static Connection conn = null;
    private Statement st = null;
    
    public SQLConnection(){
        
    }
    
    public Connection getSQLConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/";
        String dbname = "smartclassroom";
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url + dbname, "root","");
            System.out.println("Connection okay");
        }
        catch(Exception e){
            System.out.println(e);
            System.out.println("Connection is NOT okay");
        }
        return conn;
    }
}