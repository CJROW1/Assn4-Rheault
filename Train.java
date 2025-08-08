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
    public Train(String name) {
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
        curr.setNext(null);
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
            while(curr != null && curr.getType().equals(type)){
                if(curr.getNext() != null)
                curr = curr.getNext();
            }
        }
        return curr;
    }

    public void sortCarsByType() {

    }

    public boolean addPassenger(Person p) {

    }

    public boolean deboardPassenger(Person p) {

    }

    public iTrainCar findPassenger(String name) {

    }

    public iTrainCar findLuggage(String label) {

    }

    public int calculateMaxDistance() {

    }

    public String toString() {

    }
    //ge5ts the length of the current train or linked list
    public int getLength(){
        iTrainCar curr = null;
        int count = 0;
        if(head != null){
            curr = head;
            count++;
        }
        while(curr.getNext()!= null){
            curr = curr.getNext();
            count++;
        }
        return count;
    }

}

