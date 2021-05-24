package com.example.talim.Model;

public class ReklamaData {
    String fan_nomi;
    String uqituvchi_ismi;
    Integer rasmURL;

    public ReklamaData(String fan_nomi, String uqituvchi_ismi, Integer rasmURL) {
        this.fan_nomi = fan_nomi;
        this.uqituvchi_ismi = uqituvchi_ismi;
        this.rasmURL = rasmURL;
    }

    public String getFan_nomi() {
        return fan_nomi;
    }

    public void setFan_nomi(String fan_nomi) {
        this.fan_nomi = fan_nomi;
    }

    public String getUqituvchi_ismi() {
        return uqituvchi_ismi;
    }

    public void setUqituvchi_ismi(String uqituvchi_ismi) {
        this.uqituvchi_ismi = uqituvchi_ismi;
    }

    public Integer getRasmURL() {
        return rasmURL;
    }

    public void setRasmURL(Integer rasmURL) {
        this.rasmURL = rasmURL;
    }
}
