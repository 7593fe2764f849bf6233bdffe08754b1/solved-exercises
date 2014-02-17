package edu.finki.np.lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class AppManager {

	private ArrayList<App> apps;
	private ArrayList<App> randomApps;
	
	public AppManager(App[] a){
		apps = new ArrayList<App>(Arrays.asList(a));
		randomApps = new ArrayList<App>(apps);
		Collections.shuffle(randomApps);
	}
	
	public App bestApp(){
		return Collections.max(apps, new BestAppComparator());
	}
	
	public App cheapestApp(){
		return Collections.min(apps, new PriceAppComparator());
	}
	
	public List<App> randomChoice(){
		int length = Math.min(3, randomApps.size());
		ArrayList<App> retList = new ArrayList<>(randomApps.subList(0, length));
		randomApps.removeAll(retList);
		if(randomApps.size()==0){
			randomApps = new ArrayList<App>(apps);
			Collections.shuffle(randomApps);
		}	
		return retList;
	}
	
	public List<App> allApps(String attribute, boolean ascending){
		LinkedList<App> retList = new LinkedList<App>(apps);
		Comparator<App> comp;
		switch(attribute){
			case "name": comp = new NameAppComparator(); break;
			case "price": comp = new PriceAppComparator(); break;
			default : comp = new BestAppComparator();
		}
		if(!ascending){
			comp = Collections.reverseOrder(comp);
		}
		Collections.sort(retList, comp);
		return retList;
	}
	
	public int[] ratingStats(){
		int[] grades = new int[5];
		for(App app: apps){
			grades[app.getRating()-1]++;
		}
		return grades;
	}
	
}
