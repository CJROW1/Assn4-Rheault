/*
 * Candidate
 *
 * COMP 1020 SECTION A01
 * Simon Wermie
 * Assignment 4, Question 1
 * Jesse Rheault - 8019357
 * August - 2025
 *
 * This is a class that representsa  passanger car and uses an interface to help manage the information
 * about the passengers that are inside the car 
 */
public class PassengerCar implements iTrainCar {

    private Person[][] seats;
    private iTrainCar next;

    //constructor that creates a new passenger car with rows and columns for seats
    public PassengerCar(int rows, int cols) {
        //check that the parameters are valid 
        if(rows <= 0 || cols <= 0){
            throw new IllegalArgumentException();
        }
        seats = new Person[rows][cols];
    }    

    //get the maximum capacity of the passanger car using .length for each dimension of the array
    public int getMaxCapacity() {
        return seats.length * seats[0].length;
    }
    //get the type of train car that this is 
    public String getType(){
        return PASSENGER;
    }
    //get the next car in the train
    public iTrainCar getNext(){
        return next;
    }
    //set the next car in the train using the linked list
    public void setNext(iTrainCar next){
        this.next = next;
    }

    //This method will look for an available seat and attempt to board a passenger into that seat
    public boolean addPassenger(Person p) {
        boolean boarded = false;
        //check that the person is not null 
        if( p == null){
            throw new IllegalArgumentException();
        }
        //passanger is not null so search for a seat and then assign them to that seat
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j] == null && !boarded){
                    seats[i][j]= p;
                    p.board();
                    boarded = true;
                }
            }
        }
        return boarded;
    }

    //search for a specific passenger and remove them from their seat if found
    public boolean deBoard(Person p) {
    boolean removed = false;
         //check that the person is not null 
            if( p == null){
                throw new IllegalArgumentException();
            }
            //passanger is not null so search for the person and remove them from the seat
            for(int i = 0; i < seats.length; i++){
                for(int j = 0; j < seats[i].length; j++){
                    if(seats[i][j] == p && !removed){
                        seats[i][j]= null;
                        removed = true;
                    }
                }
            }
            return removed;
    }

    //find a passenger using their name and return an array of their spots index
    public int[] locatePassenger(String name) {
        int[] location = {-1,-1};
        //check that the name is a valid name
        if(name == null){
            throw new IllegalArgumentException();
        }
        //the given name is valid so search for the person and store their location
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j].getName().equals(name) && seats[i][j]!=null){
                    location[0] = i;
                    location[1] = j;
                }
            }
        }
        if(location[0] == -1 && location[1] == -1){
            location = null;
        }
        return location;
    }

    //returns a string representing the contents of the car 
    public String toStringContents(){
        String contents = "";
        //itterate throw the MDA to gather all of the rows and seats in a string of their passengers
        for(int i = 0; i < seats.length; i++){
            contents += "Row "+ i + ": ";

            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j] != null){
                contents += seats[i][j].getName();
                }else{
                    contents += "Empty";
                }

                if(j < seats[i].length - 1){
                    contents += " | ";
                }
            }
            contents += "\n";
        }
        return contents;
    }
    //get the number of passengers on the train car
    public int getPassengers(){
        int counter = 0;
        //itterate through all the seats and increase count whenever a person is in a seat
        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j] != null){
                    counter++;
                }
            }
        }
        return counter;
    }

    //returns a formatted string containing information about the max passengers compared to the 
    //current amount of passengers on the train
    public String toString(){
        return String.format("PassengerCar (%d/%d occupied)", getPassengers(), getMaxCapacity());
    }
}
