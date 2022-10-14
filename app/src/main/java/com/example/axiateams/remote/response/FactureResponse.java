package com.example.axiateams.remote.response;

import com.example.axiateams.objects.facture.Facture;

import java.util.List;

public class FactureResponse{
    private boolean status;
    private String message;
    private List<Facture> data;

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

    public List<Facture> getData() {
        return data;
    }

    public void setData(List<Facture> data) {
        this.data = data;
    }
}
