package SK_Specification_Matic_Zivanovic;

import Serialization.SaveLoadScheduleCSV;
import exception.NePostojiProstorija;
import model.FormatFajla;
import model.Prostorija;
import model.Termin;
import exception.ProstorijaVecPostoji;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class RasporedWrapper implements RasporedSpecifikacija{
    private List<Termin> termini;
    private List<Prostorija> prostorije;
    private LocalDateTime pocetak;
    private LocalDateTime kraj;

    public List<Termin> getTermini() {
        return termini;
    }

    public void setTermini(List<Termin> termini) {
        this.termini = termini;
    }

    public List<Prostorija> getProstorije() {
        return prostorije;
    }

    public void setProstorije(List<Prostorija> prostorije) {
        this.prostorije = prostorije;
    }

    public LocalDateTime getPocetak() {
        return pocetak;
    }

    public void setPocetak(LocalDateTime pocetak) {
        this.pocetak = pocetak;
    }

    public LocalDateTime getKraj() {
        return kraj;
    }

    public void setKraj(LocalDateTime kraj) {
        this.kraj = kraj;
    }

    public RasporedWrapper() {
    }

    @Override
    public void inicijalizacija() {
        termini = new ArrayList<>();
        prostorije = new ArrayList<>();
    }

    @Override
    public void dodajProstoriju(String identifikator, String additionalData) throws ProstorijaVecPostoji {
//        Prostorija prostorija = new Prostorija(identifikator, kapacitet, imaRacunare, imaProjektor, dodatniPodaci);
//        if(prostorije.contains(prostorija))
//            return;
//        else prostorije.add(prostorija);

        for (Prostorija p : prostorije) {
            if (p.getIdentifikator().equals(identifikator)) {
                // Ako prostorija već postoji, možda ćete hteti da baci neki izuzetak ili ažurira postojeću prostoriju
                throw new ProstorijaVecPostoji("Prostorija sa identifikatoro " + p.getIdentifikator() + "vec postoji!");
            }
        }

        // Kreiranje nove prostorije i dodavanje u listu
        Prostorija novaProstorija = new Prostorija(identifikator, additionalData);
        prostorije.add(novaProstorija);
    }

    @Override
    public void obrisiProstoriju(String identifikator) throws NePostojiProstorija {
        for (Prostorija p: prostorije){
            if(p.getIdentifikator().equals(identifikator)){
                prostorije.remove(p);
            } else {
                throw new NePostojiProstorija("Ne postoji prostorija sa " + p.getIdentifikator() + "identifikatorom koja treba da se obrise");
            }
        }
     }
    //prostorije.removeIf(prostorija -> prostorija.getIdentifikator().equals(identifikator));
    // Iterator<Prostorija> iterator = prostorije.iterator();
        //        while (iterator.hasNext()) {
        //            Prostorija prostorija = iterator.next();
        //            if (prostorija.getIdentifikator().equals(identifikator)) {
        //                iterator.remove();
        //                return; // Prekidamo petlju kada nađemo i obrišemo prostoriju
        //            }
        //        }

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
        SaveLoadScheduleCSV csv = new SaveLoadScheduleCSV(this);
        try {
            csv.loadFile(putanja, config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void snimiUFajl(String putanja, FormatFajla format) {
        SaveLoadScheduleCSV csv = new SaveLoadScheduleCSV(this);
        try {
            csv.exportData(putanja);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
