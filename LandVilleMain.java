//importing Scanner library
import java.util.Scanner;


public class LandVilleMain 
{

	//This function returns true if n falls between min and max or else returns false
	public static boolean validate(int n, int min, int max)
	{
		if ( n < min || n > max )
			return false;
		else
			return true;
	}


	public static void main(String[] args)
	{	
		//variables to store land dimensions
		int rows = 0, columns = 0; 
		int choice = 0;

		//variables to store house dimensions
		int buildRows = 0, buildCols = 0;

		//Scanner object to register user input
		Scanner input = new Scanner(System.in);

		//This loop runs until number of rows is between 3 and 10
		while ( !validate(rows, 3, 10) )
		{
			System.out.println("Enter number of rows");
			//Scans integer value from console and stores it
			rows = input.nextInt();

			//Breaks out of while loop if input is correct
			if (validate(rows, 3, 10))
				break;
			else
				System.out.println("Row should be greater than equal to 3 and less than equal to 10");

		}

		//This loop runs until number of columns is between 3 and 10
		while ( !validate(columns, 3, 10) )
		{
			System.out.println("Enter number of columns");
			columns = input.nextInt();

			if(validate(columns, 3, 10))
				break;
			else
				System.out.println("Column should be greater than equal to 3 and less than equal to 10");
		}

		//Create object of LandVille with user defined rows and columns
		LandVille land1 = new LandVille(rows, columns);

		//Displaying Menu
		//This loop runs until user enters 4
		while (choice != 4)
		{
			System.out.println("***MENU***\n1.Build a house\n2.Display land\n3.Clear land\n4.Quit");
			choice = input.nextInt();

			//Build house if user input is 1
			if(choice == 1)
			{
				//If hasHouse = true, then house already exists hence return to menu
				if( land1.hasHouse == true )
				{
					System.out.println("Land already has a house");
					continue;
				} else 
				{
					System.out.println("Enter number of rows to build house");
					buildRows = input.nextInt();

					if( validate(buildRows, 1, rows) && (rows-buildRows) >= 2 )
					{	
						/* difference between land rows and house rows should be greater than equal
						 * to 2 since all houses must have a border on all sides.
						 */
					} else
					{
						/* if input is NOT between 1 and total land rows AND if difference between 
						 * land rows and house rows is NOT greater than equal to 2 then print error
						 */
						System.out.println("Row should be between 1 and " + (rows-2));
						continue;
					}

					System.out.println("Enter number of columns to build house");
					buildCols = input.nextInt();

					if( validate(buildCols, 1, columns) && (columns-buildCols) >= 2 )
					{
						/* difference between land columns and house columns should be greater than equal
						 * to 2 since all houses must have a border on all sides.
						 */
					}
					else 
					{
						System.out.println("Column should be between 1 and " + (columns-2));
						continue;
					}

					//if all inputs are validated, build a house with specified dimensions
					land1.buildHouse(buildRows, buildCols);

				}
			}

			//Display current land if input is 2
			if(choice == 2)
			{
				//invoking displayLand method of LandVille.java
				land1.displayLand();
				//resetting user input
			}

			//Clear land if user input is 3
			if(choice == 3)
			{
				//invoking clearLand method of LandVille.java
				land1.clearLand();
				System.out.println("Land Cleared.");
			}

			//Exit game if user input is 4
			if( choice == 4)
				System.out.println("Exiting...");

		}

		//Closing scanner object 'input' to prevent memory leak
		input.close();

	}
}