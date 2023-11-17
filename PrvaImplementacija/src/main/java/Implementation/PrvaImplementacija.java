package Implementation;

import SK_Specification_Matic_Zivanovic.RasporedSpecifikacija;
import SK_Specification_Matic_Zivanovic.RasporedWrapper;
import Serialization.SaveLoadScheduleCSV;
import exception.NePostojiProstorija;
import exception.ProstorijaVecPostoji;
import model.FormatFajla;
import model.Prostorija;
import model.Termin;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrvaImplementacija extends RasporedWrapper {


    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


    @Override
    public void inicijalizacija() {
        super.inicijalizacija();
    }

    @Override
    public void dodajProstoriju(String s, String a) throws ProstorijaVecPostoji {
    }

    @Override
    public void obrisiProstoriju(String s) throws NePostojiProstorija {
    }

    @Override
    public void dodajTermin(Termin termin) {
        if(super.getTermini().contains(termin))
            return;
        else super.getTermini().add(termin);
    }

    @Override
    public void obrisiTermin(Termin termin) {
        if(super.getTermini().contains(termin))
            super.getTermini().remove(termin);
        return;
    }

    @Override
    public void premestiTermin(Termin stariTermin, Termin noviTermin) {
        if (super.getTermini().contains(stariTermin)) {
            super.getTermini().remove(stariTermin);
            super.getTermini().add(noviTermin);
        }
    }

    @Override
    public void ucitajIzFajla(String putanja, FormatFajla formatFajla, String config) {

    }

    @Override
    public void snimiUFajl(String putanja, FormatFajla formatFajla) {

    }

    @Override
    public void filtrirajpoPocetku(String id, LocalDateTime pocetak) {

    }

    @Override
    public void filtrirajpoUcionici(String id) {

    }

    @Override
    public void filtrirajpoProfesoru(String id, String nastavnik) {

    }
}
