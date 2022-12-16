
import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Moniteur;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author salom
 */
public class MoniteurTest {
    Moniteur president, moniteur;
    Club club, club1;
    

    @BeforeEach
    public void setUp() throws Exception {
        moniteur = new Moniteur("578", "Naji", "Geoffrey", "Carcassonne", "01 23 45 67 89", LocalDate.of(2001,05,2), 2, 1, GroupeSanguin.BPLUS);
        president = new Moniteur("693", "Leroy", "Guillaume", "Montpellier", "06 86 54 32 47", LocalDate.of(2002,07,15), 2, 1, GroupeSanguin.BPLUS);
        
        club = new Club(president, "Isis", "Castres", "01 01 01 01 01");
        club1 = new Club(president, "JSG", "Grammat", "000 000 000");

    }
    
    @AfterEach
    public void tearDown() throws Exception {
        
    }
   
    
     @Test
    public void testNouvelleEmbauche(){
        //pas d'embauche
        assertTrue(moniteur.employeurActuel().isEmpty());

        //ajout d'une embauche
        moniteur.nouvelleEmbauche(club, LocalDate.of(2020, 12, 7));
        assertEquals(moniteur.employeurActuel().orElseThrow(), club );

        //on verifie que l'employeur actuel correspond bien a la nouvell emebauche qu'on vient de creer
        moniteur.nouvelleEmbauche(club1, LocalDate.of(2020, 12, 7));
        assertEquals(moniteur.employeurActuel().orElseThrow(), club1 );
    }

    @Test
    public void testTerminerEmbauche(){
        moniteur.nouvelleEmbauche(club, LocalDate.of(2020, 12, 7));
        moniteur.terminerEmbauche(LocalDate.of(2021, 12, 7));
        assertTrue(moniteur.employeurActuel().isEmpty());
    }

}
