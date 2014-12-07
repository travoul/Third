/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Author: Jessika Darambaris
	#USP: 7961026
	
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos

*/

package Items;
import java.util.ArrayList;

/* Template usado para substituir duas funções identicas na lógica, só que usando tipos diferentes
searchItem e searchChar */
public class Busca{

	public static <T extends Name> T searchByName (ArrayList<T> a, String name) {
		int i = 0;

		/* Busca sequencial sendo a chave o nome do item ou do personagem */
		for (i = 0; i < a.size() ; i++) {
			if (a.get(i).getName() == name) {
				return a.get(i);
			}
		}
		return null;
	}
}
