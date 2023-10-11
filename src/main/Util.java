package main;

import main.data.Boat;
import main.data.Grid;

import java.awt.*;

import static java.lang.Integer.parseInt;

public class Util {

    /**
     * converts string locations to a point
     * ie a1 -> 0,0
     */
    public static Point translateCoordinates(String coordinates) {
        try {
            int x = parseInt(coordinates.substring(0, 1), 36) - 10; // converts letters to numbers. a = 0 z = 25
            int y = parseInt(coordinates.substring(1)) - 1;
            if (x <= 10 && y <= 10) {
                return new Point(x, y);
            }
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * shoots a grid and lets you know if you hit or missed
     */
    public static String shootGrid(Grid grid, String target) {
        Point p = translateCoordinates(target);
        if (p != null) {
            String str = grid.shoot(p);
            if (!str.isEmpty()) {
                return str;
            }
        }
        return "Invalid target";
    }

    public static boolean addShip(Grid grid, String coordinates,String orientation, Boat boat){
        if (orientation.matches("[vVhH]]")) {
            Point p = translateCoordinates(coordinates);
            if (p != null) {
                return grid.addBoat(p, orientation, boat);
            }
        }
        return false;
    }
}
