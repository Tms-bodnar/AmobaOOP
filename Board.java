/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Scanner;

/**
 *
 * @author bodnart
 */
public class Board {
    protected static int size;

    public Board() {
    }

    public Board(int size) {
        this.size = size;
    }
    
    public int boardSize(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the board size? (min 3, max. 12)");
        System.out.println("Under 5x5 board three marks,");
        System.out.println("over 5x5 board five marks you need for win.");
        size = sc.nextInt();
        return size;
    }
    
    public void boardBuilder(String[][] board) {

        String[][] matrix = board;
        String[] rowLetter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"};
//üres pálya felrajzolása:
        //A cellák kitöltése
        boolean occupied = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (board[i][j] == "O" || board[i][j] == "X") {
                    occupied = true;
                }
                if (!occupied) {
                    matrix[i][j] = " ";
                }
            }
        }
        //A tábla oszlopok számozása
        for (int i = 0; i < 1; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                if (k == 0) {
                    System.out.print(" ");
                }
                if (k >= 9) {
                    System.out.print("  " + (k + 1) + "");
                } else {
                    System.out.print("  " + (k + 1) + " ");
                }
            }
            System.out.println();
        }
        //A tábla első vízszintes sorai
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                if (k == 0) {
                    System.out.print(" ");
                }
                System.out.print("+---");
            }
            // A tábla sorok betűjelei   
            System.out.println("+");
            for (int k = 0; k < matrix[i].length; k++) {
                if (k == 0) {
                    System.out.print(rowLetter[i]);
                }
                System.out.print("| " + matrix[i][k] + " ");
            }
            System.out.println("|");
        }
        //A tábla legalsó sora
        for (int i = 0; i < 1; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                if (k == 0) {
                    System.out.print(" ");
                }
                System.out.print("+---");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
