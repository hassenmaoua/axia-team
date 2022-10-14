package com.example.axiateams.remote.response;

import com.example.axiateams.objects.facture.Facture;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DocumentResponse implements Serializable {
    private boolean status;
    private String message;

    private Facture data;

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

    public Facture getData() {
        return data;
    }

    public void setData(Facture data) {
        this.data = data;
    }

}
