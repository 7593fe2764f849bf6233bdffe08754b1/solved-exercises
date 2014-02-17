package edu.finki.np.lab7;

import java.util.Comparator;

public class BestAppComparator implements Comparator<App> {

	@Override
	public int compare(App o1, App o2) {
		Integer g1 = o1.getRating();
		Integer g2 = o2.getRating();
		return g1.compareTo(g2);
	}

}
