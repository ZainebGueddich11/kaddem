package tn.esprit.spring.kaddem;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.services.DepartementServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class DepartementServiceImplMockTest {
    @Mock
    DepartementRepository depRep;
    @InjectMocks
    DepartementServiceImpl depService;
    Departement departement = new Departement(1, "info");
    List<Departement> departements = new ArrayList<Departement>() {
        {
            add(new Departement(2, "Finance"));
            add(new Departement(3, "Mechanique"));


        }
    };
    @Test
    @Order(1)
    public void testRetrieveAllDepartements() {
        // Create a list of Departement objects you expect to be returned by the repository.
        List<Departement> expectedDepartement = departements;

        // Mock the behavior of the repository when the findAll method is called.
        when(depRep.findAll()).thenReturn(expectedDepartement);

        // Call the method you want to test.
        List<Departement> retrievedDepartement = depService.retrieveAllDepartements();
        System.out.println("Retrieved Departement:");
        for (Departement departement1 : expectedDepartement) {
            System.out.println(departement1);
        }

        // Assert that the retrievedDepartement list matches the expectedDepartement list.
        Assertions.assertEquals(expectedDepartement, retrievedDepartement);
    }
    @Test
    @Order(2)
    public void testRetrieveDepartement() {
        when(depRep.findById(1)).thenReturn(Optional.of(departement));
        Departement departement1 = depService.retrieveDepartement(1);
        Assertions.assertNotNull(departement1);
    }
}
