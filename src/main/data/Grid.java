package main.data;


import java.awt.Point;

public class Grid {

    private Tile[][] grid;
    private final int gridSize = 10;
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
        this.grid = tempGrid;
    }

    public String shoot(Point p) {
       return grid[p.y][p.x].shoot();
    }

        /**
         * add a boat at the location specified
         * return true if it can be placed
         * @param location location on the grid
         * @param orientation horizontal or vertical
         * @param boat what type of boat
         * @return if placed successfully
         */
    public boolean addBoat(Point location, String orientation, Boat boat) {
        if (location != null){
            if (orientation.equalsIgnoreCase("h")){
                //validate
                if (location.x + boat.length > gridSize){
                    return false;
                }
                for (int i = 0; i < boat.length; i++) {
                    if (grid[location.y][location.x + i].getState() == TileState.BOAT){
                        return false;
                    };
                }

                // place boat
                for (int i = 0; i < boat.length; i++) {
                    grid[location.y][location.x + i].setState(TileState.BOAT);
                }
            } else {
                //validate
                if (location.y + boat.length > gridSize){
                    return false;
                }
                for (int i = 0; i < boat.length; i++) {
                    if (grid[location.y + i][location.x].getState() == TileState.BOAT){
                        return false;
                    };
                }

                // place boat
                for (int i = 0; i < boat.length; i++) {
                    grid[location.y + i][location.x].setState(TileState.BOAT);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * checks if all the boats on this grid are sunk
     */
    public boolean allSunk() {
        for (Tile[] tiles : grid){
            for (Tile tile : tiles){
                if (tile.getState() == TileState.BOAT){
                    return false;
                }
            }
        }
        return true;
    }

    public Tile[][] getGrid() {
        return grid;
    }
}
