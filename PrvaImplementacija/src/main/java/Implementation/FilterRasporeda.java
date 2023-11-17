package Implementation;

import SK_Specification_Matic_Zivanovic.RasporedSpecifikacija;
import model.FormatFajla;
import model.Termin;

import java.time.LocalDateTime;
import java.util.Map;

public class FilterRasporeda implements RasporedSpecifikacija {
    @Override
    public void inicijalizacija() {

    }

    @Override
    public void dodajProstoriju(String identifikator, String additionalData) {

    }

    @Override
    public void obrisiProstoriju(String identifikator) {

    }

    @Override
    public void dodajTermin(Termin termin) {

    }

    @Override
    public void obrisiTermin(Termin termin) {

    }

    @Override
    public void premestiTermin(Termin stariTermin, Termin noviTermin) {

    }

    @Override
    public void ucitajIzFajla(String putanja, FormatFajla format, String config) {

    }

    @Override
    public void snimiUFajl(String putanja, FormatFajla format) {

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
