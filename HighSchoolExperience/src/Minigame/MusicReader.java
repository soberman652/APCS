package Minigame;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicReader 
{
	public static ArrayList<Integer> readFile(String filename)
	{
		Scanner scan = null;
		try 
		{
			ArrayList<Integer> output = new ArrayList<Integer>();
			FileReader reader = new FileReader(filename);
			scan = new Scanner(reader);
			while(scan.hasNextLine())
			{
				int integer = Integer.parseInt(scan.nextLine());
				output.add(integer);
			}
			return output;
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(scan != null)
				scan.close();
		}
		return null;
	}
}
