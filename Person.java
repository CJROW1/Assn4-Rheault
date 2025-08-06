/*
 * Candidate
 *
 * COMP 1020 SECTION A01
 * Simon Wermie
 * Assignment 4, Question 1
 * Jesse Rheault - 8019357
 * August - 2025
 *
 * This is a class that includes information about a person including thei name, and info
 * about their luggage and ticket and allows you to manage that info.
 */
import java.util.ArrayList;

public class Person {
    private final String name;
    private int ticketID;
    private ArrayList<Luggage> luggage;
    static int currTicket = 1; // Static variable to keep track of tickets

    // Constructor for Person includes the parameter of their name not yet boarded
    public Person(String name) {
        this.name = name;
        this.ticketID = 0; //default for none boarded passengers
        this.luggage = new ArrayList<>();
    }

    //constructor for a person that includes their name and their luggage already boarded
    public Person(String name, ArrayList<Luggage> l) {
        this.name = name;
        this.ticketID = currTicket;
        currTicket++;
        this.luggage = l;
    }

    public String getName() {
        return name;
    }

    public int getTicketID() {
        return ticketID;
    }

    public ArrayList<Luggage> getLuggages() {
        return new ArrayList<>(luggage);
    }

    //will return true if the person has boarded a train ticket id > 0
    public boolean boarded() {
        boolean boarded = ticketID > 0;
        return boarded;
    }

    //adds the luggage to the persons luggage if not already contained or if luggage is not null
    public void addLuggage(Luggage l) {
        if(l != null && !luggage.contains(l)){
            luggage.add(l);
        }
    }

    //assigns the persona  new ticket id and returns it
    public int board() {
        ticketID = currTicket;
        currTicket++;
        return ticketID;
    }

    //creates a formatted string of the person's information and then returns it
    public String toString() {
        String info = name + "(Ticket #"+ticketID + ") with ";
        if(luggage.isEmpty()) {
            info += "no luggage";
        }else{
            //add each individual piece of luggage to the string for returning if there is luggage
            info += luggage.size() + " luggage: [";
            for(int i = 0; i < luggage.size(); i++){
                info += luggage.get(i).getLabel();
                if(i < luggage.size() - 1) {
                    info += ", ";
                }
            }
            info += "]";
        }
        return info;
    }

}
