package com.example.axiateams.objects.facture;

public class Devise {
    private int cbmarq;
    private String label;
    private String description;

    public Devise(String label, String description) {
        this.label = label;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
