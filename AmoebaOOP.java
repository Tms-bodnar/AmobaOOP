/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amoebaoop;

import model.Player;
import model.Board;


import static model.Step.enterStep;
import static model.Step.stepColumn;
import static model.Step.stepConverter;
import static model.Step.stepRow;


/**
 *
 * @author bodnart
 */
public class AmoebaOOP {

    /**
     * @param args the command line arguments
     */
    
    public static void start(){
        Board b = new Board();
        int t = b.boardSize();
        String[][] board = new String[t][t];
        b.boardBuilder(board);
        
        Player p1 = new Player();
        p1.enterName("First player, ('O') enter your name: ");
        p1.setMark("O");
        Player p2 = new Player(); 
        p2.enterName("Second player, ('X') enter your name: ");
        p2.setMark("X");
        int playerNumber = 1;
        Player actualPlayer = p2;
        do {
            if (playerNumber % 2 == 1) {
                actualPlayer = p1;               
            } else {
                actualPlayer = p2;
            }
        String stepInput = enterStep(actualPlayer);
        stepConverter(stepInput);
        int row = stepRow(stepConverter(stepInput));
        int column = stepColumn(stepConverter(stepInput));
        if (board[row][column] != " ") {
                System.out.println("Wrong step!");
                stepInput = enterStep(actualPlayer);
                stepConverter(stepInput);
                row = stepRow(stepConverter(stepInput));
                column = stepColumn(stepConverter(stepInput));
        board[row][column] = actualPlayer.getMark();
                    b.boardBuilder(board);        
        }else if (playerNumber % 2 == 1) {
                board[row][column] = actualPlayer.getMark();
                b.boardBuilder(board);
        } else {
                board[row][column] = actualPlayer.getMark();
                b.boardBuilder(board);
            }
        playerNumber++;
        }while(actualPlayer.checkResult(board,actualPlayer.getMark()));
        if(actualPlayer.checkResult(board,actualPlayer.getMark())){
            actualPlayer.gameResult(actualPlayer);
        }
        
    }
    public static void main(String[] args) {
        start();
        
        
    }
}

