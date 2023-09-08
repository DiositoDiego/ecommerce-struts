package com.utez.edu.ecommerce_struts.sale;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoSale {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    final String INSERT_SALE = "INSERT INTO sales (date, fk_id_user_buyer, fk_id_item) VALUES (?,?,?)";
    final String GET_ALL_SALES = "SELECT * FROM sales";
    final String GET_SALE_BY_ID = "SELECT * FROM sales WHERE id = ?";

    public boolean createSale(BeanSale sale) {
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(INSERT_SALE);
            ps.setString(1, sale.getDate());
            ps.setLong(2, sale.getFk_id_user_buyer());
            ps.setLong(3, sale.getFk_id_item());
            rs = ps.executeQuery();
            return rs.next();
        }catch (SQLException e){
            Logger.getLogger(DaoSale.class.getName()).log(Level.SEVERE, null, "createSale -> " + e);
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
                Logger.getLogger(DaoSale.class.getName()).log(Level.SEVERE, null, "createSale:closingConnections -> " + e);;
            }
        }
        return false;
    }

    public List<BeanSale> getAllSales(){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_ALL_SALES);
            rs = ps.executeQuery();
            List<BeanSale> sales = new LinkedList<>();
            while(rs.next()){
                BeanSale sale = new BeanSale();
                sale.setId_sale(rs.getLong("id_sale"));
                sale.setDate(rs.getString("date"));
                sale.setFk_id_user_buyer(rs.getLong("fk_id_user_buyer"));
                sale.setFk_id_item(rs.getLong("fk_id_item"));
                sales.add(sale);
            }
            return sales;
        }catch(SQLException e){
            Logger.getLogger(DaoSale.class.getName()).log(Level.SEVERE, null, "getAllSales -> " + e);
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
                Logger.getLogger(DaoSale.class.getName()).log(Level.SEVERE, null, "getAllSales:closingConnections -> " + e);;
            }
        }
        return null;
    }

    public BeanSale getSaleById(Long id){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_SALE_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                BeanSale sale = new BeanSale();
                sale.setId_sale(rs.getLong("id_sale"));
                sale.setDate(rs.getString("date"));
                sale.setFk_id_user_buyer(rs.getLong("fk_id_user_buyer"));
                sale.setFk_id_item(rs.getLong("fk_id_item"));
                return sale;
            }
        }catch (SQLException e){
            Logger.getLogger(DaoSale.class.getName()).log(Level.SEVERE, null, "getSaleById -> " + e);
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
                Logger.getLogger(DaoSale.class.getName()).log(Level.SEVERE, null, "getSaleById:closingConnections -> " + e);;
            }
        }
        return null;
    }
}
