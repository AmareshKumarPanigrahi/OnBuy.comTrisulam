package Practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JasonPractice {

	public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {

		
		JSONParser p=new JSONParser();
		Object obj=p.parse(new FileReader("D:\\data.json"));
		
		JSONObject map= (JSONObject)obj;
		
		System.out.println(map.get("browser"));

	}

}
