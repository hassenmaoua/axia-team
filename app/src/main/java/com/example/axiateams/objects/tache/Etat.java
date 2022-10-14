package com.example.axiateams.objects.tache;

public class Etat {

     private int cbmarq;
     private String titre;
     private String couleur;
     private String ordre;
     private boolean isClosed;
     private boolean isCanceled;

    public Etat(int cbmarq, String titre, String couleur, String ordre) {
        this.cbmarq = cbmarq;
        this.titre = titre;
        this.couleur = couleur;
        this.ordre = ordre;
    }

    public int getCbmarq() {
        return cbmarq;
    }

    public void setCbmarq(int cbmarq) {
        this.cbmarq = cbmarq;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }
}
