public interface iTrainCar {
    String PASSENGER = "Passenger";
    String LUGGAGE = "Luggage";
    String FUEL = "Fuel";
    
    String getType();
    int getMaxCapacity();
    iTrainCar getNext();
    void setNext(iTrainCar next);
    String toStringContents();
    String toString();
}
