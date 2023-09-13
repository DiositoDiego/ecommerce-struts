package com.utez.edu.ecommerce_struts.role;

public class BeanRole {
    private Long id_role;
    private String role;
    private Boolean status;

    public BeanRole() {
    }

    public BeanRole(Long id_role, String role, Boolean status) {
        this.id_role = id_role;
        this.role = role;
        this.status = status;
    }

    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
