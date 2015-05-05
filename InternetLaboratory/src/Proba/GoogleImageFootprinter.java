package Proba;



import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
 
import javax.swing.JOptionPane;
 
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
 
@SuppressWarnings("deprecation")
public class GoogleImageFootprinter {
	 public static void main(String[] args ){
		    try {
		      HttpClient client = new DefaultHttpClient();
		      String url="https://www.google.com/searchbyimage/upload";
		      String imageFile= "C:/Users/valikund-pc/Desktop/OpenCV/img1.jpg";
		      HttpPost post = new HttpPost(url);

		      MultipartEntity entity = new MultipartEntity();
		      entity.addPart("encoded_image", new FileBody(new File(imageFile)));
		      entity.addPart("image_url",new StringBody(""));
		      entity.addPart("image_content",new StringBody(""));
		      entity.addPart("filename",new StringBody(""));
		      entity.addPart("h1",new StringBody("en"));
		      entity.addPart("bih",new StringBody("179"));
		      entity.addPart("biw",new StringBody("1600"));

		      post.setEntity(entity);
		      HttpResponse response = client.execute(post);
		      BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));         

		      String line = "";
		      while ((line = rd.readLine()) != null) {
		        if (line.indexOf("HREF")>0)
		      System.out.println(line.substring(9));
		      
		      }

		    }catch (ClientProtocolException cpx){
		      cpx.printStackTrace();
		    }catch (IOException ioex){
		      ioex.printStackTrace();
		    }
		
			
		 }
	
}
