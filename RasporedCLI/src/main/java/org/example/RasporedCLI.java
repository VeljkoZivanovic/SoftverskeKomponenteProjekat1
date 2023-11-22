package org.example;

import Implementation.PrvaImplementacija;
import SK_Specification_Matic_Zivanovic.RasporedManager;
import SK_Specification_Matic_Zivanovic.RasporedWrapper;
import exception.NePostojiProstorija;
import exception.NevalidanTerminException;
import exception.ProstorijaVecPostoji;
import model.FormatFajla;
import model.Prostorija;
import model.Termin;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RasporedCLI {

    static int type;
    static String nameForClass = null;

    static RasporedWrapper rasporedWrapper;
    public static void main(String[] args) throws ProstorijaVecPostoji, NePostojiProstorija {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite koju implementaciju zelite da koristite: 1 PrvaImplementacija 2 DrugaImplementacija");
        type = scanner.nextInt();
        if(type == 1) nameForClass = "Implementation.PrvaImplementacija";
        else if(type == 2) nameForClass = "implementation.DrugaImplementacija";
        else {
            System.out.println("Nevažeća opcija.");
            return;
        }
        try {
            Class.forName((nameForClass));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        rasporedWrapper = RasporedManager.getRasporedWrapper();
        scanner.nextLine();
        rasporedWrapper.inicijalizacija();
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Unesite od kog do kog datuma zelite da prikazete raspored");
        System.out.println("Unesite pocetni datum u formatu yyyy-MM-dd");
        LocalDate pocetniDatum = LocalDate.parse(scanner.nextLine());
        System.out.println("Unesite krajnji datum u formatu yyyy-MM-dd");
        LocalDate krajnjiDatum = LocalDate.parse(scanner.nextLine());
        rasporedWrapper.odrediDaneUNedelji(pocetniDatum, krajnjiDatum);
        while (true) {
            System.out.println("Izaberite opciju: 1) Dodaj prostoriju 2) Izbrisi prostoriju " +
                                "3) Dodaj termin 4) Obrisi termin 5) Premesti termin" +
                                 " 6) Ucitaj iz fajla  7)Snimi u fajl 8)Filtriraj 9) Izlaz");
            int opcija = scanner.nextInt();
            scanner.nextLine();

            switch (opcija) {

                case 1:
                    System.out.println("Unesite identifikator za prostoriju koju zelite da dodate");
                    String identifikator = scanner.nextLine();


                    System.out.println("Unesite da li se radi o ucionici sa racunarima (u) ili amfiteatru (a)");
                    String additionalData = scanner.nextLine();

                    rasporedWrapper.dodajProstoriju(identifikator, additionalData);
                    System.out.println(rasporedWrapper.getProstorije().toString());
                    break;
                case 2:
                    System.out.println("Unesite identifikator za prostoriju koju zelite da obrisete");
                    String identifikatorBrisanje = scanner.nextLine();
                    rasporedWrapper.obrisiProstoriju(identifikatorBrisanje);
                    System.out.println(rasporedWrapper.getProstorije().toString());
                    break;
                case 3:
                    System.out.println("Unesite identifikator prostorije:");
                    String identifikator1 = scanner.nextLine();

                    System.out.println("Unesite da li je u pitanju ucionica (u) ili amfiteatar (a)");
                    String additionalData1 = scanner.nextLine();

                    Prostorija prostorija = new Prostorija(identifikator1, additionalData1);

                    System.out.println("Unesite početak termina:");
                    LocalTime pocetak = LocalTime.parse(scanner.nextLine());

                    System.out.println("Unesite kraj termina:");
                    LocalTime kraj = LocalTime.parse(scanner.nextLine());

                    Map<String, String> additionalDataTermin = new HashMap<>();
                    System.out.println("Unesite predmet:");
                    additionalDataTermin.put("predmet", scanner.nextLine());

                    System.out.println("Unesite tip:");
                    additionalDataTermin.put("tip", scanner.nextLine());

                    System.out.println("Unesite nastavnika:");
                    additionalDataTermin.put("nastavnik", scanner.nextLine());

                    System.out.println("Unesite grupe koje slušaju predmet:");
                    additionalDataTermin.put("grupe", scanner.nextLine());

                    System.out.println("Unesite datum:");
                    LocalDate datum = LocalDate.parse(scanner.nextLine());

                    System.out.println("Unesite dan:");
                    String dan = scanner.nextLine();
                    /*
                    Termin termin = new Termin(prostorija,pocetak,kraj,additionalDataTermin,datum,dan);
                    try {
                        rasporedWrapper.dodajTermin(termin);
                        System.out.println(rasporedWrapper.getTermini().toString());
                    } catch (NevalidanTerminException e) {
                        throw new RuntimeException(e);
                    }
                     */
                    break;
                case 4:
                    System.out.println("Unesite podatke o terminu koji zelite da obrisete");
                    System.out.println("Unesite identifikator prostorije:");
                    String identifaktor2 = scanner.nextLine();

                    System.out.println("Unesite da li je u pitanju ucionica (u) ili amfiteatar (a)");
                    String additionalData2 = scanner.nextLine();

                    Prostorija prostorija1 = new Prostorija(identifaktor2, additionalData2);

                    System.out.println("Unesite početak termina:");
                    LocalTime pocetak1 = LocalTime.parse(scanner.nextLine());

                    System.out.println("Unesite kraj termina:");
                    LocalTime kraj1 = LocalTime.parse(scanner.nextLine());

                    Map<String, String> additionalDataTermin1 = new HashMap<>();
                    System.out.println("Unesite predmet:");
                    additionalDataTermin1.put("predmet", scanner.nextLine());

                    System.out.println("Unesite tip:");
                    additionalDataTermin1.put("tip", scanner.nextLine());

                    System.out.println("Unesite nastavnika:");
                    additionalDataTermin1.put("nastavnik", scanner.nextLine());

                    System.out.println("Unesite grupe koje slušaju predmet:");
                    additionalDataTermin1.put("grupe", scanner.nextLine());

                    System.out.println("Unesite datum:");
                    LocalDate datum1 = LocalDate.parse(scanner.nextLine());

                    System.out.println("Unesite dan:");
                    String dan1 = scanner.nextLine();

                    //Termin termin1 = new Termin(prostorija1,pocetak1,kraj1,additionalDataTermin1,datum1,dan1);
                    //rasporedWrapper.obrisiTermin(termin1);
                    break;
                case 5:
                    System.out.println("Unesite podatke o terminu koji zelite da premestite");
                    System.out.println("Unesite identifikator prostorije:");
                    String identifikator3 = scanner.nextLine();

                    System.out.println("Unesite da li je u pitanju ucionica (u) ili amfiteatar (a)");
                    String additionalData3 = scanner.nextLine();

                    Prostorija prostorijaStari = new Prostorija(identifikator3, additionalData3);

                    System.out.println("Unesite početak termina:");
                    LocalTime pocetakStari = LocalTime.parse(scanner.nextLine());

                    System.out.println("Unesite kraj termina:");
                    LocalTime krajStari = LocalTime.parse(scanner.nextLine());

                    Map<String, String> additionalDataTerminStari = new HashMap<>();
                    System.out.println("Unesite predmet:");
                    additionalDataTerminStari.put("predmet", scanner.nextLine());

                    System.out.println("Unesite tip:");
                    additionalDataTerminStari.put("tip", scanner.nextLine());

                    System.out.println("Unesite nastavnika:");
                    additionalDataTerminStari.put("nastavnik", scanner.nextLine());

                    System.out.println("Unesite grupe koje slušaju predmet:");
                    additionalDataTerminStari.put("grupe", scanner.nextLine());

                    System.out.println("Unesite datum:");
                    LocalDate datumStari = LocalDate.parse(scanner.nextLine());

                    System.out.println("Unesite dan:");
                    String danStari = scanner.nextLine();

                    //Termin terminStari = new Termin(prostorijaStari, pocetakStari, krajStari, additionalDataTerminStari, datumStari, danStari);

                    System.out.println("Unesite podatke o novom terminu na koji zelite da premestite stari termin");
                    System.out.println("Unesite identifikator prostorije:");
                    String identifikator4 = scanner.nextLine();

                    System.out.println("Unesite da li je u pitanju ucionica (u) ili amfiteatar (a)");
                    String additionalData4 = scanner.nextLine();

                    Prostorija prostorijaNovi = new Prostorija(identifikator4, additionalData4);

                    System.out.println("Unesite početak novog termina:");
                    LocalTime pocetakNovi = LocalTime.parse(scanner.nextLine());

                    System.out.println("Unesite kraj novog termina:");
                    LocalTime krajNovi = LocalTime.parse(scanner.nextLine());

//                    Map<String, String> additionalDataTerminNovi = new HashMap<>();
//                    System.out.println("Unesite predmet:");
//                    additionalDataTerminNovi.put("predmet", scanner.nextLine());
//
//                    System.out.println("Unesite tip:");
//                    additionalDataTerminNovi.put("tip", scanner.nextLine());
//
//                    System.out.println("Unesite nastavnika:");
//                    additionalDataTerminNovi.put("nastavnik", scanner.nextLine());
//
//                    System.out.println("Unesite grupe koje slušaju predmet:");
//                    additionalDataTerminNovi.put("grupe", scanner.nextLine());

                    System.out.println("Unesite datum:");
                    LocalDate datumNovi = LocalDate.parse(scanner.nextLine());

                    System.out.println("Unesite dan:");
                    String danNovi = scanner.nextLine();

                    //Termin terminNovi = new Termin(prostorijaNovi, pocetakNovi, krajNovi,additionalDataTerminStari, datumNovi,danNovi);
                    //rasporedWrapper.premestiTermin(terminStari, terminNovi);

                    break;
                case 6:
                    System.out.println("Unesite putanju fajla koji zelite da ucitate");
                    String putanja = scanner.nextLine();

                    System.out.println("Unesite kog formata je taj fajl");
                    FormatFajla formatFajla = FormatFajla.valueOf(scanner.nextLine());

                    System.out.println("Unesite putanju do config fajla");
                    String config = scanner.nextLine();

                    System.out.println("Unesite putanju do config fajla sa danima");
                    String configd = scanner.nextLine();

                    rasporedWrapper.ucitajIzFajla(putanja, formatFajla,config,configd);
                    System.out.println(rasporedWrapper.getTermini().toString());
                    break;
                case 7:
                    System.out.println("Unesite putanju fajla u koji zelite da snimite");
                    String putanjaSnimi = scanner.nextLine();

                    System.out.println("Unesite format fajla u koji se snima");
                    FormatFajla formatFajlaSnimi = FormatFajla.valueOf(scanner.nextLine());

                    rasporedWrapper.snimiUFajl(putanjaSnimi,formatFajlaSnimi);

                    break;
                case 8:
                    //logika za filtriranje preko komandne linije
                    System.out.println("Unesite vrednost za filtriranje: 0-ako ne zelite po tom atributu; konkretnu vrednost po kojoj zelite da filtrirate");

                    System.out.println("Unesite identifikator prostorije:");
                    String identifikator5 = scanner.nextLine();
                    if(identifikator5.equals("0")) identifikator5 = null;

                    System.out.println("Unesite da li je u pitanju ucionica (u) ili amfiteatar (a)");
                    String additionalData5 = scanner.nextLine();
                    if(additionalData5.equals("0")) additionalData5 = null;

                    Prostorija prostorija5 = new Prostorija(identifikator5, additionalData5);

                    System.out.println("Unesite početak termina:");
                    LocalTime pocetak5 = LocalTime.parse(scanner.nextLine());
                    if(pocetak5.equals("0")) pocetak5 = null;

                    System.out.println("Unesite kraj termina:");
                    LocalTime kraj5 = LocalTime.parse(scanner.nextLine());
                    if(kraj5.equals("0")) kraj5 = null;

                    System.out.println("Unesite predmet:");
                    String predmet = scanner.nextLine();
                    if(predmet.equals("0")) predmet = null;

                    System.out.println("Unesite tip:");
                    String tip = scanner.nextLine();
                    if(tip.equals("0")) tip = null;

                    System.out.println("Unesite nastavnika:");
                    String nastavnik = scanner.nextLine();
                    if(nastavnik.equals("0")) nastavnik = null;

                    System.out.println("Unesite grupe");
                    String grupe = scanner.nextLine();
                    if(grupe.equals("0")) grupe = null;

                    Map<String, String> additionalDataTermin5 = new HashMap<>();
                    additionalDataTermin5.put("predmet", predmet);
                    additionalDataTermin5.put("tip", tip);
                    additionalDataTermin5.put("nastavnik", nastavnik);
                    additionalDataTermin5.put("grupe", grupe);

//                    System.out.println("Unesite datum:");
//                    LocalDate datum5 = LocalDate.parse(scanner.nextLine());
//                    if(datum5.equals("0")) datum5 = null;

                    System.out.println("Unesite dan:");
                    String dan5 = scanner.nextLine();
                    if(dan5.equals("0")) dan5 = null;

                    //Termin termin5 = new Termin(prostorija5,pocetak5,kraj5,additionalDataTermin5,dan5);
                    //rasporedWrapper.filtriraj(termin5);
                    System.out.println("Filtrirani termini: " + rasporedWrapper.getFiltriraniTermini().toString());
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Nevažeća opcija.");
            }
        }
    }
}