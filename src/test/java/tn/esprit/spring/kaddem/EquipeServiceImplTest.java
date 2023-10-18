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
    public void TestRetrieveAllEquipe()
    {
        List<Equipe> equipes = equipeService.retrieveAllEquipes();
        Assertions.assertEquals(1,equipes.size());
    }
    @Test
    @Order(2)
    public void TestaddEquipe()
    {
       String nomEquipe= "equipe 1";
      Equipe eq= new Equipe(nomEquipe, Niveau.EXPERT);
      Equipe eqAddded = equipeService.addEquipe(eq);
      Assertions.assertEquals(eq.getNomEquipe(),eq.getNiveau());
    }
    @Test
    @Order(3)
    public void testDeleteUser()
    {
        equipeService.deleteEquipe(1);
        Assertions.assertNull(equipeService.retrieveEquipe(1));
    }
}
