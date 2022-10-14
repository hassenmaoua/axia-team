package com.example.axiateams.objects.projet;

import com.google.gson.annotations.SerializedName;

public class Projet {
    private int cbmarq;

    private String intitule;

    private String photo;
    @SerializedName("Categorie")
    private Etat etat;
    @SerializedName("Description")
    private String description;
    @SerializedName("Responsable")
    private Responsable responsable;
    @SerializedName("DateDebutFS")
    private String dateDebut;
    @SerializedName("DateFinFS")
    private String dateFin;

    public Projet(int cbmarq, String intitule, String photo, Etat etat, String description, Responsable responsable, String dateDebut, String dateFin) {
        this.cbmarq = cbmarq;
        this.intitule = intitule;
        this.photo = photo;
        this.etat = etat;
        this.description = description;
        this.responsable = responsable;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
}
