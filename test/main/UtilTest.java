package main;

import junit.framework.TestCase;
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
}