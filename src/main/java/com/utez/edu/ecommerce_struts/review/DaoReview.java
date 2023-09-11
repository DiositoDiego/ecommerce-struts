package com.utez.edu.ecommerce_struts.review;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoReview {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    final String INSERT_REVIEW = "INSERT INTO reviews (fk_id_sale, date, comment, rate) VALUES (?,?,?,?)";
    final String GET_ALL_REVIEWS = "SELECT reviews.* FROM reviews JOIN sales ON reviews.fk_id_sale = sales.id_sale WHERE fk_id_item = ?";
    final String GET_REVIEW_BY_ID = "SELECT * FROM reviews WHERE id_review = ?";
    final String UPDATE_REVIEW = "UPDATE reviews SET review = ?, score = ? WHERE id_review = ?";

    public boolean createReview(BeanReview review) {
        try {
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(INSERT_REVIEW);
            ps.setLong(1, review.getFk_id_sale());
            ps.setString(2, review.getDate());
            ps.setString(3, review.getComment());
            ps.setDouble(4, review.getRate());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            Logger.getLogger(DaoReview.class.getName()).log(Level.SEVERE, null, "createReview -> " + e);
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoReview.class.getName()).log(Level.SEVERE, null, "createReview:closingConnections -> " + e);
                ;
            }
        }
        return false;
    }

    public List<BeanReview> getAllReviewsByItemId(Long id_item) {
        try {
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_ALL_REVIEWS);
            ps.setLong(1, id_item);
            rs = ps.executeQuery();
            List<BeanReview> reviews = new LinkedList<>();
            while (rs.next()) {
                BeanReview review = new BeanReview();
                review.setId_review(rs.getLong("id_review"));
                review.setFk_id_sale(rs.getLong("fk_id_sale"));
                review.setDate(rs.getString("date"));
                review.setComment(rs.getString("comment"));
                review.setRate(rs.getDouble("rate"));
                reviews.add(review);
            }
            return reviews;
        } catch (SQLException e) {
            Logger.getLogger(DaoReview.class.getName()).log(Level.SEVERE, null, "getAllReviewsByItemId -> " + e);
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoReview.class.getName()).log(Level.SEVERE, null, "getAllReviewsByItemId:closingConnections -> " + e);
            }
        }
        return null;
    }

    public BeanReview getReviewById(Long id) {
        try {
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(GET_REVIEW_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                BeanReview review = new BeanReview();
                review.setId_review(rs.getLong("id_review"));
                review.setFk_id_sale(rs.getLong("fk_id_sale"));
                review.setDate(rs.getString("date"));
                review.setComment(rs.getString("comment"));
                review.setRate(rs.getDouble("rate"));
                return review;
            }
        } catch (SQLException e) {
            Logger.getLogger(DaoReview.class.getName()).log(Level.SEVERE, null, "getReviewById -> " + e);
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoReview.class.getName()).log(Level.SEVERE, null, "getReviewById:closingConnections -> " + e);
            }
        }
        return null;
    }

    public boolean updateReview(BeanReview review){
        try{
            con = MySQLConnection.getConnection();
            ps = con.prepareStatement(UPDATE_REVIEW);
            ps.setString(1, review.getComment());
            ps.setDouble(2, review.getRate());
            ps.setLong(3, review.getId_review());
            return ps.executeUpdate() > 0;
        }catch (SQLException e){
            Logger.getLogger(DaoReview.class.getName()).log(Level.SEVERE, null, "updateReview -> " + e);
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                Logger.getLogger(DaoReview.class.getName()).log(Level.SEVERE, null, "updateReview:closingConnections -> " + e);
            }
        }
        return false;
    }
}
