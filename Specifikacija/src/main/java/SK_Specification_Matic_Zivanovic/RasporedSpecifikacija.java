package SK_Specification_Matic_Zivanovic;

import exception.NePostojiProstorija;
import model.FormatFajla;
import model.Termin;
import exception.ProstorijaVecPostoji;


import java.time.LocalDateTime;
import java.util.Map;

public interface RasporedSpecifikacija {


    void inicijalizacija();


    void dodajProstoriju(String identifikator, String additionalData) throws ProstorijaVecPostoji;

    void obrisiProstoriju(String identifikator) throws NePostojiProstorija;


    void dodajTermin(Termin termin);

    void obrisiTermin(Termin termin);

    void premestiTermin(Termin stariTermin, Termin noviTermin);


    void ucitajIzFajla(String putanja, FormatFajla format, String config);

    void snimiUFajl(String putanja, FormatFajla format);

    void filtrirajpoPocetku(String id, LocalDateTime pocetak);

    void filtrirajpoUcionici(String id);

    void filtrirajpoProfesoru(String id, String nastavnik);
    public boolean uporedi(Termin termin1, Termin termin2);

}
