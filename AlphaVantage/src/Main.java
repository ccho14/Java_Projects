import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) throws IOException {

		final String SYM = "ACB.TO";

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		LocalDate today = LocalDate.now();
		LocalDate yesterday = today.minusDays(1);
		String _today = (formatter.format(date));

		URL url = new URL("https://www.alphavantage.co/query?function=RSI&symbol=" + SYM
				+ "&interval=60min&time_period=14&series_type=open&apikey=5BXBGO0O397FNY19");
		URLConnection urlConn = url.openConnection();
		InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
		BufferedReader buff = new BufferedReader(inStream);

		String line = buff.toString();
		System.out.println(line);



		
		while (line != null) {
			if (line.contains("\"" + _today + ""))
				System.out.println(line);
//
//			else if (line.contains("\"RSI\""))
//				System.out.println(line);
//			
//			else if (line.contains("\"" + yesterday + ""))
//				break;
			line = buff.readLine();
//
//		}
//System.out.println(line);
		
//		JSONParser jsonParser = new JSONParser();
//		try {
//			JSONObject jsonObj = (JSONObject) jsonParser.parse(line);
//
//			JSONArray personArray = (JSONArray) jsonObj.get("Persons");
//			for (int i = 0; i < personArray.size(); i++) {
//				System.out.println("======== person : " + i + " ========");
//				JSONObject personObject = (JSONObject) personArray.get(i);
//				System.out.println(personObject.get("RSI"));
//
//			}
//
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}}
