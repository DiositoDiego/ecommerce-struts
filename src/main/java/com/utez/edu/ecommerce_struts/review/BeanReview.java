package com.utez.edu.ecommerce_struts.review;

public class BeanReview {
    Long id_review;
    String date;
    Double rate;
    String comment;
    Long fk_id_sale;

    public BeanReview() {
    }

    public BeanReview(Long id_review, String date, Double rate, String comment, Long fk_id_sale) {
        this.id_review = id_review;
        this.date = date;
        this.rate = rate;
        this.comment = comment;
        this.fk_id_sale = fk_id_sale;
    }

    public Long getId_review() {
        return id_review;
    }

    public void setId_review(Long id_review) {
        this.id_review = id_review;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getFk_id_sale() {
        return fk_id_sale;
    }

    public void setFk_id_sale(Long fk_id_sale) {
        this.fk_id_sale = fk_id_sale;
    }
}
