package com.example.axiateams.objects.facture;

public class PhaseProjet {
    private int cbmarq;
    private String intitule;
    private String code;

    public PhaseProjet(String intitule, String code) {
        this.intitule = intitule;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
