package com.utez.edu.ecommerce_struts.user;

public class BeanUser {
    Long idUser;
    String name;
    String lastname;
    String surname;
    String curp;
    String tuition;
    String institutional_mail;
    String password;
    Boolean status;

    public BeanUser() {
    }

    public BeanUser(Long idUser, String name, String lastname, String surname, String curp, String tuition, String institutional_mail, String password, Boolean status) {
        this.idUser = idUser;
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.curp = curp;
        this.tuition = tuition;
        this.institutional_mail = institutional_mail;
        this.password = password;
        this.status = status;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public String getInstitutional_mail() {
        return institutional_mail;
    }

    public void setInstitutional_mail(String institutional_mail) {
        this.institutional_mail = institutional_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
