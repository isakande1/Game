
/*Name: Sakande Ismael
  Course: CSC 122 001
  Project # 3
  Project description:  -To allow a user to play rock, paper, sissors against the computer, 
                        -Require  the user to input their name, 
						-Ask  the user to inpput howmany times to play, 
						-Keep track of the round currently playing.
			            -keeps tracks of the record of the game,
  			            -Kepps track of the records of all games  played with the same username,
			            -keeps track of the total number of times played with the same username
						-Keep asking for valid character if the user enter an invalid character
                        -Convert uppercase input to lower case.	
                        -The program use Scanner methods when the required input is an integer to keep verifying the user
						   input and discard the input in case it is a character. In this case,the input is read only if
						   it is an integer						
                        					
						
  Purpose: create file, input and ouput on file, get familiar with scanner object and methods, while loop, for loop, scope, 

  What the program does: -Allows the user to paly rock, paper and scissors against the computer with a username.
                         -If the  user enter an invalid input when the program requires an integer, the input will be discard and the 
						   user will be ask to enter an integer.
                         -Display what round of the game the user is playing.  
                         -Display the records of wins, losses, and ties at the end of the execution of the programm
						 -Display the total records for all games played with the same username
						 
  
  How you tested the program: Run the program multiple times with the same username and with diffrent username.
  Limitations if any in the program: none.
*/


import java.io.*; // allow to create and manipulate files
import java.util.*; //  import java util library
public class Game{ 
    public static  int N = 0; // declare N in the scope of the class to associate with user input
	public static  String NAME = " "; // declare NAME in the scope of the class to associate with user input.
	public static int j = 0; // declare j in the scope of the class to index an array
	public static int won = 0; // declare won in the scope of the class to keep tracks of the wins
	public static int loss = 0; // declare loss in the scope of the class to keep tracks of the losses
	public static int tie = 0; //  declare tie in the scope of the class to keep tracks of the ties
	public static int f = 1; // declare f in the scope of the class for the array index.
	
	
	public static void explain(){ // prompt explaning the game
			System.out.println(NAME + ", Welcome to the game."); // print the username and welcome the human to the game.
	        System.out.println(" This game is played by two players. Each player selects one of ");
	        System.out.println(" three objects--a rock, paper or scissors. The winner is determined ");
			System.out.println("    Rock defeats scissors;");
			System.out.println("    Paper defeats rock");
			System.out.println("    Scissors defeats paper");
			System.out.println();
	}
		
	




	public static char userChoice() {// method handling the user input.
	   

			Scanner console = new Scanner( System.in); // create a new scanner object
			System.out.print("    Enter 'r', 'p' or 's':"); // telling the user what are his options
			
			char choice; // declaring the data type of choice
			choice	= console.next().charAt(0); // attributing the next character input to choice
			if ( choice < 'a')
			   choice =  (char) ((int) choice + 32);// convert upper case letters to lower case
			
			
			
			while (( choice != 'r')&& (choice != 'p')&&(choice!= 's')){ // while loop that run until the input correspond to r, p or s.
				System.out.println(" invalid input, please chose 'r', 'p' or 's'"); //display the valid character to input
				System.out.print("Enter 'r', 'p' or 's':");// asking for the input of the user
				
				choice = console.next().charAt(0); // take the first character input by thge keyboard.
				
				if ( choice < 'a')
				choice = (char) ((int) choice + 32);// convert upper case letters to lower case
			}
			return choice; // return the user input to the method
			
		}		


		public static char comChoice() { // method generating the computer choice
			
			Random console = new Random(); // create a new random object
			int choice2 = console.nextInt(3)+1; // limit the number generate to 1,2,3
			if ( choice2 == 1 ){
				   //System.out.println( " The computer chose 'r'");// display the computer choice
				return 'r'; // return 'r' when the random object genearate 1
			}
			else if ( choice2 == 2 ){
				   //System.out.println( " The computer chose 'p'");//display the computer choice
				return 'p'; // return 'p' when random generate 2
			   }

			else{
					//System.out.println( " The computer chose 's'");//display the computer choice
				return 's'; // return s when random generate 3
				}


		}


		public static int winner( char choice, char choice2){ // method generating the result.
			if (( choice == 'p' && choice2 == 'r')||( choice == 'r' && choice2== 's')||( choice == 's' && choice2 == 'p') ){// compare user input to r, p and s.
			   System.out.println( "     The human player won"); // telling the human he won
			   System.out.println();
				return 1;// return 1 to the main method when the human player win.
			}

			else if ( choice == choice2){ // compare user input to the character generate by the computer
			   System.out.println( "     The game is tied");// display the game is a tied when choice = choice2.
			   System.out.println(); // print a new line.
				return 0; // return 0 to the method if user choice = computer choice
			}

			else{ 
			   System.out.println( "     The computer won"); // print computer won when the human player does not win and the game is not a tie.
			   System.out.println(); // print a new line.
				return 2; // return 2 to the method when the computer won.
			}
		}

