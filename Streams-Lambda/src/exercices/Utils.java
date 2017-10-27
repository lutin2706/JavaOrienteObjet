package exercices;

import static java.util.stream.Collectors.toList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Utils {

	public static <T> List<T> allMatches(List<T> liste, Predicate<T> predicat) {
		return liste.stream().filter(predicat).collect(toList());
	}
	
	public static <T, V> List<V> transformedList(List<T> liste, Function<T, V> fonction) {
		return liste.stream().map(fonction).collect(toList());
	}
	
	public static <T> void displayList(String titre, List<T> liste) {
		System.out.println("Liste " + titre + " :\n");
		liste.forEach(System.out::println);
		System.out.println("\n");
	}

	public static void displayTab(String titre, String[] array) {
		for (String string : array) {
			System.out.println(string);
		}
	}
	
}
