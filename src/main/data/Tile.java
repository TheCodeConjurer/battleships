package main.data;

import static main.data.TileState.*;

public class Tile {

    private TileState state;
    private boolean isHit;

    public Tile() {
        this.state = NONE;
    }

    /**
     * shoot this tile
     * @return if shot is successful
     */
    public String shoot(){
        if (this.isHit){
            return null;
        }
        this.isHit = true;
        if (this.state == BOAT){
            this.state = HIT;
            return "Hit!";
        }
        this.state = MISS;
        return "Missed";
    }

    public TileState getState() {
        return this.state;
    }

    public void setState(TileState state) {
        this.state = state;
    }
}
