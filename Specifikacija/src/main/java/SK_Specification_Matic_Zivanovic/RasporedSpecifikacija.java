package SK_Specification_Matic_Zivanovic;

import exception.NePostojiProstorija;
import exception.NevalidanTerminException;
import model.FormatFajla;
import model.Termin;
import exception.ProstorijaVecPostoji;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface RasporedSpecifikacija {


    void inicijalizacija();


    void odrediDaneUNedelji(LocalDate pocetniDatum, LocalDate krajnjiDatum);

    void dodajProstoriju(String identifikator, String additionalData) throws ProstorijaVecPostoji;


    void obrisiProstoriju(String identifikator) throws NePostojiProstorija;

    void dodajTermin(Termin termin) throws NevalidanTerminException;

    void obrisiTermin(Termin termin);

    void premestiTermin(Termin stariTermin, Termin noviTermin);


    void ucitajIzFajla(String putanja, FormatFajla format, String config, String config2);

    void snimiUFajl(String putanja, FormatFajla format);

    void filtriraj(Termin t);
    boolean uporedi(Termin termin1, Termin termin2);


}
