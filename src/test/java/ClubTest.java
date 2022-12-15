
package FFSSM; 


import FFSSM.Club;
import java.time.LocalDate;
import java.timeLocalDate;


class ClubTest {

	 Club lesPlongeuses, clubSansPlongeur;
	    Moniteur president, moniteur;
	    Plongeur plongeurLValide1, plongeurLValide2, plongeurLNonValide;
	    Plongee plongeNonConforme, plongeConforme;

	    
	    @Before
	    protected void setUp() throws Exception {
	        //creation president club
	        president = new Moniteur("123", "Alexia", "Bayol", "Grammat", "06 78 65 42 31", LocalDate.of(2002, 07, 23), 1, 2, GroupeSanguin.APLUS);
	        //creation club
	        clubSansPlongeur = new Club(president, "Le club", "Au fond à gauche", "090987654");
	        lesPlongeuses = new Club(president, "Les plongeurs fous", "Au fond à droite", "12 34 56 78 89" );
	        //creation moniteur
	        moniteur = new Moniteur("123", "ROLAND", "Salomé", "Aramon", "06 43 26 30 10", LocalDate.of(2002, 11, 2), 1, 2, GroupeSanguin.APLUS);
	        //creation plongeurs avec licence valide
	        plongeurLValide1 = new Plongeur("AZERTY", "LACROIX", "Noelie","Grealoux", "00 00 00 00 00", LocalDate.of(2002 , 02, 7), 1, GroupeSanguin.APLUS);
	        plongeurLValide1.ajouterLicence("123", LocalDate.of(2021,9,2), lesPlongeuses);
	        plongeurLValide2 = new Plongeur("PFOUU", "FERREIRA", "Melia","Rodez", "00 00 00 00 00", LocalDate.of(2003 , 02, 14), 1, GroupeSanguin.APLUS);
	        plongeurLValide2.ajouterLicence("123", LocalDate.of(2021,9,2), lesPlongeuses);
	        //creation plongeur sans licence valide
	        plongeurLNonValide = new Plongeur("QWERTY", "MIRALLES", "Lucas","Carmaux", "00 00 00 00 00", LocalDate.of(2002 , 11, 9), 1, GroupeSanguin.APLUS);
	        plongeurLNonValide.ajouterLicence("442", LocalDate.of(2020,9,2), lesPlongeuses);
	        //creation d'une plongée non conforme
	        plongeNonConforme = new Plongee(new Site("Porto", "Très beau"), moniteur, LocalDate.of(2021,12,5),100,1);
	        plongeNonConforme.ajouteParticipant(plongeurLValide1);
	        plongeNonConforme.ajouteParticipant(plongeurLNonValide);
	        //création d'une plongée conforme
	        plongeConforme = new Plongee(new Site("Cassis", "Dans les calanques"), moniteur, LocalDate.of(2021,12,5),100,1);
	        plongeConforme.ajouteParticipant(plongeurLValide1);
	        plongeConforme.ajouteParticipant(plongeurLValide2);
	    }

	    @After
            
	    protected void tearDown() throws Exception {
	        lesPlongeursFou = null;
	        president = null;
	        moniteur = null;
	        plongeurLNonValide = null;
	        plongeurLValide1 = null;
	        plongeurLValide2 = null;
	        plongeNonConforme = null;
	        plongeConforme = null;
	    }

	    @Test
	    public void testOrganisePlongee(){
	        lesPlongeursFou.organisePlongee(plongeConforme);
	        lesPlongeursFou.organisePlongee(plongeNonConforme);
	        assertEquals(2, lesPlongeursFou.getActivites().size());
	    }

	    @Test
	    public void testDelivreLicence(){
	        clubSansPlongeur.ajouterLicence(new Licence(plongeurLValide1, "123", LocalDate.of(2021,9,2), lesPlongeursFou));
	        assertEquals(clubSansPlongeur.getLesLicences().size(), 1);
	        //3 plongeurs ont une licence dans le club lesPlongeurFou (voir setUp)
	        assertEquals(lesPlongeursFou.getLesLicences().size(), 3);
	    }

	    @Test
	    public void testPlongeeNonConforme(){
	        lesPlongeursFou.organisePlongee(plongeConforme);
	        lesPlongeursFou.organisePlongee(plongeNonConforme);
	        assertEquals(lesPlongeursFou.plongeesNonConformes().size(), 1);
	    }

		}



