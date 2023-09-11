package com.utez.edu.ecommerce_struts.permission;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPermission {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    final String INSERT_PERMISSION = "INSERT INTO permissions (title) VALUES (?)";
    final String GET_ALL_PERMISSIONS = "SELECT * FROM permissions";
    final String GET_PERMISSION_BY_ID = "SELECT * FROM permissions WHERE id_permission = ?";
    final String UPDATE_PERMISSION = "UPDATE permissions SET title = ? WHERE id_permission = ?";
    final String SET_PERMISSION_TO_ROLE = "INSERT INTO roles_has_permissions (fk_id_role, fk_id_permission) VALUES (?,?)";
    final String GET_PERMISSIONS_BY_ROLE = "SELECT permissions.* FROM permissions JOIN roles_has_permissions ON permissions.id_permission = roles_has_permissions.fk_id_permission WHERE fk_id_role = ?";
    final String DELETE_PERMISSION_FROM_ROLE = "DELETE FROM roles_has_permissions WHERE fk_id_role = ? AND fk_id_permission = ?";
    final String IS_PERMISSION_IN_ROLE = "SELECT * FROM roles_has_permissions WHERE fk_id_role = ? AND fk_id_permission = ?";

    public boolean createPermission(BeanPermission permission){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(INSERT_PERMISSION);
            ps.setString(1, permission.getTitle());
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "createPermission -> " + e);
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "createPermission:closingConnections -> " + e);
            }
        }
        return false;
    }

    public List<BeanPermission> getAllPermissions(){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_ALL_PERMISSIONS);
            List<BeanPermission> permissions = new LinkedList<>();
            while(rs.next()){
                BeanPermission permission = new BeanPermission();
                permission.setId_permission(rs.getLong("id_permission"));
                permission.setTitle(rs.getString("title"));
                permissions.add(permission);
            }
            return permissions;
        }catch (SQLException e){
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "getAllPermissions -> " + e);
        }finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "getAllPermissions:closingConnections -> " + e);
            }
        }
        return null;
    }

    public BeanPermission getPermissionById(Long id){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_PERMISSION_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                BeanPermission permission = new BeanPermission();
                permission.setId_permission(rs.getLong("id_permission"));
                permission.setTitle(rs.getString("title"));
                return permission;
            }
        }catch (SQLException e) {
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "getPermissionById -> " + e);
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "getPermissionById:closingConnections -> " + e);
            }
        }
        return null;
    }

    public boolean updatePermission(BeanPermission permission){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(UPDATE_PERMISSION);
            ps.setString(1, permission.getTitle());
            ps.setLong(2, permission.getId_permission());
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "updatePermission -> " + e);
        }finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "updatePermission:closingConnections -> " + e);
            }
        }
        return false;
    }

    public boolean setPermissionToRole(Long id_role, Long id_permission){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(SET_PERMISSION_TO_ROLE);
            ps.setLong(1, id_role);
            ps.setLong(2, id_permission);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "setPermissionToRole -> " + e);
        }finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "setPermissionToRole:closingConnections -> " + e);
            }
        }
        return false;
    }

    public List<BeanPermission> getPermissionsByRole(Long id_role){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_PERMISSIONS_BY_ROLE);
            ps.setLong(1, id_role);
            rs = ps.executeQuery();
            List<BeanPermission> permissions = new LinkedList<>();
            while(rs.next()){
                BeanPermission permission = new BeanPermission();
                permission.setId_permission(rs.getLong("id_permission"));
                permission.setTitle(rs.getString("title"));
                permissions.add(permission);
            }
            return permissions;
        }catch (SQLException e){
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "getPermissionsByRole -> " + e);
        }finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "getPermissionsByRole:closingConnections -> " + e);
            }
        }
        return null;
    }

    public boolean deletePermissionFromRole(Long id_role, Long id_permission){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(DELETE_PERMISSION_FROM_ROLE);
            ps.setLong(1, id_role);
            ps.setLong(2, id_permission);
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "deletePermissionFromRole -> " + e);
        }finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "deletePermissionFromRole:closingConnections -> " + e);
            }
        }
        return false;
    }

    public boolean isPermissionInRole(Long id_role, Long id_permission){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(IS_PERMISSION_IN_ROLE);
            ps.setLong(1, id_role);
            ps.setLong(2, id_permission);
            rs = ps.executeQuery();
            return rs.next();
        }catch (SQLException e){
            Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "isPermissionInRole -> " + e);
        }finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoPermission.class.getName()).log(Level.SEVERE, null, "isPermissionInRole:closingConnections -> " + e);
            }
        }
        return false;
    }
}
