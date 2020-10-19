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
import java.util.ArrayList;
import model.Article;

/**
 *
 * @author ThangCoi
 */
public class ArticleDAO {

    DBContext db = new DBContext();
    CloseConnection close = new CloseConnection();
    Connection conn;

    public ArrayList<Article> getTop4Article() throws Exception {
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Article> list = new ArrayList<>();
        try {
            conn = db.getConnection();
            String sql = "Select top 4 * from Article order by [date] desc";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setImage(db.getImagePath() + rs.getString("image"));
                a.setTitle(rs.getString("title"));
                a.setType(rs.getString("type"));
                a.setContent(rs.getString("content"));
                a.setDate(rs.getDate("date"));
                a.setLike(rs.getInt("like"));
                a.setComment(rs.getInt("comment"));
                a.setIcon(db.getImagePath() + rs.getString("icon"));
                list.add(a);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close.closeConnection(conn, rs, st);
        }
        return list;
    }

    public Article getDetail(int id) throws Exception {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            String sql = "Select * from Article where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setImage(db.getImagePath() + rs.getString("image"));
                a.setTitle(rs.getString("title"));
                a.setType(rs.getString("type"));
                a.setContent(rs.getString("content"));
                a.setDate(rs.getDate("date"));
                a.setLike(rs.getInt("like"));
                a.setComment(rs.getInt("comment"));
                a.setIcon(db.getImagePath() + rs.getString("icon"));
                return a;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close.closeConnection(conn, rs, st);
        }
        return null;
    }

    public ArrayList<Article> pagging(int pageIndex, int pageSize, int month, int year) throws Exception {
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Article> list = new ArrayList<>();
        try {
            conn = db.getConnection();
            String sql = "with r as (\n"
                    + "select *, row_number() over(order by date) as rn\n"
                    + "from Article Where MONTH([date]) = ? AND YEAR([date]) = ?\n"
                    + ")\n"
                    + "select * from r where rn between ? and ?";

            st = conn.prepareStatement(sql);
            int beginIndex = (pageIndex * pageSize) - (pageSize - 1);
            int endIndex = pageIndex * pageSize;
            st.setInt(1, month);
            st.setInt(2, year);
            st.setInt(3, beginIndex);
            st.setInt(4, endIndex);

            rs = st.executeQuery();

            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setImage(db.getImagePath() + rs.getString("image"));
                a.setTitle(rs.getString("title"));
                a.setType(rs.getString("type"));
                a.setContent(rs.getString("content"));
                a.setDate(rs.getDate("date"));
                a.setLike(rs.getInt("like"));
                a.setComment(rs.getInt("comment"));
                a.setIcon(db.getImagePath() + rs.getString("icon"));
                list.add(a);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close.closeConnection(conn, rs, st);
        }
        return list;
    }

    public int getTotalCount(int month, int year) throws Exception {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = db.getConnection();
            String sql = "Select count(id) as [tc] from Article Where MONTH([date]) = ? AND YEAR([date]) = ?";
            st = conn.prepareStatement(sql);
            st.setInt(1, month);
            st.setInt(2, year);
            rs = st.executeQuery();
            while (rs.next()) {
                int count = rs.getInt("tc");
                return count;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close.closeConnection(conn, rs, st);
        }
        return 0;
    }

    public ArrayList<Article> getListDate() throws Exception {
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Article> listDate = new ArrayList<>();
        try {
            conn = db.getConnection();
            String sql = "Select DISTINCT FORMAT(date, 'MM yyyy') As monthAndYear From Article Order By [monthAndYear]";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Article a = new Article();
                a.setMonthAndYear(rs.getString("monthAndYear"));
                listDate.add(a);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close.closeConnection(conn, rs, st);
        }
        return listDate;

    }
}
