package main.data;

import java.util.ArrayList;
import java.util.List;

public class Ship {

    private String name;
    private List<Tile> parts = new ArrayList<>();
    private int length;

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public Ship(int length) {
        this.name = "this is a name!";
        this.length = length;
    }

    public boolean isDestroyed() {
        for (Tile t: parts){
            if (t.getState() != TileState.HIT){
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public void addTile(Tile t){
        this.parts.add(t);
    }
}
