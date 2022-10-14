package com.example.axiateams.objects.account;

import java.io.Serializable;

public class Account implements Serializable {
    private String nomComplet;
    private String email;
    private String photo;
    private String token;
    private Societe societe;

    public Account(String nomComplet, String email, String photo, String token, Societe societe) {
        this.nomComplet = nomComplet;
        this.email = email;
        this.photo = photo;
        this.token = token;
        this.societe = societe;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }
}
