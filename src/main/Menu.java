package main;

import main.data.Grid;
import main.data.Ship;
import main.data.Tile;
import main.data.TileState;

import java.util.InputMismatchException;
import java.util.Scanner;

import static main.Util.addShip;
import static main.Util.shootGrid;

public class Menu {

    Grid grid;

    public void init() {
        this.grid = new Grid();
        displayMenu();
    }

    private void displayMenu() {
        drawGrid();
        System.out.println("1. Add boat");
        System.out.println("2. Shoot");
        System.out.println("3. Check win");
        System.out.println("4. Reset grid");
        switch (getUserInputNumber(4)) {
            case 1: {
                addBoat();
                break;
            }
            case 2: {
                shoot();
                break;
            }
            case 3: {
                checkWin();
                break;
            }
            case 4: {
                init();
                break;
            }
            default: {
                displayMenu();
            }
        }
    }

    private void checkWin() {
        System.out.println("you have won = ".concat(String.valueOf(this.grid.allSunk())));
        displayMenu();
    }

    private void shoot() {
        System.out.println("enter target:");
        String coordinates = getUserInputString();
        System.out.println(shootGrid(this.grid, coordinates));
        displayMenu();
    }

    private void addBoat() {
        System.out.println("Boat length? (1 - 4)");
        int length = getUserInputNumber(4);
        System.out.println("Boat location?");
        String coordinates = getUserInputString();
        System.out.println("Boat name");
        String name = getUserInputString();
        System.out.println("Orientation vertical (v) or horizontal (h)");
        String orientation = getUserInputString();
        if (!addShip(this.grid, coordinates, orientation, new Ship(name, length))) {
            System.out.println("can't put a ship there");
        }
        displayMenu();
    }

    private int getUserInputNumber(int limit) {
        int number = 0;
        Scanner input = new Scanner(System.in);
        try {
            number = input.nextInt();
            while (number < 0 || number > limit) {
                System.out.print("invalid, try again:  ");
                number = input.nextInt();
            }
        } catch (InputMismatchException e) {
        }
        return number;

    }

    private String getUserInputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private void drawGrid() {
        System.out.println();
        System.out.println("   ABCDEFGHIJ");
        for (int i = 0; i < 10; i++) {
            String line = drawNumber(i);
            for (Tile tile : this.grid.getTiles()[i]) {
                TileState state = tile.getState();
                line = line.concat(state.value);
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

}
