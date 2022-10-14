package com.example.axiateams.objects.tache;

public class UniteTemps {
    private int cbmarq;
    private String code;
    private String label;

    public UniteTemps(int cbmarq, String code, String label) {
        this.cbmarq = cbmarq;
        this.code = code;
        this.label = label;
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
}
