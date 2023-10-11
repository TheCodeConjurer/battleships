package main.data;

public enum TileState {

    BOAT("B"),
    HIT("X"),
    MISS("O"),
    NONE(".");

    public final String value;

    private TileState(String value) {
        this.value = value;
    }

}