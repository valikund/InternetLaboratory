package GoogleAPI;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException, IOException {
		// TODO Auto-generated method stub
		String google = "http://www.google.com/search?tbm=isch&q=";

	    String search = "ufo";
	    String charset = "UTF-8";
	    String userAgent = "Chrome/35.0.1916.114";

	    Elements imgTds = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select(".images_table>tbody>tr>td");

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
	}

}
