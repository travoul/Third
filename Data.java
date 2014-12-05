/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos

*/

import Items.*;
import java.util.ArrayList;

public class Data {
	private Weapon[] weapons;
	private Armor[] armors;
	private HealthPotion[] hps;
	private ManaPotion[] mps;
	private Knight[] knights;
	private Wizard[] wizards;
	private Thief[] thiefs;
	private Team[] teams;
	private ArrayList<Battle> battles = new ArrayList<Battle>(20);

	public Data() {
		
		weapons = new Weapon[10];
		armors = new Armor[6];
		hps = new HealthPotion[5];
		mps = new ManaPotion[3];
		knights = new Knight[8];
		wizards = new Wizard[8];
		thiefs = new Thief[8];
		teams = new Team[8];
		
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
		for (i = 0 ; i < 8 ; i++) {
			knights[i] = new Knight ("Knight "+i,(int)(Math.random()*50.0+1.0));
			wizards[i] = new Wizard ("Wizard "+i,(int)(Math.random()*50.0+1.0));
			thiefs[i] = new Thief ("Thief "+i,(int)(Math.random()*50.0+1.0));
			knights[i].getMyItems().setSpaces(50);
			wizards[i].getMyItems().setSpaces(50);
			thiefs[i].getMyItems().setSpaces(50);
		}

		/* Teams! */
		teams[0] = new Team("Professors e Monitors",Color.RED);
		teams[1] = new Team("Students",Color.BLUE);
		teams[2] = new Team("Moacir e Seus Amigos", Color.PINK);
		teams[3] = new Team("Truta e Seus Trutinhas", Color.BLACK);
		teams[4] = new Team("Vish. Navarro Vem aí", Color.WHITE);
		teams[5] = new Team("Os Reis da Cocaca Preta", Color.BLUE);
		teams[6] = new Team("Battlefield é Melhor que Call Of Duty", Color.GREEN);
		teams[7] = new Team("Battlefield é MUITO Melhor que Call Of Duty", Color.SILVER);
	}

	public void generateBattle() {
		int numOfItems;
		int i;
		int j;
		int k1 = (int)(Math.random()*8);
		int w1 = (int)(Math.random()*8);
		int t1 = (int)(Math.random()*8);
		int k2 = (int)(Math.random()*8);
		int w2 = (int)(Math.random()*8);
		int t2 = (int)(Math.random()*8);
		Knight k = knights[k1];
		Wizard w = wizards[w1];
		Thief t = thiefs[t1];
		Team a = teams[(int)(Math.random()*8)];
		Team b = teams[(int)(Math.random()*8)];


		numOfItems = (int)(Math.random()*4);

		/* Weapons */
		for (i = 0 ; i < numOfItems ; i++) {
				k.getMyItems().insertItem(weapons[(int)((Math.random()*10))]);
				w.getMyItems().insertItem(weapons[(int)((Math.random()*10))]);
				t.getMyItems().insertItem(weapons[(int)((Math.random()*10))]);
		}

		numOfItems = (int)(Math.random()*4);
		/* Armors */
		for (i = 0 ; i < numOfItems ; i++) {
				k.getMyItems().insertItem(armors[(int)((Math.random()*6))]);
				w.getMyItems().insertItem(armors[(int)((Math.random()*6))]);
				t.getMyItems().insertItem(armors[(int)((Math.random()*6))]);
		}

		numOfItems = (int)(Math.random()*4);
		/* Potions */
		for (i = 0 ; i < numOfItems ; i++) {
				k.getMyItems().insertItem(hps[(int)((Math.random()*5))]);
				w.getMyItems().insertItem(hps[(int)((Math.random()*5))]);
				t.getMyItems().insertItem(hps[(int)((Math.random()*5))]);

				k.getMyItems().insertItem(mps[(int)((Math.random()*3))]);
				w.getMyItems().insertItem(mps[(int)((Math.random()*3))]);
				t.getMyItems().insertItem(mps[(int)((Math.random()*3))]);
		}

		a.addChar(k);
		a.addChar(w);
		a.addChar(t);

		while (k1 == k2) {
			k2 = (int)(Math.random()*8);
		}
		while (w1 == w2) {
			w2 = (int)(Math.random()*8);
		}
		while (t1 == t2) {
			t2 = (int)(Math.random()*8);
		}
		k = knights[k2];
		w = wizards[w2];
		t = thiefs[t2];

		for (i = 0 ; i < numOfItems ; i++) {
				k.getMyItems().insertItem(weapons[(int)((Math.random()*10))]);
				w.getMyItems().insertItem(weapons[(int)((Math.random()*10))]);
				t.getMyItems().insertItem(weapons[(int)((Math.random()*10))]);
		}

		numOfItems = (int)(Math.random()*4);
		/* Armors */
		for (i = 0 ; i < numOfItems ; i++) {
				k.getMyItems().insertItem(armors[(int)((Math.random()*6))]);
				w.getMyItems().insertItem(armors[(int)((Math.random()*6))]);
				t.getMyItems().insertItem(armors[(int)((Math.random()*6))]);
		}

		numOfItems = (int)(Math.random()*4);
		/* Potions */
		for (i = 0 ; i < numOfItems ; i++) {
				k.getMyItems().insertItem(hps[(int)((Math.random()*5))]);
				w.getMyItems().insertItem(hps[(int)((Math.random()*5))]);
				t.getMyItems().insertItem(hps[(int)((Math.random()*5))]);

				k.getMyItems().insertItem(mps[(int)((Math.random()*3))]);
				w.getMyItems().insertItem(mps[(int)((Math.random()*3))]);
				t.getMyItems().insertItem(mps[(int)((Math.random()*3))]);
		}

		b.addChar(k);
		b.addChar(w);
		b.addChar(t);

		Battle battle = new Battle(a,b);
		battles.add(battle);
	}

	ArrayList<Battle> getBattles() {
		return battles;
	}
}