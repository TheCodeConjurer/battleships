package main;

import junit.framework.TestCase;
import main.data.Grid;
import main.data.Ship;
import org.junit.Assert;

import java.awt.*;

import static main.Util.*;

public class UtilTest extends TestCase {

    public void testTranslateCoordinates() {
        Assert.assertEquals(new Point(0,0), translateCoordinates("a1"));
        Assert.assertEquals(new Point(9,9), translateCoordinates("j10"));
    }

    public void testTranslateCoordinatesOutOfBounds() {
        Assert.assertNull(translateCoordinates("a1000"));
        Assert.assertNull(translateCoordinates("z2"));
    }

    public void testShipDestruction(){
        Grid grid = new Grid();
        Ship ship = new Ship("SHIP", 2);
        grid.addBoat(new Point(0,0),"h",ship);
        Assert.assertFalse(ship.isDestroyed());
        grid.shoot(new Point(0,0));
        grid.shoot(new Point(1,0));
        Assert.assertTrue(ship.isDestroyed());
    }
}