package com.utez.edu.ecommerce_struts.review;

import com.utez.edu.ecommerce_struts.user.DaoUser;
import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActionReview {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    final String INSERT_REVIEW = "INSERT INTO reviews (fk_id_sale, date, comment, rate) VALUES (?,?,?,?)";
    final String GET_ALL_REVIEWS = "SELECT * FROM reviews";
    final String GET_REVIEW_BY_ID = "SELECT * FROM reviews WHERE id_review = ?";//
    final String UPDATE_REVIEW = "UPDATE reviews SET review = ?, score = ? WHERE id_review = ?";

    public boolean createReview(BeanReview review){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(INSERT_REVIEW);
            ps.setLong(1, review.getFk_id_sale());
            ps.setString(2, review.getDate());
            ps.setString(3, review.getComment());
            ps.setDouble(4, review.getRate());
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, "createReview -> " + e);
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
                Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, "createReview:closingConnections -> " + e);;
            }
        }
        return false;
    }
}
