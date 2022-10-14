package com.example.axiateams.objects;

import com.example.axiateams.objects.projet.Etat;
import com.google.gson.annotations.SerializedName;

public class ProjetItem {
    private int cbmarq;
    private String intitule;
    private String photo;
    @SerializedName("Categorie")
    private Etat etat;

    public ProjetItem(int cbmarq, String intitule, String photo, Etat etat) {
        this.cbmarq = cbmarq;
        this.intitule = intitule;
        this.photo = photo;
        this.etat = etat;
    }

    public int getCbmarq() {
        return cbmarq;
    }

    public void setCbmarq(int cbmarq) {
        this.cbmarq = cbmarq;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}
