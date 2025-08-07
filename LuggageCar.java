/*
 * Candidate
 *
 * COMP 1020 SECTION A01
 * Simon Wermie
 * Assignment 4, Question 1
 * Jesse Rheault - 8019357
 * August - 2025
 *
 * This is a class that represents a luggage car and uses a interface for cars in order to manage 
 * information about the luggage that is being carried by the car and the next car
 */
public class LuggageCar implements iTrainCar {
    
    private Luggage[][] storage;
    private iTrainCar next;

    //constructor to initialize the luggage car in the train with a number of compartments
    public LuggageCar(int numCompartments) {
        //check if negative or 0 compartments
        if(numCompartments <= 0){
            throw new IllegalArgumentException();
        }
        //initialize the storage to have the number of compartments rows
        storage = new Luggage[numCompartments][];
    }

    //get the maximum number of initialized luggage spots in this car
    public int getMaxCapacity(){
        int counter = 0;
        //itterate through all the rows of compartments and add how many luggage slots there are
        //in each row 
        for(int i = 0; i < storage.length; i++){
            counter += storage[i].length;
        }
        return counter;
    }
    //returns the total weight of all the luggage contained in all the slots
    public int getWeight() {
        int weight = 0;
        //itterate through the 2d array and add to the total weight for every stored piece of luggage
        for(int i = 0; i < storage.length; i++){
            for(int j = 0; j<storage[i].length; j++){
                if(storage[i][j]!=null){
                weight += storage[i][j].getWeight();
                }
            }
        }
        return weight;
    }
    //get the type of car that this currently is
    public String getType(){
        return LUGGAGE;
    }
    //get the next car in the linked list
    public iTrainCar getNext(){
        return next;
    }
    //set the next car in the linked list
    public void setNext(iTrainCar next){
        this.next = next;
    }

    //initializes the compartment at a given index with a size for number of luggage slots
    //so long as the index and size are both valid inputs non negative or 0 for size
    public boolean initializeCompartment(int index, int size) {
        boolean initialized = false;
        if(index < 0 || index >= storage.length || size <=0 ){
            throw new IllegalArgumentException();
        }
        //check if already initialized
        if(storage[index].length != 0){
            throw new IllegalArgumentException();
        }else{
        //if the index exists and isnt initialized go and initialize it
        storage[index] = new Luggage[size];
        initialized = true;
        }
        return initialized;
    }

    //attempts to add luggage to an empty luggage spot on the passenger car in train
    public boolean addLuggage(Luggage l) {
     boolean packed = false;
        //check that the luggage is not null 
        if( l == null){
            throw new IllegalArgumentException();
        }
        //luggage is not null so search for a spot and then store it in that spot
        for(int i = 0; i < storage.length; i++){
            for(int j = 0; j < storage[i].length; j++){
                if(storage[i][j] == null){
                    storage[i][j]= l;
                    packed = true;
                }
            }
        }
        return packed;
    }

    //attempts to remove a piece of luggage from the car if found it will be removed
    public boolean deBoard(Luggage l) {
        boolean removed = false;
         //check that the luggage is not null 
            if( l == null){
                throw new IllegalArgumentException();
            }
            //luugage is not null so search for the luggage and remove them from the seat
            for(int i = 0; i < storage.length; i++){
                for(int j = 0; j < storage[i].length; j++){
                    if(storage[i][j] == l){
                        storage[i][j]= null;
                        removed = true;
                    }
                }
            }
            return removed;
    }

     //find a luggage using its label and return an array of their spots index
    public int[] locateLuggage(String label) {
        int[] location = new int[2];
        //check that the label is a valid label
        if(label == null){
            throw new IllegalArgumentException();
        }
        //the given label is valid so search for the luggage and store its location
        for(int i = 0; i < storage.length; i++){
            for(int j = 0; j < storage[i].length; j++){
                if(storage[i][j].getLabel().equals(label)){
                    location[0] = i;
                    location[1] = j;
                }
            }
        }
        return location;
    }

    //returns a string representing the contents of the car 
    public String toStringContents(){
        String contents = "";
        //itterate throw the MDA to gather all of the compartments in a string of their luggage
        for(int i = 0; i < storage.length; i++){
            contents += "Compartment "+ i + ": ";

            for(int j = 0; j < storage[i].length; j++){
                if(storage[i][j] != null){
                contents += "[]";
                }else{
                    contents += "__";
                }
            }
            contents += "\n";
        }
        return contents;
    }
    //get the number of luggage on the train car
    public int getLuggage(){
        int counter = 0;
        //itterate through all the compartments and increase count whenever a luggage is in a spot
        for(int i = 0; i < storage.length; i++){
            for(int j = 0; j < storage[i].length; j++){
                if(storage[i][j] != null){
                    counter++;
                }
            }
        }
        return counter;
    }
    //returns a formatted string containing information about the max Luggage compared to the 
    //current amount of luggage on the train
    public String toString(){
        return String.format("LuggageCar (%d/%d occupied) @ %dkg",
         getLuggage(), getMaxCapacity(), getWeight());
    }
}

