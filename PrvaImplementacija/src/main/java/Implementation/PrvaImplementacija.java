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
        if (super.getTermini().contains(stariTermin))
        {
            if(uporedi(stariTermin,noviTermin))
            {
                super.getTermini().remove(stariTermin);
                super.getTermini().add(noviTermin);
            }
            else System.out.println("Termin se ne moze premestiti");
        }
    }

    @Override
    public void ucitajIzFajla(String putanja, FormatFajla formatFajla, String config) {

    }

    @Override
    public void snimiUFajl(String putanja, FormatFajla formatFajla) {

    }

    @Override
    public void filtriraj(Termin termin){

    }
    @Override
    public boolean uporedi(Termin termin1, Termin termin2) {
        List<Termin> sviTermini = super.getTermini();

        for (Termin t : sviTermini) {
            // Preskoči proveru za sam stari termin
            if (t.equals(termin1)) {
                continue;
            }

            // Provera za novi termin
            if (t.getProstorija().equals(termin2.getProstorija()) &&
                    t.getDatum().equals(termin2.getDatum()) &&
                    !t.getPocetak().isAfter(termin2.getKraj()) &&
                    !t.getKraj().isBefore(termin2.getPocetak())) {
                return false; // Novi termin se poklapa sa nekim postojećim terminom
            }
        }

        return true; // Nema poklapanja, premestanje je moguće
    }
}
