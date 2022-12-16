
import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongeur;
import java.time.LocalDate;
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
public class LicenceTest {
    Moniteur president;
    Club club;
    Plongeur plongeur;
    Licence licenceValide, licenceNonValide;
    
     @BeforeEach
    protected void setUp() throws Exception {
        president = new Moniteur("4567", "Pellegrin", "Leo", "AIx", "0874361845", LocalDate.of(2002,12,5), 2, 1, GroupeSanguin.BPLUS);
        club = new Club(president, "Isis", "Castres", "08 07 56 45 32");
        plongeur = new Plongeur("123", "Estadieu", "Jean", "Toulouse", "04 66 54 34 55", LocalDate.of(2000,10,19), 2, GroupeSanguin.AMOINS);
        licenceValide = new Licence(plongeur, "12", LocalDate.of(2021,5,5),club);
        licenceNonValide = new Licence(plongeur, "12", LocalDate.of(2018,5,5),club);
}
    
     @Test
    public void testLicenceValide(){
        assertFalse(licenceNonValide.estValide(LocalDate.of(2020,6,6)));
        assertTrue(licenceValide.estValide(LocalDate.of(2021,6,6)));
    }
}
