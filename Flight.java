/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Hamza
 */
public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice ;
    
    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice) {
        if(origin.equals(destination)){
            throw new IllegalArgumentException("Origin is the same as Destination"); 
        }
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.numberOfSeatsLeft = capacity;
        this.originalPrice = originalPrice; 
    }
  
    public int getFlightNumber() {
        return this.flightNumber;
    }
    
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public String getOrigin() {
        return this.origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
    public String getDestination() {
        return this.destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public String getDepartureTime() {
        return this.departureTime;
    }
    
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    
    public int getCapacity() {
        return this.capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public int getNumberOfSeatsLeft() {
        return this.numberOfSeatsLeft;
    }
    
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    
    public double getOriginalPrice() {
        return this.originalPrice;
    }
    
    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    
    public boolean bookASeat(){
        if(this.numberOfSeatsLeft > 0){
            this.numberOfSeatsLeft = numberOfSeatsLeft - 1;
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public String toString(){
        return String.format("Flight %d, %s to %s, %s, original price: $%.2f", this.flightNumber, this.origin, this.destination, this.departureTime, this.originalPrice);
    }
}
