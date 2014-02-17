package edu.finki.np.lab8;

public class WeatherStatsTest {

	public static void main(String[] args) {
		WeatherStats ws = new WeatherStats(System.in);
		//System.out.println(ws.getMonthlyPressures());
		System.out.println(ws.temperatureMax());
		System.out.println(ws.temperatureMin());
		System.out.println(ws.temperature("Berovo", "avg"));
		System.out.println(ws.rainyDays("Gevgelija"));
		//System.out.println(ws.getWarmCities("2012.05.12"));
	}

 }