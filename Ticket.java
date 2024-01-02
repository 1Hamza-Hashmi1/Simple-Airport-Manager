/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author hamza
 */
public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private int number;
    private static int totalTickets = 0;
    
    public Ticket(Passenger p, Flight flight, double price){
        this.passenger = p;
        this.flight = flight;
        this.price = price;
        this.number = ++Ticket.totalTickets;
    }
    
    public Passenger getPassenger() {
        return this.passenger;
    }
    
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    
    public Flight getFlight() {
        return this.flight;
    }
    
    public void setFlightNumber(Flight flight) {
        this.flight = flight;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(int number) {
        this.number = number;
    }
    
    @Override
    public String toString() {
        return String.format("%s, Flight %d, %s to %s, %s, original price: $%.2f, ticket price: $%.2f",this.passenger.getName() , this.flight.getFlightNumber(), this.flight.getOrigin(), this.flight.getDestination(), this.flight.getDepartureTime(), this.flight.getOriginalPrice(), this.price); 
    }
}
