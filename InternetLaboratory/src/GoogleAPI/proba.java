package GoogleAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class proba {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
		File input = new File("C:/Users/valikund-pc/Desktop/OpenCV/proba.html");
		PrintWriter output = new PrintWriter(input);
		
		
		String google = "http://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=";
		
	    String search = "ufo";
	    String charset = "UTF-8";
	    String userAgent = "Chrome/35.0.1916.114";
		 Document imgTd = Jsoup.connect(google + URLEncoder.encode(search, charset)+"&start=4").userAgent(userAgent).get();
	
		    Elements imgTds = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select("['responseData']['results']");
		    //['responseData']['results'][0]['unescapedUrl'] seelctor statement
		    
		 output.print(imgTds.text());  
        output.close();

	}

}
