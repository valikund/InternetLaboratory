package GoogleAPI;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GoogleReverseImageSearch {
	public static void keres(String url) throws IOException{
		
		File file = new File("C:/Users/valikund-pc/Desktop/OpenCV/index.html");
		PrintWriter output = new PrintWriter(file);
		
		String[] kimenetiurl = new String[15];
		int kereses_pozicioja =0;
		
		String userAgent = "Chrome/35.0.1916.114";
		Document imgTd = Jsoup.connect(url).userAgent(userAgent).get();
		String szoveg = imgTd.text();
		
		while(szoveg.contains("\"ou\":") == true){
			int	 szoveg1 = szoveg.indexOf("\"ou\":");
			String	resz =szoveg.substring(szoveg1);
			resz = resz.substring(5);
			szoveg1 = resz.indexOf("\",");
			kimenetiurl[kereses_pozicioja]  = resz.substring(0, szoveg1) ;
			szoveg = resz.substring(szoveg1);
			System.out.println(kimenetiurl[kereses_pozicioja]);
			kereses_pozicioja++;
			}
		
		output.print(imgTd.html());
		output.close();
	}

}
