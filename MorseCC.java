/******************************************************
 * @author Christian Nwafor
 * Lab: 4
 * Date: 1/12/2016
 * Description: This is the Morse code class
 ******************************************************/

public class MorseCC {
	protected String[] morse = new String [26];				// This is the encoding array of string
	protected BinTree <String> source;						// This BinTree is the decoding tree
	
	public MorseCC ()
	{
		//initialize the array 
		morse[0] = ".-";							// A
		morse[1] = "-...";							// B
		morse[2] = "-.-.";							// C
		morse[3] = "-..";							// D
		morse[4] = ".";								// E
		morse[5] = "..-.";							// F
		morse[6] = "--.";							// G
		morse[7] = "....";							// H	
		morse[8] = "..";							// I
		morse[9] = ".---"; 							// J
		morse[10] = "-.-";							// K
		morse[11] = ".-..";							// L
		morse[12] = "--";							// M
		morse[13] = "-.";							// N
		morse[14] = "---";							// O
		morse[15] = ".--.";							// P
		morse[16] = "--.-";							// Q
		morse[17] = ".-.";    						// R
		morse[18] = "...";							// S
		morse[19] = "-";							// T
		morse[20] = "..-";							// U
		morse[21] = "...-";							// V
		morse[22] = ".--";							// W
		morse[23] = "-..-";							// X
		morse[24] = "-.--";							// Y
		morse[25] = "--..";							// Z
		
		// Call the constructTree method to build the tree
		constructTree();
	}
//--This method builds the decoding Tree -----------------------------------------------------------------------------------------------------	
	public void constructTree()
	// Create little trees and attach them to the main tree
	{
		// Create the S tree, left H, right V
		BinTree <String> sTree = new BinTree <String> ("S", new BinTree <String> ("H"), new BinTree <String> ("V"));
		
		// Create the U tree, attachLeft "F"
		BinTree <String> uTree = new BinTree <String> ("U");
		uTree.attachLeft(new BinTree <String> ("F"));
		
		// Create the R tree, and attachLeft "L"
		BinTree <String> rTree = new BinTree <String> ("R");
		rTree.attachLeft(new BinTree <String> ("L"));
		
		// Create the W tree, left P, right J
		BinTree <String> wTree = new BinTree <String> ("W", new BinTree <String> ("P"), new BinTree <String> ("J"));
		
		// Create the D tree, left B, right X
		BinTree <String> dTree = new BinTree <String> ("D", new BinTree <String> ("B"), new BinTree <String> ("X"));
		
		// Create the K tree, left C, right Y
		BinTree <String> kTree = new BinTree <String> ("K", new BinTree <String> ("C"), new BinTree <String> ("Y"));
		
		// Create the G tree, left Z, right Q
		BinTree <String> gTree = new BinTree <String> ("G", new BinTree <String> ("Z"), new BinTree <String> ("Q"));
		
		// Create the O, no left, no right
		BinTree <String> oTree = new BinTree <String> ("O");
		
		// Create the I tree, attach the S to left, and U to right
		BinTree <String> iTree = new BinTree <String> ("I", sTree, uTree);
		
		// Create the A tree, attach the R to the left, and W to right
		BinTree <String> aTree = new BinTree <String> ("A", rTree, wTree);
		
		// Create the N tree, attach the D to the left, and K to right
		BinTree <String> nTree = new BinTree <String> ("N", dTree, kTree);
		
		// Create the M tree, attach the G to the left, and O to right
		BinTree <String> mTree = new BinTree <String> ("M", gTree, oTree);
		
		// Create the E tree, attach the I to the left, and A to right
		BinTree <String> eTree = new BinTree <String> ("E", iTree, aTree);
		
		// Create the T tree, attach the N to the left, and M to right
		BinTree <String> tTree = new BinTree <String> ("T", nTree, mTree);
		
		// Attach the eTree to the left of the root
		// Attach the tTree to the right of the root
		source = new BinTree<String> (" ", eTree, tTree);
	} 

//--This method calls encoder to encode a string into a morse code-----------------------------------------------------------------------------------------------------	
	public String encode (String message){
		return encoder(message);
	}
	
//--This method encodes a string into morse a code -----------------------------------------------------------------------------------------------------	
	private String encoder (String message)
	{
		char[] cArray = message.toUpperCase().toCharArray();
		String morseCode = "";
		
		for (int i = 0; i < cArray.length; i++)
		{
			if (cArray[i] == ' ')
				morseCode += "#";
			else if (cArray[i] == 'A')
				morseCode += morse[0] + " ";
			else if (cArray[i] == 'B')
				morseCode += morse[1] + " ";
			else if (cArray[i] == 'C')
				morseCode += morse[2] + " ";
			else if (cArray[i] == 'D')
				morseCode += morse[3] + " ";
			else if (cArray[i] == 'E')
				morseCode += morse[4] + " ";
			else if (cArray[i] == 'F')
				morseCode += morse[5] + " ";
			else if (cArray[i] == 'G')
				morseCode += morse[6] + " ";
			else if (cArray[i] == 'H')
				morseCode += morse[7] + " ";
			else if (cArray[i] == 'I')
				morseCode += morse[8] + " ";
			else if (cArray[i] == 'J')
				morseCode += morse[9] + " ";
			else if (cArray[i] == 'K')
				morseCode += morse[10] + " ";
			else if (cArray[i] == 'L')
				morseCode += morse[11] + " ";
			else if (cArray[i] == 'M')
				morseCode += morse[12] + " ";
			else if (cArray[i] == 'N')
				morseCode += morse[13] + " ";
			else if (cArray[i] == 'O')
				morseCode += morse[14] + " ";
			else if (cArray[i] == 'P')
				morseCode += morse[15] + " ";
			else if (cArray[i] == 'Q')
				morseCode += morse[16] + " ";
			else if (cArray[i] == 'R')
				morseCode += morse[17] + " ";
			else if (cArray[i] == 'S')
				morseCode += morse[18] + " ";
			else if (cArray[i] == 'T')
				morseCode += morse[19] + " ";
			else if (cArray[i] == 'U')
				morseCode += morse[20] + " ";
			else if (cArray[i] == 'V')
				morseCode += morse[21] + " ";
			else if (cArray[i] == 'W')
				morseCode += morse[22] + " ";
			else if (cArray[i] == 'X')
				morseCode += morse[23] + " ";
			else if (cArray[i] == 'Y')
				morseCode += morse[24] + " ";
			else if (cArray[i] == 'Z')
				morseCode += morse[25] + " ";
		}
		
		return morseCode;
	}
	
//--This method calls decoder to decode a morse code back to strings-----------------------------------------------------------------------------------------------------	
	public String decode (String code){
		
		// Go through the array and decode 
		return decoder(source,code);
	}
	
//--This method decodes a morse code back into strings-----------------------------------------------------------------------------------------------------	
	private String decoder (BinTree <String> tree, String code){
		
		String decodedText = ""; 							// Holds the decoded text
		char[] cArray = code.toCharArray();					// Holds the encoded text
		
		for (int count = 0; count < cArray.length; count++)
		{
			if (cArray[count] == '.' && tree.left != null )
                    tree = tree.left;
			else if (cArray[count] == '-' && tree.right != null)
                    tree = tree.right;
			else if (cArray[count] == '#')
				decodedText += " ";
			else if (cArray[count] == ' '){
				decodedText += tree.info;
				tree = tree.root();
			}
		}
		
		return decodedText;
	}	
}
