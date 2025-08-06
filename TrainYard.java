/*
 * Candidate
 *
 * COMP 1020 SECTION A01
 * Simon Wermie
 * Assignment 4, Question 1
 * Jesse Rheault - 8019357
 * August - 2025
 *
 * This is a class that represents the yard of all the trains and allows you to manage all of the 
 * trains as well as all the people and luggage that are contained in the yard
 */
import java.util.ArrayList;

public class TrainYard {
    
    private ArrayList<Train> trains;
    private ArrayList<Person> people;
    private ArrayList<Luggage> luggage;

    public TrainYard() {

    }

    // ==== Train Management ====
    public boolean createTrain(String name) {

    }

    public Train getTrain(String name) {

    }

    public String[] listTrains() {

    }

    // ==== Person and Luggage Management ====
    public boolean createPerson(String name) {

    }

    public boolean createLuggage(String label, int weight, String ownerName) {

    }

    public Person getPerson(String name) {

    }

    public Luggage getLuggage(String label) {

    }

    // ==== Passenger Operations ====
    public boolean addPassengerToTrain(String trainName, String personName) {

    }

    public boolean deboardPassengerFromTrain(String trainName, String personName) {

    }

    public iTrainCar findPassengerInTrain(String trainName, String personName) {

    }

    public iTrainCar findLuggageInTrain(String trainName, String label) {

    }

    // ==== Info & Metrics ====
    public int getMaxDistance(String trainName) {

    }

    public String describeTrain(String trainName) {

    }

    // ==== Shunting (Merging and Rearranging) ====
    public boolean sortTrain(String trainName) {

    }


    public boolean shuntWholeTrain(String fromTrain, String toTrain) {

    }

    public boolean shuntFromCarType(String fromTrain, String toTrain, String carType) {

    }

    public boolean shuntFromIndex(String fromTrain, String toTrain, int index) {

    }

    public String toString() {

    }
}
