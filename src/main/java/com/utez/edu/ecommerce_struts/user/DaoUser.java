package com.utez.edu.ecommerce_struts.user;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoUser {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    final String INSERT_USER = "INSERT INTO users (name, surname, lastname, curp, tuition, institutional_mail, password) VALUES (?,?,?,?,?,?,?)";
    final String GET_ALL_USERS = "SELECT * FROM users";
    final String GET_USER_BY_ID = "SELECT * FROM users WHERE id_user = ?";
    final String UPDATE_USER_BY_ID = "UPDATE users SET name = ?, surname = ?, lastname = ?, curp = ?, tuition = ?, institutional_mail = ?, password = ? WHERE id_user = ?";

    public boolean createUser(BeanUser user) {
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(INSERT_USER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getCurp());
            ps.setString(5, user.getTuition());
            ps.setString(6, user.getInstitutional_mail());
            ps.setString(7, user.getPassword());
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, "createUser -> " + e);
        } finally {//
            try {
                if(con != null){
                        con.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, "createUser:closingConnections -> " + e);;
            }
        }
        return false;
    }

    public List<BeanUser> getAllUsers() {
        List<BeanUser> users;
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_ALL_USERS);
            rs = ps.executeQuery();
            users = new LinkedList<>();
            while(rs.next()){
                BeanUser user = new BeanUser();
                buildUser(user);
                users.add(user);
            }
            return users;
        }catch(SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, "getAllUsers -> "+e);
        } finally {
            try {
                if(con != null){
                    con.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, "getAllUsers:closingConnections -> " + e);;
            }
        }
        return null;
    }

    public BeanUser getUserById(Long id) {
        BeanUser user = null;
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_USER_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new BeanUser();
                buildUser(user);
            }
            return user;
        }catch(SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, "getUserById -> "+e);
        } finally {
            try {
                if(con != null){
                    con.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, "getUserById:closingConnections -> " + e);;
            }
        }
        return null;
    }

    public boolean updateUser(BeanUser user){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(UPDATE_USER_BY_ID);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getLastname());
            ps.setString(4, user.getCurp());
            ps.setString(5, user.getTuition());
            ps.setString(6, user.getInstitutional_mail());
            ps.setString(7, user.getPassword());
            ps.setLong(8, user.getIdUser());
            return ps.executeUpdate() > 0;
        } catch(SQLException e) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, "updateUser -> "+e);
        } finally {
            try {
                if(con != null){
                    con.close();
                }
                if(ps != null){
                    ps.close();
                }
                if(rs != null){
                    rs.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, "updateUser:closingConnections -> " + e);;
            }
        }
        return false;
    }

    private void buildUser(BeanUser user) throws SQLException {
        user.setIdUser(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setLastname(rs.getString("lastname"));
        user.setCurp(rs.getString("curp"));
        user.setTuition(rs.getString("tuition"));
        user.setInstitutional_mail(rs.getString("institutional_mail"));
        user.setPassword(rs.getString("password"));
    }
}
