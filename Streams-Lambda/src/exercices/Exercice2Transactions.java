package exercices;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import java.util.Arrays;
import java.util.List;

public class Exercice2Transactions {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950));
		
		List<Transaction> transactions2011 = transactions.stream().filter(t->t.getYear() == 2011).
				sorted(comparing(Transaction::getValue)).collect(toList());
		Utils.displayList("Transactions 2011", transactions2011);
		
		List<String> villesCourtiers = transactions.stream().map(Transaction::getTrader).
				map(Trader::getCity).distinct().collect(toList());
		Utils.displayList("Villes des courtiers", villesCourtiers);
		
		List<Trader> tradersDeCambridge = transactions.stream().map(Transaction::getTrader).
				filter(t->t.getCity().equals("Cambridge")).sorted(comparing(Trader::getName)).
				distinct().collect(toList());
		Utils.displayList("Courtiers de Cambridge", tradersDeCambridge);
		
		String nomsCourtiers = transactions.stream().map(Transaction::getTrader).
		sorted(comparing(Trader::getName)).map(Trader::getName).distinct().collect(joining(","));
		System.out.println(nomsCourtiers);
	}
}
