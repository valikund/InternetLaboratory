package Proba;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GoogleReverseImageSearch {
	public static void main(String[] args  ) throws IOException{
		
		File file = new File("C:/Users/valikund-pc/Desktop/OpenCV/index.html");
		PrintWriter output = new PrintWriter(file);
		
		String[] kimenetiurl = new String[15];
		int kereses_pozicioja =0;
		String url = "https://www.google.com/search?tbs=sbi:AMhZZivul5b8b_1ZBV9wfwtBaJyCcEv-ox_11OOg52XwZGZa7vevkgQ5blO8SkXhsjVa6nJhFoc5v7lk9u9yko_1r9eCkWXTOkbPFQ5a5gRPlCVVqYgFgIqYBSX1Z-6cc_1srVZfuzCNgxZvof3HtQ_1G6A0EgVc6U0o3EyDoRlICnxD36QnTh9YhuPzB_1gZoK_1ERzzcGVChr4sK9KT6CKDhe5rLnlIE4rrWSVbXYI5RNdHid7BKUBtoKu1tIa20dSpPOHWVSqSmmPbIBSPGx139GoaKvAZS8tYthep02Sh6EshG2_1kABXY1Vx95zAhtyErITd0CQGwnY1iS8FQvd7tXmKZgEh6PAueswIiDZ3iE8OWbfAXomYXj15wto1vyevRn40YwipFDUAp673_11_1zp5MpCyEuKTvG5H1sW11oGl-yiNPjCGQtdndOj4twLtgWMPnJRglVE3q-VreLeeNdsWAUC0HhVM6m8q1kn2LgD-WnbobSAE5I-ui2-YwaGarFCJnhaQApqHYLkqgOasH9OP5MvwXzhE4otVOtiDOTJhXGkii4hCxu4QuJ8yiYnAFoJ-y6IKVbanNn2Nwsa6AsbT8wfRQ88686jO1nUVME2sr38kAhHZuv_1TmNQ9jv6OpNBixUHlxydE8NVVU9Oyo-wsMNkGZeU7yPhOcM5uWPtKFlXeGy6FuAuxXIkdrZJ2R63sy1I7OeNdhGkbLxABdviI23ZCFOzy5pSxkO9-0p9hWayN5lQnbgBm_1qzv_1FSknInTYE-v-Nj2faYvKiaTXM0mjMwFGdUcR85xTv5EhXH2ImpC66-BD8HcH249dDB2DObv0NDf9CLYLng43iwq9CbCBWk0u68kFATrQzAGNB5N-mEzcnuPC6k-18HbjdrtoR4rhWCJ9ed3yOBUd5QrDbcsCX9AGbsMK92netF-Uuco2PmER8uqqnPTgmMf_1qWMWqPv80OTICSaq1Cqc3cemA3WRlEMGH0BhSlsHeIOdUEkzvSZj0SSeZUKx5m8v4o_1g0PdsYVYGhptRq2pIAb0PRfZNMhwcs6K1bMzydrNXvUuCpAJX4LMCbsR5o3vNglpsTPc4SCje-k1UEEWvdaMuq_1VK2AK4DiCVNBoByeKMedEboIN1GZelJ_1m2lYA&amp;h1=en&amp;bih=179&amp;biw=1600";
		
		
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
