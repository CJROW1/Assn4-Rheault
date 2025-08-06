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

    public FuelCar(int maxFuelLevel) {

    }

    public boolean refuel(int amount) {

    }

    public boolean consumeFuel(int amount) {

    }
}