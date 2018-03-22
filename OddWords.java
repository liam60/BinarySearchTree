import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


//ID: 126 87 26
//NAME: Liam Barclay

class OddWords
{
	public static void main(String [] args)
	{	
		//Declares the bst to hold the strings
		BSTlex BST = new BSTlex();
		if(args.length != 1)
		{
			//If the command is not given the right number of arguments, give an error.
			System.err.println("Usage: java TestRead <filename>");
			return;
		}

		try
		{
			//Using a buffered reader to read in each line of the file
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
	      	String s = br.readLine();
			String str;
	      	String delims = ".,;:'!\" \t\n";			
			while(s != null)
			{
				//Using a tokenizer to read each string from the line
				StringTokenizer st = new StringTokenizer(s,delims);
				//While there are still more words in the line
				while(st.hasMoreTokens())
				{
					//Make str the next word and convert to lowercase
					str = st.nextToken();
					str = str.toLowerCase();

					//If the word is already in the BST
					if(BST.find(str))
					{
						//Remove the word from the BST.
						BST.remove(str);
						System.out.print("REMOVED");
						System.out.print("\n");
					}
					else
					{
						//Otherwise it is a new word, so add it to the BST
						BST.insert(str);
						System.out.print("ADDED");
						System.out.print("\n");
					}
					
				}
				//Get the next line of the file
				//Repeat until no more lines to read
				s = br.readLine();
			}
			//Print out the lexicon of words in the BST
			//This will be the words that have occured an odd number of times
			System.out.println("LEXICON: ");
			BST.traverse();
			br.close();
		}
		catch(Exception ex)
		{
			System.err.println("error: " + ex.getMessage());
	    	}
	}
}
