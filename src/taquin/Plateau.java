package taquin;

import java.util.ArrayList;
import java.util.Collections;

public class Plateau {
	
	private final static int TAILLE = 4;
	private ArrayList<Integer> grille;
	private ArrayList<Integer> base;
	private ArrayList<Integer> choix;
	
	
	public Plateau() {
		choix = new ArrayList<Integer>();
		grille = new ArrayList<Integer>();
		for (int i=1; i<TAILLE*TAILLE; ++i)
			grille.add(new Integer(i));
		Collections.shuffle(grille);
		grille.add(TAILLE*TAILLE);
		base = new ArrayList<Integer>(grille);
		numerosPossibles();
	}
	
	public ArrayList<Integer> getGrille() {
		return grille;
	}
	
	public String toString() {
		String s = "";
		for (int i=0; i<grille.size(); ++i) {
			if (i%TAILLE == TAILLE-1) {
				if (grille.get(i) == TAILLE*TAILLE)
					s+="X" + System.lineSeparator();
				else
				s+=grille.get(i) + System.lineSeparator();
			}
			else {
				if (grille.get(i) == TAILLE*TAILLE)
					s+="X" + " ";
				else
				s+=grille.get(i) + " ";
			}
		}
		return s;
	}
	
	public void jouer(int n) throws Exception {
		
		if (estFinie() || n < 0 || n > TAILLE*TAILLE)
			throw new Exception("Le numéro donné n'existe pas.");
		else if (!choix.contains(n))
			throw new Exception("Choisissez un numéro parmi les choix proposés");
		
		if (n == TAILLE*TAILLE)
			reset();
		else {
			int temp = grille.indexOf(n);
			grille.set(grille.indexOf(TAILLE*TAILLE), n);
			grille.set(temp, TAILLE*TAILLE);
		}
		numerosPossibles();
		
	}
	
	public boolean estFinie() {
		ArrayList<Integer> copie = new ArrayList<Integer>(grille);
		Collections.sort(copie);
		return grille.equals(copie);
	}
	
	private void reset() {
		if (grille.equals(base)) 
			System.out.println("Je ne pense pas que cela soit fortement utile...");
		else {
			System.out.println("Retour vers le passé enclenché.");
		grille.clear();
		
			for (int i=0; i<base.size(); ++i) {
				grille.add(base.get(i));
			}
		
		}
	}
	
	private void numerosPossibles() {
		choix.clear();
		if (grille.indexOf(TAILLE*TAILLE)+1 < TAILLE*TAILLE && grille.indexOf(TAILLE*TAILLE)%TAILLE!=TAILLE-1)
			choix.add(grille.get(grille.indexOf(TAILLE*TAILLE)+1));
		if (grille.indexOf(TAILLE*TAILLE)%TAILLE != 0)
			choix.add(grille.get(grille.indexOf(TAILLE*TAILLE)-1));
		if (grille.indexOf(TAILLE*TAILLE) >= TAILLE)
			choix.add(grille.get(grille.indexOf(TAILLE*TAILLE)-TAILLE));
		if (grille.indexOf(TAILLE*TAILLE)+TAILLE < TAILLE*TAILLE)
			choix.add(grille.get(grille.indexOf(TAILLE*TAILLE)+TAILLE));
		choix.add(TAILLE*TAILLE);
	}
	
	public String getChoix() {
		String s = "";
		for (int i=0; i<choix.size(); ++i) {
			s+= choix.get(i);
			if (i!=choix.size()-1) 
				s+= " ou ";
		}
		return s;
	}
	
	

}
