/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Author: Jessika Darambaris
	#USP: 7961026
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos
	Character class

*/

import Items.*;
import java.util.Random;

public abstract class Character implements Name{
	private String alias;
	private String type;
	private	Inventory myitems = new Inventory();
	private int hp;
	private int mp;
	protected int xp;
	protected int strenght;
	protected int speed;
	protected int dexterity;
	protected int constitution;

	public Character (String alias) {
		this.alias = alias;
		xp = (int)(Math.random()*80);
		hp = 10000;
		mp = 100;
	}

	public Character (Character Base){
		this.xp = Base.xp;
		this.hp = Base.hp;
		this.mp = Base.mp;
		this.alias = Base.alias;
		this.type = Base.type;
		this.strenght = Base.strenght;
		this.speed = Base.speed;
		this.dexterity = Base.dexterity;
		this.constitution = Base.constitution;
		this.myitems = new Inventory();
		this.myitems.setSpaces(Base.getMyItems().getAvailableSpace());
	}

	public String getName(){
		return this.alias;
	}

	public void setType(String type){
		this.type = type;
	}
	protected int getAttackPoints () {
		int item_att_pts = 0;
		double true_speed = 0;
		for (int i = 0 ; i < getMyItems().size() ; i++) {
			if (getMyItems().items.get(i).getEquiped()) {
				item_att_pts = item_att_pts + myitems.items.get(i).getAttackPts();
				true_speed = true_speed + getMyItems().items.get(i).getWeight();
			}
		}
		true_speed = this.speed/(Math.exp((true_speed*true_speed)));
		return (int)((this.strenght*0.5+this.dexterity*0.3+true_speed*0.2+(double)item_att_pts)*(xp/3.0));
	}

	protected int getDefensePoints () {
		int item_def_pts = 0;
		double true_speed = 0;

		for (int i = 0 ; i < getMyItems().size() ; i++) {
			if (getMyItems().items.get(i).getEquiped()) {
				item_def_pts = item_def_pts + getMyItems().items.get(i).getDefensePts();
				true_speed = true_speed + getMyItems().items.get(i).getWeight();
			}
		}
		true_speed = this.speed/(Math.exp((true_speed*true_speed)));
		return (int)((this.constitution*0.5+this.dexterity*0.3+true_speed*0.2+(double)item_def_pts)*(xp/2.0));
	}

	public abstract void attack(Character target);

	public void addXP (int xp) {
		this.xp = this.xp + xp;
		if (xp >= 0){
			System.out.println("You have gained "+xp+"XP.");
		}
		else{
			System.out.println("You have lost "+xp+"XP.");
		}
	}

	public int controlAttributes () {
		int temp = this.strenght+this.constitution+this.dexterity+this.speed;
		if (temp > 100)
			return 101;
		else
			return temp;
	}

	/*********************** Setters *********************/
	
	public void setStrenght (int strenght) {
		int temp = controlAttributes();
		if (temp < 100) {
			temp = temp - this.strenght;
			temp = temp + strenght;
			if (temp <= 100) {
				this.strenght = strenght;
			}
			else {
				temp = temp - strenght;
				this.strenght = 100-temp;
			}
		}
		else this.strenght = strenght;
	}


	public void setSpeed (int speed) {
		int temp = controlAttributes();
		if (temp < 100) {
			temp = temp - this.speed;
			temp = temp + speed;
			if (temp <= 100) {
				this.speed = speed;
			}
			else {
				temp = temp - speed;
				this.speed = 100-temp;
			}
		}
		else this.speed = speed;
	}

	public void setDexterity (int dexterity) {
		int temp = controlAttributes();
		if (temp < 100) {
			temp = temp - this.dexterity;
			temp = temp + dexterity;
			if (temp <= 100) {
				this.dexterity = dexterity;
			}
			else {
				temp = temp - dexterity;
				this.dexterity = 100-temp;
			}
		}
		else this.dexterity = dexterity;
	}

	public void setConstitution (int constitution) {
		int temp = controlAttributes();
		if (temp < 100) {
			temp = temp - this.constitution;
			temp = temp + constitution;
			if (temp <= 100) {
				this.constitution = constitution;
			}
			else {
				temp = temp - constitution;
				this.constitution = 100-temp;
			}
		}
		else this.constitution = constitution;
	}

	public void addHP (int hp) {
		this.hp = this.hp + hp;
		if (this.hp < 0) {
			this.hp = 0;
		}
	}

	/* Usada somente para consumível.
	A intenção é que quando uma poção for usada, a função seja chamada como "HealthPotion" no argumento */
	public void addHP (String name) {
		addHP(myitems.equip(name));
	}

	public void addMP(int mp) {
		this.mp = this.mp + mp;
		if (this.mp < 0) {
			this.mp = 0;
		}
	}

	public void addMP (String name) {
		addMP(myitems.equip(name));
	}

	public int getHP () {
		return this.hp;
	}

	/* Returns this classes' ArrayList so it can be used from outside */
	public Inventory getMyItems () {
		return myitems;
	}
};
