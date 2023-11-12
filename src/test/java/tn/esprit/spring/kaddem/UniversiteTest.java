package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class UniversiteTest {
    @Mock
    UniversiteRepository unrep;
    @InjectMocks
    UniversiteServiceImpl UniversiteService;
    Universite universite = new Universite(1, "espritt");
    List<Universite> universites = new ArrayList<Universite>() {
        {
            add(new Universite(2, "esp 3"));
            add(new Universite(2, "esp 4"));

        }
    };

    @Test
    @Order(1)
    public void testRetrieveAllUniversite() {
        // Create a list of Equipe objects you expect to be returned by the repository.
        List<Universite> expectedUniversities = universites;

        // Mock the behavior of the repository when the findAll method is called.
        when(unrep.findAll()).thenReturn(expectedUniversities);

        // Call the method you want to test.
        List<Universite> retrievedUniversite = UniversiteService.retrieveAllUniversites();
        System.out.println("Retrieved Universites:");
        for (Universite universite1 : expectedUniversities) {
            System.out.println(universite1);
        }

        // Assert that the retrievedEquipes list matches the expectedEquipes list.
        Assertions.assertEquals(expectedUniversities, retrievedUniversite);
    }

    @Test
    @Order(2)
    public void testRetrieveUniversite() {
        when(unrep.findById(1)).thenReturn(Optional.of(universite));
        Universite universite1 = UniversiteService.retrieveUniversite(1);
        Assertions.assertNotNull(universite1);
    }

}
