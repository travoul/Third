/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Author: Jessika Darambaris
	#USP: 7961026
	
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos

*/

import Items.*;
import java.util.*;


public class TestDrive extends Thread {
	
	public static void main (String args[]) throws InterruptedException{
		int i;
		System.out.println("Welcome to Instant Revenge");
		int option = 0;
		Data collection = new Data();
		Scanner sc = new Scanner(System.in);
		Thread battle;

		/* Test do Template de Busca */
		/* As funções de Busca deveriam ser usadas em um outro contexto, como por exemplo uma situação real de buscar um item no inventário,
		que não é simulada no trabalho, então as seguintes linhas comentadas servem apenas como demonstração do funcionamento do template
		usado para a função de busca usando uma String como argumento */

		/*Character c = new Knight("Headless Pony",100);
		Team t = new Team("Peperoni",Color.PINK);
		t.addChar(c);
		Item w = new Weapon ("Black Cleaver",3200,7,6);
		c.getMyItems().setSpaces(10);
		c.getMyItems().insertItem(w);
		Character a = new Busca().<Character>searchByName(t.getCharacter(),"Claudinho");
		Item j = new Busca().<Item>searchByName(c.getMyItems().getItems(),"Black Cleaver");
		System.out.println("Nome: "+c.getName()+"\nItem: "+j.getName());
		*/
		

		while (option != -1) {
			/* Imprime número de batalhas na lista de batalha */
			System.out.println("#Battles: "+collection.getBattles().size());

			/* Somente mostra a opção de Esvaziar a lista de batalhas caso haja ao menos uma batalha */
			if (collection.getBattles().size() == 0) {
				System.out.print(" (1) - Create a new Random Battle;\n (2) - Start all battles\n(-1) - Exit\nOption:");
			} else System.out.print(" (1) - Create a new Random Battle;\n (2) - Start all battles\n (3) - Empty Battles List\n(-1) - Exit\nOption:");

			option = sc.nextInt();

			switch(option){
				case 1:
					/* Gera uma nova batalha pseudo-aleatória */
					System.out.println("Creating battle... Please Wait.");
					collection.generateBattle();
				break;

				case 2:
					if (collection.getBattles().size() == 0) {
						break;
					}
					/* Mensagem amigável */
					System.out.println("Brace Yourselves! Battles are about to begin...");
					
					/* Para cara batalha gera uma thread e a inicia */
					for (i = 0 ; i < collection.getBattles().size() ; i++) {
						battle = new Thread(collection.getBattles().get(i));
						collection.getBattles().get(i).print();
						battle.start();
						/* Espera um tempo para a Thread terminar a execução */
						battle.sleep(100);
					}
				break;
				case 3:
					/* Somente remove algo, se existir algo para ser removido */
					if (collection.getBattles().size() == 0) {
						break;
					}
					else {
						/* Esvazia a lista de batalhas */
						collection.getBattles().removeAll(collection.getBattles());
					}
				case -1:
					/* Exibe mensagem de despedida ao usuário */
					System.out.println("Thanks for playing Instant Revenge! Hope you enjoyed it! Cya");
				break;
			}
		}
	}
};
