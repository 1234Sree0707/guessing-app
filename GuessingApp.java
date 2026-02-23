/**
*GuessingApp - Use Case 6: Game Restart and Exit
*
*This class coordinates the complete game lifecycle,
*allowing the player to replay or exit gracefully.
*
*Responsibilites
*-Start a new game
*-Execute the guessing flow
*-Persist game results 
*-Restart or exit based on user choice 
*Store game result at the end
*
*@author Developer
*@version 6.0
*/
import java.util.Scanner;
public class GuessingApp{	

	public static void main(String[] args) throws InvalidInputException{
	    System.out.println("===========================");
		System.out.println("Welcome to the Guessing App");
	    System.out.println("===========================\n");
		/*
		*Player name is captured once
		*and stored along with game results
		*/
		Scanner sc=new Scanner(System.in);
		boolean restart;
	do{
		System.out.print("Enter Player Name: ");
		String player=sc.nextLine();
	    GameConfig gameConfig=new GameConfig();
		HintService hints=new HintService();
		ValidationService inputvalidate=new ValidationService();
		gameConfig.showRules();
		int attempts=0;
		int hintc=0;
		/*
		*Tracks whether the player
		*successfully guessed the number
		*/
		boolean win=false;
		/*
		Game loop runs until the player 
		*exhausts the maximum attempts 
		*/
		while(attempts<gameConfig.getMaxAttemps()){
			System.out.println("Enter your guess: ");
			/*
			*User input is validated before
			*being used in the game logic.
			*/
			int guess=inputvalidate.validateInput(sc.nextLine());
			
			attempts++;
			String result=GuessValidator.validateGuess(guess, gameConfig.getTargetNumber());
			/*
			*A hint is generated only after 
			*an incorrect guess and within
			*the allowed hint limit.
			*/
			if(!"CORRECT".equals(result) && hintc<gameConfig.getMaxHints()){
				hintc++;
				System.out.println(hints.generateHint(gameConfig.getTargetNumber(),hintc));
			}	
			System.out.println(result);
			/*
			*Stop the loop immediately
			*if the correct number is guessed.
			*/
			if("CORRECT".equals(result)){
				break;
			}
        }	
        /*
        *Final game result is persisted
        *after the game loop completes/
        */
        StorageService s=new StorageService();
        s.saveResult(player,attempts,win);
        /*
        *Player decides whether to 
        *restart the game or exit 
        */		
        restart=GameController.restartGame(sc);	
	}while(restart);
}
}	
		
		
