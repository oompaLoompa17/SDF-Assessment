package vttp.batch5.sdf.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.sound.midi.SysexMessage;
import vttp.batch5.sdf.task01.models.BikeEntry;


public class Main {

	public static void main(String[] args) {

		String filePath = "C:\\Users\\darre\\Coding\\VTTP\\SDF\\Assessment\\vttp_b5_assessment_template\\task01\\day.csv";
		List<BikeEntry> bikeEntries = new ArrayList<>();
        
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.trim().split(","); 
                bikeEntries.add(BikeEntry.toBikeEntry(values));
            }

			List<BikeEntry> collect = bikeEntries.stream()
										.sorted(Comparator.comparingInt(be -> be.getCasual() + be.getRegistered()))
										.sorted(Collections.reverseOrder())
										.limit(5)
										.collect(Collectors.toList());
			

			String[] position = {"highest", "second highest", "third highest", "fourth highest", "fifth highest"};
			String[] weather = {"Clear, Few clouds, Partly cloudy, Partly cloudy",
								"Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist",
								"Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds",
								"Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog"};
			int i = 1;
			String hols;
			for(BikeEntry b : collect){
				if (b.isHoliday()){
					hols = "a holiday";
				} else{
					hols = "not a holiday";
				}
				
				System.out.printf("The %s (position) recorded number of cyclists was in %s (season), 
									on a %s (day) in the month of %s (month). There were a total of %d (total) cyclists. 
									The weather was %s (weather). %s (day) was %s.",  
									position[i], Utilities.toSeason(b.getSeason()), Utilities.toWeekday(b.getWeekday()), 
									Utilities.toMonth(b.getMonth()), b.getCasual() + b.getRegistered(), weather[b.getWeather()-1],
									Utilities.toWeekday(b.getWeekday()), hols);
				i++;					
			}
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
		
	}

}
