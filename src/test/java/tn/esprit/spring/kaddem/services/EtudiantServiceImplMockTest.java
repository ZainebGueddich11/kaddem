package tn.esprit.spring.kaddem.services;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.services.entities.Etudiant;
import tn.esprit.spring.kaddem.services.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.services.EtudiantServiceImpl;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static tn.esprit.spring.kaddem.services.entities.Option.GAMIX;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class EtudiantServiceImplMockTest {





        @Mock
        EtudiantRepository etudiantRepository;

        @InjectMocks
        EtudiantServiceImpl etudiantService;




        Etudiant etudiant=new Etudiant(3,"Kabboura","Sirine" ,GAMIX);
@Test
        public void TestRetrieveAllEtudiants()
        {
            when(etudiantRepository.findById(1)).thenReturn(Optional.of(etudiant));
            Etudiant etudiant1=etudiantService.retrieveEtudiant(1);
            Assertions.assertNotNull(etudiant1);
        }
    }


