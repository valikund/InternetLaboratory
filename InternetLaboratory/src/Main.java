import java.io.IOException;
import java.util.Vector;

import org.opencv.core.*;
import org.opencv.highgui.*;
import org.opencv.imgproc.Imgproc;

import GoogleAPI.GoogleImageFootprinter;
import GoogleAPI.GoogleReverseImageSearch;
 
public class Main {
 
public static void main(String[] args) throws Exception
       {
		new Collage("analog circuit", 1000, 1000, 16);
//		String url = GoogleImageFootprinter.footprint("C:/Users/valikund-pc/Desktop/OpenCV/img1.jpg");
//		System.out.println(url);
//		GoogleReverseImageSearch.keres(url);
//	
//	Mat a = Beolvaso.beolvaso_fajlbol("temp3.jpeg");
//	a = Resize.resize(a, 200, 200);
//		new Megjelenito("kep.jpg",a);
       }

}