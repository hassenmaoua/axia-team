package com.example.axiateams.objects.projet;

public class Etat {
    private int cbmarq;
    private String code;
    private String label;
    private String style;

    public Etat(int cbmarq, String code, String label, String style) {
        this.cbmarq = cbmarq;
        this.code = code;
        this.label = label;
        this.style = style;
    }

    public int getCbmarq() {
        return cbmarq;
    }

    public void setCbmarq(int cbmarq) {
        this.cbmarq = cbmarq;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
