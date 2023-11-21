package SK_Specification_Matic_Zivanovic;

import Serialization.SaveLoadScheduleCSV;
import exception.NePostojiProstorija;
import exception.NevalidanTerminException;
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
    private List<Termin> filtriraniTermini;
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

    /**
     * Inicijalizacija liste termina i prostorija
     */
    @Override
    public void inicijalizacija() {
        termini = new ArrayList<>();
        prostorije = new ArrayList<>();
        filtriraniTermini = new ArrayList<>();
    }

    /**
     * Dodavanje nove prostorije u listu prostorija
     * @param identifikator
     * @param additionalData
     * @throws ProstorijaVecPostoji
     */
    @Override
    public void dodajProstoriju(String identifikator, String additionalData) throws ProstorijaVecPostoji{
        // Provera da li prostorija vec postoji
        for (Prostorija p: prostorije){
            if(p.getIdentifikator().equals(identifikator)){
                throw new ProstorijaVecPostoji("Prostorija sa identifikatorom " + identifikator + " vec postoji!");
            }
        }
        // Kreiranje nove prostorije i dodavanje u listu
        Prostorija prostorija = new Prostorija(identifikator, additionalData);
        prostorije.add(prostorija);

    }
    /**
     * Brisanje prostorije iz liste prostorija
     * @param identifikator
     * @throws NePostojiProstorija
     */
    @Override
    public void obrisiProstoriju(String identifikator) throws NePostojiProstorija
    {
        for (Prostorija p: prostorije){
            if(p.getIdentifikator().equals(identifikator)){
                prostorije.remove(p);
                return;
            }
        }
        throw new NePostojiProstorija("Prostorija sa identifikatorom" + identifikator + " ne postoji!");
    }
    /**
     * Dodavanje novog termina u listu termina
     * @param termin
     */
    @Override
    public void dodajTermin(Termin termin)throws NevalidanTerminException {

    }
    /**
     * Brisanje termina iz liste termina
     * @param termin
     */
    @Override
    public void obrisiTermin(Termin termin) {

    }
       /**
        * Premestanje termina na novu vrednost vremena ili mesta
        * @param stariTermin
        * @param noviTermin
        */
    @Override
    public void premestiTermin(Termin stariTermin, Termin noviTermin) {

    }
    /**
     * Ucitavanje podataka iz fajla
     * @param putanja
     * @param format
     * @param config
     */
    @Override
    public void ucitajIzFajla(String putanja, FormatFajla format, String config) {
        SaveLoadScheduleCSV csv = new SaveLoadScheduleCSV(this);
        try {
            csv.loadFile(putanja, config);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Snimanje podataka u fajl
     * @param putanja
     * @param format
     */
    @Override
    public void snimiUFajl(String putanja, FormatFajla format) {
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbb");
        SaveLoadScheduleCSV csv = new SaveLoadScheduleCSV(this);
        try {
            System.out.println("ccccccccccccccccc");
            csv.exportData(putanja);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Filtriranje termina
     * @param termin
     */
    @Override
    public void filtriraj(Termin termin){

    }
    /**
     * Poredjenje dva termina
     * @param termin1
     * @param termin2
     * @return
     */
    @Override
    public boolean uporedi(Termin termin1, Termin termin2) {
        return false;
    }
    /**
     * Filtriranje termina
     * @return
     */
    public List<Termin> getFiltriraniTermini() {
        return filtriraniTermini;
    }
    /**
     *
     * @param filtriraniTermini
     */
    public void setFiltriraniTermini(List<Termin> filtriraniTermini) {
        this.filtriraniTermini = filtriraniTermini;
    }
}
