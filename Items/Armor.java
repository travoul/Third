/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Author: Jessika Darambaris
	#USP: 7961026
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos

*/

package Items;

public class Armor extends Item {

	protected int defensepts;
	protected double weight;

	public Armor (String name, double price, int defensepts, double weight) {
		super(name,price);

		/* Defense Points Insertion */
		if (defensepts < 1) /* Minimum */
			this.defensepts = 1;
		else 	if (defensepts > 20) /* Maximum */
				this.defensepts = 20;
			else 	this.defensepts = defensepts;

		/* Weight Insertion */
		if (weight < 1) /* Minimum */
			this.weight = 1;
		else 	if (weight > 20) /* Maximum */
				this.weight = 20;
			else 	this.weight = weight;
	}

	public Armor (Armor Base) {
		super (Base);
		this.defensepts = Base.defensepts;
		this.weight = Base.weight;
	}

	@Override
	public int getAttackPts () {
		return 0;
	}

	@Override
	public int getDefensePts () {
		return defensepts;
	}

	@Override
	public double getWeight () {
		return weight;
	}

	@Override
	public int getRestorePts() {
		return 0;
	}

	@Override
	public double getRange() {
		return 0.0;
	}

	@Override
	public void use (Inventory i) {
		int j = 0;
	}
}
