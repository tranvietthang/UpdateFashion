/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ThangCoi
 */
public class DBContext {

    public Connection getConnection() throws Exception {
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             InitialContext environment = new javax.naming.InitialContext();  
             Context context = (Context) environment.lookup("java:comp/env");
             String myConnection = (String) context.lookup("myConnection");
             String user = (String) context.lookup("username");
             String password = (String) context.lookup("password");
             return DriverManager.getConnection(myConnection,user,password);
        } catch (ClassNotFoundException | SQLException | NamingException e) {
            throw e;
        }
    }
    
    public String getImagePath() throws Exception{
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            InitialContext environment = new InitialContext();
            Context context = (Context) environment.lookup("java:comp/env");
            String imagepath = (String) context.lookup("imagePath");
            return imagepath;
        }catch(ClassNotFoundException | NamingException e){
            throw e;
        }
    }
}
