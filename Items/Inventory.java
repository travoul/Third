/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos
	Inventory class

*/

package Items;
import java.util.*;

/* Optei por fazer com que cada item tivesse a flag boolean de equipado
Não foi feito um par de arrays */
public class Inventory {
	private int spaces;
	private double gold; 
	public ArrayList<Item> items;

	/* Construtor */
	public Inventory () {
		gold = 0.0;
		spaces = 0;
		items = new ArrayList<Item>();
	}

	public double getTotalGold () {
		return gold;
	}

	public int getAvailableSpace () {
		return spaces-items.size();
	}

	public void spendGold (double cost) {
		if (cost > 0)
			gold = gold - cost;
		else
			System.out.println("Cost value must be positive");
	}

	public void earnGold (double income) {
		if (income > 0)
			gold = gold + income;
		else
			System.out.println("Income value must be positive");
	}

	public void setSpaces (int spaces) {
		if (spaces > 0 )
			this.spaces = spaces;
		else
			System.out.println("Spaces must be positive.");
	}

	public Item searchItem (String name_key) {
		int i = 0;

		for (i = 0; i < items.size() ; i++) {
			if (items.get(i).getName() == name_key) {
				return items.get(i);
			}
		}
		return null;
	}

	public Item searchItem (int key) {
		if (key > (items.size()-1)) {
			System.out.print("There is no such position on inventory!");
			System.out.println("Must be something between 0 and "+(items.size()-1));
			return null;
		}
		
		return items.get(key);
	}

	public void insertItem (Item i) {
		if (getAvailableSpace() > 0) {
			items.add(i);
		}
		else
			System.out.println("Inventory is full!");
	}

	public void removeItem (String name) {
		Item temp = searchItem(name);
		if (temp != null) {
			items.remove(items.indexOf(temp));
			/* System.out.println("Item removed"); */
		}
		else
			System.out.println("Impossible to remove!");
	}

	public void removeItem (int index) {
		Item temp = searchItem(index);
		if (temp != null) {
			items.remove(items.indexOf(temp));
			/*System.out.println("Item removed");*/
		}
		else
			System.out.println("Impossible to remove.");
	}

	public int size() {
		return items.size();
	}

	public int equip (String target_name) {
		Item target = searchItem(target_name);
		int i = 0;
		int k = 0;
		int aux = 0;
		if(target != null) {
			if (!(target.getAttackPts() == 0 && target.getDefensePts() == 0)) {
				if(target.getAttackPts() > 0) {
					for (i = 0 ; i < items.size() ; i++) {
						System.out.println("AttackPts: "+items.get(i).getAttackPts());
						if (items.get(i).getAttackPts() > 0 && items.get(i).getEquiped()) {
							items.get(i).setEquiped(false);
						}
					}
					items.get(items.indexOf(target)).setEquiped(true);
				}
				else {
					if (target.getDefensePts() > 0) {
						for (i = 0 ; i < items.size() ; i++) {
							if (items.get(i).getDefensePts() > 0 && items.get(i).getEquiped()) {
								k++;
						 		if (k == 1 && !((i+1) == items.size())) {
									aux = i;
								}
								if (k == 1 && ((i+1) == items.size())) {
									items.get(items.indexOf(target)).setEquiped(true);
								}
								if (k == 2) {
									if (items.get(aux).getDefensePts() < items.get(i).getDefensePts()){
										items.get(aux).setEquiped(false);
									}
									else {
										items.get(i).setEquiped(false);
									}
								}
							}
						}
						items.get(items.indexOf(target)).setEquiped(true);
					}
				}
			}
			else {
				int restorepts = target.getRestorePts();
				/* Ao contrário do que foi feito em C++, aqui a hierarquia de classe proposta foi "obedecida".
				 * Ainda assim, o ponteiro no inventário é passado para o item apenas chamar a função de remoção.
				 * O que de certa forma viola a ideia de encapsulamento */
				/* Em C++ o próprio inventário que remove o item após verificar o efeito que ele terá. */
				target.use(this);
				return restorepts;
			}
			return 0;
		}
		return 0;
	}

	public void list() {

		for (int i = 0 ; i < items.size() ; i++) {
			System.out.println("Item: "+items.get(i).getName());
			System.out.println("Valor booleano: "+items.get(i).getEquiped());
		}
	}
};
