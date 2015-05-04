package GoogleAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GoogleAPI {

	public static String[] kereso(int hanyszor_keres, String mit_keresel) throws IOException, Exception {
		// TODO Auto-generated method stub
		File input = new File("C:/Users/valikund-pc/Desktop/OpenCV/proba.html");
		PrintWriter output = new PrintWriter(input);
		int keresesek_szama =hanyszor_keres+1;
		Integer kereses_pozicioja=0;
		String[] kimenetiurl = new String[keresesek_szama];
	
		String google = "http://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=";
		
	    String search = mit_keresel;
	    String charset = "UTF-8";
	    String userAgent = "Chrome/35.0.1916.114";
	    while(kereses_pozicioja < keresesek_szama-1){
		 Document imgTd = Jsoup.connect(google + URLEncoder.encode(search, charset)+"&start="+kereses_pozicioja).userAgent(userAgent).get();
			    
		 output.print(imgTd.text()); 
		 String szoveg = imgTd.text();
		 output.close();
	        
		 
		
		while(szoveg.contains("unescapedUrl\":") == true){
		int	 szoveg1 = szoveg.indexOf("unescapedUrl\":");
		String	resz =szoveg.substring(szoveg1);
		resz = resz.substring(15);
		szoveg1 = resz.indexOf("\",");
		kimenetiurl[kereses_pozicioja]  = resz.substring(0, szoveg1) ;
		szoveg = resz.substring(szoveg1);
		System.out.println(kimenetiurl[kereses_pozicioja]);
		kereses_pozicioja++;
		}
		
		
	    }
		return kimenetiurl;
       

	}

}
