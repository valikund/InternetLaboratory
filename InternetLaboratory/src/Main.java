import java.io.IOException;
import java.util.Vector;

import org.opencv.core.*;
import org.opencv.highgui.*;
import org.opencv.imgproc.Imgproc;

import GoogleAPI.GoogleImageFootprinter;
import GoogleAPI.GoogleReverseImageSearch;
 
public class Main {
 
public static void main(String[] args) throws IOException
       {
	Mat a = Beolvaso.beolvaso_fajlbol("C:/Users/valikund-pc/Desktop/OpenCV/img2.jpg");
	Mat b = Beolvaso.beolvaso_fajlbol("C:/Users/valikund-pc/Desktop/OpenCV/img.jpg");

	new Megjelenito("temp.jpg", ImageTiling.beilleszto(a, b, 300, 400));
       }
       }