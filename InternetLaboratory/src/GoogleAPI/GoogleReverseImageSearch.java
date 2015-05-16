package GoogleAPI;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GoogleReverseImageSearch {
	public static void keres(String url) throws IOException{
		
		File file = new File("C:/Users/valikund-pc/Desktop/OpenCV/index.html");
		PrintWriter output = new PrintWriter(file);
		
		String[] kimenetiurl = new String[15];
		int kereses_pozicioja =0;
		
		
		String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36";
		Document imgTd = Jsoup.connect(url).userAgent(userAgent).referrer("http://www.yahoo.com").timeout(12000) 
		           .followRedirects(true).get();
		String szoveg = imgTd.html();
		
		
		
		while(szoveg.contains("\"ou\":") == true){
			int	 szoveg1 = szoveg.indexOf("\"ou\":");
			String	resz =szoveg.substring(szoveg1);
			resz = resz.substring(6);
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
