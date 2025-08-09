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

    //initializes the train with empy arraylists of trains people and luggage
    public TrainYard() {
        trains = new ArrayList<Train>();
        people = new ArrayList<Person>();
        luggage = new ArrayList<Luggage>();
    }

    // ==== Train Management ====
    //attempts to create a new train as long as the name is valid and not a repeat
    public boolean createTrain(String name) {
        boolean created;
        try{
            trains.add(new Train(name));
            created = true;
        }catch(IllegalArgumentException iae){
            created = false;
        }
        return created;
    }

    //returns the train object with the specified name! or null if not found
    public Train getTrain(String name) {
        Train found = null;
        for(int i = 0; i < trains.size(); i++){
            if(trains.get(i).getName().equals(name)){
                found = trains.get(i);
            }
        }
        return found;
    }

    //creates a new array that will be filled with the names of all the trains in the list
    public String[] listTrains() {
        String[] names =  new String[trains.size()];
        for(int i = 0; i < trains.size(); i++){
            names[i] = trains.get(i).getName();
        }
        return names;
    }

    // ==== Person and Luggage Management ====
    //attempt to add a new person to the person arraylist
    public boolean createPerson(String name) {
        boolean created;
        try{
            people.add(new Person(name));
            created = true;
        }catch(IllegalArgumentException iae){
            created = false;
        }
        return created;
    }

    //attempt to create a new luggage with the given information
    public boolean createLuggage(String label, int weight, String ownerName) {
        boolean created = false;
        Luggage newLuggage;
        if(getLuggage(label) ==null && weight > 0 && getPerson(ownerName) != null){
            newLuggage = new Luggage(label, weight);
            getPerson(ownerName).addLuggage(newLuggage);
            created = true;
            luggage.add(newLuggage);
        }
        return created;
    }

    //returns a person object when given a name returns null if not found
    public Person getPerson(String name) {
        Person found = null;
        for(int i = 0; i < people.size(); i++){
            if(people.get(i).getName().equals(name)){
                found = people.get(i);
            }
        }
        return found;
    }

    //get a luggage object when given a label for the luggage
    public Luggage getLuggage(String label) {
        Luggage found = null;
        for(int i = 0; i < luggage.size(); i++){
            if(luggage.get(i).getLabel().equals(label)){
                found = luggage.get(i);
            }
        }
        return found;
    }

    // ==== Passenger Operations ====
    //add a person to a train if both the train and the person exist 
    public boolean addPassengerToTrain(String trainName, String personName) {
        boolean added = false;
        if(getTrain(trainName) != null && getPerson(personName) != null){
            if(getTrain(trainName).addPassenger(getPerson(personName))){
                added = true;
            }
        }
        return added;
    }

    //removes a person from a specified train if either dont exist return false else true
    public boolean deboardPassengerFromTrain(String trainName, String personName) {
        boolean removed = false;
        if(getTrain(trainName) != null && getPerson(personName) != null){
            if(getTrain(trainName).deboardPassenger(getPerson(personName))){
                removed = true;
            }
        }
        return removed;
    }

    //searches the train and looks for the car where a specified person is located and returns it   
    public iTrainCar findPassengerInTrain(String trainName, String personName) {
        iTrainCar passengerCar = null;
        if(getTrain(trainName) != null && getPerson(personName) != null){
            passengerCar = getTrain(trainName).findPassenger(personName);
        }
        return passengerCar;
    }

    //looks through the trains an returns the car that contains the luggage or null if not found
    public iTrainCar findLuggageInTrain(String trainName, String label) {
        iTrainCar luggage = null;
        if(getTrain(trainName) != null && getPerson(label) != null){
            luggage = getTrain(trainName).findLuggage(label);
        }
        return luggage;
    }

    // ==== Info & Metrics ====
    //get the maximum possible distance that a train would be able to travel
    public int getMaxDistance(String trainName) {
        int maxDist = 0;
        if(getTrain(trainName) != null){
            maxDist = getTrain(trainName).calculateMaxDistance();
        }
        return maxDist;
    }

    //get the string from the train class if the given train exists and return it
    public String describeTrain(String trainName) {
        String trainInfo = "Train not found.";
        if(getTrain(trainName) != null){
            trainInfo = getTrain(trainName).toString();
        }
        return trainInfo;
    }

    // ==== Shunting (Merging and Rearranging) ====
    //use the created method if the train exists and sort the train by type 
    public boolean sortTrain(String trainName) {
        boolean sorted = false;
        if(getTrain(trainName) != null){
            getTrain(trainName).sortCarsByType();
            sorted = true;
        }
        return sorted;
    }

    //take all the cars attached to the from train detach them and then reatach them to the toTrain
    //if both of them exist and are not the same train
    public boolean shuntWholeTrain(String fromTrain, String toTrain) {
        boolean shunted = false;
        iTrainCar held = null;
        //attach one train to the end of the other
        if(getTrain(fromTrain) != null && getTrain(toTrain) != null && getTrain(toTrain) != getTrain(fromTrain)){
            held = getTrain(fromTrain).detachAtIndex(0);
            getTrain(toTrain).addCar(held);
            shunted = true;
        }
        return shunted;
    }

    //attempt to take all the cars after finding the first instance of a type and append them to
    //a different train and return true or false based on if it happens
    public boolean shuntFromCarType(String fromTrain, String toTrain, String carType) {
        boolean shunted = false;
        iTrainCar held = null;
        iTrainCar car = null;
        //attach one train to the end of the other starting at a type
        if(getTrain(fromTrain) != null && getTrain(toTrain) != null && getTrain(toTrain) != getTrain(fromTrain)){
            car = getTrain(fromTrain).findFirstCarOfType(carType);
            held = getTrain(fromTrain).detachAt(car);
            getTrain(toTrain).addCar(held);
            shunted = true;
        }
        return shunted;
    }

    //take a train and detach it from a specific given index and then append it to the end
    //of the other given train
    public boolean shuntFromIndex(String fromTrain, String toTrain, int index) {
        boolean shunted = false;
        iTrainCar held = null;
        //attach one train to the end of the other
        if(getTrain(fromTrain) != null && getTrain(toTrain) != null && getTrain(toTrain) != getTrain(fromTrain) &&
        index < getTrain(fromTrain).getLength() && index >= 0){
            held = getTrain(fromTrain).detachAtIndex(index);
            getTrain(toTrain).addCar(held);
            shunted = true;
        }
        return shunted;
    }

    //returns a formatted string about all the trains
    public String toString() {
        String info = "";
        for(int i = 0; i < trains.size(); i++){
            info += trains.get(i).toString();
            info += "\n";
        }
        return info;
    }
}
