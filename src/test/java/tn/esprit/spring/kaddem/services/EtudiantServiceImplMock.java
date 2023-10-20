package tn.esprit.spring.kaddem.services;
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
import tn.esprit.spring.kaddem.services.entities.Etudiant;
import tn.esprit.spring.kaddem.services.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.services.EtudiantServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static tn.esprit.spring.kaddem.services.entities.Option.GAMIX;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class EtudiantServiceImplMock {





        @Mock
        EtudiantRepository etudiantRepository;

        @InjectMocks
        EtudiantServiceImpl etudiantService;


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
        Etudiant etudiant=new Etudiant(3,"Kabboura","Sirine" ,GAMIX);

        @Test
        public void TestRetrieveAllContrats()
        {
            Mockito.when(etudiantRepository.findById((int) Mockito.anyLong())).thenReturn(Optional.ofNullable(etudiant));
            Etudiant etudiant1=etudiantService.retrieveEtudiant(2);
            Assertions.assertNotNull(etudiant1);
        }
    }


