package cpsc2150.extendedConnects;
import java.util.Scanner;
import cpsc2150.extendedConnectX.models.BoardPosition;
import cpsc2150.extendedConnectX.models.GameBoard;

/*GROUP MEMBER NAMES AND GITHUB USERNAMES SHOULD GO HERE
Gabriel Hillesheim @ghilles23


 */
public class GameScreen {
        
        private static GameBoard gameBoard = new GameBoard();
        public static void main(String[] args) {
            
            Scanner input = new Scanner(System.in);
            char currentPlayer = 'X'; //set initial character/ player1 to X
            boolean isPlayedAgain = true; 
    
            while(isPlayedAgain){
               
                System.out.println(gameBoard); //print initial gameBoard
                System.out.print("Player " + currentPlayer + ", what column do you want to place your marker in?\n");
                int chosenCol = input.nextInt();
                if (chosenCol >= 0 && chosenCol < gameBoard.getNumColumns()) {
                   //check validity
                    if (gameBoard.checkIfFree(chosenCol)) {
                        gameBoard.dropToken(currentPlayer, chosenCol);
                        
                        if(gameBoard.checkForWin(chosenCol)){
                            System.out.println(gameBoard);
                            System.out.println("Player " + currentPlayer + " Won!");
                            
                       }
                       
                       //Switch player 1 with player 2
                        if(currentPlayer == 'X'){
                            currentPlayer ='O';
                        }
                        else{
                            currentPlayer = 'X';
                        }
                    } 
                    
                    //Error messages
                    else {
                        System.out.println("Column is full");
                    }
                } else {
                    System.out.println("Invalid column choice. Please choose a valid column.");
                }

                System.out.println("Do you want to play again? y/n");
                isPlayedAgain = input.nextLine().equalsIgnoreCase("y");
             }
        }
                
            
    }

    
