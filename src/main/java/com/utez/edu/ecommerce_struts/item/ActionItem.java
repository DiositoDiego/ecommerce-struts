package com.utez.edu.ecommerce_struts.item;

import com.google.gson.Gson;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static com.opensymphony.xwork2.Action.ERROR;

public class ActionItem {
    private BeanItem item;
    private List<BeanItem> items;
    private String message;
    private String data;
    private final DaoItem daoItem = new DaoItem();
    HttpSession session;

    public String createItem(){
        session = ServletActionContext.getRequest().getSession();
        if(session.getAttribute("role").toString().equals("vendedor")) {
            BeanItem item = new Gson().fromJson(data, BeanItem.class);
            if (item != null) {
                if (daoItem.createItem(item)) {
                    setMessage("success");
                } else {
                    setMessage("failed");
                }
            } else {
                setMessage("failed");
            }
            return SUCCESS;
        }
        return ERROR;
    }

    public String getAllItemsByName(){
        return SUCCESS;
    }

    public List<BeanItem> getItems() {
        return items;
    }

    public void setItems(List<BeanItem> items) {
        this.items = items;
    }

    public BeanItem getItem() {
        return item;
    }

    public void setItem(BeanItem item) {
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
