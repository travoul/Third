/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos
	Thief (Character's subclass)

*/

public class Thief extends Character{
	protected int stealth;

	public Thief (String name, int stealth) {
		super(name);
		this.stealth = stealth;
	}

	@Override
	protected int getAttackPoints () {
		return super.getAttackPoints() + this.stealth;
	}

	public void attack (Character target) {
		double p;	/* p is be used as an random probability
				 * and also as an auxiliar variable */
		int damage;

		p = Math.random() * 100.0;
		if (!(p <= 10.0/(double)this.xp)) {
				p = (getAttackPoints() - target.getDefensePoints() + (Math.random()*10.0-5.0));
				if (p < 0.0 || (int)p == 0) {
					damage = 1;
				}
				else damage = (int)p;

				/* Critical Attack probability */
				p = Math.random() * 100.0;
				if (p < (0.02*(double)this.xp/2.0)*100.0) {
					damage += damage;
					//System.out.print("Critical Strike! ");
				}
				//System.out.println("Damage dealt: "+damage);
				target.addHP((-damage));
		}
		else {
			//System.out.println("You missed your attack! Be cafeful!");
		}
	}

	public void addStealth (int stealth) {
		this.stealth += stealth;
	}
}
