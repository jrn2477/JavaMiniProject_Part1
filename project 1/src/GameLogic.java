/**
 * @author Jeremy Bolella and Jason Nordheim
 * Contains the main method for the game and all of the game logic that is needed for the game to function
 */
public class GameLogic {


    public static void main(String[] args) {

        GUI gameDisplay = new GUI();

        gameDisplay.init(); // initializes the first screen

        String player1Name = gameDisplay.player1_name;
        String player2Name = gameDisplay.player2_name;
        // Player player2 = new Player();
        gameDisplay.setBoard(player1Name); //setup the player setup board stage






    }

}
