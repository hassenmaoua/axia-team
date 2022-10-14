package com.example.axiateams.objects.account;

public class Societe {

    private int cbmarq;
    private String intitule;

    public Societe(int cbmarq, String intitule) {
        this.cbmarq = cbmarq;
        this.intitule = intitule;
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
}
