package tn.esprit.spring.kaddem;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class EquipeServiceImplMockTest {
    @Mock
    EquipeRepository eqRep;
    @InjectMocks
    EquipeServiceImpl equipeService;
    Equipe equipe = new Equipe(1, "equipe2", Niveau.SENIOR);
    List<Equipe> equipes = new ArrayList<Equipe>() {
        {
            add(new Equipe(2, "equ 01", Niveau.EXPERT));
            add(new Equipe(3, "equ 02", Niveau.JUNIOR));

        }
    };


    @Test

    void updatedequipe() {

        Mockito.when(eqRep.findById(equipe.getIdEquipe())).thenReturn(Optional.of(equipe));
        Equipe equipe1 = equipeService.retrieveEquipe(equipe.getIdEquipe());
        equipe1.setNomEquipe("equipe3");
        Mockito.when(eqRep.save(equipe1)).thenReturn(equipe1);
        Assertions.assertEquals(equipe1.getNomEquipe(), equipeService.updateEquipe(equipe1).getNomEquipe());
    }
}
