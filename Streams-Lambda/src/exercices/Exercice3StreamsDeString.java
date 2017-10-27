package exercices;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import java.util.Arrays;
import java.util.List;

public class Exercice3StreamsDeString {

	public static void main(String[] args) {
		List<String> maListe = Arrays.asList("aiguille", "machine à coudre", "bobine de fil", "ciseaux", "patron");
		
		Utils.displayList("Liste de mots", maListe);
		
		Utils.displayList("Liste exclamée", maListe.stream().map(s -> s + " !").collect(toList()));
		
		Utils.displayTab("Tableau de strings", maListe.stream().toArray(String[]::new));
		
		Utils.displayList("Majuscule, ordre inverse", 
				maListe.stream().map(String::toUpperCase).sorted(reverseOrder()).collect(toList()));
		
		System.out.println(maListe.stream().filter(s -> s.length() % 2 == 0).collect(joining(" ")));
	}

}
