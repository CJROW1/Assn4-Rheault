/*
 * Candidate
 *
 * COMP 1020 SECTION A01
 * Simon Wermie
 * Assignment 4, Question 1
 * Jesse Rheault - 8019357
 * August - 2025
 *
 * This is a class that represents the entire train and manages all the different cars and the 
 * ordering of these cars in the train using linked lists 
 */
public class Train {

    private String name;
    private iTrainCar head;

    //constructor that sets the name for the train unless it is empty null or whitespace
    public Train(String name) throws IllegalArgumentException {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //add a car to the end of the train using the linked list
    public void addCar(iTrainCar car) {
        //check for null input parameters
        if(car == null){
            throw new IllegalArgumentException();
        }
        //check if there is any elements in our linked list if not create a head
        if(head == null){
            head = car;
        }else{
        iTrainCar curr = head;
        while(curr.getNext() != null){
            curr = curr.getNext();
        }
        //set the next car to the new one
        curr.setNext(car);
    }
    }

    //remove a specific link from the linked list and then attach the two parts of the list
    public boolean removeCar(iTrainCar target) {
        //use a linear search to find the target train
        iTrainCar curr = head;
        boolean removed = false;
        if(target == null || head == null){
            removed = false;
        }else{
        //if the head is the target
        if(head == target){
            head = head.getNext();
            removed = true;
        }else{
        while(curr.getNext() != null ){
            //if the next car is the target save this one
            if(curr.getNext() == target){
                curr.setNext(target.getNext());
                removed = true;
            }
            curr = curr.getNext();
        }//while
    }//else
    }//else
    return removed;
    }

    //attach a linked list of train cars to the already existing linked list of train cars
    public void attachCars(iTrainCar other) {
     //check for null input parameters
        if(other == null){
            throw new IllegalArgumentException();
        }
        //check if there is any elements in our linked list if not create a head
        if(head == null){
            head = other;
        }else{
        iTrainCar curr = head;
        while(curr.getNext() != null){
            curr = curr.getNext();
        }
        //set the next car to the new one
        curr.setNext(other);
    }
    }

    //detach a car from the train and then return that car and its subsequent cars in linked list
    public iTrainCar detachAtIndex(int index) {
        iTrainCar curr = null;
        iTrainCar prev = null;
        if(index >= 0 && index < getLength() && head != null){
        //itterate until the index and store the node right before it as well
        curr = head;
        if(index == 0){
            head = null;
        }else{
        for(int i = 0; i < index; i++){
            if(i == index -1){
                prev = curr; 
            }
            curr = curr.getNext();
        }
        prev.setNext(null);
    }
    }
        return curr;
    }

    //detach from a specified car and then set the element before it to be the end and return the
    //list starting from the target element
    public iTrainCar detachAt(iTrainCar target) {
        iTrainCar curr = head;
        iTrainCar detached = null;
        if(target == null || head == null){
        }else{
        //if the head is the target
        if(head == target){
            detached = head;
            head = null;
        }else{
        while(curr.getNext() != null ){
            //if the next car is the target save this one
            if(curr.getNext() == target){
                detached = curr;
                curr = null;
            }
            curr = curr.getNext();
        }//while
    }//else
    }//else
    return detached;
    }

    //finds the first car of the given type in the arraylist and returns it if it exists in the train
    public iTrainCar findFirstCarOfType(String type) {
        iTrainCar curr = null;
        if(head!=null){
            curr = head;
            while(curr.getNext() != null && !curr.getType().equals(type)){
                curr = curr.getNext();
            }
        }
        //check to make sure that a matching type was actually found
        if(!curr.getType().equals(type)){
            curr = null;
        }
        return curr;
    }

    //This method wil sort a linked list of cars based opn their type and return a new linked list
    //containing the sorted original list
    public void sortCarsByType() {
        iTrainCar newHead = null; //head of the new list
        iTrainCar curr = null;  
        iTrainCar holder = null;
        iTrainCar newCurr = null;
        boolean inserted = false;
        //check to see if the current head is null
        if(head != null){
            curr = head;
            newHead = head;
            newCurr = head;
            //itterate through the old linked list and         
        while(curr.getNext() != null){
            inserted = false;
            newCurr = newHead;
            while(inserted == false && newCurr.getNext() != null){
                //if this current element has the same type but the next element isnt insert the element there
                if(curr.getType() == newCurr.getType() && newCurr.getNext().getType() != curr.getType()){
                    holder = newCurr.getNext();
                    newCurr.setNext(curr);
                    newCurr.getNext().setNext(holder);
                    inserted = true;
                }
                newCurr = newCurr.getNext();
            }
            if(inserted == false){
                //if the new string is less than the original check the head to see if it is the lowest
                if(newCurr.getType().compareTo(curr.getType()) > 0){
                    //if the current element is less than the head then replace the head
                    if(newHead.getType().compareTo(curr.getType()) > 0){
                        holder = newHead;
                        newHead = curr;
                        newHead.setNext(holder);
                    }else{ //the element is not less than the head so go look for the next element type
                        newCurr = newHead;
                        //itterate starting at head until you find the next type and then put the curr
                        //in between those two types because there are only 3 types
                        while(newCurr.getType().compareTo(newHead.getType()) == 0){
                            newCurr = newCurr.getNext();
                        }
                        holder = newCurr.getNext();
                        newCurr.setNext(curr);
                        newCurr.getNext().setNext(holder);
                    }
                }else{//if its not bigger then just set the current to be at the end of the new list
                    newCurr.setNext(curr);
                }
            }
        }
        head = newHead; //set the sorted list to be the new list
    }
    }

    //attempt to add a passenger and their luggage to the train will return true if it happens
    public boolean addPassenger(Person p) {
        boolean added = false;
        boolean luggageIn = false;
        if(p == null){
            throw new IllegalArgumentException();
        }
        iTrainCar curr  = null;
        //if there is a head start looking through the list
        if(head != null){
            curr = head;
            //while there is a next car go to that car and look
            while(curr != null && !added){
                if(curr instanceof PassengerCar ){
                    if(((PassengerCar)curr).addPassenger(p)){
                        added = true;
                    }
                }
                curr = curr.getNext();
            }
        }
        //attempt to add their luggage now 
        if(added){
            //check for a passenger car 
            for(int i = 0; i < p.getLuggages().size(); i++){
                curr = head;
                luggageIn = false;
            while(curr != null && !luggageIn){
                if(curr instanceof LuggageCar){
                    //if you cant store the luggage remove the passenger and end the loop
                    if(!((LuggageCar)curr).addLuggage(p.getLuggages().get(i))){
                        added = false;
                        i = p.getLuggages().size();
                    }else{
                        luggageIn = true;
                    }
                }
                curr = curr.getNext();
            }
            if(!added){
                deboardPassenger(p);
            }
        }
        }
        return added;
    }

    //looks to see if a passenger is on the train and then attempts to remove them and their 
    //luggage from the said train return true if successful
    public boolean deboardPassenger(Person p) {
     boolean removed = false;
        boolean luggageOut = false;
        if(p == null){
            throw new IllegalArgumentException();
        }
        iTrainCar curr  = null;
        //if there is a head start looking through the list
        if(head != null){
            curr = head;
            //while there is a next car go to that car and look
            while(curr != null && !removed){
                if(curr instanceof PassengerCar ){
                    if(((PassengerCar)curr).deBoard(p)){
                        removed = true;
                    }
                }
                curr = curr.getNext();
            }
        }
        //attempt to add their luggage now 
        if(removed){
            //check for a passenger car 
            for(int i = 0; i < p.getLuggages().size(); i++){
                curr = head;
                luggageOut = false;
            while(curr != null && !luggageOut){
                if(curr instanceof LuggageCar){
                    //if you cant store the luggage remove the passenger and end the loop
                    if(!((LuggageCar)curr).deBoard(p.getLuggages().get(i))){
                        removed = false;
                        i = p.getLuggages().size();
                    }else{
                        luggageOut = true;
                    }
                }
                curr = curr.getNext();
            }
        }
        }
        return removed;
    }

    //look through the train for a person that matches the name and return their car
    public iTrainCar findPassenger(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        iTrainCar curr = null;
        boolean found = false;
        int[] location;
        if(head!= null){
            curr = head;
            //itterate through the train checking passenger cars for the passenger
            while(curr != null && !found){
                if(curr instanceof PassengerCar){
                    location = ((PassengerCar)curr).locatePassenger(name);
                    //if location found set found to true
                    if(location != null){
                        found = true;
                    }
                }
                if(!found){
                        curr = curr.getNext();
                    }
            }
        }
        return curr;
    }

    //search the train for a certain piece of luggage using the label and return the car
    public iTrainCar findLuggage(String label) {
        if(label == null || label.isEmpty()){
            throw new IllegalArgumentException();
        }
        iTrainCar curr = null;
        boolean found = false;
        int[] location;
        if(head!= null){
            curr = head;
            //itterate through the train checking Luggage cars for the luggage
            while(curr != null && !found){
                if(curr instanceof LuggageCar){
                    location = ((LuggageCar)curr).locateLuggage(label);
                    //if location found set found to true
                    if(location != null){
                        found = true;
                    }
                }
                    if(!found){
                        curr = curr.getNext();
                    }
            }
        }
        return curr;
    }

    //using the fuel cars calculate the maximum total distance that the train would be able to go
    public int calculateMaxDistance() {
        iTrainCar curr = null;
        boolean found = false;
        int fuelTot = 0;
        if(head!= null){
            curr = head;
            //itterate through the train checking Luggage cars for the luggage
            while(curr != null && !found){
                if(curr instanceof FuelCar){
                    fuelTot += ((FuelCar)curr).getMaxCapacity();
                }
                curr = curr.getNext();
            }
        }
        return fuelTot / (getLength() * 10);
    }

    //returns a formatted string showing the ordering of the cars
    public String toString() {
        String info = name + ": ";
        iTrainCar curr;
        if(head != null){
        curr = head;
        //add each car to the string
        while(curr != null){
            info += curr.getType();
            if(curr.getNext() != null){
                info += " -> ";
            }
            curr = curr.getNext();
        }
        }
        return info;
    }
    //ge5ts the length of the current train or linked list
    public int getLength(){
        iTrainCar curr = null;
        int count = 0;
        if(head != null){
            curr = head;
            count++;
        while(curr.getNext()!= null){
            curr = curr.getNext();
            count++;
        }
    }
        return count;
    }

}

