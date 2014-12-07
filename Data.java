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

public class Data{
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
		armors = new Armor[10];
		hps = new HealthPotion[10];
		mps = new ManaPotion[10];
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
		armors[6] = new Armor ("Colete de Ferro",2300,15,16); 
		armors[7] = new Armor ("Colete Nomex de Aço",1400,12,8); 
		armors[8] = new Armor ("Chain Vest",650,5,5); 
		armors[9] = new Armor ("Mikhail's Crucible",1000,7,17);
		/* Potion Objects new "Potion" (Name,Price,Points) */
		for (i = 0 ; i < 10 ; i++) {
			hps[i] = new HealthPotion ("HealthPotion",50,150);
		}
		for (i = 0 ; i < 10 ; i++) {
			mps[i] = new ManaPotion ("ManaPotion",50,80);
		}
		
		/* Characters "Character" (Name,Attribute)*/
		for (i = 0 ; i < 8 ; i++) {
			knights[i] = new Knight ("Knight "+i,(int)(Math.random()*50.0+1.0));
			wizards[i] = new Wizard ("Wizard "+i,(int)(Math.random()*50.0+1.0));
			thiefs[i] = new Thief ("Thief "+i,(int)(Math.random()*50.0+1.0));

			knights[i].setStrenght((int)(Math.random()*40));
			knights[i].setDexterity((int)(Math.random()*40));
			knights[i].setSpeed((int)(Math.random()*40));
			knights[i].setConstitution((int)(Math.random()*40));

			wizards[i].setStrenght((int)(Math.random()*40));
			wizards[i].setDexterity((int)(Math.random()*40));
			wizards[i].setSpeed((int)(Math.random()*40));
			wizards[i].setConstitution((int)(Math.random()*40));

			thiefs[i].setStrenght((int)(Math.random()*40));
			thiefs[i].setDexterity((int)(Math.random()*40));
			thiefs[i].setSpeed((int)(Math.random()*40));
			thiefs[i].setConstitution((int)(Math.random()*40));

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

	public <T extends Item> void insertItemGeneric (T[] item, int numOfItems, Knight k, Wizard w, Thief t){
		int i;

		for (i = 0 ; i < numOfItems; i++) {
				k.getMyItems().insertItem(item[(int)((Math.random()*10))]);
				w.getMyItems().insertItem(item[(int)((Math.random()*10))]);
				t.getMyItems().insertItem(item[(int)((Math.random()*10))]);
		}
		
	}

	public void generateBattle()  {
		int numOfItems;
		int i;
		int j;
		int aux;
		int k1 = (int)(Math.random()*8);
		int w1 = (int)(Math.random()*8);
		int t1 = (int)(Math.random()*8);
		int k2 = (int)(Math.random()*8);
		int w2 = (int)(Math.random()*8);
		int t2 = (int)(Math.random()*8);
		Knight k = new Knight(knights[k1]);
		Wizard w = new Wizard(wizards[w1]);
		Thief t = new Thief(thiefs[t1]);
		Team a = teams[(int)(Math.random()*8)];
		Team b = teams[(int)(Math.random()*8)];
		k.getMyItems().setSpaces(50);
		w.getMyItems().setSpaces(50);
		t.getMyItems().setSpaces(50);
		/* Weapons */

		/* Gera um número aleatório até 4 para colocar no inventário do personagem */
		numOfItems = (int)(Math.random()*4);
		if (numOfItems == 0) {
			numOfItems++;
		}
		/* Insere itens pseudo aleatórios */
		insertItemGeneric (weapons,numOfItems,k,w,t);

		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		k.getMyItems().equip(k.getMyItems().getItems().get(aux).getName());

		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		w.getMyItems().equip(k.getMyItems().getItems().get(aux).getName());

		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		t.getMyItems().equip(k.getMyItems().getItems().get(aux).getName());


		/* Armors */
		numOfItems = (int)(Math.random()*4);
		if (numOfItems == 0) {
			numOfItems++;
		}
		insertItemGeneric (armors,numOfItems,k,w,t);

		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		k.getMyItems().equip(k.getMyItems().getItems().get(aux).getName());
		
		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		w.getMyItems().equip(k.getMyItems().getItems().get(aux).getName());

		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		t.getMyItems().equip(k.getMyItems().getItems().get(aux).getName());

		/* Potions */
		numOfItems = (int)(Math.random()*4);
		insertItemGeneric (hps,numOfItems,k,w,t);
		insertItemGeneric (mps,numOfItems,k,w,t);

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
		Knight kb = new Knight(knights[k2]);
		Wizard wb = new Wizard(wizards[w2]);
		Thief tb = new Thief(thiefs[t2]);
		kb.getMyItems().setSpaces(50);
		wb.getMyItems().setSpaces(50);
		tb.getMyItems().setSpaces(50);

		/* Weapons */
		/* Gera um número aleatório até 4 para colocar no inventário do personagem */
		numOfItems = (int)(Math.random()*4);
		if (numOfItems == 0) {
			numOfItems++;
		}

		/* Insere itens pseudo aleatórios */
		insertItemGeneric (weapons,numOfItems,kb,wb,tb);

		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		kb.getMyItems().equip(kb.getMyItems().getItems().get(aux).getName());

		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		wb.getMyItems().equip(wb.getMyItems().getItems().get(aux).getName());

		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		tb.getMyItems().equip(tb.getMyItems().getItems().get(aux).getName());

		/* Armors */
		numOfItems = (int)(Math.random()*4);
		if (numOfItems == 0) {
			numOfItems++;
		}
		insertItemGeneric (armors,numOfItems,kb,wb,tb);

		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		kb.getMyItems().equip(kb.getMyItems().getItems().get(aux).getName());
		
		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		wb.getMyItems().equip(wb.getMyItems().getItems().get(aux).getName());

		/* Gera posição para um item até 4 ser quipado */
		aux = numOfItems + 1;
		while (aux >= numOfItems){
			aux = (int)(Math.random()*4);
		}
		tb.getMyItems().equip(wb.getMyItems().getItems().get(aux).getName());

		/* Potions */
		numOfItems = (int)(Math.random()*4);
		insertItemGeneric (hps,numOfItems,kb,wb,tb);
		insertItemGeneric (mps,numOfItems,kb,wb,tb);

		b.addChar(kb);
		b.addChar(wb);
		b.addChar(tb);

		Battle battle = new Battle(a,b);
		battles.add(battle);
	}

	ArrayList<Battle> getBattles() {
		return battles;
	}
}
