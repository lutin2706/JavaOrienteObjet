package exercices;

import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Exercice5StreamsAvecFichiers {

	public static void main(String[] args) {
		try(Stream<String> lignes = Files.lines(Paths.get("etudiants.csv"), Charset.defaultCharset())) {
			List<String> lS = lignes.collect(toList());
			
			// 1. Affiche la première ligne du csv
			System.out.println("Première ligne du fichier:\n\t");
			System.out.println(lS.get(0));
			
//			System.out.println("\nListe des étudiants:");
			// 2. Construit une liste d'étudiants (méthode 1)
			List<Etudiant> etudiants = lS.stream().map(Etudiant::new).collect(toList());
//			etudiants.forEach(System.out::println);
			
			// 3. Construit une liste d'étudiants (méthode 2)
			List<Etudiant> etudiants2 = lS.stream().map(
					s -> new Etudiant(s.split(";")[3], s.split(";")[0])).collect(toList()); 
//			etudiants2.forEach(System.out::println);
			
			// 4. Affiche les noms de moins de 6 caractères qui contiennent la voyelle I ou Y
			System.out.println(etudiants.stream().map(Etudiant::getNom).
					filter(nom -> nom.length() < 6 && (nom.contains("I") || nom.contains("Y"))).
					collect(joining("\n")));
		} catch (IOException e) { 
			e.printStackTrace();
		} 
	}

}
