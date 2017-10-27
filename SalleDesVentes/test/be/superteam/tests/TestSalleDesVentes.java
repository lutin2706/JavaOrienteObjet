package be.superteam.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import be.superteam.domaine.Enchere;
import be.superteam.domaine.Objet;
import be.superteam.domaine.Utilisateur;

public class TestSalleDesVentes {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	// Classe Objet
	private static void testAjoutEnchere(Objet objet, Utilisateur encherisseur) {
		Enchere enchere = new Enchere(10, encherisseur, objet);
	}
	
	private static void testAjoutEnchereTropBasse(Objet objet, Utilisateur encherisseur) {
		Enchere enchere = new Enchere(8, encherisseur, objet);
	}
	
	private static void testAjoutEnchereAnterieure(Objet objet, Utilisateur encherisseur, Enchere enchereAnterieure) {
		
	}
	
	private static void testAjoutEnchereSurObjetVendu(Objet objet, Utilisateur encherisseur) {
		
	}
	
	private static void testOrdreDesObjetsAchetes() {
		
	}
	
	private static void testListeEncheres() {
		// Vérifier ordre des enchères (toujours croissantes en date et en montant)
	}
	
	private static void testListeEncheresDate() {
		// Vérifier liste vide, un seul élément, plusieurs éléments, date postérieure à date du jour
	}
	
	private static void testMeilleureEnchere() {
		
	}
	
	private static void testEncherisseursDuJour() {
		
	}
	
	private static void testEstVendu() {
		
	}
	
	private static void testPrixVente() {
		
	}
	
	// Classe Utilisateur
	private static void testAjouterObjetAchete() {
		
	}
	
	private static void testAjouterObjetDejaAchete() {
		
	}
	
	private static void testAjouterObjetDejaAcheteParAutre() {
		
	}
	
	private static void testAjouterObjetPasEncherisseur() {
		
	}
	
	private static void testListeObjetsAchetes() {
		
	}
	
	private static void testListeObjetsAchetesPourVendeur() {
		
	}
	
	// Salle des Ventes
	private static void testAccepterEnchere() {
		
	}
	
	public static void main(String[] args) {
		TestSalleDesVentes sdv = new TestSalleDesVentes();
		
		Utilisateur vendeur1 = new Utilisateur("Canet", "Guillaume", "guillaume.canet@gmail.be");
		Utilisateur encherisseur1 = new Utilisateur("Dujardin", "Jean", "jdujardin@hotmail.com");
		
		Objet objet = new Objet("Sèche-cheveux vapeur", vendeur1);
		
		sdv.testAjoutEnchere(objet, encherisseur1);
		sdv.testAjoutEnchereTropBasse(objet, encherisseur1);
		afficheEncheres(objet);
	}

	private static void afficheEncheres(Objet objet) {
		StringBuilder sb = new StringBuilder("Liste des enchères pour l'objet: " + objet.getDescription() + "\n");
		int i = 1;
		for (Enchere enchere : objet.encheres()) {
			sb.append("Enchère " + i + ": " + enchere.getMontant() + " par " + enchere.getEncherisseur() + " le " + enchere.getDate());
			i++;
		}
		System.out.println(sb);
	}

}
