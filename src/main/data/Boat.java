package main.data;

public enum Boat {

    AIRCRAFT_CARRIER("Aircraft Carrier",4),
    DESTROYER("Destroyer",3),
    FRIGATE("Frigate", 2);

    public final String name;
    public final int length;

    private Boat(String name, int length) {
        this.name = name;
        this.length = length;
    }

}