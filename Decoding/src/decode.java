import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class decode
{
	static int[][] img;
	static Scanner inFile;
	static BufferedWriter outFile;

	
	static void decodeMethod(int r, int c, int greyscale, int count, int row, int col)
	{
		while(count != 0)
		{
			img[r][c] = greyscale;
			c++;
			count--;
			if(c == col)
			{
				c = 0;
				r++;
			}
		}
			
	}
	
	public static void main(String[] args)
	{
		try
		{
			inFile = new Scanner(new FileReader(args[0]));
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
			

			for(int i = 0; i < numRows; i++)
			{
				for(int j = 0; j < numCols; j++)
				{
					img[i][j] = 0;
				}
			}	
			outFile.write(numRows + " " + numCols+ " " + minVal + " " +maxVal +"\n");

			int method = inFile.nextInt();
			
			if(method == 1 || method == 2 || method == 3 || method == 4)
			{
				while(inFile.hasNext())
				{
					int i = inFile.nextInt();
					int j = inFile.nextInt();
					int greyScale = inFile.nextInt();
					int count = inFile.nextInt();
					decodeMethod(i, j, greyScale, count, numRows, numCols);	
				}
			}
			
			for(int i = 0; i < numRows; i++)
			{
				for(int j = 0; j < numCols; j++)
				{
					outFile.write(img[i][j] + " ");
				}
				outFile.write("\n");
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
