package com.example.axiateams.static_data;

import com.example.axiateams.objects.categorie.Categorie;
import com.example.axiateams.objects.facture.Facture;
import com.example.axiateams.objects.projet.Etat;
import com.example.axiateams.objects.projet.Projet;
import com.example.axiateams.objects.projet.Responsable;
import com.example.axiateams.objects.tache.Tache;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.List;

public class FilteredData {
    public static List<Tache> getListTache(int cbmarq) {
        List<Tache> tacheList = new ArrayList<>();

        for (Tache tache : StaticData.getListTaches()) {
            if (tache.getReference() == cbmarq) tacheList.add(tache);
        }

        return tacheList;
    }

    public static Projet getProjetByCBMARQ(int cbmarq) {
        for (Projet projet : StaticData.getListProjets()) {
            if (projet.getCbmarq() == cbmarq) return projet;
        }

        return new Projet(0, "", "", new Etat(0, "", "", "#000000"), "", new Responsable(0, ""), "", "");
    }

    public static List<Categorie> getListByCategorie(String code) {
        List<Categorie> categorieList = new ArrayList<>();

        for (Categorie categorie : StaticData.getListCategorie()) {
            if (categorie.getCode().equals(code)) categorieList.add(categorie);
        }

        return categorieList;
    }

    public static List<Facture> getListDocument(String type) {
        List<Facture> factureList = new ArrayList<>();

        for (Facture facture : StaticData.getListDocuments()) {
            if (facture.getType().getCode().equals(type))
                factureList.add(facture);
        }

        return factureList;
    }

    public static Facture getDocument(int cbmarq){
        for (Facture document : StaticData.getListDocuments()){
            if (document.getCbmarq() == cbmarq)
                return document;
        }

        return StaticData.getListDocuments().get(0);
    }
}
