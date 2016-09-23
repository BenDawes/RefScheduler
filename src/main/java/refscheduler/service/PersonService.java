package refscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import refscheduler.util.DozerMapper;
import refscheduler.domain.Level;
import refscheduler.domain.PersonCreate;
import refscheduler.domain.PersonGet;
import refscheduler.entity.PersonEntity;
import refscheduler.repository.PersonRepository;

/**
 * Person service.
 */
@Service("personService")
public class PersonService {

    @Autowired
    private DozerMapper mapper;

    @Autowired
    private PersonRepository personRepository;

    public PersonGet getPerson(final Long personId) {
        final PersonEntity entity = personRepository.findOne(personId);

        return mapper.map(entity, PersonGet.class);
    }

    @Transactional
    public Long createPerson(final PersonCreate personCreate) {
        final PersonEntity person = new PersonEntity();

        person.setFirstName(personCreate.getFirstName());
        person.setLastName(personCreate.getLastName());
        person.setEmailAddress(personCreate.getEmailAddress());
        person.setHeadRefereeLevel(personCreate.getHeadRefereeLevel() == null ? Level.LEVEL_5 : personCreate.getHeadRefereeLevel());
        person.setAssistantRefereeLevel(personCreate.getAssistantRefereeLevel() == null ? Level.LEVEL_5 : personCreate.getAssistantRefereeLevel());
        person.setSnitchRefereeLevel(personCreate.getSnitchRefereeLevel() == null ? Level.LEVEL_5 : personCreate.getSnitchRefereeLevel());

        personRepository.save(person);

        return person.getPersonId();
    }
}
