/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos

*/

import Items.*;

public class TestDrive{

	public static void main (String args[]) {
		Weapon[] weapons;
		Armor[] armors;
		HealthPotion[] hps;
		ManaPotion[] mps;
		Knight[] knights;
		Wizard[] wizards;
		Thief[] thiefs;
		Team[] teams;
		weapons = new Weapon[10];
		armors = new Armor[6];
		hps = new HealthPotion[5];
		mps = new ManaPotion[3];
		knights = new Knight[3];
		wizards = new Wizard[3];
		thiefs = new Thief[2];
		teams = new Team[2];
		
		int i, j;

		/* Ten Weapon Objects Weapon (Name,Price,Attack(1~9),Range(1~20)) */
		weapons[0] = new Weapon ("Black Cleaver",3200,7,6);
		weapons[1] = new Weapon ("The Bloodthirster",9,15,17);
		weapons[2] = new Weapon ("Infinity Edge",9,14,20);
		weapons[3] = new Weapon ("Archangel Staff",8,10,13);
		weapons[4] = new Weapon ("Blade of The Ruined King",3050,6,20);
		weapons[5] = new Weapon ("Rabadon's Deathcap",3600,50,14);
		weapons[6] = new Weapon ("Deathfire Grasp",3100,42,20);
		weapons[7] = new Weapon ("Rod of Ages",2800,5,15);
		weapons[8] = new Weapon ("Athene's Holy Grail",2400,3,15);
		weapons[9] = new Weapon ("Feral Flare",3000,5,20);
		/* Eight Armor Objects Armor (Name,Price,Defense(1~20),Weight(1~20))*/
		armors[0] = new Armor ("Thornmail",2000,15,15);
		armors[1] = new Armor ("Warmog's",3000,15,10);
		armors[2] = new Armor ("Randuin's Omen",2800,20,18);
		armors[3] = new Armor ("Force of Nature",2300,17,10);
		armors[4] = new Armor ("Locket Of The Iron Solari",2100,10,10);
		armors[5] = new Armor ("Capa de Fogo",2500,13,19);
		/* Potion Objects new "Potion" (Name,Price,Points) */
		for (i = 0 ; i < 5 ; i++) {
			hps[i] = new HealthPotion ("HealthPotion",50,150);
		}
		for (i = 0 ; i < 3 ; i++) {
			mps[i] = new ManaPotion ("ManaPotion",50,80);
		}
		
		/* Characters "Character" (Name,Attribute)*/
		for (i = 0 ; i < 3 ; i++) {
			knights[i] = new Knight ("Knight "+i,(int)(Math.random()*50.0+1.0));
			wizards[i] = new Wizard ("Wizard "+i,(int)(Math.random()*50.0+1.0));
			knights[i].getMyItems().setSpaces(50);
			wizards[i].getMyItems().setSpaces(50);
		}
		for (i = 0 ; i < 2 ; i++) {
			thiefs[i] = new Thief ("Thief "+i,(int)(Math.random()*50.0+1.0));
			thiefs[i].getMyItems().setSpaces(50);
		}
		/* Teams! */
		teams[0] = new Team("Professors e Monitors",Color.RED);
		teams[1] = new Team("Students",Color.BLUE);
		

		/* Each player will receive 4 out of 10 Weapons, 3 out of 6 Armors, 3 HealthPotions and 1 ManaPotion*/
		/* Knights */
		for (i = 0 ; i < 3 ; i++) {
			/* Weapons */
			for (j = 0 ; j < 4 ; j++) {
				knights[i].getMyItems().insertItem(weapons[(int)(Math.random()*10)]);
			}
			/* Armors and Health Potions */
			for (j = 0 ; j < 3 ; j++) {
				knights[i].getMyItems().insertItem(armors[(int)((Math.random()*6))]);
				knights[i].getMyItems().insertItem(hps[j]);
			}
			/* Mana potion */
			knights[i].getMyItems().insertItem(mps[i]);
		}

		/* Wizards */
		for (i = 0 ; i < 3 ; i++) {
			/* Weapons */
			for (j = 0 ; j < 4 ; j++) {
				wizards[i].getMyItems().insertItem(weapons[(int)((Math.random()*10))]);
			}
			/* Armors and Health Potions */
			for (j = 0 ; j < 3 ; j++) {
				wizards[i].getMyItems().insertItem(armors[(int)((Math.random()*6))]);
				wizards[i].getMyItems().insertItem(hps[j]);
			}
			/* Mana potion */
			wizards[i].getMyItems().insertItem(mps[i]);
		}

		/*  Thiefs */
		for (i = 0 ; i < 2 ; i++) {
			/* Weapons */
			for (j = 0 ; j < 4 ; j++) {
				thiefs[i].getMyItems().insertItem(weapons[(int)((Math.random()*10))]);
			}
			/* Armors and Health Potions */
			for (j = 0 ; j < 3 ; j++) {
				thiefs[i].getMyItems().insertItem(armors[(int)((Math.random()*6))]);
				thiefs[i].getMyItems().insertItem(hps[j]);
			}
			/* Mana potion */
			thiefs[i].getMyItems().insertItem(mps[i]);
		}
		
		for (i = 0 ; i < 3 ; i++) {
			teams[0].addChar(wizards[i]);
		}
		teams[0].addChar(thiefs[0]);

		teams[1].addChar(thiefs[1]);
		for (i = 0 ; i < 3 ; i++) {
			teams[1].addChar(knights[i]);
		}
		/* Up untill here the code was to setup both teams with different characters with their items */
		/* From now untill the end is a simulation of a battle between two teams */

		/* There will be 10 rounds! */
		int[] flag, flag2;
		flag = new int[4];
		flag2 = new int[4];
		int aux = 0;
		int aux2 = 0;
		for (i = 0 ; i < 10 ; i++) {
			/* Team 0 Starts! */
			j = 0;
			if (((int)(Math.random()*1)) == 0) {
				while(j < 4) {
					while (flag[aux] == 0) {
						aux = (int)(Math.random()*4.0);
						if (flag[aux] == 0)
							flag[aux] = 1;
					}
					while (flag[aux2] == 0) {
						aux2 = (int)(Math.random()*4.0);
						if (flag[aux2] == 0)
							flag[aux2] = 1;
					}
					teams[0].getCharacter().get(aux).attack(teams[1].getCharacter().get(aux2));
					j++;
				}
				/* Another team's turn */
				j = 0;
				while(j < 4) {
					while (flag[aux] == 0) {
						aux = (int)(Math.random()*4.0);
						if (flag[aux] == 0)
							flag[aux] = 1;
					}
					while (flag[aux2] == 0) {
						aux2 = (int)(Math.random()*4.0);
						if (flag[aux2] == 0)
							flag[aux2] = 1;
					}
					teams[1].getCharacter().get(aux).attack(teams[0].getCharacter().get(aux2));
					j++;
				}
			}


			/* Team 1 Starts! */
			else {
				j = 0;
				while(j < 4) {
					while (flag[aux] == 0) {
						aux = (int)(Math.random()*4.0);
						if (flag[aux] == 0)
							flag[aux] = 1;
					}
					while (flag[aux2] == 0) {
						aux2 = (int)(Math.random()*4.0);
						if (flag[aux2] == 0)
							flag[aux2] = 1;
					}
					teams[1].getCharacter().get(aux).attack(teams[0].getCharacter().get(aux2));
					j++;
				}
				/* Another team's turn */
				j = 0;
				while(j < 4) {
					while (flag[aux] == 0) {
						aux = (int)(Math.random()*4.0);
						if (flag[aux] == 0)
							flag[aux] = 1;
					}
					while (flag[aux2] == 0) {
						aux2 = (int)(Math.random()*4.0);
						if (flag[aux2] == 0)
							flag[aux2] = 1;
					}
					teams[0].getCharacter().get(aux).attack(teams[1].getCharacter().get(aux2));
					j++;
				}

			}
			teams[0].resolveBattle(teams[1]);
			teams[1].resolveBattle(teams[0]);
		}
	}

};
