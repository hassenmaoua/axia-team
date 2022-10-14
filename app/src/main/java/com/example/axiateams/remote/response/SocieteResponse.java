package com.example.axiateams.remote.response;

import com.example.axiateams.objects.societe.Societe;

public class SocieteResponse {
    private boolean satuts;
    private String message;
    private Societe data;

    public boolean isSatuts() {
        return satuts;
    }

    public void setSatuts(boolean satuts) {
        this.satuts = satuts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Societe getData() {
        return data;
    }

    public void setData(Societe data) {
        this.data = data;
    }
}
