package main.data;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class GridTest extends TestCase {

    public void testShoot() {
        Grid grid = new Grid();
        Point p = new Point(1, 4);
        Assert.assertEquals("Missed", grid.shoot(p));
        Assert.assertEquals(TileState.MISS, grid.getGrid()[4][1].getState());
        Assert.assertNull(grid.shoot(p));
    }

    public void testAddBoat(){
        Grid grid = new Grid();
        Assert.assertTrue(grid.addBoat(new Point(0,0),"h", 4));
        Assert.assertEquals(TileState.BOAT,grid.getGrid()[0][0].getState());
        Assert.assertEquals(TileState.BOAT,grid.getGrid()[0][1].getState());
        Assert.assertEquals(TileState.BOAT,grid.getGrid()[0][2].getState());
        Assert.assertEquals(TileState.BOAT,grid.getGrid()[0][3].getState());
    }

    public void testEmptyGrid(){
        Grid grid = new Grid();
        Assert.assertTrue(grid.allSunk());
    }

    public void testAddBoatInvalid(){
        Grid grid = new Grid();
        Assert.assertFalse(grid.addBoat(new Point(9,9),"h", 4));
        Assert.assertEquals(TileState.NONE,grid.getGrid()[9][9].getState());
    }

}