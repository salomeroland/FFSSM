/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;
    public ArrayList<Embauche> lesEmbauches = new ArrayList<Embauche>(); 

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int numeroDiplome,int niveau,  GroupeSanguin gs) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance,niveau,  gs);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
    	Club res = null; 
        if(!lesEmbauches.isEmpty()){
            Embauche emb = lesEmbauches.get(lesEmbauches.size()-1);
            res = emb.getEmployeur();
            if(emb.estTerminee()){
                res = null;
            }
        }
        Optional<Club> oc = Optional.ofNullable(res);
        return oc;
      
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
         if(lesEmbauches.isEmpty()) {
        	 this.terminerEmbauche(debutNouvelle);
        	 lesEmbauches.add(new Embauche(debutNouvelle, this, employeur)); 
         }
    }

    public List<Embauche> emplois() {
         return lesEmbauches; 
    }
    
    public void terminerEmbauche(LocalDate fin) {
    	if(!lesEmbauches.get(lesEmbauches.size()-1).estTerminee()) {
    		lesEmbauches.get(lesEmbauches.size()-1).setFin(fin);
    	}
    }

}
