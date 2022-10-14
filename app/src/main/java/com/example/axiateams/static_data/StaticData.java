package com.example.axiateams.static_data;

import com.example.axiateams.objects.Phase;
import com.example.axiateams.objects.ProjetDashboard;
import com.example.axiateams.objects.ProjetItem;
import com.example.axiateams.objects.categorie.Categorie;
import com.example.axiateams.objects.facture.Article;
import com.example.axiateams.objects.facture.Devise;
import com.example.axiateams.objects.facture.Facture;
import com.example.axiateams.objects.facture.Lignes;
import com.example.axiateams.objects.facture.PhaseProjet;
import com.example.axiateams.objects.facture.Tier;
import com.example.axiateams.objects.facture.Type;
import com.example.axiateams.objects.projet.Etat;
import com.example.axiateams.objects.projet.Projet;
import com.example.axiateams.objects.projet.Responsable;
import com.example.axiateams.objects.societe.Societe;
import com.example.axiateams.objects.tache.Tache;
import com.example.axiateams.objects.tache.UniteTemps;

import java.util.ArrayList;
import java.util.List;

public class StaticData {

    public static List<Projet> getListProjets() {
        List<Projet> projetList = new ArrayList<>();
        projetList.add(new Projet(
                0,
                "Projet Abstract Master",
                "https://img.freepik.com/premium-vector/flying-eagle-abstract-logo-design_23987-441.jpg",
                new Etat(1, "P002", "En Cours", "#c77c1a"),
                "Description ici",
                new Responsable(0, "Hassen Maoua"),
                "20-07-2022",
                "01-02-2023"));

        projetList.add(new Projet(
                1,

                "One Team",
                "https://www.logoarena.com/contestimages/public_new/9431/3446_1548994630_oneteam.jpg",
                new Etat(0, "P001", "Nouveau", "#1a8ac7"),
                "Description ici",
                new Responsable(0, "Hassen Maoua"),
                "20-07-2022",
                "01-02-2023"));

        projetList.add(new Projet(
                2,
                "School Online",
                "https://www.schooleducationgateway.eu/files/jpg10/adobestock_331951541_edited.jpeg",
                new Etat(0, "P001", "Nouveau", "#1a8ac7"),
                "Description ici",
                new Responsable(0, "Hassen Maoua"),
                "20-07-2022",
                "01-02-2023"));

        return projetList;
    }

    public static List<ProjetItem> getListProjetItem() {
        List<ProjetItem> projetList = new ArrayList<>();
        for (Projet projet : getListProjets()) {
            projetList.add(new ProjetItem(
                    projet.getCbmarq(),
                    projet.getIntitule(),
                    projet.getPhoto(),
                    projet.getEtat()));
        }

        return projetList;
    }

    public static List<ProjetDashboard> getProjetsDashboard() {
        List<ProjetDashboard> projetList = new ArrayList<>();
        for (Projet projet : getListProjets()) {
            projetList.add(new ProjetDashboard(projet.getCbmarq(), projet.getIntitule()));
        }

        return projetList;
    }

