package backend.restservices;

import backend.restservices.dtos.PersonDto;
import backend.restservices.filereader.PersonListDtoCreator;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;


/**
 * Implementation of REST interface
 */
public class FavouriteColourResource implements FavouriteColourResourceIf{

    @Inject
    private PersonListDtoCreator personListDtoCreator;

    @Override
    public Response getAllPeople() {

        try
        {
            personListDtoCreator = new PersonListDtoCreator();
            List<PersonDto> people = personListDtoCreator.getAllPeople();
            return Response.status(Response.Status.OK).entity(people).build();
        }catch (Exception aException)
        {
            return Response.serverError().entity("Error: " + aException.getMessage()).build();
        }
    }

    @Override
    public Response getPersonById(int aId) {
        try
        {
            personListDtoCreator = new PersonListDtoCreator();
            PersonDto identifiedPerson = null;
            for (PersonDto person : personListDtoCreator.getAllPeople()) {
                if (person.getId() == aId){
                    identifiedPerson = person;
                }
            }
            return Response.status(Response.Status.OK).entity(identifiedPerson).build();
        }catch (Exception aException)
        {
            return Response.serverError().entity("Error: " + aException.getMessage()).build();
        }
    }

    @Override
     public Response getPeopleWhoLoveTheSameColor(String aColor) {
        try
        {
            personListDtoCreator = new PersonListDtoCreator();
            List<PersonDto> people = new ArrayList<>();
            for (PersonDto person : personListDtoCreator.getAllPeople()) {
                if (person.getColor().equalsIgnoreCase(aColor)){
                    people.add(person);
                }
            }
            return Response.status(Response.Status.OK).entity(people).build();
        }catch (Exception aException)
        {
            return Response.serverError().entity("Error: " + aException.getMessage()).build();
        }
    }
}
