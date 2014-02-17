package edu.finki.np.lab8;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeatherStats {

	private Map<String, ArrayList<WeatherData>> data;
	private WeatherData minTemp;
	private WeatherData maxTemp;
	private String minTempCityName = "";
	private String maxTempCityName = "";

	private class WeatherData {
		private int stationNum;
		private String date;
		private int minTemp;
		private int maxTemp;
		private double rain;
		private int pressure;

		public WeatherData(int stationNum, String date, int minTemp,
				int maxTemp, double rain, int pressure) {
			this.stationNum = stationNum;
			this.date = date;
			this.minTemp = minTemp;
			this.maxTemp = maxTemp;
			this.rain = rain;
			this.pressure = pressure;
		}

	}

	public WeatherStats(InputStream in) {
		data = new HashMap<String, ArrayList<WeatherData>>();
		Scanner reader = new Scanner(in);
		minTemp = new WeatherData(0,"",Integer.MAX_VALUE,Integer.MIN_VALUE,Double.MIN_VALUE,Integer.MIN_VALUE);
		maxTemp = new WeatherData(0,"",Integer.MAX_VALUE,Integer.MIN_VALUE,Double.MIN_VALUE,Integer.MIN_VALUE);
		while(reader.hasNextLine()){
			String[] parts = reader.nextLine().split(";");
			String cityName = parts[0];
			ArrayList<WeatherData> cityInfo = data.get(cityName);
			if(cityInfo==null){
				cityInfo = new ArrayList<WeatherData>();
			}
			for(int i=1; i<parts.length; i++){
				String[] weatherInfo = parts[i].split(" ");
				WeatherData newMeasure = new WeatherData(
						Integer.parseInt(weatherInfo[0]), 
						weatherInfo[1], 
						Integer.parseInt(weatherInfo[2]), 
						Integer.parseInt(weatherInfo[3]), 
						Double.parseDouble(weatherInfo[5]), 
						Integer.parseInt(weatherInfo[4]));
				cityInfo.add(newMeasure);
				if(minTemp.minTemp>newMeasure.minTemp){
					minTempCityName = cityName;
					minTemp = newMeasure;
				}
				if(maxTemp.maxTemp<newMeasure.maxTemp){
					maxTempCityName = cityName;
					maxTemp = newMeasure;
				}
			}
			data.put(cityName, cityInfo);
		}
		reader.close();
	}
	
	public String temperature(String city, String type){
		if(type.equals("max"))
			return max(city);
		if(type.equals("min"))
			return min(city);
		return avg(city);
	}
	
	private String max(String city){
		ArrayList<WeatherData> cityData = data.get(city);
		WeatherData max = cityData.get(0);
		for (WeatherData weatherData : cityData) {
			if(max.maxTemp<weatherData.maxTemp)
				max = weatherData;
		}
		return String.format("%d*C %s", max.maxTemp, max.date);
	}
	
	private String min(String city){
		ArrayList<WeatherData> cityData = data.get(city);
		WeatherData min = cityData.get(0);
		for (WeatherData weatherData : cityData) {
			if(min.minTemp>weatherData.minTemp)
				min = weatherData;
		}
		return String.format("%d*C %s", min.minTemp, min.date);
	}
	
	private String avg(String city){
		ArrayList<WeatherData> cityData = data.get(city);
		int avg = 0;
		for (WeatherData weatherData : cityData) {
			avg += (weatherData.maxTemp + weatherData.minTemp)/2;
		}
		return String.format("%d*C", avg/cityData.size());
	}
	
	public String temperatureMin(){
		return String.format("%s %d*C %s", minTempCityName, minTemp.minTemp, minTemp.date);
	}
	
	public String temperatureMax(){
		return String.format("%s %d*C %s", maxTempCityName, maxTemp.maxTemp, maxTemp.date);
	}
	
	public int rainyDays(String city){
		ArrayList<WeatherData> cityData = data.get(city);
		int rainyDaysCount = 0;
		for (WeatherData weatherData : cityData) {
			if(weatherData.rain>0.05)
				rainyDaysCount++;
		}
		return rainyDaysCount;
	}
	

}
