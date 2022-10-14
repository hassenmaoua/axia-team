package com.example.axiateams.objects.tache;

import com.example.axiateams.static_data.StaticData;
import com.google.gson.annotations.SerializedName;

public class Tache {

    private int cbmarq;

    private String intitule;

    @SerializedName("Description")
    private String description;

    private int reference;

    @SerializedName("progress")
    private int progress;

    @SerializedName("TempsEstime")
    private int tempsEstime;

    @SerializedName("UniteTemps")
    private UniteTemps uniteTemps;

    @SerializedName("Categorie")
    private Etat etat;

    @SerializedName("DateDebutFS")
    private String dateDebut;

    @SerializedName("DateFinFS")
    private String dateFin;

    @SerializedName("isTitre")
    private boolean isTitre;


    public Tache(int cbmarq, String intitule, String description, int reference, int progress, int tempsEstime, UniteTemps uniteTemps, Etat etat, String dateDebut, String dateFin, boolean isTitre) {
        this.cbmarq = cbmarq;
        this.intitule = intitule;
        this.description = description;
        this.reference = reference;
        this.progress = progress;
        this.tempsEstime = tempsEstime;
        this.uniteTemps = uniteTemps;
        this.etat = etat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.isTitre = isTitre;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getCbmarq() {
        return cbmarq;
    }

    public void setCbmarq(int cbmarq) {
        this.cbmarq = cbmarq;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getTempsEstime() {
        return tempsEstime;
    }

    public void setTempsEstime(int tempsEstime) {
        this.tempsEstime = tempsEstime;
    }

    public UniteTemps getUniteTemps() {
        return uniteTemps;
    }

    public void setUniteTemps(UniteTemps uniteTemps) {
        this.uniteTemps = uniteTemps;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
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

    public boolean isTitre() {
        return isTitre;
    }

    public void setTitre(boolean titre) {
        isTitre = titre;
    }
}
