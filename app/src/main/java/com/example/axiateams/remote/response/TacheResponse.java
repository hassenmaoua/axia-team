package com.example.axiateams.remote.response;

import com.example.axiateams.objects.tache.Tache;

import java.io.Serializable;
import java.util.List;

public class TacheResponse implements Serializable {
    private boolean status;
    private String message;
    private List<Tache> data;

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

    public List<Tache> getData() {
        return data;
    }

    public void setData(List<Tache> data) {
        this.data = data;
    }
}
