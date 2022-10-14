package com.example.axiateams.remote.response;

import com.example.axiateams.objects.ProjetDashboard;

import java.util.List;

public class DashboardResponse {
    private boolean status;
    private String message;
    private List<ProjetDashboard> data;

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

    public List<ProjetDashboard> getData() {
        return data;
    }

    public void setData(List<ProjetDashboard> data) {
        this.data = data;
    }
}
