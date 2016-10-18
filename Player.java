/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static amoebaoop.AmoebaOOP.start;
import java.util.Scanner;

/**
 *
 * @author bodnart
 */
public class Player {
    protected String name;
    protected String mark;

    public Player() {
    }

    public Player(String mark) {
        this.mark = mark;
    }


    public String enterName(String text) {

        Scanner sc = new Scanner(System.in);
        System.out.println(text);
        this.name = sc.nextLine();
        return this.name;
    }
    
    public boolean checkResult(String[][] board, String mark) {

        boolean winner = false;
        String[][] matrix = board;
        int mustHit = 0;
        System.out.println(mark);
        if (matrix.length <= 5) {
            mustHit = 3;
        }
        if (matrix.length > 5) {
            mustHit = 5;
        }
//vízszintes sorok vizsgálata       
        for (int i = 0; i < matrix.length; i++) {
            int hit = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {

                if (matrix[i][j] == mark) {
                    hit = 1;
                    winner = true;
                }
                while (hit < mustHit && j - 1 >= 0 && winner) {
                    if (j - hit >= 0 && matrix[i][j - hit] == mark) {
                        winner = true;
                        hit++;
                        if (winner && hit == mustHit) {
                            eredmenyHirdetes(mark);
                        }

                    } else {
                        winner = false;
                        hit = 0;
                    }
                }
            }
        }
//Függőleges sorok vizsgálata
        winner = false;
        for (int i = 0; i < matrix.length; i++) {
            int talalat = 0;
            for (int j = matrix.length - 1; j >= 0; j--) {

                if (matrix[j][i] == mark) {
                    talalat = 1;
                    winner = true;
                }
                while (talalat < mustHit && j - 1 >= 0 && winner) {
                    if (j - talalat >= 0 && matrix[j - talalat][i] == mark) {
                        winner = true;
                        talalat++;
                        if (winner && talalat == mustHit) {
                            eredmenyHirdetes(mark);
                        }
                    } else {
                        winner = false;
                        talalat = 0;
                    }
                }
            }
        }
//átlók vizsgálata jobbról balra           
        winner = false;
        int talalat = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix.length - 1; j >= 0; j--) {

                if (matrix[j][i] == mark) {
                    talalat = 1;
                    winner = true;
                }
                while (talalat < mustHit && i - 1 >= 0 && j - 1 >= 0 && winner) {
                    if (j - talalat >= 0 && i - talalat >= 0 && matrix[j - talalat][i - talalat] == mark) {
                        winner = true;
                        talalat++;
                        if (winner && talalat == mustHit) {
                            eredmenyHirdetes(mark);
                        }
                    } else {
                        winner = false;
                        talalat = 0;
                    }
                }
            }
        }
// átlók vizsgálata balról jobbra
        winner = false;
        talalat = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == mark) {
                    talalat = 1;
                    winner = true;
                }
                while (talalat < mustHit && i - 1 >= 0 && j + talalat < matrix.length && winner) {
                    if (j - talalat >= 0 && matrix[i - talalat][j + talalat] == mark) {
                        winner = true;
                        talalat++;
                        if (winner && talalat == mustHit) {
                            
                        }
                    } else {
                        winner = false;
                        talalat = 0;
                    }
                }
            }
        }
        if (talalat != 3) {
            winner = false;
        }
        return winner;
    }
    
    public void gameResult(Player player){
            System.out.println("Congratulation, " + player  + ", you win!");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("One more match?");
        System.out.println("Yes, of course: 1.)");
        System.out.println("No, thanks: 2.)");
        int newMatch = sc.nextInt();
        switch (newMatch) {
            case 1:
                start();
                break;
            default:
                System.out.println("Bye!");
                System.exit(0);
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
    
    
}
