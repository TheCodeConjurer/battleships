package main.data;

import main.Util;

import java.awt.*;
import java.util.Locale;

public class Grid {

    private Tile[][] grid;
    private boolean hidden;

    public Grid(boolean hidden) {
        this.hidden = hidden;
        Tile[][] tempGrid = new Tile[10][10];
        for (int x = 0; x < tempGrid.length; x++) {
            for (int y = 0; y < tempGrid.length; y++) {
                tempGrid[y][x] = new Tile();
            }
        }
        this.grid = tempGrid;
    }

    public Tile[][] getGrid(){
        return this.grid;
    }

    public boolean shoot(Point p) {
       return grid[p.y][p.x].shot();
    }

    public boolean addBoat(String location, String orientation, Boat boat) {
        Point p = Util.translateCoordinates(location);
        if (p != null){
            if (orientation.equalsIgnoreCase("h")){
                //validate
                if (p.x + boat.length > 10){
                    return false;
                }
                for (int i = 0; i < boat.length; i++) {
                    if (grid[p.y][p.x + i].getState() == TileState.BOAT){
                        return false;
                    };
                }
                // place boat
                for (int i = 0; i < boat.length; i++) {
                    grid[p.y][p.x + i].setState(TileState.BOAT);
                }
            } else {
                //validate
                if (p.y + boat.length > 10){
                    return false;
                }
                for (int i = 0; i < boat.length; i++) {
                    if (grid[p.y + i][p.x].getState() == TileState.BOAT){
                        return false;
                    };
                }
                // place boat
                for (int i = 0; i < boat.length; i++) {
                    grid[p.y + i][p.x].setState(TileState.BOAT);
                }
            }
            return true;
        }
        return false;
    }

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

    public boolean isHidden() {
        return hidden;
    }
}
