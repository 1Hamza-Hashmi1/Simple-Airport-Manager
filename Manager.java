/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;

/**
 *
 * @author hamza
 */
public class Manager {

    private ArrayList<Flight> Flights;
    private ArrayList<Ticket> Tickets;

    public Manager() {
        this.Flights = new ArrayList<>();
        this.Tickets = new ArrayList<>();
    }

    public void createFlights() {
        Flights.add(new Flight(1000,"Mississauga","Ajax","06/30/2020 7:50 pm", 2,6590.32));
        Flights.add(new Flight(1001,"Ajax","Mississauga","07/10/2020 8:10 pm", 3,5268.70));
        Flights.add(new Flight(1002,"Mississauga","Waterloo","07/11/2020 6:20 pm", 2 ,10000));
        Flights.add(new Flight(1003,"Mississauga","Waterloo","07/12/2020 7:20 pm", 3 ,1000));
    }

    public void displayAvalibleFlights(String origin, String destination){
        boolean foundAFlight = false;
        System.out.println(String.format("\nHere are the avalible flights from %s to %s:", origin, destination));
        for (Flight Flight : Flights) {
            if (Flight.getOrigin().equals(origin) && Flight.getDestination().equals(destination) && Flight.getNumberOfSeatsLeft() > 0){
                System.out.println(Flight);
                foundAFlight = true;
            }
        }
        if(!foundAFlight){
            System.out.println(String.format("There are no more avalible flights from %s to %s.", origin, destination));
        }
    }
    
    public Flight getFlight(int flightNumber){
        for(Flight Flight : Flights){
            if(Flight.getFlightNumber() == flightNumber){
                return Flight;
            }
        }
        return null;
    }
    
    public void bookSeat(int flightNumber, Passenger p){
        System.out.println(String.format("\nAttempting to book: %s on Flight %d", p.toString(), flightNumber));
        Flight Flight = this.getFlight(flightNumber);
        if (Flight == null){
            return;
        }
        if (Flight.bookASeat()){
            Tickets.add(new Ticket(p,Flight,p.applyDiscount(Flight.getOriginalPrice())));
        }
    }
    
    public static void main(String args[]){
        Manager manager = new Manager();
        Passenger[] passenger = {new Member("Bill",22,6),new Member("Billy",24,4),new Member("Joe",26,0),new Member("Joey",27,0),new NonMember("Frank",36), new NonMember("Franky",66)};
        manager.createFlights();
        manager.displayAvalibleFlights("Mississauga","Waterloo");
        manager.bookSeat(1002, passenger[0]); //will book successfully, discount of 50% will be applied
        System.out.println(String.format("One ticket with a 50%% discount on flight 1002 should have been booked:\n\t%s", manager.Tickets.get(0).toString()));
        manager.bookSeat(1002, passenger[1]); //will book successfully, discount of 10% will be applied
        System.out.println(String.format("One ticket with a 10%% discount on flight 1002 should have been booked:\n\t%s", manager.Tickets.get(1).toString()));
        manager.bookSeat(1002, passenger[2]); //will not book, since flight is full
        System.out.println(String.format("Booking should have failed, since flight is full (there should only be 2 tickets right now).\n\tNumber of booked tickets:%d", manager.Tickets.size()));
        manager.bookSeat(1003, passenger[2]); //will book successfully, no discount will be applied
        System.out.println(String.format("One ticket with no discount on flight 1003 should have been booked:\n\t%s", manager.Tickets.get(2).toString()));
        manager.bookSeat(1003, passenger[4]); //will book successfully, no discount will be applied
        System.out.println(String.format("One ticket with no discount on flight 1003 should have been booked:\n\t%s", manager.Tickets.get(3).toString()));
        manager.bookSeat(1003, passenger[5]); //will book successfully, discount of 10% will be applied
        System.out.println(String.format("One ticket with a 10%% discount on flight 1002 should have been booked:\n\t%s", manager.Tickets.get(4).toString()));
        manager.displayAvalibleFlights("Mississauga","Waterloo");
    }
}
