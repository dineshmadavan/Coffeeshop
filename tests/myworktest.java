package com.mywork.tests;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mywork.cofeeshops.Coffeeshop;
import com.mywork.main.Mywork;



public class myworktest {
	
	 List<Coffeeshop> coffeeShops = null;
	 TreeMap<Double, String> distances=null;
	 
	 @BeforeClass 
	 public void initialize() {

	     Coffeeshop cs = new Coffeeshop();
	     
	     cs.setName("San Jose 1");
         cs.setxCoordinate(Double.parseDouble("47.6"));
         cs.setyCoordinate(Double.parseDouble("-111"));
         coffeeShops.add(cs);
         
	     cs.setName("San Jose 2");
         cs.setxCoordinate(Double.parseDouble("147.6"));
         cs.setyCoordinate(Double.parseDouble("-11"));
         coffeeShops.add(cs);
	         
	     cs.setName("San Jose 3");
         cs.setxCoordinate(Double.parseDouble("12.6"));
         cs.setyCoordinate(Double.parseDouble("-90"));
         coffeeShops.add(cs);
         
	     cs.setName("San Jose 4");
         cs.setxCoordinate(Double.parseDouble("100.6"));
         cs.setyCoordinate(Double.parseDouble("-11"));
         coffeeShops.add(cs);
	         
	    }
	  
		@Test
	   public void test() {
		Mywork m=new Mywork();
		distances=m.calculateDistances(12, 111, coffeeShops);
	   }
		
		@After
	    public void tearDown() throws IOException { 
			int resultCount=3;
			for(Entry<Double, String> entry : distances.entrySet()){
				System.out.println(entry.getValue() + "," + entry.getKey());
				if(--resultCount<1){
					break;
				}
			}
	    }
		 
}
