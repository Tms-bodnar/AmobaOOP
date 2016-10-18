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
public class Step {
    protected int[] step;

    public Step() {
    }

    public Step(int[] step) {
        this.step = step;
    }

    public static String enterStep(Player player){
        Scanner sc = new Scanner(System.in);
        System.out.println(player.getName() + ", enter yout step!");
        System.out.println("First row, then column: (pl:A2, b3, etc...)");
        String stepInput = sc.nextLine();
        if (Character.isLowerCase(stepInput.charAt(0))) {
            String stepInputUpper = stepInput.toUpperCase();
            stepInput = stepInputUpper;
        }
        return stepInput;
    }
    
    public static int[] stepConverter(String stepInput) {

        int[] step = new int[2];
        char[] row = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L'};
        step[1] = Character.getNumericValue(stepInput.charAt(1));
        for (int i = 0; i < row.length; i++) {
            if (stepInput.charAt(0) == row[i]) {
                step[0] = (i);
            }
        }
        return step;
    }
    
    public static boolean isWinner(String[][] board, String mark) {

        boolean isWinner = false;
        String[][] matrix = board;
        int hit = 0;
        System.out.println(mark);
        if (matrix.length <= 5) {
            hit = 3;
        }
        if (matrix.length > 5) {
            hit = 5;
        }
//vízszintes sorok vizsgálata       
        for (int i = 0; i < matrix.length; i++) {
            int talalat = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {

                if (matrix[i][j] == mark) {
                    talalat = 1;
                    isWinner = true;
                }
                while (talalat < hit && j - 1 >= 0 && isWinner) {
                    if (j - talalat >= 0 && matrix[i][j - talalat] == mark) {
                        isWinner = true;
                        talalat++;
                        if (isWinner && talalat == hit) {
                            eredmenyHirdetes(mark);
                        }

                    } else {
                        isWinner = false;
                        talalat = 0;
                    }
                }
            }
        }
//Függőleges sorok vizsgálata
        isWinner = false;
        for (int i = 0; i < matrix.length; i++) {
            int talalat = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {

                if (matrix[j][i] == mark) {
                    talalat = 1;
                    isWinner = true;
                }
                while (talalat < hit && j - 1 >= 0 && isWinner) {
                    if (j - talalat >= 0 && matrix[j - talalat][i] == mark) {
                        isWinner = true;
                        talalat++;
                        if (isWinner && talalat == hit) {
                            eredmenyHirdetes(mark);
                        }
                    } else {
                        isWinner = false;
                        talalat = 0;
                    }
                }
            }
        }
//átlók vizsgálata jobbról balra           
        isWinner = false;
        int talalat = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix.length - 1; j >= 0; j--) {

                if (matrix[j][i] == mark) {
                    talalat = 1;
                    isWinner = true;
                }
                while (talalat < hit && i - 1 >= 0 && j - 1 >= 0 && isWinner) {
                    if (j - talalat >= 0 && i - talalat >= 0 && matrix[j - talalat][i - talalat] == mark) {
                        isWinner = true;
                        talalat++;
                        if (isWinner && talalat == hit) {
                            eredmenyHirdetes(mark);
                        }
                    } else {
                        isWinner = false;
                        talalat = 0;
                    }
                }
            }
        }
// átlók vizsgálata balról jobbra
        isWinner = false;
        talalat = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == mark) {
                    talalat = 1;
                    isWinner = true;
                }
                while (talalat < hit && i - 1 >= 0 && j + talalat < matrix.length && isWinner) {
                    if (j - talalat >= 0 && matrix[i - talalat][j + talalat] == mark) {
                        isWinner = true;
                        talalat++;
                        if (isWinner && talalat == hit) {
                            eredmenyHirdetes(mark);
                        }
                    } else {
                        isWinner = false;
                        talalat = 0;
                    }
                }
            }
        }
        if (talalat != 3) {
            isWinner = false;
        }
        return isWinner;
    }
    
    public static int stepRow(int[] step) {

        return step[0];
    }
    
    public static int stepColumn(int[] step) {

        return step[1]-1;
    }
    
    public int[] getStep() {
        return step;
    }

    public void setStep(int[] step) {
        this.step = step;
    }
    
}
