package com.mywork.cofeeshops;

public class Coffeeshop {
	
	//local variables for name, x and y
    private String name;
    private double xCoordinate;
    private double yCoordinate;
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getxCoordinate() {
        return xCoordinate;
    }
    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    public double getyCoordinate() {
        return yCoordinate;
    }
    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    
    @Override
    public String toString(){
        return "Name="+name+",xCoordinate="+xCoordinate+",yCoordinate="+yCoordinate+"\n";
    }
}
