package tn.esprit.spring.kaddem;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.services.IDepartementService;

import java.util.List;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentJUnitTest {


        @Autowired

        IDepartementService departementService;

        @Test
        @Order(1)
        public void TestaddDepartment()
        {
            String nomDepartement= "departement";
            Departement dep= new Departement(nomDepartement);
            Departement depAddded = departementService.addDepartement(dep);
            Assertions.assertEquals(depAddded.getNomDepart(),dep.getNomDepart());
        }

        @Test
        @Order(2)
        void retrieveAllStocks() {
            List<Departement> listdepartement = departementService.retrieveAllDepartements();
            Assertions.assertNotNull(listdepartement);
        }

    }

