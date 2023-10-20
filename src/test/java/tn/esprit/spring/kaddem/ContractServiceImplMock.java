package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static tn.esprit.spring.kaddem.entities.Specialite.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ContractServiceImplMock {

    @Mock
    ContratRepository contratRepository;

    @InjectMocks
    ContratServiceImpl contratService;

    Contrat contrat2 = new Contrat(1,new Date(),new Date(),CLOUD,true,5000);
    Contrat contrat3 = new Contrat(2,new Date(),new Date(),RESEAUX,true,5100);
    Contrat contrat4 = new Contrat(3,new Date(),new Date(),IA,true,5200);


    @Test
    public void TestRetrieveAllContrats()
    {
        List<Contrat> contratsFactices = new ArrayList<>();
        Mockito.when(contratService.retrieveAllContrats()).thenReturn(contratsFactices);

        // Appelez la méthode que vous testez
        List<Contrat> result = contratService.retrieveAllContrats();

        // Vérifiez les assertions pour vous assurer que le comportement est conforme à vos attentes
        // Exemple : vérifiez la taille de la liste
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void testRetrieveContrat() {

        Mockito.when(contratRepository.findById(1)).thenReturn(Optional.of(contrat2));
        Contrat contrat = contratService.retrieveContrat(1);
        Assertions.assertNotNull(contrat);
    }


}
