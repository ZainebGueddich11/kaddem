package tn.esprit.spring.kaddem;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.services.IEquipeService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EquipeServiceImplTest {
   @Autowired
    IEquipeService equipeService;

    @Test
    @Order(1)
    public void TestaddEquipe()
    {
       String nomEquipe= "equipe 1";
      Equipe eq= new Equipe(nomEquipe, Niveau.EXPERT);
      Equipe eqAddded = equipeService.addEquipe(eq);
      Assertions.assertEquals(eqAddded.getNiveau(),eq.getNiveau());
    }

}
