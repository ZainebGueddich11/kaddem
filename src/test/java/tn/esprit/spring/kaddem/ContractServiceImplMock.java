package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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

import static tn.esprit.spring.kaddem.entities.Specialite.CLOUD;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ContractServiceImplMock {

    @Mock
    ContratRepository contratRepository;

    @InjectMocks
    ContratServiceImpl contratService;


    /*Contrat contrat2=new Contrat(new Date(),new Date(),CLOUD,false,5600);
    Contrat contrat3=new Contrat(new Date(),new Date(),CLOUD,true,5700);
    List<Contrat> contratList = new ArrayList<Contrat>()
    {


        @Override
        public void add(int index, Contrat element) {
            super.add(index, contrat2);
            super.add(index, contrat3);
        }
    };
*/
    Contrat contrat2 = new Contrat(1,new Date(),new Date(),CLOUD,true,5000);

    @Test
    public void TestRetrieveAllContrats()
    {
        Mockito.when(contratRepository.findByIdContrat(Mockito.anyInt())).thenReturn(contrat2);
        Contrat contrat = contratService.retrieveContrat(1);
        Assertions.assertNotNull(contrat);
    }
}
