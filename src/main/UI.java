package main;

import main.data.Boat;
import main.data.Grid;
import main.data.Tile;
import main.data.TileState;

import java.awt.*;
import java.util.Scanner;

import static main.data.TileState.BOAT;
import static main.data.TileState.NONE;

public class UI {

    private Grid player;
    private Grid enemy;

    public UI(Grid player, Grid enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void renderGrids() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println("opponent grid");
        drawGrid(this.enemy);
        System.out.println("your grid");
        drawGrid(this.player);
    }

    private void spacer() {
        System.out.println("------------");
    }

    private void drawGrid(Grid grid) {
        spacer();
        System.out.println("   ABCDEFGHIJ");
        for (int i = 0; i < 10; i++) {
            String line = drawNumber(i);
            for (Tile tile : grid.getGrid()[i]) {
                TileState state = tile.getState();
                if (tile.getState() == BOAT && grid.isHidden()) {
                    line = line.concat(NONE.value);
                } else {
                    line = line.concat(state.value);
                }
            }
            System.out.println(line);
        }
    }

    private String drawNumber(int i) {
        i++;
        if (i < 10) {
            return i + " |";
        }
        return i + "|";
    }

    public void addBoats(Grid playerGrid, Boat[] boats) {
        for (Boat boat : boats) {
            renderGrids();
            boolean placed;
            do {
                System.out.println("Where do you want to place your ".concat(boat.name).concat("?"));
                String location = getUserInput();
                System.out.println("Horizontal (H) or vertical (V)?");
                String orientation;
                do {
                    orientation = getUserInput();
                } while (!orientation.matches("[hHvV]"));
                placed = playerGrid.addBoat(location, orientation, boat);
                if (!placed) {
                    System.out.println("Invalid location, try again");
                }
            } while (!placed);

        }
    }

    private String getUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void shoot(Grid enemyGrid) {
        renderGrids();
        Point p;
        boolean hit;
        do {
            System.out.println("Where would you like to shoot?");
            do {
                String target = getUserInput();
                p = Util.translateCoordinates(target);
            } while (p == null);
            hit = enemyGrid.shoot(p);
        } while (!hit);
    }
}
