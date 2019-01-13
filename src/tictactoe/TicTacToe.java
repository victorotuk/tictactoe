package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        //at first the main method had no instructions in it, but it is created first when we create the package..
        // -->notsndcrosses.java    ___________ is the starting point
        Scanner sc = new Scanner(System.in);
        boolean doYouWantToPlay = true;
        
        while(doYouWantToPlay){
            System.out.println("Welcome to nots and crosses!");
            System.out.println("please pick your character: ");
            char playerToken = sc.next().charAt(0);
            System.out.println("now enter a single character that will represent your opponent on the board");
            char opponentToken = sc.next().charAt(0);
            
            notsndcrosses game = new notsndcrosses(playerToken, opponentToken);
            AI ai = new AI();
            
            //set up the game.
            System.out.println();
            System.out.println("Now we can start the game. to play enter  a number and your token shall be put in its place.\n the numbers go from 1 to 9 left to right");
            
            notsndcrosses.printIndexBoard();
            System.out.println();
            
            while(game.gameOver().equals("notOver")){
                if(game.currentMarker == game.userMarker){
                    System.out.println("It's your turn! Enter a spot for your token");
                    int spot = sc.nextInt();
                    while(!game.turn(spot)){
                        System.out.println("invalid spot, try again");
                        spot = sc.nextInt();
                    }
                    System.out.println("you picked "+ spot +"!");
                }else{
                    System.out.println("It's my turn!");
                    int aiSpot = ai.pickSpot(game);
                    game.turn(aiSpot);
                    System.out.println("I picked spot "+aiSpot+"!");
                }
                System.out.println();
                game.printBoard();
                System.out.println("");
                
            }
            System.out.println(game.gameOver());
            System.out.println();
            System.out.println("Do you want to play again? enter Y if you do. "+"Enter anything else if you are tired of me.");
            char response = sc.next().charAt(0);
            doYouWantToPlay = (response=='y');
            System.out.println();
        }
        
        
    }
    
}
