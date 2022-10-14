package com.example.axiateams.objects.projet;

public class Responsable {
    private int cbmarq;
    private String nom;

    public Responsable(int cbmarq, String nom) {
        this.cbmarq = cbmarq;
        this.nom = nom;
    }

    public int getCbmarq() {
        return cbmarq;
    }

    public void setCbmarq(int cbmarq) {
        this.cbmarq = cbmarq;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
