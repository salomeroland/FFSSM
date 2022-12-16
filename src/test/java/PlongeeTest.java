
import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
public class PlongeeTest {
     Moniteur president, moniteur;
    Club club;
    Plongee plongee;
    Licence licence1, licence2;
    Plongeur plongeur1, plongeur2;

    @BeforeEach
    protected void setUp() throws Exception {

        club = new Club(president, "Isis", "Castres", "09 87 65 43 26");

        plongeur1 = new Plongeur("123", "ROLAND", "Salomé", "Aramon", "06 43 26 30 10", LocalDate.of(2002,11,2), 2, GroupeSanguin.AMOINS);
        plongeur1.ajouterLicence( "12", LocalDate.of(2019,11,5),club);
        plongeur2 = new Plongeur("145", "BAYOL", "Alexia", "Grammat", "09 87 65 43 21", LocalDate.of(2002,7,23), 2, GroupeSanguin.AMOINS);
        plongeur2.ajouterLicence( "12", LocalDate.of(2021,5,5),club);

        moniteur = new Moniteur("99", "Esatdieu ", "Jean", "castres", "08 08 08 08 08", LocalDate.of(2000,10,19), 2, 1, GroupeSanguin.BPLUS);
        president = new Moniteur("56", "Naji", "Geoffrey", "Carcassonne", "08 09 10 11 12", LocalDate.of(2001,5,2), 2, 1, GroupeSanguin.BPLUS);
        plongee = new Plongee(new Site("Cassis", "Calanques"), moniteur, LocalDate.of(2021,12,5),100,1);
        

    }

    
    @Test
    public void testAjouterParticipant(){
        plongee.ajouteParticipant(plongeur1);
        plongee.ajouteParticipant(plongeur2);
        assertEquals(2, plongee.getPalanquee().size());
    }

    @Test
    public void testPlongeeEstConforme(){
        plongee.ajouteParticipant(plongeur2);
        assertTrue(plongee.estConforme());

        plongee.ajouteParticipant(plongeur1);
        assertFalse(plongee.estConforme());
    }
    
}
