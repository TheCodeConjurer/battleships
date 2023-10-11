package main;

import main.data.Boat;
import main.data.Grid;

import java.util.Scanner;

public class Menu {

    Grid grid;

    public void init(){
        this.grid = new Grid();
        displayMenu();
    }

    private void displayMenu(){
        renderGrid();
        System.out.println("1. Add boat");
        System.out.println("2. Shoot");
        System.out.println("3. Check win");
        System.out.println("4. Reset grid");
        switch (getUserInputNumber(4)){
            case 1:{
                addBoat();
                break;
            }
            case 2:{
                shoot();
                break;
            }
            case 3:{
                checkWin();
                break;
            }
            case 4:{
                resetGrid();
                break;
            }
        }
    }

    private void renderGrid() {
    }

    private void resetGrid() {
        this.grid = new Grid();
        displayMenu();
    }

    private void checkWin() {
        System.out.println("you have won = ".concat(String.valueOf(this.grid.allSunk())));
        displayMenu();
    }

    private void shoot() {
        System.out.println("enter target:");
        String coordinates = getUserInputString();
        System.out.println(Util.shootGrid(this.grid, coordinates));
        displayMenu();
    }

    private void addBoat() {
        System.out.println("Boat length? (1 - 4)");
        int length = getUserInputNumber(4);
        System.out.println("Boat location?");
        String coordinates = getUserInputString();
        System.out.println("Orientation vertical (v) or horizontal (h)");
        String orientation = getUserInputString();
        Util.addShip(this.grid,coordinates,orientation,length);
        displayMenu();
    }

    private int getUserInputNumber(int limit) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        while (number > 0 && number < limit) {
            System.out.print("invalid, try again:  ");
            number = input.nextInt();
        }
        return number;
    }

    private String getUserInputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
