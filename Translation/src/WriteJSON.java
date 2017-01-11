import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.json.JSONArray;
import org.json.JSONObject;


public class WriteJSON implements Closeable{

	private final String langs[]={"en","de","ru","fr"};
	private PrintWriter out_file;
	public WriteJSON(String out_file)
	{

		try{
			out_file=new PrintWriter(new File(out_file),"UTF-8");
		}catch( FileNotFoundException e){
			System.err.println("Error generating output file");
			System.exit(1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.exit(1);
		}

		out_file.println("[");
	}


	public void processJSONArray(JSONArray inp) throws Exception
	{
		final int JSON_size=inp.length();
		for(int i=0;i<JSON_size;i++)
		{

			//Read tweet
			JSONObject j_obj=(JSONObject) inp.get(i);

			//Read language of the tweet
			String my_lang=j_obj.get("tweet_lang").toString();

			//Read the text contained in the tweet
			String my_text=j_obj.get("text_"+my_lang).toString();

			//Translate the tweet to ALL languages
			for(int j=0;j<langs.length;j++)
			{
				//Translate only if current language is different from the language of the Tweet
				if(my_lang.compareTo(langs[j])!=0)
				{
					String temp=Yandex_API.sendQuery(my_text, my_lang, langs[j]);
					j_obj.append("text_"+langs[j],temp);
				}
			}
			out_file.println(j_obj.toString()+",");
		}
	}

	@Override
	public void close() throws IOException {
		out_file.println("]");
		out_file.close();
	}
}
