package main;

import java.awt.*;

import static java.lang.Integer.parseInt;

public class Util {

    public static Point translateCoordinates(String coordinates) {
        try {
            int x = parseInt(coordinates.substring(0, 1), 36) - 10; // converts letters to numbers. a = 0 z = 25
            int y = parseInt(coordinates.substring(1)) - 1;
            if (x <= 10 && y <= 10) {
                return new Point(x, y);
            }
            return null;
        } catch (NumberFormatException e){
            return null;
        }
    }

}
