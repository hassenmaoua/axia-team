package com.example.axiateams.remote.response;

import com.example.axiateams.objects.ProjetItem;

import java.util.List;

public class ListProjetResponse {

    private boolean status;
    private String message;
    private List<ProjetItem> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ProjetItem> getData() {
        return data;
    }

    public void setData(List<ProjetItem> data) {
        this.data = data;
    }
}
