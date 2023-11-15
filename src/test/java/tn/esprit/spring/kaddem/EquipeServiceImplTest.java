package tn.esprit.spring.kaddem;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;
import tn.esprit.spring.kaddem.services.IEquipeService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EquipeServiceImplTest {



    @Autowired

    IEquipeService equipeService;

    @Test
    @Order(1)
    void updateEquipe() {
        Equipe s1= equipeService.retrieveEquipe(1);
        s1.setNomEquipe("equipe3");
        Equipe updatedequipe1= equipeService.updateEquipe(s1);
        assertEquals(s1.getNomEquipe(), updatedequipe1.getNomEquipe());
    }

}
