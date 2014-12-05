/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos
	Classe Abstrata Item

*/

package Items;

public abstract class Item {

	private final String name;
	private final double price;
	private boolean equiped;

	/* Pure Abstract Methods */
	public abstract int getAttackPts ();
	public abstract int getDefensePts();
	public abstract void use(Inventory i);
	public abstract double getWeight();
	public abstract double getRange();
	public abstract int getRestorePts();

	public Item (String name, double price) {
				
		this.name = name;

		/* Price Insertion */
		if (price < 0.0) /* Expected to be free or some positive value */
			this.price = 0.0;
		else 	this.price = price;

		this.equiped = false;
	}

	public Item (Item Base) {
		this.name = Base.name;
		this.price = Base.price;
	}

	public String getName () {
		return this.name;
	}

	public double getPrice () {
		return this.price;
	}

	public boolean getEquiped() {
		return this.equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}
}
