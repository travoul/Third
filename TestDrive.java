/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos

*/

import Items.*;
import java.util.*;


public class TestDrive{
	
	public static void main (String args[]) {
		int i;
		System.out.println("Welcome to Instant Revenge");
		int option = 0;
		Data collection = new Data();
		Scanner sc = new Scanner(System.in);

		while (option != -1) {
			System.out.println("Type:\n1 to Create a new Ramdom Battle.\n2 to start all battles\n-1 to exit program.\nOption: ");
			option = sc.nextInt();

			switch(option){
				case 1:
					System.out.println("A new battle between two teams is being created! Wait a while...");
					collection.generateBattle();
				break;

				case 2:
					System.out.println("Brace Yourselves, battles are about to begin...");
					//battles.run();
					for (i = 0 ; i < collection.getBattles().size() ; i++) {
						collection.getBattles().get(i).run();
					}
				break;

				case -1:
					System.out.println("Thanks for playing! Hope you enjoyed it!");
				break;
			}
		}
	}
};
