package backend.restservices.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Data transfer object
 */
/*
public record PersonDto (int id, String name, String lastname, String zipcode, String city, String color){ }
*/

@AllArgsConstructor
@Data
public class PersonDto implements Serializable {
    private int id;
    private String name;

    private String lastname;

    private String zipcode;

    private String city;

    private String color;
};

