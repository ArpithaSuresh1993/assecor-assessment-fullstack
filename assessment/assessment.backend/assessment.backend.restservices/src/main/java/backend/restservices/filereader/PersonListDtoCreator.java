package backend.restservices.filereader;

import backend.restservices.dtos.PersonDto;
import backend.models.Color;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Creates PersonDto[] after reading the data in the file provided
 *
 */

@ApplicationScoped
public class PersonListDtoCreator {

    public static final int ZIP_CODE_SIZE = 5;

    private  List<PersonDto> readFile()
    {
        CsvFileReader csvFileReader = new CsvFileReader();
        List<PersonDto> people = new ArrayList<>();
        List<String> lines = csvFileReader.readLines("sample-input.csv");
        lines.forEach(line -> {
            String[] entry = line.split(",");
            if (entry.length == 4) {
                entry[2] = entry[2].trim();
                String zipCode = entry[2].substring(0, ZIP_CODE_SIZE);
                String city = entry[2].substring(ZIP_CODE_SIZE + 1);
                people.add(new PersonDto(people.size() + 1, entry[0].trim(), entry[1].trim(), zipCode, city, Color.byOrdinal(Integer.parseInt(entry[3].trim()))));
            } else {
                Logger.getLogger(getClass().getName()).log(Level.WARNING, "Incorrect entry in CSV file skipping line: " + line);
            }

        });
        return people;
    }

    public List<PersonDto> getAllPeople()
    {
        return this.readFile();
    }

}

