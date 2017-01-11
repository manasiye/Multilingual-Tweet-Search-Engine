import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.json.*;

public class ReadJSONFile
{


	private File inp_file;
	private Scanner s;

	public ReadJSONFile(String f)
	{
		try{
		inp_file=new File(f);
		s=new Scanner(inp_file);

		}catch(FileNotFoundException s){
			System.err.println("Invalid Input File path");
			System.exit(1);
		}
	}

	public JSONArray getJSONArr()
	{
		StringBuffer JSONArr=new StringBuffer();
		while(s.hasNext())
		{
			JSONArr.append(s.next()+" ");
		}
		JSONArray file_contents=new JSONArray(JSONArr.toString());
		s.close();
		return(file_contents);
	}
}
