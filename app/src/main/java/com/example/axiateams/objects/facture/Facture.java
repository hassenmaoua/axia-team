package com.example.axiateams.objects.facture;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Facture{

    @SerializedName("cbmarq")
    private int cbmarq;

    @SerializedName("tiers")
    private Tier tiers;

    @SerializedName("etat")
    private Etat etat;

    @SerializedName("dopiece")
    private String reference;

    @SerializedName("dateDoc")
    private String dateDoc;

    @SerializedName("montantHT")
    private String montantHT;

    @SerializedName("montantNetHT")
    private String montantNetHT;

    @SerializedName("montantTVA")
    private String montantTVA;

    @SerializedName("montantTTC")
    private String montantTTC;

    @SerializedName("intituleTiers")
    private String intituleTiers;

    @SerializedName("identifiant")
    private String identifiant;

    @SerializedName("devise")
    private Devise devise;

    @SerializedName("lignes")
    private List<Lignes> lignes;

    @SerializedName("type")
    private Type type;

    @SerializedName("NETapayer")
    private String NETapayer;

    @SerializedName("intituleProjet")
    private String intituleProjet;

    @SerializedName("pahseProjet")
    private PhaseProjet phaseProjet;

    public Facture(int cbmarq, Tier tiers, Etat etat, String reference, String dateDoc, String montantHT, String montantNetHT, String montantTVA, String montantTTC, String intituleTiers, String identifiant, Devise devise, List<Lignes> lignes, Type type, String NETapayer, String intituleProjet, PhaseProjet phaseProjet) {
        this.cbmarq = cbmarq;
        this.tiers = tiers;
        this.etat = etat;
        this.reference = reference;
        this.dateDoc = dateDoc;
        this.montantHT = montantHT;
        this.montantNetHT = montantNetHT;
        this.montantTVA = montantTVA;
        this.montantTTC = montantTTC;
        this.intituleTiers = intituleTiers;
        this.identifiant = identifiant;
        this.devise = devise;
        this.lignes = lignes;
        this.type = type;
        this.NETapayer = NETapayer;
        this.intituleProjet = intituleProjet;
        this.phaseProjet = phaseProjet;
    }

    public int getCbmarq() {
        return cbmarq;
    }

    public void setCbmarq(int cbmarq) {
        this.cbmarq = cbmarq;
    }

    public Tier getTiers() {
        return tiers;
    }

    public void setTiers(Tier tiers) {
        this.tiers = tiers;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDateDoc() {
        return dateDoc;
    }

    public void setDateDoc(String dateDoc) {
        this.dateDoc = dateDoc;
    }

    public String getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(String montantHT) {
        this.montantHT = montantHT;
    }

    public String getMontantNetHT() {
        return montantNetHT;
    }

    public void setMontantNetHT(String montantNetHT) {
        this.montantNetHT = montantNetHT;
    }

    public String getMontantTVA() {
        return montantTVA;
    }

    public void setMontantTVA(String montantTVA) {
        this.montantTVA = montantTVA;
    }

    public String getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(String montantTTC) {
        this.montantTTC = montantTTC;
    }

    public String getIntituleTiers() {
        return intituleTiers;
    }

    public void setIntituleTiers(String intituleTiers) {
        this.intituleTiers = intituleTiers;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public List<Lignes> getLignes() {
        return lignes;
    }

    public void setLignes(List<Lignes> lignes) {
        this.lignes = lignes;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNETapayer() {
        return NETapayer;
    }

    public void setNETapayer(String NETapayer) {
        this.NETapayer = NETapayer;
    }

    public String getIntituleProjet() {
        return intituleProjet;
    }

    public void setIntituleProjet(String intituleProjet) {
        this.intituleProjet = intituleProjet;
    }

    public PhaseProjet getPhaseProjet() {
        return phaseProjet;
    }

    public void setPhaseProjet(PhaseProjet phaseProjet) {
        this.phaseProjet = phaseProjet;
    }

}
