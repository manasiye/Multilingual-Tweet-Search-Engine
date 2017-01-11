
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/*Reads data line by line from a given file*/

public class ReadTextFile
{

	private Scanner inp_file;

	@SuppressWarnings("unused")

	/*DEF CONS*/
	private ReadTextFile()
	{

	}

	public ReadTextFile(String fil_nam)
	{

		try
		{
			inp_file=new Scanner(new File(fil_nam));
		}
		catch(FileNotFoundException e)
		{
			System.err.println("Invalid file "+fil_nam);
		}
	}

	public boolean hasNext() throws IllegalStateException
	{
		return(inp_file.hasNext());
	}
	public String nextLine() throws NoSuchElementException,IllegalStateException
	{
		return(inp_file.nextLine());
	}
	public boolean fileExists(String file_name)
	{
		return(new File(file_name).isFile());
	}
	public void close()
	{
		inp_file.close();
	}
}
