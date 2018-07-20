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
			System.out.print("Votre choix :");
			
			pause=true;
			while (pause) {
				try {
					p.jouer(sc.nextInt());
					pause = false;
				}
				catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			System.out.println("===============");
		}
		
		System.out.println(p.toString());
		System.out.println("WOW ! Bien joué, nous sommes fiers de toi !");
	}

}
