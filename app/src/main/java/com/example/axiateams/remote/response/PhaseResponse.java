package com.example.axiateams.remote.response;

import com.example.axiateams.objects.Phase;

import java.util.List;

public class PhaseResponse {
    private boolean status;
    private String message;
    private List<Phase> data;

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

    public List<Phase> getData() {
        return data;
    }

    public void setData(List<Phase> data) {
        this.data = data;
    }
}
