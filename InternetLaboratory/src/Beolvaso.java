import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;


public class Beolvaso {
	public static int hanyadik = 0;
	public static String file_path = new String();
	
	
	public static Mat beolvaso_fajlbol(String forras){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat uj = Highgui.imread(forras ,Highgui.CV_LOAD_IMAGE_COLOR);
		return uj;
	}
	public static Mat beolvaso_urlrol(String url) throws IOException{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		File file = new File("temp"+hanyadik+".jpeg");
		file_path = file.getAbsolutePath();
		hanyadik++;
		
		URL url_ki =new URL(url);
         HttpURLConnection httpcon = (HttpURLConnection) url_ki.openConnection();
         httpcon.addRequestProperty("User-Agent", "Chrome/42.0.2311.135");
		
         BufferedImage originalImage = ImageIO.read(httpcon.getInputStream());
         BufferedImage newImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

             for (int x = 0; x < originalImage.getWidth(); x++) {
                 for (int y = 0; y < originalImage.getHeight(); y++) {
                     newImage.setRGB(x, y, originalImage.getRGB(x, y));
                 }
             }
		
         
         
         
         
		ImageIO.write(newImage, "jpeg", file);
		
		Mat uj = Highgui.imread("temp.jpeg" ,Highgui.CV_LOAD_IMAGE_COLOR);	
		
		
				
		return uj;
		
		
	}

}
