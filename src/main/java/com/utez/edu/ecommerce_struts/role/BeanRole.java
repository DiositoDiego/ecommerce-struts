package com.utez.edu.ecommerce_struts.role;

public class BeanRole {
    Long id_role;
    String name;
    Boolean status;

    public BeanRole() {
    }

    public BeanRole(Long id_role, String name, Boolean status) {
        this.id_role = id_role;
        this.name = name;
        this.status = status;
    }

    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
