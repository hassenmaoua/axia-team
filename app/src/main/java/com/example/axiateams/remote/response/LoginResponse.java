package com.example.axiateams.remote.response;

import com.example.axiateams.objects.account.Account;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private boolean status;
    private String message;
    private Account data;

    public boolean getStatus() {
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

    public  Account getData() {
        return data;
    }

    public void setData(Account data) {
        this.data = data;
    }
}
