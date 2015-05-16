import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
		URL url_kep =new URL(url);

		ImageIO.write(ImageIO.read(url_kep), "jpeg", file);
		
		Mat uj = Highgui.imread("temp.jpeg" ,Highgui.CV_LOAD_IMAGE_COLOR);	
//		new Megjelenito("tempa"+hanyadik+".jpeg", uj);
		
		return uj;
		
	}

}
