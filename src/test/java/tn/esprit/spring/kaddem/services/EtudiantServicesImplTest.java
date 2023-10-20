package tn.esprit.spring.kaddem.services;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.services.entities.Etudiant;
import tn.esprit.spring.kaddem.services.entities.Option;
import tn.esprit.spring.kaddem.services.services.IEtudiantService;


import java.util.List;

import static tn.esprit.spring.kaddem.services.entities.Option.GAMIX;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EtudiantServicesImplTest {

    @Autowired
    IEtudiantService EtudiantServiceImpl;

    @Test
    @Order(1)
    public void TestRetrieveAllEtudiants()
    {
        List<Etudiant> contrats = EtudiantServiceImpl.retrieveAllEtudiants();
        Assertions.assertEquals(1,contrats.size());
    }

    @Test
    @Order(2)
    public void testAddEtudiant()
    {
        Etudiant etudiant=new Etudiant(99,"Kabboura","Sirine" ,GAMIX);
        Etudiant etudiant1= EtudiantServiceImpl.addEtudiant(etudiant);
        Assertions.assertEquals(etudiant.getNomE(),etudiant1.getNomE());
    }


}