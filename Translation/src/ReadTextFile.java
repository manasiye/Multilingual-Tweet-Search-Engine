import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadTextFile
{
	private Scanner inp_file;

	@SuppressWarnings("unused")
	private ReadTextFile(){
	}
	public ReadTextFile(String file_name)
	{

		try{
			inp_file=new Scanner(new File(file_name));
		}catch(FileNotFoundException e){
			System.err.println("Invalid file "+file_name);
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