    public static List<Tache> getListTaches() {
        List<Tache> tacheList = new ArrayList<>();

        tacheList.add(new Tache(
                100,
                "Tache 1",
                "Description Tache 1",
                0,
                55,
                10,
                getListUniteTemps().get(1),
                getListEtatTache().get(1),
                "01-09-2022",
                "01-01-2023",
                false));

        tacheList.add(new Tache(
                101,
                "Tache 2",
                "Description Tache 2",
                0,
                100,
                2,
                getListUniteTemps().get(2),
                getListEtatTache().get(2),
                "05-04-2022",
                "09-09-2022",
                false));

        tacheList.add(new Tache(
                102,
                "Tache 3",
                "Description Tache 3",
                0,
                0,
                10,
                getListUniteTemps().get(3),
                getListEtatTache().get(0),
                "05-04-2022",
                "09-09-2022",
                false));

        tacheList.add(new Tache(
                103,
                "Tache 4",
                "Description Tache 4",
                0,
                0,
                24,
                getListUniteTemps().get(0),
                getListEtatTache().get(0),
                "05-04-2022",
                "09-09-2022",
                false));

        tacheList.add(new Tache(
                104,
                "Tache 5",
                "Description Tache 5",
                0,
                25,
                1,
                getListUniteTemps().get(2),
                getListEtatTache().get(1),
                "05-04-2022",
                "09-09-2022",
                false));


        tacheList.add(new Tache(
                201,
                "Tache 2",
                "Description Tache 2",
                1,
                0,
                2,
                getListUniteTemps().get(2),
                getListEtatTache().get(0),
                "05-04-2022",
                "09-09-2022",
                false));

        tacheList.add(new Tache(
                202,
                "Tache 3",
                "Description Tache 3",
                1,
                18,
                10,
                getListUniteTemps().get(3),
                getListEtatTache().get(1),
                "05-04-2022",
                "09-09-2022",
                false));

        tacheList.add(new Tache(
                203,
                "Tache 4",
                "Description Tache 4",
                1,
                90,
                24,
                getListUniteTemps().get(0),
                getListEtatTache().get(1),
                "05-04-2022",
                "09-09-2022",
                false));

        tacheList.add(new Tache(
                204,
                "Tache 5",
                "Description Tache 5",
                1,
                25,
                1,
                getListUniteTemps().get(2),
                getListEtatTache().get(1),
                "05-04-2022",
                "09-09-2022",
                false));

        tacheList.add(new Tache(
                300,
                "Tache 1",
                "Description Tache 1",
                2,
                55,
                10,
                getListUniteTemps().get(1),
                getListEtatTache().get(1),
                "01-09-2022",
                "01-01-2023",
                false));

        tacheList.add(new Tache(
                301,
                "Tache 2",
                "Description Tache 2",
                2,
                100,
                2,
                getListUniteTemps().get(2),
                getListEtatTache().get(2),
                "05-04-2022",
                "09-09-2022",
                false));

        tacheList.add(new Tache(
                302,
                "Tache 3",
                "Description Tache 3",
                2,
                0,
                10,
                getListUniteTemps().get(3),
                getListEtatTache().get(0),
                "05-04-2022",
                "09-09-2022",
                false));

        tacheList.add(new Tache(
                303,
                "Tache 4",
                "Description Tache 4",
                2,
                0,
                24,
                getListUniteTemps().get(0),
                getListEtatTache().get(0),
                "05-04-2022",
                "09-09-2022",
                false));

        tacheList.add(new Tache(
                304,
                "Tache 5",
                "Description Tache 5",
                2,
                33,
                1,
                getListUniteTemps().get(2),
                getListEtatTache().get(1),
                "05-04-2022",
                "09-09-2022",
                false));



        return tacheList;

    }

    public static List<UniteTemps> getListUniteTemps() {
        List<UniteTemps> uniteTempsList = new ArrayList<>();

        uniteTempsList.add(new UniteTemps(0, "heure", "Heure"));
        uniteTempsList.add(new UniteTemps(1, "jour", "Jour"));
        uniteTempsList.add(new UniteTemps(2, "semaine", "Semaine"));
        uniteTempsList.add(new UniteTemps(3, "mois", "Mois"));
        uniteTempsList.add(new UniteTemps(4, "trimestre", "Trimestre"));
        uniteTempsList.add(new UniteTemps(5, "annee", "Année"));

        return uniteTempsList;

    }

    public static List<com.example.axiateams.objects.tache.Etat> getListEtatTache() {
        List<com.example.axiateams.objects.tache.Etat> etatList = new ArrayList<>();

        etatList.add(new com.example.axiateams.objects.tache.Etat(0, "Nouveau", "#A1A1A1", "1"));
        etatList.add(new com.example.axiateams.objects.tache.Etat(1, "En Cours", "#33AE10", "2"));
        etatList.add(new com.example.axiateams.objects.tache.Etat(2, "Cloturé", "#5454E8", "3"));

        return etatList;
    }

    public static List<Phase> getListPhaseProjet() {
        List<Phase> phaseList = new ArrayList<>();

        phaseList.add(new Phase(0, "Nouveau", "P001", "#1a8ac7"));
        phaseList.add(new Phase(1, "En Cours", "P002", "#c77c1a"));

        return phaseList;
    }

    public static List<Categorie> getListCategorie() {
        List<Categorie> categorieList = new ArrayList<>();

        for (com.example.axiateams.objects.tache.Etat etat : getListEtatTache()) {
            categorieList.add(new Categorie(etat.getCbmarq(), etat.getTitre(), "ETT"));
        }

        for (UniteTemps uniteTemps : getListUniteTemps()) {
            categorieList.add(new Categorie(uniteTemps.getCbmarq(), uniteTemps.getLabel(), "PRD"));
        }

        return categorieList;
    }

