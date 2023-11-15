package tn.esprit.spring.kaddem;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.kaddem.entities.Universite;

import tn.esprit.spring.kaddem.services.IUniversiteService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitTest {



    @Autowired

    IUniversiteService universiteService;

    @Test
    @Order(1)
    public void TestaddUniversite()
    {
        String nomUniv= "Universite 1";
        Universite universite= new Universite(nomUniv);
        Universite universite1 = universiteService.addUniversite(universite);
        Assertions.assertEquals(universite1.getNomUniv(),universite.getNomUniv());
    }

    @Test
    @Order(2)
    void retrieveAllStocks() {
        List<Universite> universiteList = universiteService.retrieveAllUniversites();
        Assertions.assertNotNull(universiteList);
    }

}