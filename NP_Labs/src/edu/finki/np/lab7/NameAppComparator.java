package edu.finki.np.lab7;

import java.util.Comparator;

public class NameAppComparator implements Comparator<App>{

	@Override
	public int compare(App o1, App o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
