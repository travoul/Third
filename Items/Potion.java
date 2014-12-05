/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos
	Abstract Item's subclass

*/

package Items;

public abstract class Potion extends Item {

	private int restorepts;

	public Potion (String name, double price, int restorepts) {
		super(name,price);
		this.restorepts = restorepts;
	}

	public Potion (Potion Base) {
		super(Base);
		this.restorepts = Base.restorepts;
	}

	@Override
	public int getAttackPts () {
		return 0;
	}

	@Override
	public int getDefensePts() {
		return 0;
	}

	@Override
	public double getWeight() {
		return 0.0;
	}

	@Override
	public double getRange() {
		return 0.0;
	}

	@Override
	public int getRestorePts () {
		return this.restorepts;
	}
}
