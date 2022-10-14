package com.example.axiateams.objects.facture;

import java.util.List;

public class Lignes {
    private String designation;

    private String num;

    private List<Article> fils;

    public Lignes(String designation, String num, List<Article> fils) {
        this.designation = designation;
        this.num = num;
        this.fils = fils;
    }

    public String getDesignation() {
        return designation;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Article> getFils() {
        return fils;
    }
    public void setFils(List<Article> fils) {
        this.fils = fils;
    }
}
