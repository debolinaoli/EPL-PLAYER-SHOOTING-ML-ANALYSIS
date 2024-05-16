package com.example;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Day;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TimeSeriesAnalysis {

    public static void main(String[] args) {
        TimeSeries timeSeries = loadData("C:\\Users\\DEBOLINA\\OneDrive\\Documents\\CAC\\cac\\src\\main\\resources\\player_shooting_2023_2024.csv");

        // Display the time series data
        System.out.println("Time Series Data:");
        System.out.println(timeSeries);

        // Perform time series analysis here
    }

    private static TimeSeries loadData(String filename) {
        TimeSeries timeSeries = new TimeSeries("Player Shooting Data");
    
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // Skip header
            br.readLine();
    
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                double shots;
                try {
                    shots = Double.parseDouble(values[9]); // Assuming the "Shots" column is the 10th column
                } catch (NumberFormatException e) {
                    // Skip this line if value parsing fails
                    continue;
                }
                timeSeries.addOrUpdate(new Day(), shots); // You can modify this to add timestamps if needed
                System.out.println("Added data point: Day=" + new Day() + ", Shots=" + shots);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return timeSeries;
    }
    
}
