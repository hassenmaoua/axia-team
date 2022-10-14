package com.example.axiateams.objects.societe;

public class Societe {
    private int cbmarq;

    private String raisonSociale;

    private String matriculeFiscale;

    private String adresse;

    private String telephone;

    private String email;

    private String logo;

    public Societe(int cbmarq, String raisonSociale, String matriculeFiscale, String adresse, String telephone, String email, String logo) {
        this.cbmarq = cbmarq;
        this.raisonSociale = raisonSociale;
        this.matriculeFiscale = matriculeFiscale;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.logo = logo;
    }

    public int getCbmarq() {
        return cbmarq;
    }

    public void setCbmarq(int cbmarq) {
        this.cbmarq = cbmarq;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getMatriculeFiscale() {
        return matriculeFiscale;
    }

    public void setMatriculeFiscale(String matriculeFiscale) {
        this.matriculeFiscale = matriculeFiscale;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
