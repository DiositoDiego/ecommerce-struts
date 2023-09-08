package com.utez.edu.ecommerce_struts.permission;

public class BeanPermission {
    Long id_permission;
    String title;

    public BeanPermission() {
    }

    public BeanPermission(Long id_permission, String title) {
        this.id_permission = id_permission;
        this.title = title;
    }

    public Long getId_permission() {
        return id_permission;
    }

    public void setId_permission(Long id_permission) {
        this.id_permission = id_permission;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