	public static void main( String[] args) 
		throws FileNotFoundException, InputMismatchException {// main mehtod.   
			
			Scanner console = new Scanner(System.in);
			System.out.print( "What is your name : ");// ask the user to type his name.
			NAME = console.next(); // attribute the next input string to NAME
			
			
			
			
			
			
			explain(); // callthe explain method to explain the rules of the game
			System.out.print( " Enter a number for how many rounds to play : "); // ask the user input for how many times to play the game
			
			/*try{
			N = console.nextInt();// associate the number of times to repeat the game to N.
			}
			catch( Exception e){
				
				main(null);
			}
			System.out.println(); // print a line.*/
			
			while( !console.hasNextInt()){// verify if the input is an integer
				console.next();// discard the input if it is not an integer.
				System.out.print( " Invalid input, enter an Integer:");// Alert the user to enter an valid input.
			}
			int N = console.nextInt();// read the input when it is an integer.
				
				
			char[] array = new char[(N*3)]; // call the array object associate array to it to keep track of the moves.
			for ( int i = 0; i< N; i++){ // repeat the game accordind to the integer enter by the human player.
			
			
			int a = ++j; // declare a and increment its value each time the for loop execute to count the rounds of game.
			
			// display what round the user is playing
			if ( N == 0 ) // compare the integer enter by the user to 0
				System.out.println ( "   GOOD BYE !"); // print good bye if the integer enter by the user = 0'
			else if (( a == 1) && ( a!= N)) // case when the game is at the first round.
				System.out.println("   Let's go, 1st round"); // print 1st round for the first round of the game
			else if (( a == 2) && ( a!=N))// case when the game is at the secon round
				System.out.println("   2nd round"); // print 2nd round for the second round
			else if (( a == 3) && ( a!= N)) // case when the game is at the third round
				System.out.println("   3rd round"); // print 3rd round for the 3rd round
			else if ((a >= 4)&& ( a!= N))// other round of the game between the third and last round. ( 3rd and last round exclude)
				System.out.println("   " +a +"th round"); // add th to integers grater or equal to 4 and print the current round.
			else if ( a == N) // to determine the last round of the game.
				System.out.println("   Last round"); // print the last round of the game 
			
			
			
			char choice; // declare choice 
			char choice2;// declare choice2
			choice2 = comChoice(); // attribute comChoice(); to choice2
			choice = userChoice(); // attrbute userChoice(); to choice
			System.out.println( "     "+  NAME + ", chose " + choice);
			System.out.println( "     The computer chose "+ choice2); // display the human and the computer choice
					
			
			
			int result = winner(choice, choice2);// attrbute winner to result
			
			// create a record of the choice of the user and the computer
			if (result == 1)  // increment won if result = 1
			  ++ won;
			else if( result == 0) // increment tie if result = 0
			  ++tie;  
			else     
			  ++loss; //incremenr tie
			array[f++] = choice; // inseert the user  choice in the array
			array[f++] = choice2; //  insert the computer choice in the array.
			
			
			}
			
			// print the record of the game
			System.out.println( NAME +", The record of this game  displays below"); // to allow the user to know  the records  of the game are to be print.
			System.out.println( " You won "+won+" time(s)"); // print number of wins
			System.out.println( " you tied " +tie+ " time(s)"); // print number of ties
			System.out.println( " you lost "+loss+ " time(s)"); // print number of loss
			
			
			
		 
			
			// display the reccord of the game.
			System.out.println();
			System.out.println( "The records of the moves played:"); // to allow the user to know  moves of the game are to be print.
			System.out.print("   "); // print a space 
		   for (int i = 0; i <= (N*2); i++){ // loop to print all the elements of the array
			  
			  
			  System.out.print(" "+ array[i]);// print  the elements of the array
			  
		   } 
			System.out.println();// print a line
			String filename = NAME+".txt";// concatenate NAME to .txt 
			File f = new File(filename);// create a file name and associate it to f
			if (!(f.exists())){ // check if a file f exist
			PrintStream newfile = new PrintStream(f); // create a new file if the same file does not exists and associate it to newfile
			newfile.println( won); // write the number of wins in the file
			newfile.println(tie);// write the number of ties in the file
			newfile.println(loss);// write the number of loss in the file
			for (int i=0; i<=(N*2); i++){
			newfile.print( " "+ array[i]);}
			}
			else {
			Scanner read = new Scanner(f); // create a scanner object to read from the file
			int i = 2;
			
			
			
			won =  read.nextInt() + won; // concatenate the wins in the actual game to the wins of the previous game
			tie= read.nextInt()+ tie;//concatenate the ties in the actual game to the ties of the previous game
			loss= read.nextInt() + loss; // concatenate the loss in the actual game to the loss of the previous game
			System.out.println();// print a line.
			System.out.println( "Below is the total records of your games so far"); // print the records of games
			System.out.println( NAME +", you have played a total of " + ( won + tie+loss) + " games");
			System.out.println( "	your total wins are: "+ (won)); // print the concatenate the wins in the actual game to the wins of the previous game 
			System.out.println( " 	your total ties are: " + (tie)); // print the concatenate the ties in the actual game to the ties of the previous game
			System.out.println( " 	your total loss are: " + (loss));// print theconcatenate the loss in the actual game to the loss of the previous game
			int v = 0;
			char[] storage = new char[(N*10)];
			
			System.out.println( " The moves of the games played so far are represent in the next line ");
			while( read.hasNext()){
			  String x = read.next();
			  System.out.print(" " + x);
			  storage[v++] = x.charAt(0);
			}
			
			for (int d = 0; d <= (N*2); d++){ // loop to print all the elements of the array
			  System.out.print(" "+ array[d]);// print  the elements of the array
			  
		   } 
		   
					   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
			
			
			PrintStream newfile = new PrintStream(f);// Set the size of the existing  file f to zero
			                                         // and update the total records of the game
		
			newfile.println( won); // write the total  wins for all games played with the same username.
			newfile.println(tie); // write the total  ties for all games played with the same username.
			newfile.println(loss);// write the total  losses for all games played with the same username.
			
			for (int d = 0; d <= (N*2); d++){
				newfile.print( " "+ storage[d]);
			}
			
			for (int d = 0; d <= (N*2); d++){
				newfile.print(" "+ array[d]);
			}
			}

		} 
    
	
	
}

