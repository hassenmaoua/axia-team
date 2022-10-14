package com.example.axiateams.objects.facture;

public class Etat {
    private int cbmarq;
    private String label;
    private String code;
    private String style;

    public Etat(String label, String code, String style) {
        this.label = label;
        this.code = code;
        this.style = style;
    }

    public int getCbmarq() {
        return cbmarq;
    }

    public void setCbmarq(int cbmarq) {
        this.cbmarq = cbmarq;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
