package tn.esprit.spring.kaddem;



import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static tn.esprit.spring.kaddem.entities.Specialite.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ContractServiceImplTest {

    @Mock
    ContratRepository contratRepository;

    @InjectMocks
    ContratServiceImpl contratService;


    Contrat contrat2 = new Contrat(1,new Date(),new Date(),CLOUD,true,5000);
    Contrat contrat3 = new Contrat(2,new Date(),new Date(),RESEAUX,true,5100);
    Contrat contrat4 = new Contrat(3,new Date(),new Date(),IA,true,5200);

    @Before
    public void setup() {
        List<Contrat> mockContracts = new ArrayList<>();
        when(contratRepository.findAll()).thenReturn(mockContracts);
    }


    @Test
    @Order(1)
    public void testRetrieveAllContrats() {
        List<Contrat> contratsFactices = new ArrayList<>();
        contratsFactices.add(construireUnContratFactice());
        contratsFactices.add(construireUnContratFactice());
        when(contratRepository.findAll()).thenReturn(contratsFactices);
        List<Contrat> result = contratService.retrieveAllContrats();
        Assertions.assertEquals(2, result.size()); // Changez 0 à 2 pour correspondre au nombre de contrats factices.
    }

    private Contrat construireUnContratFactice() {
        Date d1 = new Date();
        Date d2 = new Date();
        return new Contrat(d1, d2, CLOUD, true, 5000);
    }

    @Test
    @Order(2)
    public void testRetrieveContrat() {
        when(contratRepository.findById(1)).thenReturn(Optional.of(construireUnContratFactice()));
        Contrat contrat = contratService.retrieveContrat(1);
        Assertions.assertNotNull(contrat);

    }


    @Test
    @Order(3)
    public void testAddContrat() {
        Contrat contratFactice = construireUnContratFactice();
        when(contratRepository.save(Mockito.any(Contrat.class))).thenReturn(contratFactice);
        Contrat contratAjoute = contratService.addContrat(contratFactice);
        Assertions.assertEquals(contratFactice, contratAjoute);
    }



}
