package com.example.axiateams.remote.response;

import com.example.axiateams.objects.projet.Projet;

public class ProjetResponse {

    private boolean status;
    private String message;
    private Projet data;

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

    public Projet getData() {
        return data;
    }

    public void setData(Projet data) {
        this.data = data;
    }
}
