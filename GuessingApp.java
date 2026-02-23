/**
*GuessingApp - Use Case 3: Hint Generation 
*
*This class serves as the application entry point.
*It initializes the game configuration and displays game rules. Also takes
*input from the user and tells if the user input is greater than or less than
*the target value. The game also gives two hints
*
*@author Developer
*@version 3.0
*/
import java.util.Scanner;
public class GuessingApp{	
	public static void main(String[] args){
		System.out.println("Welcome to the Guessing App");
		GameConfig gameConfig=new GameConfig();
		HintService hints=new HintService();
		gameConfig.showRules();
		Scanner sc=new Scanner(System.in);
		int attempts=0;
		int hintc=1;
		while(attempts<gameConfig.getMaxAttemps()){
			System.out.println("Enter your guess: ");
			int guess=sc.nextInt();
			attempts++;
			String result=GuessValidator.validateGuess(guess, gameConfig.getTargetNumber());
			String hinti=hints.generateHint(gameConfig.getTargetNumber(),hintc);
			hintc++;
			System.out.println(hinti);
			System.out.println(result);
			if("CORRECT".equals(result)){
				break;
			}
        }			
	}
}	
		
		