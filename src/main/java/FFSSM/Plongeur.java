package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Plongeur extends Personne  {
	public int niveau;
	protected ArrayList<Licence> licences = new ArrayList<Licence>(); 
	protected GroupeSanguin gs; 

	
	
	public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin gs) {
		super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
		this.niveau = niveau; 
		this.gs = gs;
	}

		
	

	public void ajouterLicence(String numero, LocalDate delivrance, Club c) {
		 Licence l = new Licence(this, numero, delivrance, c);
	        licences.add(l); 
	       
	}
	
	 public Optional<Licence> derniereLicence(){
	        Licence res = null;
	        if(!licences.isEmpty()){
	            res = licences.get(licences.size()-1);
	        }
	        Optional<Licence> oc = Optional.ofNullable(res);
	        return oc;
	    }
	}
	

