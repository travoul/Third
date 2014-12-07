/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Author: Jessika Darambaris
	#USP: 7961026
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos

*/

package Items;

public class Weapon extends Item {

	protected int attackpts;
	protected double range;

	public Weapon (String name, double price, int attackpts, double range) {
		super(name,price);

		/* Attack Points Insertion */
		if (attackpts < 1) /* Minimum */
			this.attackpts = 1;
		else 	if (attackpts > 9) /* Maximum */
				this.attackpts = 9;
			else 	this.attackpts = attackpts;

		/* Range Insertion */
		this.range = range;
	}

	public Weapon (Weapon Base) {
		super(Base);
		this.attackpts = Base.attackpts;
		this.range = Base.range;
	}

	@Override
	public int getAttackPts () {
		return attackpts;
	}

	@Override
	public int getDefensePts () {
		return 0;
	}

	@Override
	public double getRange () {
		return range;
	}

	@Override
	public int getRestorePts() {
		return 0;
	}

	@Override
	public double getWeight () {
		return 0.0;
	}

	@Override
	public void use (Inventory i){
		int j = 0;
	}
}
