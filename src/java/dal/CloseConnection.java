/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ThangCoi
 */
public class CloseConnection {
    public void closeConnection(Connection conn, ResultSet rs, PreparedStatement st){
        try{
            if(rs != null && !rs.isClosed()){
                rs.close();
            }
            if(st != null && st.isClosed()){
                st.close();
            }
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        }catch(Exception e){
        }
    }
}
