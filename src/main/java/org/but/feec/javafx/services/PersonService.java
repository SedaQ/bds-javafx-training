package org.but.feec.javafx.services;

import org.but.feec.javafx.api.PersonBasicView;
import org.but.feec.javafx.data.PersonRepository;

import java.util.List;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonBasicView> getPersonsBasicView() {
        return personRepository.getPersonsBasicView();
    }
}
