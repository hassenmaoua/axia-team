package com.example.axiateams.objects.facture;

public class Article {
    private int cbmarq;

    private String num;

    private String designation;

    private int quantite;

    private double prixUnitaire;

    private String montantTVA;

    private String montantHT;

    public Article(int cbmarq, String num, String designation, int quantite, double prixUnitaire, String montantTVA, String montantHT) {
        this.cbmarq = cbmarq;
        this.num = num;
        this.designation = designation;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montantTVA = montantTVA;
        this.montantHT = montantHT;
    }

    public int getCbmarq() {
        return cbmarq;
    }

    public void setCbmarq(int cbmarq) {
        this.cbmarq = cbmarq;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getMontantTVA() {
        return montantTVA;
    }

    public void setMontantTVA(String montantTVA) {
        this.montantTVA = montantTVA;
    }

    public String getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(String montantHT) {
        this.montantHT = montantHT;
    }
}
