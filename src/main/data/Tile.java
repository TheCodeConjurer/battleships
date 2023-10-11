package main.data;

import static main.data.TileState.*;

public class Tile {

    private TileState state;
    private boolean isHit;

    public Tile() {
        this.state = NONE;
    }

    public boolean shot(){
        if (this.isHit){
            return false;
        }
        this.isHit = true;
        this.state = this.state == BOAT ? HIT:MISS;
        return true;
    }

    public String getChar(){
        return state.value;
    }

    public void setState(TileState state) {
        this.state = state;
    }

    public TileState getState() {
        return this.state;
    }
}
