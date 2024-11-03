package com.betrybe.agrix.solution;

import static com.betrybe.agrix.ebytr.staff.security.Role.USER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

/**
 * The type Person service test.
 */
@SpringBootTest
@ActiveProfiles("test")
public class PersonServiceTest {

  /**
   * The Person service.
   */
  @Autowired
  PersonService personService;

  /**
   * The Person repository.
   */
  @MockBean
  PersonRepository personRepository;

  /**
   * Test get person by id.
   */
  @Test
  @DisplayName("Verifica que o método getPersonById retorna objeto do tipo Person caso encontrado.")
  public void testGetPersonById() {
    Person mockPerson = new Person();
    mockPerson.setId(111L);
    mockPerson.setUsername("mockPersonPersistant");
    mockPerson.setRole(USER);
    mockPerson.setPassword("verySafePassword");

    Mockito.when(personRepository.findById(eq(111L)))
        .thenReturn(Optional.of(mockPerson));

    Person returnedPerson = personService.getPersonById(111L);

    Mockito.verify(personRepository).findById(111L);

    assertEquals(returnedPerson.getId(), mockPerson.getId());
    assertEquals(returnedPerson.getUsername(), mockPerson.getUsername());
    assertEquals(returnedPerson.getRole(), mockPerson.getRole());
  }

  /**
   * Test get person by username.
   */
  @Test
  @DisplayName(
      "Verifica que o método getPersonByUsername retorna objeto do tipo Person caso encontrado."
  )
  public void testGetPersonByUsername() {
    Person mockPerson = new Person();
    mockPerson.setId(111L);
    mockPerson.setUsername("mockPersonPersistant");
    mockPerson.setRole(USER);
    mockPerson.setPassword("verySafePassword");

    Mockito.when(personRepository.findByUsername("mockPersonPersistant"))
        .thenReturn(Optional.of(mockPerson));

    Person returnedPerson = personService.getPersonByUsername("mockPersonPersistant");

    Mockito.verify(personRepository).findByUsername("mockPersonPersistant");

    assertEquals(returnedPerson.getId(), mockPerson.getId());
    assertEquals(returnedPerson.getUsername(), mockPerson.getUsername());
    assertEquals(returnedPerson.getRole(), mockPerson.getRole());
  }

  /**
   * Test create person.
   */
  @Test
  @DisplayName(
      "Verifica que o método create salva e retorna o objeto do tipo Person."
  )
  public void testCreatePerson() {
    Person mockPerson = new Person();
    mockPerson.setUsername("mockPersonPersistant");
    mockPerson.setRole(USER);
    mockPerson.setPassword("verySafePassword");

    Person personToReturn = new Person();
    personToReturn.setId(1L);
    personToReturn.setUsername(mockPerson.getUsername());
    personToReturn.setRole(mockPerson.getRole());
    personToReturn.setPassword(mockPerson.getPassword());

    Mockito.when(personRepository.save(any()))
        .thenReturn(personToReturn);

    Person savedPerson = personService.create(mockPerson);

    Mockito.verify(personRepository).save(any());
    assertEquals(1L, savedPerson.getId());
    assertEquals(mockPerson.getUsername(), savedPerson.getUsername());
    assertEquals(mockPerson.getRole(), savedPerson.getRole());
  }
}
