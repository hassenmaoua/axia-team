package com.example.axiateams.objects;

import java.io.Serializable;

public class ProjetDashboard implements Serializable {
    private int cbmarq;
    private String intitule;

    public ProjetDashboard(int cbmarq, String intitule) {
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
