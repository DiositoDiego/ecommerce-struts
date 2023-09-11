package com.utez.edu.ecommerce_struts.user;

import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class ActionUser extends ActionSupport{
    DaoUser daoUser = new DaoUser();
    List<BeanUser> users;
    BeanUser user;
    String data;
    String message;

    public String consultarUsuarios(){

        return "success";
    }

    public List<BeanUser> getUsers() {
        return users;
    }

    public void setUsers(List<BeanUser> users) {
        this.users = users;
    }

    public BeanUser getUser() {
        return user;
    }

    public void setUser(BeanUser user) {
        this.user = user;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
