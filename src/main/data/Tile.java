package main.data;

import static main.data.TileState.*;

public class Tile {

    private TileState state;
    private boolean isHit;
    private Ship ship;

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
        if (this.ship != null){
            this.state = HIT;
            boolean destroyed = this.ship.isDestroyed();
            if (destroyed){
                return "You destroyed the ".concat(this.ship.getName());
            }
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

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
