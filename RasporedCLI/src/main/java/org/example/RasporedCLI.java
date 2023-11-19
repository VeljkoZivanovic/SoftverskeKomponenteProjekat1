package org.example;

import Implementation.PrvaImplementacija;
import SK_Specification_Matic_Zivanovic.RasporedWrapper;
import exception.NePostojiProstorija;
import exception.ProstorijaVecPostoji;
import model.FormatFajla;
import model.Termin;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RasporedCLI extends PrvaImplementacija {

    public static void main(String[] args) throws ProstorijaVecPostoji, NePostojiProstorija {

        RasporedCLI rasporedCLI = new RasporedCLI();
        DateTimeFormatter inputFormatter = new DateTimeFormatterBuilder()
                .appendPattern("[H:mm-HH][HH:mm-HH]")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm - HH:mm");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            rasporedCLI.inicijalizacija();
            System.out.println("Izaberite opciju: 1) Dodaj prostoriju 2) Izbrisi prostoriju " +
                                "3) Dodaj termin 4) Obrisi termin 5) Premesti termin" +
                                 "6) Ucitaj iz fajla  7)Snimi u fajl 8)Filtriraj 9) Izlaz");
            int opcija = scanner.nextInt();
            //String linija = scanner.nextLine();
            //String [] delovi = linija.split(" ");

            switch (opcija) {

                case 1:
                    System.out.println("Unesite identifikator za prostoriju koju zelite da dodate");
                    String identifikator = scanner.nextLine();


                    System.out.println("Unesite da li se radi o ucionici sa racunarima (u) ili amfiteatru (a)");
                    String additionalData = scanner.nextLine();

                    rasporedCLI.dodajProstoriju(identifikator, additionalData);
                    System.out.println(rasporedCLI.getProstorije().toString());
                    break;
                case 2:
                    System.out.println("Unesite identifikator za prostoriju koju zelite da obrisete");
                    String identifikatorBrisanje = scanner.nextLine();
                    rasporedCLI.obrisiProstoriju(identifikatorBrisanje);
                    System.out.println(rasporedCLI.getProstorije().toString());
                    break;
                case 3:
//                    LocalTime startDateTime = LocalTime.parse(split[0], inputFormatter);
//                    String formattedStartTime = outputFormatter.format(startDateTime);
//                    System.out.println("Unesite redom podatke o terminu: prostorija, pocetak, kraj, predmet, tip, nastavnik, grupe, datum, dan");
//                    String prostorija = delovi[0];
//                    LocalTime startDateTime = LocalTime.parse(delovi[1],inputFormatter);
//                    String pocetak = outputFormatter.format(startDateTime);
//                    LocalTime endDateTime = LocalTime.parse(delovi[2],inputFormatter);
//                    String kraj = outputFormatter.format(endDateTime);
//
//                    String datum = delovi[7];//u terminu definisano kao lokaldate
//                    String dan = delovi[8];
//                    //dodati za additional data nastavnik,predmet, grupe
//                    break;

                    System.out.println("Unesite prostoriju:");
                    String prostorija = scanner.nextLine();

                    System.out.println("Unesite početak termina:");
                    LocalTime startDateTime = LocalTime.parse(scanner.nextLine(),inputFormatter);
                    String pocetak = outputFormatter.format(startDateTime);

                    System.out.println("Unesite kraj termina:");
                    LocalTime endDateTime = LocalTime.parse(scanner.nextLine(),inputFormatter);
                    String kraj = outputFormatter.format(endDateTime);

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
                    String datum = scanner.nextLine();

                    System.out.println("Unesite dan:");
                    String dan = scanner.nextLine();
                    //Termin termin = new Termin(prostorija,pocetak,kraj,additionalData,datum,dan); problem oko parsiranja i prostorije
                    //rasporedCLI.dodajTermin(termin);
                case 4:
//                    System.out.println("Unesite redom: pocetak, kraj, prostorija, datum, dan ");
//                    String pocetak1 = delovi[0];//U terminu definisano kao Lokaltime mzd ce biti problema
//                    String kraj1 = delovi[1];//u terminu definisano kao lokaltime mzd ce biti problema
//                    String prostorija1 = delovi[2];
//                    String datum1 = delovi[3];//u terminu definisano kao lokaldate
//                    String dan1 = delovi[4];
//                    //dodati za additional data nastavnik,predmet, grupe
//                    break;
                    System.out.println("Unesite podatke o terminu koji zelite da obrisete");
                    System.out.println("Unesite prostoriju:");
                    String prostorija1 = scanner.nextLine();

                    System.out.println("Unesite početak termina:");
                    LocalTime startDateTime1 = LocalTime.parse(scanner.nextLine(),inputFormatter);
                    String pocetak1 = outputFormatter.format(startDateTime1);

                    System.out.println("Unesite kraj termina:");
                    LocalTime endDateTime1 = LocalTime.parse(scanner.nextLine(),inputFormatter);
                    String kraj1 = outputFormatter.format(endDateTime1);

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
                    String datum1 = scanner.nextLine();

                    System.out.println("Unesite dan:");
                    String dan1 = scanner.nextLine();

                    //Termin termin = new Termin(prostorija1,pocetak1,kraj1,additionalDataTermin1,datum1,dan1); problem oko parsiranja i prostorije
                    //rasporedCLI.obrisiTermin(termin);
                case 5:
                    System.out.println("Unesite podatke o terminu koji zelite da premestite");
                    System.out.println("Unesite prostoriju:");
                    String prostorijaStari = scanner.nextLine();

                    System.out.println("Unesite početak termina:");
                    LocalTime startDateTimeOld = LocalTime.parse(scanner.nextLine(),inputFormatter);
                    String pocetakStari = outputFormatter.format(startDateTimeOld);

                    System.out.println("Unesite kraj termina:");
                    LocalTime endDateTimeOld = LocalTime.parse(scanner.nextLine(),inputFormatter);
                    String krajStari = outputFormatter.format(endDateTimeOld);

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
                    String datumStari = scanner.nextLine();

                    System.out.println("Unesite dan:");
                    String danStari = scanner.nextLine();

                    //Termin terminStari = new Termin(prostorijaStari, pocetakStari,krajStari, additionalDataTerminStari, datumStari, danStari);

                    System.out.println("Unesite podatke o novom terminu na koji zelite da premestite stari termin");
                    System.out.println("Unesite prostoriju:");
                    String prostorijaNovi = scanner.nextLine();

                    System.out.println("Unesite početak termina:");
                    LocalTime startDateTimeNew = LocalTime.parse(scanner.nextLine(),inputFormatter);
                    String pocetakNovi = outputFormatter.format(startDateTimeNew);

                    System.out.println("Unesite kraj termina:");
                    LocalTime endDateTimeNew = LocalTime.parse(scanner.nextLine(),inputFormatter);
                    String krajNovi = outputFormatter.format(endDateTimeNew);

                    Map<String, String> additionalDataTerminNovi = new HashMap<>();
                    System.out.println("Unesite predmet:");
                    additionalDataTerminNovi.put("predmet", scanner.nextLine());

                    System.out.println("Unesite tip:");
                    additionalDataTerminNovi.put("tip", scanner.nextLine());

                    System.out.println("Unesite nastavnika:");
                    additionalDataTerminNovi.put("nastavnik", scanner.nextLine());

                    System.out.println("Unesite grupe koje slušaju predmet:");
                    additionalDataTerminNovi.put("grupe", scanner.nextLine());

                    System.out.println("Unesite datum:");
                    String datumNovi = scanner.nextLine();

                    System.out.println("Unesite dan:");
                    String danNovi = scanner.nextLine();

                    //Termin terminNovi = new Termin(prostorijaNovi, pocetakNovi, krajNovi,additionalDataTerminNovi, datumNovi,danNovi);

                    //rasporedCLI.premestiTermin(terminStari, terminNovi);
                    break;
                case 6:
//                    String putanja = delovi[0];
//                    FormatFajla formatFajla = FormatFajla.valueOf(delovi[1]);
//                    String config = delovi[2];
//                    rasporedCLI.ucitajIzFajla(putanja, formatFajla, config);
//                    System.out.println(rasporedCLI.getTermini());
                    System.out.println("Unesite putanju fajla koji zelite da ucitate");
                    String putanja = scanner.nextLine();

                    System.out.println("Unesite kog formata je taj fajl");
                    FormatFajla formatFajla = FormatFajla.valueOf(scanner.nextLine());
                    System.out.println("Unesite putanju do config fajla");
                    String config = scanner.nextLine();

                    rasporedCLI.ucitajIzFajla(putanja, formatFajla,config);
                    System.out.println(rasporedCLI.getTermini());
                    break;
                case 7:
                    System.out.println("Unesite putanju fajla u koji zelite da snimite");
                    String putanjaSnimi = scanner.nextLine();

                    System.out.println("Unesite format fajla u koji se snima");
                    FormatFajla formatFajlaSnimi = FormatFajla.valueOf(scanner.nextLine());

                    rasporedCLI.snimiUFajl(putanjaSnimi,formatFajlaSnimi);
//                    String putanjaSnimi = delovi[0];
//                    FormatFajla formatFajlaSnimi = FormatFajla.valueOf(delovi[1]);
//                    rasporedCLI.snimiUFajl(putanjaSnimi, formatFajlaSnimi);
                    break;
                case 8:
                    //logika za filtriranje preko komandne linije
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Nevažeća opcija.");
            }
        }
    }
}