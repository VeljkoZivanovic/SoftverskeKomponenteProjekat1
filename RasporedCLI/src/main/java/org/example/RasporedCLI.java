package org.example;

import Implementation.PrvaImplementacija;
import SK_Specification_Matic_Zivanovic.RasporedWrapper;
import exception.NePostojiProstorija;
import exception.ProstorijaVecPostoji;

import java.util.Scanner;

public class RasporedCLI extends PrvaImplementacija {

    public void main(String[] args) throws ProstorijaVecPostoji, NePostojiProstorija {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Izaberite opciju: 1) Dodaj prostoriju 2) Izbrisi prostoriju " +
                                "3) Dodaj termin 4) Obrisi termin 5) Premesti termin" +
                                 "6) Ucitaj iz fajla  7)Snimi u fajl 8)Filtriraj 9) Izlaz");
            int opcija = scanner.nextInt();
            String linija = scanner.nextLine();
            String [] delovi = linija.split(" ");

            switch (opcija) {
                case 1:
                    if(delovi.length == 2) {
                        String identifikator = delovi[0];
                        String additionalData = delovi[1];
                        super.dodajProstoriju(identifikator, additionalData);
                    }else System.out.println("Nije uneta prostorija u pravom obliku.(identifikator additionalData)");
                    break;
                case 2:
                    String identifikator = delovi[0];
                    super.obrisiProstoriju(identifikator);
                    break;
                case 3:
                    System.out.println("Unesite redom: pocetak, kraj, prostorija, datum, dan ");
                    String pocetak = delovi[0];//U terminu definisano kao Lokaltime mzd ce biti problema
                    String kraj = delovi[1];//u terminu definisano kao lokaltime mzd ce biti problema
                    String prostorija = delovi[2];
                    String datum = delovi[3];//u terminu definisano kao lokaldate
                    String dan = delovi[4];
                    //dodati za additional data
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Nevažeća opcija.");
            }
        }
    }
}