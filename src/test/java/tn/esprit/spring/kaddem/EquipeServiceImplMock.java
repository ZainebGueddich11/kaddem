package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)

public class EquipeServiceImplMock {
    @Mock
    EquipeRepository eqRep;
    @InjectMocks
    EquipeServiceImpl equipeService;
    Equipe equipe = new Equipe(1, "equipe2", Niveau.SENIOR);
    List<Equipe> equipes = new ArrayList<Equipe>() {
        {
            add(new Equipe(2, "equipe 3", Niveau.EXPERT));
            add(new Equipe(3, "equipe 4", Niveau.JUNIOR));

        }
    };

    @Test
    @Order(1)
    public void testRetrieveAllEquipes() {
        // Create a list of Equipe objects you expect to be returned by the repository.
        List<Equipe> expectedEquipes = equipes;

        // Mock the behavior of the repository when the findAll method is called.
        when(eqRep.findAll()).thenReturn(expectedEquipes);

        // Call the method you want to test.
        List<Equipe> retrievedEquipes = equipeService.retrieveAllEquipes();
        System.out.println("Retrieved Equipes:");
        for (Equipe equipe : expectedEquipes) {
            System.out.println(equipe);
        }

        // Assert that the retrievedEquipes list matches the expectedEquipes list.
        Assertions.assertEquals(expectedEquipes, retrievedEquipes);
    }

    @Test
    @Order(2)
    public void testRetrieveEquipe() {
        when(eqRep.findById(2)).thenReturn(Optional.of(equipe));
        Equipe equipe1 = equipeService.retrieveEquipe(1);
        Assertions.assertNotNull(equipe1);
    }
    @Test
    @Order(3)
    public void testAddEquipe() {
        // Create a new Equipe object to add.
        Equipe newEquipe = new Equipe(4, "Nouvelle Equipe", Niveau.JUNIOR);

        // Mock the behavior of the repository when the save method is called.
        when(eqRep.save(newEquipe)).thenReturn(newEquipe);

        // Call the method you want to test.
        Equipe addedEquipe = equipeService.addEquipe(newEquipe);

        // Assert that the addedEquipe matches the newEquipe.
        Assertions.assertEquals(newEquipe, addedEquipe);
    }
    @Test
    @Order(4)
    public void testDeleteEquipe() {
        // Mock the behavior of the repository when the deleteById method is called.
        when(eqRep.existsById(1)).thenReturn(true); // Assuming the equipe with ID 1 exists.

        // Call the method you want to test.
        equipeService.deleteEquipe(1);

        // Verify that the delete operation was called on the repository.
        verify(eqRep, times(1)).deleteById(1);
    }

    @Test
    @Order(5)
    public void testUpdateEquipe() {
        // Créez un objet Equipe avec les nouvelles informations.
        Equipe updatedEquipe = new Equipe(1, "Equipe Mise à Jour", Niveau.JUNIOR);

        // Appelez la méthode que vous souhaitez tester.
        Equipe result = equipeService.updateEquipe(updatedEquipe);

        // Utilisez verify pour vérifier que la méthode save est appelée avec les bonnes informations.
        verify(eqRep).save(updatedEquipe);

        // Assurez-vous que la méthode renvoie la nouvelle équipe mise à jour.
        Assertions.assertEquals(updatedEquipe, result);
    }


}
