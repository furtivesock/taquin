package taquin;

import java.util.Scanner;

public class Jeu {

	public static void main(String[] args) {
		Plateau p = new Plateau();
		boolean pause;
		
		Scanner sc = new Scanner(System.in);
		
		while(!p.estFinie()) {
			System.out.println(p.toString());
			System.out.println("Choisissez un numéro parmi les choix possibles (dernier choix = reset)");
			System.out.println(p.getChoix());
			System.out.print("Votre choix : ");
			
			pause=true;
			while (pause) {
				try {
						p.jouer(Integer.parseInt(sc.nextLine()));
						pause = false;
				}
				catch (RuntimeException e) {
					if (e instanceof NumberFormatException) 
						System.out.println(e.toString() + System.lineSeparator() + "Miséricorde, écris un nombre figurant dans la liste, te dis-je !");
					else
						System.out.println(e.toString());
				}
			}
			System.out.println("===============");
		}
		
		System.out.println(p.toString());
		System.out.println("WOW ! Bien joué, nous sommes fiers de toi !");
	}

}