/*
C:\java>java Game
What is your name : Phoenix
Phoenix, Welcome to the game.
 This game is played by two players. Each player selects one of
 three objects--a rock, paper or scissors. The winner is determined
    Rock defeats scissors;
    Paper defeats rock
    Scissors defeats paper

 Enter a number for how many rounds to play : 2

   Let's go, 1st round
    Enter 'r', 'p' or 's':r
     Phoenix, chose r
     The computer chose p
     The computer won

   Last round
    Enter 'r', 'p' or 's':r
     Phoenix, chose r
     The computer chose r
     The game is tied

Phoenix, The record of this game  displays below
 You won 0 time(s)
 you tied 1 time(s)
 you lost 1 time(s)

The records of the moves played:
      r p r r

Below is the total records of your games so far
Phoenix, you have played a total of 4 games
        your total wins are: 2
        your total ties are: 1
        your total loss are: 1

C:\java>java Game
What is your name : Frank
Frank, Welcome to the game.
 This game is played by two players. Each player selects one of
 three objects--a rock, paper or scissors. The winner is determined
    Rock defeats scissors;
    Paper defeats rock
    Scissors defeats paper

 Enter a number for how many rounds to play : 2

   Let's go, 1st round
    Enter 'r', 'p' or 's':r
     Frank, chose r
     The computer chose p
     The computer won

   Last round
    Enter 'r', 'p' or 's':r
     Frank, chose r
     The computer chose s
     The human player won

Frank, The record of this game  displays below
 You won 1 time(s)
 you tied 0 time(s)
 you lost 1 time(s)

The records of the moves played:
      r p r s

C:\java>java Game
What is your name : Frank
Frank, Welcome to the game.
 This game is played by two players. Each player selects one of
 three objects--a rock, paper or scissors. The winner is determined
    Rock defeats scissors;
    Paper defeats rock
    Scissors defeats paper

 Enter a number for how many rounds to play : 2

   Let's go, 1st round
    Enter 'r', 'p' or 's':p
     Frank, chose p
     The computer chose p
     The game is tied

   Last round
    Enter 'r', 'p' or 's':p
     Frank, chose p
     The computer chose s
     The computer won

Frank, The record of this game  displays below
 You won 0 time(s)
 you tied 1 time(s)
 you lost 1 time(s)

The records of the moves played:
      p p p s

Below is the total records of your games so far
Frank, you have played a total of 4 games
        your total wins are: 1
        your total ties are: 1
        your total loss are: 2

C:\java>java Game
What is your name : Phoenix
Phoenix, Welcome to the game.
 This game is played by two players. Each player selects one of
 three objects--a rock, paper or scissors. The winner is determined
    Rock defeats scissors;
    Paper defeats rock
    Scissors defeats paper

 Enter a number for how many rounds to play : 1

   Last round
    Enter 'r', 'p' or 's':t
 invalid input, please chose 'r', 'p' or 's'
Enter 'r', 'p' or 's':s
     Phoenix, chose s
     The computer chose r
     The computer won

Phoenix, The record of this game  displays below
 You won 0 time(s)
 you tied 0 time(s)
 you lost 1 time(s)

The records of the moves played:
      s r

Below is the total records of your games so far
Phoenix, you have played a total of 5 games
        your total wins are: 2
        your total ties are: 1
        your total loss are: 2

C:\java>



*/
