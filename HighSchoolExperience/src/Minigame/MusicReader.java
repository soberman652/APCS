package Minigame;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * scans a formatted file and translate into a rhythm that will be played in MusicGame
 * @author Lin
 *
 */
public class MusicReader 
{
	/** 
	 * 
	 * @param filename file to be read
	 * @return list of beats of the tune
	 */
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
