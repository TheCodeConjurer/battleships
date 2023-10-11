package main.data;

import java.awt.*;

public class Grid {

    private Tile[][] tiles;
    private static final int gridSize = 10;

    /**
     * constructor
     */
    public Grid() {
        Tile[][] tempGrid = new Tile[gridSize][gridSize];
        for (int x = 0; x < tempGrid.length; x++) {
            for (int y = 0; y < tempGrid.length; y++) {
                tempGrid[y][x] = new Tile();
            }
        }
        this.tiles = tempGrid;
    }

    public String shoot(Point p) {
        return this.tiles[p.y][p.x].shoot();
    }

    /**
     * add a boat at the location specified
     * return true if it can be placed
     *
     * @param location    location on the grid
     * @param orientation horizontal or vertical
     * @param ship        the ship
     * @return if placed successfully
     */
    public boolean addBoat(Point location, String orientation, Ship ship) {
        int length = ship.getLength();
        if (location != null) {
            if (orientation.equalsIgnoreCase("h")) {
                //validate
                if (location.x + length > gridSize) {
                    return false;
                }
                if (this.tiles[location.y][location.x + length].getState() == TileState.BOAT) {
                    return false;
                }

                // place boat
                for (int i = 0; i < length; i++) {
                    assignShip(this.tiles[location.y][location.x + i], ship);
                }
            } else {
                //validate
                if (location.y + length > gridSize) {
                    return false;
                }
                if (this.tiles[location.y + length][location.x].getState() == TileState.BOAT) {
                    return false;
                }

                // place boat
                for (int i = 0; i < length; i++) {
                    assignShip(this.tiles[location.y + i][location.x], ship);
                }
            }
            return true;
        }
        return false;
    }

    public void assignShip(Tile t, Ship ship) {
        t.setShip(ship);
        t.setState(TileState.BOAT);
        ship.addTile(t);
    }

    /**
     * checks if all the boats on this grid are sunk
     */
    public boolean allSunk() {
        for (Tile[] tileArray : this.tiles) {
            for (Tile tile : tileArray) {
                if (tile.getState() == TileState.BOAT) {
                    return false;
                }
            }
        }
        return true;
    }

    public Tile[][] getTiles() {
        return this.tiles;
    }
}
