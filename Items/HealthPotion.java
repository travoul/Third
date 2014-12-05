/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos

*/

package Items;

public class HealthPotion extends Potion {

	public HealthPotion (String name, double price, int hp) {
		super(name,price,hp);
	}

	@Override
	public void use (Inventory i) {
		i.removeItem(super.getName());
	}
}
