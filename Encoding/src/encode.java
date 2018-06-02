import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class encode
{
	static int[][] img;
	static Scanner inFile;
	static BufferedWriter outFile;
	
	//Method 1: Encode without zero and no wrap-around.
	static void method1(int row, int col)
	{
		int r = 0;
		int greyScale = 0;
		int count = 0;
		while(r < row)
		{
			int c = 0;
			while(c < col)
			{	
				if(img[r][c] > 0)
				{
					count = 0;
					greyScale = img[r][c];		
					try 
					{
						outFile.write(r + " "+ c + " " + greyScale +" ");
					} 
					catch (IOException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					do
					{
						c++;
						count++;
					}
					while(c < col && img[r][c] == greyScale);
					
					try 
					{
						outFile.write(count + "\n");
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count = 0;		
				} 
				else
				{
					c++;
				}
			}
			r++;
		}
	}
	
	
	//Method 2: Encode without zero and wrap-around.
	static void method2(int row, int col)
	{
		int r = 0;
		int greyScale = 0;
		int count = 0;
		while(r < row)
		{
			int c = 0;
			while(c < col)
			{	
				if(img[r][c] > 0)
				{
					count = 0;
					greyScale = img[r][c];
			
					try 
					{
						outFile.write(r + " "+ c + " " + greyScale +" ");
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					do
					{
						if(c == col - 1)
						{
							r++;
							c = 0;
							count++;
						}
						else
						{
							c++;
							count++;
						}
					}
					while(c < col && img[r][c] == greyScale);
					
					try 
					{
						outFile.write(count + "\n");
					} 
					catch (IOException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count = 0;
				} 
				else
				{
					c++;
				}
			}
			r++;
		}
	}
	
	//Method 3: Encode with zero and no wrap-around. 
	static void method3(int row, int col)
	{
		int r = 0;
		int greyScale = 0;
		int count = 0;
		while(r < row)
		{
			int c = 0;
			while(c < col)
			{	
				count = 0;
				greyScale = img[r][c];		
				try 
				{
					outFile.write(r + " "+ c + " " + greyScale +" ");
				} 
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				do
				{
					c++;
					count++;
				}
				while(c < col && img[r][c] == greyScale);
				
				try 
				{
					outFile.write(count + "\n");
				} 
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count = 0;	
			}
			r++;
		}
	}
	
	//Method 4: Encode with zero and wrap-around
	static void method4(int row, int col)
	{
		int r = 0;
		int greyScale = 0;
		int count = 0;
		while(r < row)
		{
			int c = 0;
			while(c < col && r < row)
			{	
				count = 0;
				greyScale = img[r][c];
		
				try 
				{
					outFile.write(r + " "+ c + " " + greyScale +" ");
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				do
				{
					if(c == col - 1)
					{
						r++;
						c = 0;
						count++;
					}
					else
					{
						c++;
						count++;
					}
				}
				while(c < col&& r < row && img[r][c] == greyScale);
				
				try 
				{
					outFile.write(count + "\n");
				} 
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				count = 0;		
			}
			r++;
		}
	}
	
	public static void main(String[] args) 
	{
		try
		{
			inFile = new Scanner(new FileReader(args[0]));
			Scanner input = new Scanner(System.in);
			outFile = new BufferedWriter(new FileWriter(new File(args[1])));

			if(args.length < 1) 
		    {
		        System.out.println("Error");
		        System.exit(1);
		    }
			
			int numRows = inFile.nextInt();
			int numCols = inFile.nextInt();
			int minVal = inFile.nextInt();
			int maxVal = inFile.nextInt();	
			img = new int[numRows][numCols];
			System.out.println("Which method you want to use?");
			int method = input.nextInt();
			
			while(inFile.hasNext())
			{
				for(int i = 0; i < numRows; i++)
				{
					for(int j = 0; j < numCols; j++)
					{
						int value = inFile.nextInt();
						img[i][j] = value;
					}
				}
				
			}		
			outFile.write(numRows + " " + numCols + " " + minVal + " " + maxVal + "\n"); 
			outFile.write(method + "\n");
			if(method == 1)
			{
				method1(numRows, numCols);
			}
			else if(method == 2)
			{
				method2(numRows, numCols);
			}
			else if(method == 3)
			{
				method3(numRows, numCols);
			}
			else if(method == 4)
			{
				method4(numRows, numCols);
			}
			else
			{
				System.out.println("Error input");
		        System.exit(1);
			}
			
			//close all file
		    inFile.close();
		    outFile.close();
		} 	
		catch (IOException e)
		{
			e.printStackTrace();
		}	
	}
}
