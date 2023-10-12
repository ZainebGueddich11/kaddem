package tn.esprit.spring.kaddem;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.services.IContratService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static tn.esprit.spring.kaddem.entities.Specialite.CLOUD;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ContratServiceImplTest {
    @Autowired
    IContratService contratService;

    @Test
    @Order(1)
    public void TestRetrieveAllContrats()
    {
        List<Contrat> contrats = contratService.retrieveAllContrats();
        Assertions.assertEquals(1,1);
    }

    @Test
    @Order(2)
    public void TestAddContract() throws ParseException {
        Date d1 = new Date();
        Date d2 = new Date();
        Contrat contrat=new Contrat(d1,d2,CLOUD,true,5000);
        Contrat contrat1=contratService.addContrat(contrat);
        Assertions.assertEquals(contrat.getArchive(),contrat1.getArchive());
    }




}
