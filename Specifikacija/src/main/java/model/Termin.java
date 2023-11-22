package model;


import java.time.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Termin {
    private LocalTime pocetak;
    private LocalTime kraj;
    private Prostorija prostorija;
    private LocalDate datum;

    private DayOfWeek dan;

    private Map<String,String> additionalData;

    public Termin(Prostorija prostorija, LocalTime pocetak, LocalTime kraj, Map<String,String> additionalData, LocalDate datum, DayOfWeek dan) {
        this.prostorija = prostorija;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.additionalData = additionalData;
        this.datum = datum;
        this.dan = dan;
    }
    public Termin(Prostorija prostorija, LocalTime pocetak, LocalTime kraj, Map<String,String> additionalData, DayOfWeek dan) {
        this.prostorija = prostorija;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.additionalData = additionalData;
        this.dan = dan;
    }

    public Termin() {
        additionalData = new HashMap<>();
    }

    public LocalTime getPocetak() {
        return pocetak;
    }

    public void setPocetak(LocalTime pocetak) {
        this.pocetak = pocetak;
    }

    public LocalTime getKraj() {
        return kraj;
    }

    public void setKraj(LocalTime kraj) {
        this.kraj = kraj;
    }

    public Prostorija getProstorija() {
        return prostorija;
    }

    public void setProstorija(Prostorija prostorija) {
        this.prostorija = prostorija;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Map<String,String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String,String> additionalData) {
        this.additionalData = additionalData;
    }

    public DayOfWeek getDan() {
        return dan;
    }

    public void setDan(DayOfWeek dan) {
        this.dan = dan;
    }

    @Override
    public String toString() {
        return  "Pocetak " + pocetak + ", Kraj " + kraj + ", Prostorija " + prostorija + ", Datum "  + datum + ", Dan " + dan + ", Dodatni podaci: '" + additionalData + '\n';
    }


}

