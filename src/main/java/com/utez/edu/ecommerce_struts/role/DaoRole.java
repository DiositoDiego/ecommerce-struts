package com.utez.edu.ecommerce_struts.role;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoRole {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    final String INSERT_ROLE = "INSERT INTO roles (name) VALUES (?)";
    final String GET_ALL_ROLES = "SELECT * FROM roles";
    final String GET_ROLE_BY_ID = "SELECT * FROM roles WHERE id = ?";

    public boolean createRole(BeanRole role){
        try {
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(INSERT_ROLE);
            ps.setString(1, role.getName());
            rs = ps.executeQuery();
            return rs.next();
        }catch (SQLException e){
            Logger.getLogger(DaoRole.class.getName()).log(Level.SEVERE, null, "createRole -> " + e);
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
                Logger.getLogger(DaoRole.class.getName()).log(Level.SEVERE, null, "createRole:closingConnections -> " + e);;
            }
        }
        return false;
    }

    public List<BeanRole> getAllRoles(){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_ALL_ROLES);
            rs = ps.executeQuery();
            List<BeanRole> roles = new LinkedList<>();
            while(rs.next()){
                BeanRole role = new BeanRole();
                role.setId_role(rs.getLong("id_role"));
                role.setName(rs.getString("name"));
                role.setStatus(rs.getBoolean("status"));
                roles.add(role);
            }
            return roles;
        }catch (SQLException e){
            Logger.getLogger(DaoRole.class.getName()).log(Level.SEVERE, null, "getAllRoles -> " + e);
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
                Logger.getLogger(DaoRole.class.getName()).log(Level.SEVERE, null, "getAllRoles:closingConnections -> " + e);;
            }
        }
        return null;
    }

    public BeanRole getRoleById(Long id){
        try{
            con = MySQLConnection.getConnection();
        }catch (SQLException e){

        }
        return null;
    }
}
