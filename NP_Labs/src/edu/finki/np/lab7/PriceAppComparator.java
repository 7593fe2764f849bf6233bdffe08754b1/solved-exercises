package edu.finki.np.lab7;

import java.util.Comparator;

public class PriceAppComparator implements Comparator<App>{

	@Override
	public int compare(App o1, App o2) {
		Double p1 = o1.getPrice();
		Double p2 = o2.getPrice();
		return p1.compareTo(p2);
	}

}
