package Serialization;

import SK_Specification_Matic_Zivanovic.RasporedWrapper;
import model.Prostorija;
import model.Termin;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;


import javax.swing.text.DateFormatter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.*;
import java.util.List;
import java.util.Map;

public class SaveLoadScheduleCSV {

    public final RasporedWrapper rw;

    public SaveLoadScheduleCSV(RasporedWrapper rw) {
        this.rw = rw;
    }

    public boolean exportData(String path) throws IOException{
        System.out.println("ddddddddddddddddddddddddddd");
        writeData(path);
        return true;
    }

    public boolean loadFile(String putanja, String configPath) throws IOException {

        loadApache(putanja, configPath);
        return true;
    }
    public void loadApache(String filePath, String configPath) throws IOException {
        List<ConfigMapping> columnMappings = readConfig(configPath);
        Map<Integer, String> mappings = new HashMap<>();
        //LocalTime endDateTime = null;
        for(ConfigMapping configMapping : columnMappings) {
            mappings.put(configMapping.getIndex(), configMapping.getOriginal());
        }

        FileReader fileReader = new FileReader(filePath);
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader);

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern(mappings.get(-1));
        DateTimeFormatter inputFormatterStart = new DateTimeFormatterBuilder()
                .appendPattern("HH:mm")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT);
        DateTimeFormatter inputFormatterEnd = new DateTimeFormatterBuilder()
                .appendPattern("HH")
                .toFormatter()
                .withResolverStyle(ResolverStyle.STRICT);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(mappings.get(-2));

        for (CSVRecord record : parser) {
            Termin appointment = new Termin();

            for (ConfigMapping entry : columnMappings) {
                int columnIndex = entry.getIndex();

                if(columnIndex == -1) continue;

                String columnName = entry.getCustom();

                switch (mappings.get(columnIndex)) {
                    case "prostorija":
                        String [] split2 = record.get(columnIndex).split("",2);
                        String identifikator = split2[0];
                        String additionalData = split2[1];
                        appointment.setProstorija(new Prostorija(identifikator, additionalData));
                        break;
                    case "pocetak":
                        String[] split = record.get(columnIndex).split("-", 2);
                        LocalTime startDateTime = LocalTime.parse(split[0], inputFormatterStart);
                        //endDateTime = LocalTime.parse(split[1], inputFormatterEnd);
                        String formattedStartTime = outputFormatter.format(startDateTime);
                        appointment.setPocetak(LocalTime.parse(formattedStartTime, outputFormatter));
                        //String[] split1 = record.get(columnIndex).split("-", 2);
                        LocalTime endDateTime = LocalTime.parse(split[1], inputFormatterEnd);
                        String formattedEndTime = outputFormatter.format(endDateTime);
                        appointment.setKraj(LocalTime.parse(formattedEndTime, outputFormatter));
                        //System.out.println("Pocetak: " + appointment.getPocetak() + " Kraj: " + appointment.getKraj());
                        break;
 //                   case "kraj":
//                        String[] split1 = record.get(columnIndex).split("-", 2);
//                        LocalTime endDateTime = LocalTime.parse(split1[0], inputFormatterEnd);
//                        String formattedEndTime = outputFormatter.format(endDateTime);
//                        appointment.setKraj(LocalTime.parse(formattedEndTime, outputFormatter));
 //                       break;
//                    case "datum":
//                        LocalDate datum = LocalDate.parse(record.get(columnIndex), formatter);
//                        appointment.setDatum(datum);
//                        break;
                    case "dan":
                        String tab = record.get(columnIndex);
                        tab = tab.replaceAll("[ \\t\\n\\x0B\\f\\r\\u00A0\\u2028\\u2029]+","");
                        appointment.setDan(tab);
                        break;
                    case "additionalData":
                        appointment.getAdditionalData().put(columnName, record.get(columnIndex));
                        break;
                }
            }
            rw.getTermini().add(appointment);
        }
    }

    private static List<ConfigMapping>  readConfig(String filePath) throws FileNotFoundException{
        List<ConfigMapping> mappings = new ArrayList<>();

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] splitLine = line.split(" ", 3);

            mappings.add(new ConfigMapping(Integer.valueOf(splitLine[0]), splitLine[1], splitLine[2]));
        }

        scanner.close();


        return mappings;
    }
    private void writeData(String path) throws IOException {
        // Create a FileWriter and CSVPrinter
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeee");
        FileWriter fileWriter = new FileWriter(path);
        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);

        for (Termin appointment : rw.getTermini()) {
            System.out.println("fffffffffffffffffffffffffffff");
            csvPrinter.printRecord(
                    appointment.getPocetak(),
                    appointment.getKraj(),
                    appointment.getDan(),
                    appointment.getDatum(),
                    appointment.getProstorija(),
                    appointment.getAdditionalData()
            );
        }

        csvPrinter.close();
        fileWriter.close();
    }
}
