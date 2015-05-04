package GoogleAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		int keresesek_szama = 10;
		String[] kimenetiurl = new String[keresesek_szama];
		
		String google = "http://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=";
		
	    String search = "ufo";
	    String charset = "UTF-8";
	    String userAgent = "Chrome/35.0.1916.114";
		 Document imgTd = Jsoup.connect(google + URLEncoder.encode(search, charset)+"&start=4").userAgent(userAgent).get();
			    
		 output.print(imgTd.text()); 
		 
		 String szoveg = imgTd.text();
		
		 
		 int i=0;
		while(szoveg.contains("unescapedUrl\":") == true){
		int	 szoveg1 = szoveg.indexOf("unescapedUrl\":");
		String	resz =szoveg.substring(szoveg1);
		resz = resz.substring(15);
		szoveg1 = resz.indexOf("\",");
		kimenetiurl[i]  = resz.substring(0, szoveg1) ;
		szoveg = resz.substring(szoveg1);
		System.out.println(kimenetiurl[i]);
		}
        output.close();
        
    

	}

}
