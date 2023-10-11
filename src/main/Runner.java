package main;

import main.data.Boat;
import main.data.Grid;

import java.awt.*;
import java.util.Random;

import static main.data.Boat.*;

public class Runner {

    private Grid playerGrid;
    private Grid enemyGrid;
    private UI ui;

    public Runner() {
        this.enemyGrid = new Grid(true);
        enemyGrid.addBoat("a1", "h", DESTROYER);
        this.playerGrid = new Grid(false);
        this.ui = new UI(this.playerGrid, this.enemyGrid);
    }

    public void run() {
        ui.renderGrids();
        Boat[] boats = {AIRCRAFT_CARRIER, DESTROYER, FRIGATE};
        ui.addBoats(this.playerGrid, boats);
        ui.renderGrids();
        boolean win = false;
        boolean lost = false;
        while (!win || !lost) {
            ui.shoot(enemyGrid);
            enemyTurn();
            win = enemyGrid.allSunk();
            lost = playerGrid.allSunk();
        }
        ui.renderGrids();
        if (win) {
            System.out.println("you won!");
        } else {
            System.out.println("you lost");
        }
    }

    private void enemyTurn() {
        Random random = new Random();
        boolean hit;
        do {
            hit = playerGrid.shoot(new Point(random.nextInt(9) + 1, random.nextInt(9) + 1));
        } while (!hit);
    }
}
