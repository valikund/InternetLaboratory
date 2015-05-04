package GoogleAPI;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EloProba {

	public static void main(String[] args) throws IOException, IOException {
		File input = new File("C:/Users/valikund-pc/Desktop/OpenCV/index.html");
		PrintWriter output = new PrintWriter(input);
		
		// TODO Auto-generated method stub
		String google = "http://www.google.com/search?tbm=isch&q=";
		
		//a képek variálásához az ajaxos api
//		String google ="http://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=";

	    String search = "ufo";
	    String charset = "UTF-8";
	    String userAgent = "Chrome/35.0.1916.114";
	   
	    
	    Document imgTd = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get();


	    Elements imgTds = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select(".images_table>tbody>tr>td");
	    output.print(imgTd.text());
	    for (Element td : imgTds) {
	        //Build in Exception handling at this point just in case you get unexpected input.
	        System.out.println("Title: "+td.html().split("<br>")[2].split("<br>")[0].replaceAll("<[^>]*>", ""));
	        System.out.println("Domain: "+td.html().split("<br>")[1].split("<br>")[0].replaceAll("<[^>]*>", ""));
	        System.out.println("URL (Where the image is embedded): "+td.select("a:has(img)").get(0).attr("href").substring(7).split("&")[0]);
	        // http:// is left out of the src attribute
	        System.out.println("Image Preview (gstatic.com): http://"+td.select("a>img").get(0).attr("src").substring(7).split("&")[0]);
	        System.out.println("-----");
	        //.substring(7).split("&")[0] Quickest way to get to the URL, but definitely not the best out there.
	        
	        
	        
	    }
	    output.close();
	}

}
