package be.superteam.compteBancaire;

public class Compte {
  private int solde = 0;

  public void ajouter(int somme) {
    solde += somme;
    System.out.print(" ajoute " + somme);
  }

  public void retirer(int somme) {
    solde -= somme;
    System.out.print(" retire " + somme);
  }

  public void operationNulle(int somme) {
    solde += somme;
    System.out.print(" ajoute " + somme);
    solde -= somme;
    System.out.print(" retire " + somme);
  }

  public int getSolde() {
    return solde;
  }
}
    
