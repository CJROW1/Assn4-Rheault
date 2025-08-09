/*
 * Candidate
 *
 * COMP 1020 SECTION A01
 * Simon Wermie
 * Assignment 4, Question 1
 * Jesse Rheault - 8019357
 * August - 2025
 *
 * This is a class that represents a fuel car and uses an interface to managage the information
 * about the car including fuel levels and the next train car
 */
public class FuelCar implements iTrainCar {

    private final int maxFuelLevel;
    private int currentFuelLevel;
    private iTrainCar next;

    //creates a new fuel car with a given max fuel amount
    public FuelCar(int maxFuelLevel) {
        if(maxFuelLevel <= 0 ){
            throw new IllegalArgumentException();
        }
        this.maxFuelLevel = maxFuelLevel;
        currentFuelLevel = 0;
    }

    //refuel the tank up to the max fuel level if given too much return false
    public boolean refuel(int amount) {
        boolean refueled = false;
        if(amount <= 0){
            throw new IllegalArgumentException();
        }
        //if the amount exceeds the max return false
        if(currentFuelLevel + amount > maxFuelLevel){
            refueled = false;
        }else{
            currentFuelLevel += amount;
            refueled = true;
        }
        return refueled;
    }

    //consumes a given amount of fuel from the curretn amount of fuel 
    public boolean consumeFuel(int amount) {
        boolean consumed = false;
        if(amount <= 0){
            throw new IllegalArgumentException();
        }
        //check if tehre is aenough fule and consume that amount 
        if(currentFuelLevel - amount >= 0){
            currentFuelLevel -= amount;
            consumed = true;
        }
        return consumed;
    }
    //return the type of the car
    public String getType(){
        return FUEL;
    }
    //get the maximum capacity of the fuel car
    public int getMaxCapacity() {
        return maxFuelLevel;
    }
    //get the next car in the train
    public iTrainCar getNext(){
        return next;
    }
    //set the next car in the train
    public void setNext(iTrainCar next){
        this.next = next;
    }
    //the contents of the car represented by a string 
    public String toStringContents(){
        String contents = "Fuel: [";
        for(int i = 0; i < maxFuelLevel; i++){
            if(i < currentFuelLevel){
                contents += "#";
            }else{
                contents += " ";
            }
        }
        contents += "]";
        return contents;
    }
    //creates a to string for the fuel car showing how much it has and its max
    public String toString(){
        return String.format("FuelCar (%d/%d)", currentFuelLevel, maxFuelLevel);
    }
}