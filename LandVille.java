
class LandVille
{
	//declaring 2D-array for land size
	private int[][] land;
	//declaring variable which returns true if house exists on the land
	protected boolean hasHouse;


	//Constructor to initialize LandVille object
	public LandVille(int maxRows, int maxColumns)
	{
		//Initialize the 2D-array with size of specified rows and columns
		land = new int[maxRows][maxColumns];
		//Set '0' for each element of land by invoking clearLand method
		clearLand();
	}


	// Display the current land
	public void displayLand()
	{
		//Iterating through the rows
		for(int i = 0; i < land.length; i++)
		{
			//Iterating through the columns
			for(int j = 0; j < land[0].length; j++)
			{
				//Print land element with a space afterwards
				System.out.print(this.land[i][j] + " ");
			}
			//Move to next row 
			System.out.println();
		}
	}


	//Clear land by assigning all elements to 0
	public void clearLand()
	{
		for(int i = 0; i < land.length; i++)
		{
			for(int j = 0; j < land[0].length; j++)
			{
				//Assigning current array element to 0
				this.land[i][j] = 0;
			}
		}

		//Reset hasHouse since house has been cleared
		this.hasHouse = false;
		this.displayLand();
	}


	//Build house with size of specified rows and columns
	public void buildHouse(int rows, int columns)
	{
		for(int i = 1; i <= rows; i++)
		{
			for(int j = 1; j <= columns; j++)
			{
				//Assigning 8 to current array element to signify house area
				this.land[i][j] = 8;
			}
		}

		//Building border around the house
		for(int i = 0; i <= rows + 1; i++)
		{
			for (int j = 0; j <= columns + 1; j++)
			{
				if (this.land[i][j] != 8)
				{
					this.land[i][j] = 1;
				}
			}
		}

		//House was built hence update accordingly
		this.hasHouse = true;

		//Display land after construction
		this.displayLand();

	}

}