




import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;

public class KepLetolto {

	public static void main(String[] args) throws IOException {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		File file = new File("temp.jpeg");
		
		
		URL url =new URL("http://www.theouthousers.com/images/templates/thumbnails/128058/bayfinger_size3.png");
         HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
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
		new Megjelenito("tempelt.jpg", uj);
		

	}

}
