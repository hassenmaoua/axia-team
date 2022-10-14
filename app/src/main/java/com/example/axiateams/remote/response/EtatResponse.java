package com.example.axiateams.remote.response;

import com.example.axiateams.objects.categorie.Categorie;

import java.util.List;

public class EtatResponse {
    private boolean status;
    private String message;
    private List<Categorie> data;

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

    public List<Categorie> getData() {
        return data;
    }

    public void setData(List<Categorie> data) {
        this.data = data;
    }
}
