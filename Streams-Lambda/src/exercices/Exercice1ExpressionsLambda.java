package exercices;

import java.util.Arrays;
import java.util.List;

public class Exercice1ExpressionsLambda {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
		
		Utils.displayList("Mots avec 'o'", Utils.allMatches(words, a->a.contains("o")));
		
		Utils.displayList("Mots plus longs que 4", Utils.allMatches(words, a->a.length() > 4));
		
		Utils.displayList("Mots en majuscule", Utils.transformedList(words, String::toUpperCase));
		
		Utils.displayList("Longueur des mots", Utils.transformedList(words, String::length));
		
		
		List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000); 
		
		Utils.displayList("Nombres supérieurs à 500", Utils.allMatches(nums, n -> n>500)); 
		
		Utils.displayList("Nombres inversés", Utils.transformedList(nums, i-> 1.0/i));
	}

}
