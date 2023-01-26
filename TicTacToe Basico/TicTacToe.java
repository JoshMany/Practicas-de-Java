package tictactoe;

import java.util.Scanner;

/**
 *
 * @author José Manuel Muñoz García
 */
public class TicTacToe {
    
    public static void main(String[] args) {
        
        boolean[][] xSpots = new boolean[3][3];
        boolean[][] oSpots = new boolean[3][3];
        
        int playerTurn = 1;
        int row = 0;
        int column = 0;
        boolean gameOver = false;
        
        Scanner myObj = new Scanner(System.in);
        
        //Outpout the board
        for(int i = 0; i<3;i++){
            System.out.println("");
            for(int j = 0; j<3; j++){
                System.out.print(" _ ");
            }
        }
        
        while(gameOver == false){
            System.out.println("");
            
            System.out.println("What row do you want?");
            row = myObj.nextInt();
            System.out.println("What column do you want?");
            column = myObj.nextInt();
            
            if(playerTurn == 1){
                xSpots[row][column] = true;
            }else{
                oSpots[row][column] = true;
            }
            
            updateBoard(xSpots, oSpots);
            
            //Check for a win
            gameOver = checkWin(xSpots, oSpots);
            if(gameOver == true){
                break;
            }
            
            //Switch player turn
            if(playerTurn == 1){
                playerTurn = 2;
            }else{
                playerTurn = 1;
            }
        }
        System.out.println();
        if(playerTurn == 1){
            System.out.println("Player One Won!");
        }else{
            System.out.println("Player Two Won!");
        }
    }
   
    public static void updateBoard(boolean[][] p1Spots, boolean[][] p2Spots) {
        System.out.println("\u000c");
        
        for(int i = 0; i<3; i++){
            System.out.println("");
            for(int j=0; j<3; j++){
                if(p1Spots[i][j] == true){
                    System.out.print(" X ");
                }
                else if(p2Spots[i][j] == true){
                    System.out.print(" O ");
                }
                else{
                    System.out.print(" _ ");
                }
            }
        }
    }
    
    public static boolean checkWin(boolean[][] p1Spots, boolean[][] p2Spots){
        //Check across the top
        if(p1Spots[0][0] == true && p1Spots[0][1] == true && p1Spots[0][2] == true){
            return true;
        }
        else if(p2Spots[0][0] == true && p2Spots[0][1] == true && p2Spots[0][2] == true){
            return true;
        }
        
        //Check across the middle
        if(p1Spots[1][0] == true && p1Spots[1][1] == true && p1Spots[1][2] == true){
            return true;
        }
        else if(p2Spots[1][0] == true && p2Spots[1][1] == true && p2Spots[1][2] == true){
            return true;
        }
        
        //Check across the bottom
        if(p1Spots[2][0] == true && p1Spots[2][1] == true && p1Spots[2][2] == true){
            return true;
        }
        else if(p2Spots[2][0] == true && p2Spots[2][1] == true && p2Spots[2][2] == true){
            return true;
        }
        
        //Check left side
        if(p1Spots[0][0] == true && p1Spots[1][0] == true && p1Spots[2][0] == true){
            return true;
        }
        else if(p2Spots[0][0] == true && p2Spots[1][0] == true && p2Spots[2][0] == true){
            return true;
        }
        
        //Check the down middle
        if(p1Spots[0][1] == true && p1Spots[1][1] == true && p1Spots[2][1] == true){
            return true;
        }
        else if(p2Spots[0][1] == true && p2Spots[1][1] == true && p2Spots[2][1] == true){
            return true;
        }
        
        //Check the right side
        if(p1Spots[0][2] == true && p1Spots[1][2] == true && p1Spots[2][2] == true){
            return true;
        }
        else if(p2Spots[0][2] == true && p2Spots[1][2] == true && p2Spots[2][2] == true){
            return true;
        }
        
        //Check diagonal 1
        if(p1Spots[0][0] == true && p1Spots[1][1] == true && p1Spots[2][2] == true){
            return true;
        }
        else if(p2Spots[0][0] == true && p2Spots[1][1] == true && p2Spots[2][2] == true){
            return true;
        }
        
        //Check diagonal 2
        if(p1Spots[2][0] == true && p1Spots[1][1] == true && p1Spots[0][2] == true){
            return true;
        }
        else if(p2Spots[2][0] == true && p2Spots[1][1] == true && p2Spots[0][2] == true){
            return true;
        }
        return false;
    }
    
}
