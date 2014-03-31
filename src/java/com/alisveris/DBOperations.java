/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alisveris;

import com.alisveris.pojo.Brand;
import com.alisveris.pojo.Product;
import com.alisveris.pojo.User;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author User
 */
public class DBOperations {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void connected() {
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alisveris?zeroDateTimeBehavior=convertToNull", "root", "admin");
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void close() {
        try {
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Product> productList() {
        try {
            List<Product> list = new ArrayList<Product>();
            connected();
            String sql = "select * from products where status=0 order by id desc limit 6";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setTitle(rs.getString(2));
                p.setShort_article(rs.getString(3));
                p.setArticle(rs.getString(4));
                p.setPrice(rs.getDouble(5));
                p.setRaiting(rs.getInt(6));
                p.setImage(rs.getString(7));
                p.setStatus(rs.getString(8));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            close();
        }

    }

    public List<Product> productListNextPrevious(int param) {
        try {
            List<Product> list = new ArrayList<Product>();
            connected();
            String sql = "select * from products where  status=0 order by id desc limit " + param + "";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setTitle(rs.getString(2));
                p.setShort_article(rs.getString(3));
                p.setArticle(rs.getString(4));
                p.setPrice(rs.getDouble(5));
                p.setRaiting(rs.getInt(6));
                p.setImage(rs.getString(7));
                p.setStatus(rs.getString(8));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            close();
        }

    }

    public List<Product> productListByPriceDesc(String param2, int param1) {

        String sql = "";
        try {
            List<Product> list = new ArrayList<Product>();
            connected();
            if (param2.equals("Price")) {

                sql = "select * from products where status=0 ORDER BY " + param2 + " limit " + param1 + "";
            } else if (param2.equals("price") || param2.equals("raiting") || param2.equals("insert_date")) {
                sql = "select * from products where status=0 ORDER BY " + param2 + " DESC limit " + param1 + "";
            }

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setTitle(rs.getString(2));
                p.setShort_article(rs.getString(3));
                p.setArticle(rs.getString(4));
                p.setPrice(rs.getDouble(5));
                p.setRaiting(rs.getInt(6));
                p.setImage(rs.getString(7));
                p.setStatus(rs.getString(8));
                p.setInsert_date(rs.getString(9));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            close();
        }

    }

    public List<Brand> brandList() {
        try {
            List<Brand> listBrand = new ArrayList<Brand>();
            connected();
            String sql = "select * from brands where brand_status=0";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Brand b = new Brand();
                b.setBrand_id(rs.getInt("brand_id"));
                b.setBrand_name(rs.getString("brand_name"));
                b.setBrand_image(rs.getString("brand_image"));
                b.setBrand_status(rs.getString("brand_status"));
                b.setBrand_link(rs.getString("brand_link"));
                b.setInsert_date(rs.getString("insert_date"));
                listBrand.add(b);
            }
            return listBrand;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            close();
        }

    }

    public void insertUser(User p) {
        try {
            connected();
            String sql = "insert into users values(0,'" + p.getF_name() + "', '" + p.getL_name() + "', '" + p.getM_name() + "', '" + p.getPassword() + "', '" + p.getTel() + "', '" + p.getEmail() + "', '" + p.getCompany() + "', '" + p.getFirst_address() + "', '" + p.getSecond_address() + "', '" + p.getCity() + "', 'AZ" + p.getPost_code() + "', '" + p.getRegion() + "','0','" + generateCode() + "' )";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
    }

    public String generateCode() {
        try {
            String val = "";
            String sql = "SELECT SUBSTRING(MD5(RAND()) FROM 1 FOR 10) AS password";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {

                val = rs.getString(1);
            }
            return val;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public boolean checkEmail(String email) {
        try {
            connected();
            boolean val = false;
            String sql = "SELECT email from users where email='" + email + "'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {

                val = true;
            }
            return val;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String searchUserCode(String email) {
        try {
            String userCode = "";
            String sql = "select user_code from users where email=?";
            connected();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                userCode = rs.getString(1);
            }
            return userCode;
        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            close();
        }
    }

    public void activateUser(String userCode) {
        try {
            connected();
            String checksql = "select user_code from users where user_code=?";
            ps = conn.prepareStatement(checksql);
            ps.setString(1, userCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                String sql = "Update users set active=1 where user_code=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, userCode);
                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBOperations.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }

    }

    public static void main(String[] args) {
        DBOperations db = new DBOperations();

    }
}
