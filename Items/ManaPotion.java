/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Author: Jessika Darambaris
	#USP: 7961026
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos

*/

package Items;

public class ManaPotion extends Potion {

	public ManaPotion (String name, double price, int mp) {
		super(name,price,mp);
	}

	@Override
	public void use (Inventory i) {
		i.removeItem(super.getName());
	}
}
