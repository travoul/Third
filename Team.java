/*

	Author: Marcello de Paula Ferreira Costa
	#USP: 7960690
	Universidade de São Paulo
	Trabalho para o Curso de Programação Orientada à Objetos
	Character class

*/

import java.util.ArrayList;

public class Team {
	private String name;
	private Color color;
	private int win;
	private int draw;
	private int lose;
	private ArrayList<Character> characters;

	public Team (String name, Color color) {
		this.name = name;
		this.color = color;
		this.win = 0;
		this.draw = 0;
		this.lose = 0;
		characters = new ArrayList<Character>();	
	}

	public String getName () {
		return this.name;
	}

	public String getResults () {
		return toString()+"\nWins: "+this.win+"\nDraws: "+this.draw+"\nLosses: "+this.lose;
	}

	/* Returns team's name and color as a string */
	public String toString () {
		return "Time: "+this.name+" Cor:"+color.name();
	}
	
	public void resolveBattle(Team team) {
		double p1 = this.getPoints();
		double p2 = team.getPoints();

		if (p1 < p2) lose++;
		else 	if (p1 > p2) win++;
			else draw++;
		//System.out.println(getResults());
	}

	public void addChar (Character new_member) {
		characters.add(new_member);
	}

	public void removeChar (int key) {
		if (key < (characters.size()-1)) {
			characters.remove(key);
			System.out.println("Item removed");
		}
		else {
			System.out.println("Character not found");
		}
	}

	public void removeChar (Character temp) {
		temp = searchChar(temp.getAlias());
		if (temp != null) {
			System.out.println("Player "+temp.getAlias()+" will be excluded from team "+color+"");
			characters.remove(characters.indexOf(temp));

		}
		else {
			System.out.println("Impossible to remove!");
		}
	}

	/* Searchs for a character with given name */
	public Character searchChar (String name) {
		int i = 0;

		for (i = 0 ; i < characters.size() ; i++) {
			if (characters.get(i).getAlias() == name) {
				return characters.get(i);
			}
		}
		return null;
	}

	/* Returns arithmetic media of characters' HP */
	public double getPoints () {
		int i = 0;
		int sum = 0;

		for (i = 0 ; i < characters.size() ; i++) {
			sum = sum + characters.get(i).getHP();
		}
		return (double)sum/(double)characters.size();
	}

	public ArrayList<Character> getCharacter() {
		return characters;
	}

	public int getWin (){
		return this.win;
	}

	public void reinitStats() {
		this.win = 0;
		this.draw = 0;
		this.lose = 0;
	}
}
