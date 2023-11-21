package Implementation;

import SK_Specification_Matic_Zivanovic.RasporedSpecifikacija;
import SK_Specification_Matic_Zivanovic.RasporedWrapper;
import Serialization.SaveLoadScheduleCSV;
import exception.NePostojiProstorija;
import exception.NevalidanTerminException;
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
    public void dodajProstoriju(String identifikator, String additionalData) throws ProstorijaVecPostoji {
        super.dodajProstoriju(identifikator, additionalData);
    }

    @Override
    public void obrisiProstoriju(String s) throws NePostojiProstorija{
        super.obrisiProstoriju(s);
    }

    @Override
    public void dodajTermin(Termin termin) throws NevalidanTerminException {
        for(Termin t : super.getTermini())
        {
            if(t.getProstorija().equals(termin.getProstorija()) &&
                    t.getDatum().equals(termin.getDatum()) &&
                    !t.getPocetak().isAfter(termin.getKraj()) &&
                    !t.getKraj().isBefore(termin.getPocetak()))
                throw new NevalidanTerminException();
            //else super.getTermini().add(termin);
        }
        super.getTermini().add(termin);
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
        super.ucitajIzFajla(putanja, formatFajla, config);
    }

    @Override
    public void snimiUFajl(String putanja, FormatFajla formatFajla) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        super.snimiUFajl(putanja, formatFajla);
    }

    @Override
    public void filtriraj(Termin termin){
        super.setFiltriraniTermini(TerminManager.filtrirajTermine(super.getTermini(),
                TerminManager.filtrirajPoPocetku(termin.getPocetak()),
                TerminManager.filtrirajPoKraju(termin.getKraj()),
                TerminManager.filtrirajPoProstoriji(termin.getProstorija()),
                TerminManager.filtrirajPoDanu(termin.getDan()),
                TerminManager.filtrirajPoDatumu(termin.getDatum()),
                TerminManager.filtrirajPoDodatnimPodacima(termin.getAdditionalData())));
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
