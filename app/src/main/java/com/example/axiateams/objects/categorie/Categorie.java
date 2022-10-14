package com.example.axiateams.objects.categorie;

public class Categorie {
    private int cbmarq;
    private String label;
    private String code;


    public Categorie(int cbmarq, String label, String code) {
        this.cbmarq = cbmarq;
        this.label = label;
        this.code = code;
    }

    public int getCbmarq() {
        return cbmarq;
    }

    public void setCbmarq(int cbmarq) {
        this.cbmarq = cbmarq;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
