public class Luggage {
    private final String label;
    private final int weight;

    public Luggage(String label, int weight) {
        this.label = label;
        this.weight = weight;
    }

    public String getLabel() { return label; }
    public int getWeight() { return weight; }

    public String toString() { return label + " [" + weight + "kg]"; }
}