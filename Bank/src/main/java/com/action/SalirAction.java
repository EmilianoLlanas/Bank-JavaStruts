package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class SalirAction implements SessionAware {
    private Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> session) {
        // TODO Auto-generated method stub
        this.session=session;

    }

    public String execute() {
        session.clear();
        return "success";
    }

}