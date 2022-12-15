
import FFSSM.Club;
import FFSSM.GroupeSanguin;
import FFSSM.Licence;
import FFSSM.Moniteur;
import FFSSM.Plongee;
import FFSSM.Plongeur;
import FFSSM.Site;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class ClubTest2 {
    Club lesPlongeuses, clubSansPlongeur;
	    Moniteur presidentAlex, moniteur;
	    Plongeur plongeurVNol, plongeurVMel, plongeurNVMiralles;
	    Plongee plongeNonConforme, plongeConforme;
            
            
             
	    @BeforeEach
	    protected void setUp() throws Exception {
	        //creation president club
	        presidentAlex = new Moniteur("123", "Alexia", "Bayol", "Grammat", "06 78 65 42 31", LocalDate.of(2002, 07, 23), 1, 2, GroupeSanguin.APLUS);
	        //creation club
	        clubSansPlongeur = new Club(presidentAlex, "Le club", "Au fond à gauche", "090987654");
	        lesPlongeuses = new Club(presidentAlex, "Les plongeuses", "Au fond à droite", "12 34 56 78 89" );
	        //creation moniteur
	        moniteur = new Moniteur("123", "ROLAND", "Salomé", "Aramon", "06 43 26 30 10", LocalDate.of(2002, 11, 2), 1, 2, GroupeSanguin.APLUS);
	        //creation plongeurs avec licence valide
	        plongeurVNol = new Plongeur("AZERTY", "LACROIX", "Noelie","Grealoux", "00 00 00 00 00", LocalDate.of(2002 , 02, 7), 1, GroupeSanguin.APLUS);
	        plongeurVNol.ajouterLicence("123", LocalDate.of(2021,9,2), lesPlongeuses);
	        plongeurVMel = new Plongeur("PFOUU", "FERREIRA", "Melia","Rodez", "00 00 00 00 00", LocalDate.of(2003 , 02, 14), 1, GroupeSanguin.APLUS);
	        plongeurVMel.ajouterLicence("123", LocalDate.of(2021,9,2), lesPlongeuses);
	        //creation plongeur sans licence valide
	        plongeurNVMiralles = new Plongeur("QWERTY", "MIRALLES", "Lucas","Carmaux", "00 00 00 00 00", LocalDate.of(2002 , 11, 9), 1, GroupeSanguin.APLUS);
	        plongeurNVMiralles.ajouterLicence("442", LocalDate.of(2020,9,2), lesPlongeuses);
	        //creation d'une plongée non conforme
	        plongeNonConforme = new Plongee(new Site("Porto", "Très beau"), moniteur, LocalDate.of(2021,12,5),100,1);
	        plongeNonConforme.ajouteParticipant(plongeurVNol);
	        plongeNonConforme.ajouteParticipant(plongeurNVMiralles);
	        //création d'une plongée conforme
	        plongeConforme = new Plongee(new Site("Cassis", "Dans les calanques"), moniteur, LocalDate.of(2021,12,5),100,1);
	        plongeConforme.ajouteParticipant(plongeurVNol);
	        plongeConforme.ajouteParticipant(plongeurVMel);
	    }
            
            
             @AfterEach
            
	    protected void tearDown() throws Exception {
	        lesPlongeuses = null;
	        presidentAlex = null;
	        moniteur = null;
	        plongeurNVMiralles = null;
	        plongeurVNol = null;
	        plongeurVMel = null;
	        plongeNonConforme = null;
	        plongeConforme = null;
	    }

            
	    @Test
	    public void testOrganisePlongee(){
	        lesPlongeuses.organisePlongee(plongeConforme);
	        lesPlongeuses.organisePlongee(plongeNonConforme);
	        assertEquals(2, lesPlongeuses.getActivites().size());
	    }

	    @Test
	    public void testDelivreLicence(){
	        clubSansPlongeur.ajouterLicence(new Licence(plongeurVNol, "123", LocalDate.of(2021,9,2), lesPlongeuses));
	        //assertEquals(1, clubSansPlongeur.getLesLicences().size());
	        //3 plongeurs ont une licence dans le club lesPlngeuses (voir setUp)
	        assertEquals(3, lesPlongeuses.getLesLicences().size());
	    }

	    @Test
	    public void testPlongeeNonConforme(){
	        lesPlongeuses.organisePlongee(plongeConforme);
	        lesPlongeuses.organisePlongee(plongeNonConforme);
	        assertEquals(lesPlongeuses.plongeesNonConformes().size(), 1);
	    }

		}

