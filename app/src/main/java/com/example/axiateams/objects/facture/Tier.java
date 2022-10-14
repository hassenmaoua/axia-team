package com.example.axiateams.objects.facture;

public class Tier {

    private String intitule;
    private String identifiant;
    private String adresse;
    private String telephone;
    private String email;
    private Type type;

    public Tier(String intitule, String identifiant, String telephone) {
        this.intitule = intitule;
        this.identifiant = identifiant;
        this.telephone = telephone;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public String getInformation() {
        return identifiant + "\n" + telephone;
    }
}
