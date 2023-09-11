package com.utez.edu.ecommerce_struts.item;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoItem {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    final String INSERT_ITEM = "INSERT INTO items (image, name, description, price, start_availability_date, end_availability_date, fk_id_user_seller) VALUES (?,?,?,?,?,?,?)";
    final String GET_ALL_ITEMS_BY_SELLER = "SELECT * FROM items WHERE fk_id_user_seller = ? ORDER BY ? LIMIT ? OFFSET ?";
    final String GET_ALL_ITEMS_BY_NAME = "SELECT * FROM items WHERE name LIKE ? ORDER BY ? LIMIT ? OFFSET ?";
    final String GET_ITEM_BY_ID = "SELECT * FROM items WHERE id_item = ?";
    final String UPDATE_ITEM = "UPDATE items SET image = ?, name = ?, description = ?, price = ?, start_availability_date = ?, end_availability_date = ?, rate = ?, fk_id_user_seller = ? WHERE id_item = ?";

    public boolean createItem(BeanItem item){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(INSERT_ITEM);
            ps.setString(1, item.getImage());
            ps.setString(2, item.getName());
            ps.setString(3, item.getDescription());
            ps.setDouble(4, item.getPrice());
            ps.setString(5, item.getStart_availability_date());
            ps.setString(6, item.getEnd_availability_date());
            ps.setLong(7, item.getFk_id_user_seller());
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoItem.class.getName()).log(Level.SEVERE, null, "createItem -> " + e);
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoItem.class.getName()).log(Level.SEVERE, null, "createItem:closingConnections -> " + e);
            }
        }
        return false;
    }

    public List<BeanItem> getAllItemsBySeller(Long id_seller, String orderBy, Integer limit, Integer offset){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_ALL_ITEMS_BY_SELLER);
            ps.setLong(1, id_seller);
            ps.setString(2, orderBy);
            ps.setInt(3, limit);
            ps.setInt(4, offset);
            rs = ps.executeQuery();
            List<BeanItem> items = new LinkedList<>();
            while(rs.next()){
                BeanItem item = new BeanItem();
                item.setId_item(rs.getLong("id_item"));
                item.setImage(rs.getString("image"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getDouble("price"));
                item.setStart_availability_date(rs.getString("start_availability_date"));
                item.setEnd_availability_date(rs.getString("end_availability_date"));
                item.setRate(rs.getDouble("rate"));
                item.setFk_id_user_seller(rs.getLong("fk_id_user_seller"));
                items.add(item);
            }
            return items;
        }catch (SQLException e){
            Logger.getLogger(DaoItem.class.getName()).log(Level.SEVERE, null, "getAllItemsBySeller -> " + e);
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoItem.class.getName()).log(Level.SEVERE, null, "getAllItemsBySeller:closingConnections -> " + e);
            }
        }
        return null;
    }

    public List<BeanItem> getAllItemsByName(String name, String orderBy, Integer limit, Integer offset){
        try {
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_ALL_ITEMS_BY_NAME);
            ps.setString(1, name);
            ps.setString(2, orderBy);
            ps.setInt(3, limit);
            ps.setInt(4, offset);
            rs = ps.executeQuery();
            List<BeanItem> items = new LinkedList<>();
            while(rs.next()){
                BeanItem item = new BeanItem();
                item.setId_item(rs.getLong("id_item"));
                item.setImage(rs.getString("image"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getDouble("price"));
                item.setStart_availability_date(rs.getString("start_availability_date"));
                item.setEnd_availability_date(rs.getString("end_availability_date"));
                item.setRate(rs.getDouble("rate"));
                item.setFk_id_user_seller(rs.getLong("fk_id_user_seller"));
                items.add(item);
            }
            return items;
        }catch (SQLException e){
            Logger.getLogger(DaoItem.class.getName()).log(Level.SEVERE, null, "getAllItemsByName -> " + e);
        } finally {
            try{
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            }catch (SQLException e){
                Logger.getLogger(DaoItem.class.getName()).log(Level.SEVERE, null, "getAllItemsByName:closingConnections -> " + e);
            }
        }
        return null;
    }

    public BeanItem getItemById(Long id){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_ITEM_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                BeanItem item = new BeanItem();
                item.setId_item(rs.getLong("id_item"));
                item.setImage(rs.getString("image"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getDouble("price"));
                item.setStart_availability_date(rs.getString("start_availability_date"));
                item.setEnd_availability_date(rs.getString("end_availability_date"));
                item.setRate(rs.getDouble("rate"));
                item.setFk_id_user_seller(rs.getLong("fk_id_user_seller"));
                return item;
            }
        }catch (SQLException e){
            Logger.getLogger(DaoItem.class.getName()).log(Level.SEVERE, null, "getItemById -> " + e);
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoItem.class.getName()).log(Level.SEVERE, null, "getItemById:closingConnections -> " + e);
            }
        }
        return null;
    }

    public boolean updateItem(BeanItem item){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(UPDATE_ITEM);
            ps.setString(1, item.getImage());
            ps.setString(2, item.getName());
            ps.setString(3, item.getDescription());
            ps.setDouble(4, item.getPrice());
            ps.setString(5, item.getStart_availability_date());
            ps.setString(6, item.getEnd_availability_date());
            ps.setDouble(7, item.getRate());
            ps.setLong(8, item.getFk_id_user_seller());
            ps.setLong(9, item.getId_item());
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoItem.class.getName()).log(Level.SEVERE, null, "updateItem -> " + e);
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoItem.class.getName()).log(Level.SEVERE, null, "updateItem:closingConnections -> " + e);
            }
        }
        return false;
    }
}
