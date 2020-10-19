/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import dbContext.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Info;

/**
 *
 * @author ThangCoi
 */
public class InfoDAO {
    DBContext db = new DBContext();
    CloseConnection close = new CloseConnection();
    Connection conn;
    public Info getInfo() throws Exception{
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = db.getConnection();
            String sql = "select * from Info";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()){
                Info info = new Info();
                info.setId(rs.getInt("id"));
                info.setName(rs.getString("name"));
                info.setImage(db.getImagePath() + rs.getString("image"));
                info.setAge(rs.getInt("age"));
                info.setDescription(rs.getString("description"));
                return info;
            }
        }catch(Exception e){
            throw e;
        }finally{
            close.closeConnection(conn, rs, st);
        }
        return null;
    }
}