    public static List<Facture> getListDocuments() {
        List<Facture> factureList = new ArrayList<>();

        List<Lignes> lignes = new ArrayList<>();

        List<Article> articles = new ArrayList<>();

        articles.add(new Article(0, "1", "Article 1", 3, 10.5D, "0.315", "31.500"));
        articles.add(new Article(0, "2", "Article 2", 3, 3.5D, "0.105", "10.500"));
        articles.add(new Article(0, "3", "Article 3", 3, 389.0D, "81.690", "1 167.000"));
        articles.add(new Article(0, "4", "Article 4", 1, 199.0, "13.930", "199.000"));


        lignes.add(new Lignes("Article Bundle", "1", articles));

        factureList.add(new Facture(
                0,
                new Tier("My Tech", "IDDF-145T-123", "73 000 000"),
                new com.example.axiateams.objects.facture.Etat("Nouveau", "ETD0", "primary"),
                "FA00000001",
                "20-09-2022",
                "1 408.000",
                "1 408.000",
                "96.000",
                "1 504.000",
                "1 504.000",
                "IDDF-145T-123",
                new Devise("TND", "Dinar"),
                lignes,
                new Type("P0013"),
                "1 504.000",
                "",
                new PhaseProjet("", "")
        ));
        factureList.add(new Facture(
                1,
                new Tier("My Tech", "IDDF-145T-123", "73 000 000"),
                new com.example.axiateams.objects.facture.Etat("Nouveau", "ETD0", "primary"),
                "FA00000002",
                "20-09-2022",
                "1 408.000",
                "1 408.000",
                "96.000",
                "1 504.000",
                "1 504.000",
                "IDDF-145T-123",
                new Devise("TND", "Dinar"),
                lignes,
                new Type("P0013"),
                "1 504.000",
                "",
                new PhaseProjet("", "")
        ));
        factureList.add(new Facture(
                2,
                new Tier("My Tech", "IDDF-145T-123", "73 000 000"),
                new com.example.axiateams.objects.facture.Etat("Nouveau", "ETD0", "primary"),
                "FA00000003",
                "20-09-2022",
                "1 408.000",
                "1 408.000",
                "96.000",
                "1 504.000",
                "1 504.000",
                "IDDF-145T-123",
                new Devise("TND", "Dinar"),
                lignes,
                new Type("P0013"),
                "1 504.000",
                "",
                new PhaseProjet("", "")
        ));
        factureList.add(new Facture(
                4,
                new Tier("My Tech", "IDDF-145T-123", "73 000 000"),
                new com.example.axiateams.objects.facture.Etat("Nouveau", "ETD0", "primary"),
                "FA00000005",
                "20-09-2022",
                "1 408.000",
                "1 408.000",
                "96.000",
                "1 504.000",
                "1 504.000",
                "IDDF-145T-123",
                new Devise("TND", "Dinar"),
                lignes,
                new Type("P0013"),
                "1 504.000",
                "",
                new PhaseProjet("", "")
        ));
        factureList.add(new Facture(
                5,
                new Tier("My Tech", "IDDF-145T-123", "73 000 000"),
                new com.example.axiateams.objects.facture.Etat("Nouveau", "ETD0", "primary"),
                "FA00000006",
                "20-09-2022",
                "1 408.000",
                "1 408.000",
                "96.000",
                "1 504.000",
                "1 504.000",
                "IDDF-145T-123",
                new Devise("TND", "Dinar"),
                lignes,
                new Type("P0013"),
                "1 504.000",
                "",
                new PhaseProjet("", "")
        ));


        lignes = new ArrayList<>();

        articles = new ArrayList<>();

        articles.add(new Article(0, "1", "Application 1", 1, 5000.0D, "500.000", "50 000.000"));
        articles.add(new Article(0, "2", "Application 2", 1, 80000.0D, "800.000", "80 000.000"));


        lignes.add(new Lignes("Phase Clôturé", "1", articles));


        factureList.add(new Facture(
                1,
                new Tier("JJO Software", "AA-47-AA-Z", "71 999 000"),
                new com.example.axiateams.objects.facture.Etat("Validé", "ETD1", "success"),
                "FV00000001",
                "29-09-2022",
                "130 000.000",
                "130 000.000",
                "1 300.000",
                "131 300.000",
                "131 300.000",
                "AA-47-AA-Z",
                new Devise("$", "Dollar"),
                lignes,
                new Type("P0014"),
                "131 300.000",
                FilteredData.getProjetByCBMARQ(0).getIntitule(),
                new PhaseProjet(FilteredData.getProjetByCBMARQ(0).getEtat().getLabel(), "")
        ));
        factureList.add(new Facture(
                2,
                new Tier("JJO Software", "AA-47-AA-Z", "71 999 000"),
                new com.example.axiateams.objects.facture.Etat("Validé", "ETD1", "success"),
                "FV00000002",
                "29-09-2022",
                "130 000.000",
                "130 000.000",
                "1 300.000",
                "131 300.000",
                "131 300.000",
                "AA-47-AA-Z",
                new Devise("$", "Dollar"),
                lignes,
                new Type("P0014"),
                "131 300.000",
                FilteredData.getProjetByCBMARQ(0).getIntitule(),
                new PhaseProjet(FilteredData.getProjetByCBMARQ(0).getEtat().getLabel(), "")
        ));
        factureList.add(new Facture(
                3,
                new Tier("JJO Software", "AA-47-AA-Z", "71 999 000"),
                new com.example.axiateams.objects.facture.Etat("Validé", "ETD1", "success"),
                "FV00000003",
                "29-09-2022",
                "130 000.000",
                "130 000.000",
                "1 300.000",
                "131 300.000",
                "131 300.000",
                "AA-47-AA-Z",
                new Devise("$", "Dollar"),
                lignes,
                new Type("P0014"),
                "131 300.000",
                FilteredData.getProjetByCBMARQ(0).getIntitule(),
                new PhaseProjet(FilteredData.getProjetByCBMARQ(0).getEtat().getLabel(), "")
        ));
        factureList.add(new Facture(
                4,
                new Tier("JJO Software", "AA-47-AA-Z", "71 999 000"),
                new com.example.axiateams.objects.facture.Etat("Validé", "ETD1", "success"),
                "FV00000004",
                "29-09-2022",
                "130 000.000",
                "130 000.000",
                "1 300.000",
                "131 300.000",
                "131 300.000",
                "AA-47-AA-Z",
                new Devise("$", "Dollar"),
                lignes,
                new Type("P0014"),
                "131 300.000",
                FilteredData.getProjetByCBMARQ(0).getIntitule(),
                new PhaseProjet(FilteredData.getProjetByCBMARQ(0).getEtat().getLabel(), "")
        ));
        factureList.add(new Facture(
                5,
                new Tier("JJO Software", "AA-47-AA-Z", "71 999 000"),
                new com.example.axiateams.objects.facture.Etat("Validé", "ETD1", "success"),
                "FV00000005",
                "29-09-2022",
                "130 000.000",
                "130 000.000",
                "1 300.000",
                "131 300.000",
                "131 300.000",
                "AA-47-AA-Z",
                new Devise("$", "Dollar"),
                lignes,
                new Type("P0014"),
                "131 300.000",
                FilteredData.getProjetByCBMARQ(0).getIntitule(),
                new PhaseProjet(FilteredData.getProjetByCBMARQ(0).getEtat().getLabel(), "")
        ));
        factureList.add(new Facture(
                6,
                new Tier("JJO Software", "AA-47-AA-Z", "71 999 000"),
                new com.example.axiateams.objects.facture.Etat("Validé", "ETD1", "success"),
                "FV00000006",
                "29-09-2022",
                "130 000.000",
                "130 000.000",
                "1 300.000",
                "131 300.000",
                "131 300.000",
                "AA-47-AA-Z",
                new Devise("$", "Dollar"),
                lignes,
                new Type("P0014"),
                "131 300.000",
                FilteredData.getProjetByCBMARQ(0).getIntitule(),
                new PhaseProjet(FilteredData.getProjetByCBMARQ(0).getEtat().getLabel(), "")
        ));
        factureList.add(new Facture(
                7,
                new Tier("JJO Software", "AA-47-AA-Z", "71 999 000"),
                new com.example.axiateams.objects.facture.Etat("Validé", "ETD1", "success"),
                "FV00000007",
                "29-09-2022",
                "130 000.000",
                "130 000.000",
                "1 300.000",
                "131 300.000",
                "131 300.000",
                "AA-47-AA-Z",
                new Devise("$", "Dollar"),
                lignes,
                new Type("P0014"),
                "131 300.000",
                FilteredData.getProjetByCBMARQ(0).getIntitule(),
                new PhaseProjet(FilteredData.getProjetByCBMARQ(0).getEtat().getLabel(), "")
        ));
        factureList.add(new Facture(
                8,
                new Tier("JJO Software", "AA-47-AA-Z", "71 999 000"),
                new com.example.axiateams.objects.facture.Etat("Validé", "ETD1", "success"),
                "FV00000008",
                "29-09-2022",
                "130 000.000",
                "130 000.000",
                "1 300.000",
                "131 300.000",
                "131 300.000",
                "AA-47-AA-Z",
                new Devise("$", "Dollar"),
                lignes,
                new Type("P0014"),
                "131 300.000",
                FilteredData.getProjetByCBMARQ(0).getIntitule(),
                new PhaseProjet(FilteredData.getProjetByCBMARQ(0).getEtat().getLabel(), "")
        ));


        return factureList;
    }

    public static Societe getSociete() {
        return new Societe(
                0,
                "Abstract",
                "A-B-S-TR",
                "Msaken Sousse",
                "93 000 947",
                "contact@abstract.com",
                "https://e7.pngegg.com/pngimages/95/452/png-clipart-logo-graphic-design-construction-company-logo-design-angle-photography-thumbnail.png");
    }
}

