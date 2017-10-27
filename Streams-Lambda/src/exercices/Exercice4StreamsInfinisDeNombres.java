package exercices;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Exercice4StreamsInfinisDeNombres {
	
	private static Random random = new Random();
	private static DoubleStream generateDoubleStream(int taille, double valeurMax) {
		return random.doubles(taille, 0.0, valeurMax);
	}
	
	private static Stream<Double> generateStreamDoubles(int taille, double valeurMax) {
		return Stream.generate(random::nextDouble).map(d-> d * valeurMax).limit(taille);
	}

	public static void main(String[] args) {
		
		double[] mesDoubles = random.doubles(10, 0, 100).toArray();
		System.out.println("10 r�els al�atoires:");
		for (double d : mesDoubles) {
			System.out.println(d);
		}
		
		System.out.println("\nLa somme des racines carr�es vaut : " + 
				DoubleStream.of(mesDoubles).map(d -> Math.sqrt(d)).sum());
		
		System.out.println("\n5 r�els al�atoires:");
		generateDoubleStream(5, 100).forEach(System.out::println);
		
		System.out.println("\n10 r�els al�atoires:");
		generateStreamDoubles(10, 100).forEach(System.out::println);
	}
	
}
