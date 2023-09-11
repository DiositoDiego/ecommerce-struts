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

public class DaoRole {//
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    final String INSERT_ROLE = "INSERT INTO roles (name) VALUES (?)";
    final String GET_ALL_ROLES = "SELECT * FROM roles";
    final String GET_ROLE_BY_ID = "SELECT * FROM roles WHERE id_role = ?";
    final String UPDATE_ROLE = "UPDATE roles SET name = ? WHERE id_role = ?";

    public boolean createRole(BeanRole role){
        try {
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(INSERT_ROLE);
            ps.setString(1, role.getName());
            return ps.executeUpdate() > 0;
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
            ps = con.prepareStatement(GET_ROLE_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                BeanRole role = new BeanRole();
                role.setId_role(rs.getLong("id_role"));
                role.setName(rs.getString("name"));
                role.setStatus(rs.getBoolean("status"));
                return role;
            }
        }catch (SQLException e){
            Logger.getLogger(DaoRole.class.getName()).log(Level.SEVERE, null, "getRoleById -> " + e);
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
            }catch (SQLException e){
                Logger.getLogger(DaoRole.class.getName()).log(Level.SEVERE, null, "getRoleById:closingConnections -> " + e);
            }
        }
        return null;
    }

    public boolean updateRole(BeanRole role){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(UPDATE_ROLE);
            ps.setString(1, role.getName());
            ps.setLong(2, role.getId_role());
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoRole.class.getName()).log(Level.SEVERE, null, "updateRole -> " + e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                Logger.getLogger(DaoRole.class.getName()).log(Level.SEVERE, null, "updateRole:closingConnections -> " + e);
            }
        }
        return false;
    }
}
