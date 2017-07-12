/******************************************************
 * @author Christian Nwafor
 * Lab: 4
 * Date: 1/12/2016
 * Description: This is main program contains a loop 
 * which prompts for a String, translates to Morse code
 * and prints the Morse code, and then translates back 
 * to characters and prints the characters.
 ******************************************************/
import java.util.Scanner;
//used to read input from the keyboard

public class codedText {
	public static void main (String[] args)
	{
		
		MorseCC obj = new MorseCC();	// create a morse code object to encode and decode a message
		String text; 					// Holds the text to be encrypted, and after decoding
		int choice;						// Holds the choice of a user to repeat program or not
		
		do
		// Loop through: asking user to enter a message
		// encode the message and decode it, till the user
		// enters choice = 2 to end the program
		{
			// get the message from the user
			text = requestMessage();
			
			// Print the encoded text
			String encodedText = obj.encode(text);
			System.out.println("This is the encoded text: " + encodedText);
			
			// Decode the encoded text
			String decodedText = obj.decode(encodedText);
			System.out.println("This is the decoded text: " + decodedText);

			//ask client to repeat program or end
			choice = doAgain();
		} while(choice == 1);	
	}

//--This method requests the user to enter a message------------------------------------------------------------------------------------------------------	
	public static String requestMessage()
	{
		Scanner reader = new Scanner (System.in);
		
		// Ask the user to input a message
		// return the entered String
		System.out.print("Enter a message (in text): ");
		return reader.nextLine();		
	}
	
//--This method requests the user's choice to repeat program or not------------------------------------------------------------------------------------------------------	
	public static int doAgain()
	/***************************************************************
	 * doAgain method to ask the client to repeat the program or not
	 ***************************************************************/
	{
		Scanner keyboard = new Scanner(System.in); 	//to get input from a keyboard
		int choice = 0;								//a client's choice to continue or not
		String tempNum;								//to store number temporarily 
		
		//Ask the user to repeat or not
		System.out.println("\nDo you want to encode and decode another text?"
						 + "\nEnter choice 1 to repeat:"
						 + "\nEnter choice 2 to end the program:");
		try 
		{
			tempNum = keyboard.next();
			choice = Integer.parseInt(tempNum);
		}
		catch (NumberFormatException e)
		{
			System.out.println("\nInvalid entry for choice ");
		    System.out.println("End of Program");
		    System.exit(0);																	
		}
		
		if (choice != 1)
		{
			System.out.println("\nEnd of Program");
			System.exit(0);
		}
		
		//return the choice of the user
		return choice;
	}

}
