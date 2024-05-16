package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

    public static void main(String[] args){
        String csvFile = "C://Users//DEBOLINA//OneDrive//Documents//CAC//cac//src//main//resources//player_shooting_2023_2024.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                // Process data here
                for (String value : data) {
                    System.out.print(value + "\t");
                }
                System.out.println(); // Move to the next line for the next row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   