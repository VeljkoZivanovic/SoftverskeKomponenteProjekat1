package Implementation;

import SK_Specification_Matic_Zivanovic.RasporedWrapper;
import model.Termin;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Termin termin = new Termin("RG1", LocalTime.of(9,15), LocalTime.of(11,0),"101, Milan Tomic, Genetski Algoritmi", LocalDate.of(2023,11,17), "Petak");
        RasporedWrapper rw = new PrvaImplementacija();
        rw.inicijalizacija();
        rw.getTermini().add(termin);
        System.out.println(rw.getTermini().toString());
    }
}