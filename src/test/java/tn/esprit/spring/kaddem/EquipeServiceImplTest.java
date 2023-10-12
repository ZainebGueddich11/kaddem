package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.services.IEquipeService;

import java.util.List;

@SpringBootTest
public class EquipeServiceImplTest {
    @Autowired
    IEquipeService equipeService;
    @Test
    public void TestRetrieveAllEquipe()
    {
        List<Equipe> equipes = equipeService.retrieveAllEquipes();
        Assertions.assertEquals(1,equipes.size());
    }
    @Test
    public void TestaddEquipe()
    {
       String nomEquipe= "equipe 1";
      Equipe eq= new Equipe(nomEquipe, Niveau.EXPERT);
      Equipe eqAddded = equipeService.addEquipe(eq);
      Assertions.assertEquals(eq.getNomEquipe(),eq.getNiveau());
    }

}
