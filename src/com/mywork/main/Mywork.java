package com.mywork.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.mywork.cofeeshops.Coffeeshop;

import au.com.bytecode.opencsv.CSVReader;

public class Mywork {

	public static void main(String[] args) throws IOException {
		
		  if(args.length < 3)
		    {
		        System.out.println("Proper Usage is: java -jar <jar file> x-coordinate y-coordinate coffeeshops-csv-file");
		        System.exit(0);
		    }
		
		  /*
		   * Get the command line arguments
		   */
		double userXCoordinate = Double.parseDouble(args[0]);
		double useryCoordinate = Double.parseDouble(args[1]);
		String inputCsv = args[2];
		int resultCount=3;
		
		List<Coffeeshop> coffeeShops;
			
		//Parse the input csv and update the list with coffeeshop DAO objects
		coffeeShops = parseCSVFile(inputCsv);
		
		
		//Treemap to store sorted list
		TreeMap<Double, String> distances=calculateDistances(userXCoordinate,useryCoordinate,coffeeShops);
		
		//print the output based on number of output required
		for(Entry<Double, String> entry : distances.entrySet()){
			System.out.println(entry.getValue() + "," + entry.getKey());
			if(--resultCount<1){
				break;
			}
		}
	}

	
	/*
	 * Method to find the distance between the user and the given coffee shops
	 * Returns a map of distance between the user and a coffeshop
	 */
	public static TreeMap calculateDistances(double userXCoordinate,double useryCoordinate, List<Coffeeshop> coffeeShops){
		
		TreeMap<Double, String> distancesList = new TreeMap<Double, String>();
		
		for(Coffeeshop cshop:coffeeShops){
			double distance = findDistance(cshop.getxCoordinate(), cshop.getyCoordinate(), userXCoordinate, useryCoordinate);
			distancesList.put(distance, cshop.getName());
		}
		return distancesList;	
	}
	
	/*
	 * Reads the csv file and populates our coffeeshop objects
	 * 
	 */
	private static List<Coffeeshop> parseCSVFile(String csvfile) throws IOException {
        //create CSVReader object
        CSVReader reader = new CSVReader(new FileReader(csvfile), ',');
         
        List<Coffeeshop> cshops = new ArrayList<Coffeeshop>();
        //read line by line
        String[] record = null;
        try{
	        while((record = reader.readNext()) != null){
	        	//ignoring empty lines
	        	 if(record[0].equalsIgnoreCase("")){continue;}
	        	Coffeeshop cs = new Coffeeshop();
	            cs.setName(record[0]);
	            cs.setxCoordinate(Double.parseDouble(record[1]));
	            cs.setyCoordinate(Double.parseDouble(record[2]));
	            cshops.add(cs);
	        }
        }catch(Exception e){
        	System.out.println("Error in input CSV File. Format should be 'coffee shop name,x-coordinate,y-coordinate");
        	/*
        	 * Write this to log
        	 * e.printStackTrace();
        	 */
        }
        
        reader.close();
        if(cshops.isEmpty()){
        	System.out.println("No coffeshops added. Input csv file is empty/invalid");
        }
//        System.out.println(cshops);
        return cshops;
    }
	
	/*
	 * Method to calculate the distance between two point on a single plane
	 * sqrt(
	 * 		(x1-x2)^2 
	 * 		+(y1 -y2)^2
	 * 		)
	 */
	
	private static double findDistance(double x1,double y1,double x2,double y2){
		return Math.sqrt(
	            (x1 - x2) *  (x1 - x2) + 
	            (y1 - y2) *  (y1 - y2)
	        );
		
	}
}
