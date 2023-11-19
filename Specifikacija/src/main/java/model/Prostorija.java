package model;

import java.util.Map;

public class Prostorija {
    private String identifikator;
    private String additionalData;

    public Prostorija(String identifikator, String additionalData) {
        this.identifikator = identifikator;
        this.additionalData = additionalData;

    }
    public Prostorija(String identifikator){
        this.identifikator = identifikator;
    }

    public String getIdentifikator() {
        return identifikator;
    }

    public void setIdentifikator(String identifikator) {
        this.identifikator = identifikator;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public String toString() {
        return "Ucionica:" + identifikator + additionalData;
    }
}
