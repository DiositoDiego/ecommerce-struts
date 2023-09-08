package com.utez.edu.ecommerce_struts.item;

public class BeanItem {
    Long id_item;
    String image;
    String name;
    String description;
    Double price;
    String start_availability_date;
    String end_availability_date;
    Double rate;
    Long fk_id_user_seller;

    public BeanItem() {
    }

    public BeanItem(Long id_item, String image, String name, String description, Double price, String start_availability_date, String end_availability_date, Double rate, Long fk_id_user_seller) {
        this.id_item = id_item;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.start_availability_date = start_availability_date;
        this.end_availability_date = end_availability_date;
        this.rate = rate;
        this.fk_id_user_seller = fk_id_user_seller;
    }

    public Long getId_item() {
        return id_item;
    }

    public void setId_item(Long id_item) {
        this.id_item = id_item;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStart_availability_date() {
        return start_availability_date;
    }

    public void setStart_availability_date(String start_availability_date) {
        this.start_availability_date = start_availability_date;
    }

    public String getEnd_availability_date() {
        return end_availability_date;
    }

    public void setEnd_availability_date(String end_availability_date) {
        this.end_availability_date = end_availability_date;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getFk_id_user_seller() {
        return fk_id_user_seller;
    }

    public void setFk_id_user_seller(Long fk_id_user_seller) {
        this.fk_id_user_seller = fk_id_user_seller;
    }
}
