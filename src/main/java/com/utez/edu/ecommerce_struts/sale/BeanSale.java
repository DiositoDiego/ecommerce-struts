package com.utez.edu.ecommerce_struts.sale;

public class BeanSale {
    private Long id_sale;
    private String date;
    private Long fk_id_user_buyer;
    private Long fk_id_item;

    public BeanSale() {
    }

    public BeanSale(Long id_sale, String date, Long fk_id_user_buyer, Long fk_id_item) {
        this.id_sale = id_sale;
        this.date = date;
        this.fk_id_user_buyer = fk_id_user_buyer;
        this.fk_id_item = fk_id_item;
    }

    public Long getId_sale() {
        return id_sale;
    }

    public void setId_sale(Long id_sale) {
        this.id_sale = id_sale;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getFk_id_user_buyer() {
        return fk_id_user_buyer;
    }

    public void setFk_id_user_buyer(Long fk_id_user_buyer) {
        this.fk_id_user_buyer = fk_id_user_buyer;
    }

    public Long getFk_id_item() {
        return fk_id_item;
    }

    public void setFk_id_item(Long fk_id_item) {
        this.fk_id_item = fk_id_item;
    }
}
