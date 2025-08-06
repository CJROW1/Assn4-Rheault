import java.util.ArrayList;

public class Person {
    private final String name;

    private int ticketID;
    private ArrayList<Luggage> luggage;

    public Person(String name) {

    }

    public Person(String name, ArrayList<Luggage> l) {

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

    public boolean boarded() {

    }

    public void addLuggage(Luggage l) {

    }

    public int board() {

    }

    public String toString() {

    }

}
