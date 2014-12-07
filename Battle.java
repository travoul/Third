/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Author: Jessika Darambaris
	#USP: 7961026
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos
	Character class

*/

import java.util.*;

public class Battle implements Runnable {
	private Team a;
	private Team b;

	public Battle (Team a, Team b) {
		this.a = a;
		this.b = b;
	}

	public void run() {
		int[] flag, flag2;
		flag = new int[4];
		flag2 = new int[4];
		int aux = 0;
		int aux2 = 0;
		int i;
		int j;

		for (i = 0 ; i < 10 ; i++) {
			/* Team 0 Starts! */
			j = 0;
			if (((int)(Math.random()*2)) == 0) {
				while(j < 3) {
					while (flag[aux] == 0) {
						aux = (int)(Math.random()*3.0);
						if (flag[aux] == 0)
							flag[aux] = 1;
					}
					while (flag[aux2] == 0) {
						aux2 = (int)(Math.random()*3.0);
						if (flag[aux2] == 0)
							flag[aux2] = 1;
					}
					a.getCharacter().get(aux).attack(b.getCharacter().get(aux2));
					j++;
				}
				/* Another team's turn */
				j = 0;
				while(j < 3) {
					while (flag[aux] == 0) {
						aux = (int)(Math.random()*3.0);
						if (flag[aux] == 0)
							flag[aux] = 1;
					}
					while (flag[aux2] == 0) {
						aux2 = (int)(Math.random()*3.0);
						if (flag[aux2] == 0)
							flag[aux2] = 1;
					}
					b.getCharacter().get(aux).attack(a.getCharacter().get(aux2));
					j++;
				}
			}
			/* Team 1 Starts! */
			else {
				j = 0;
				while(j < 3) {
					while (flag[aux] == 0) {
						aux = (int)(Math.random()*3.0);
						if (flag[aux] == 0)
							flag[aux] = 1;
					}
					while (flag[aux2] == 0) {
						aux2 = (int)(Math.random()*3.0);
						if (flag[aux2] == 0)
							flag[aux2] = 1;
					}
					b.getCharacter().get(aux).attack(a.getCharacter().get(aux2));
					j++;
				}
				/* Another team's turn */
				j = 0;
				while(j < 3) {
					while (flag[aux] == 0) {
						aux = (int)(Math.random()*3.0);
						if (flag[aux] == 0)
							flag[aux] = 1;
					}
					while (flag[aux2] == 0) {
						aux2 = (int)(Math.random()*3.0);
						if (flag[aux2] == 0)
							flag[aux2] = 1;
					}
					a.getCharacter().get(aux).attack(b.getCharacter().get(aux2));
					j++;
				}

			}
			a.resolveBattle(b);
			b.resolveBattle(a);
		}

		System.out.println(getWinner());
		a.reinitStats();
		b.reinitStats();
	}

	public String getWinner() {
		if (a.getWin() > b.getWin()) {
			a.getResults();
			return a.getName()+" won the battle!";

		}
		else
			if (a.getWin() < b.getWin()) {
				b.getResults();
			return b.getName()+" won the battle!";
			}
			else
				a.getResults();
				b.getResults();
				return "There was a Draw!";
	}

	public void print(){
		System.out.println("[Time A: "+a.getName()+" vs Time B: "+b.getName()+"]");
	}
}