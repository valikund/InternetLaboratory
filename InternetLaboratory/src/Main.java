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
System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
Mat m = Beolvaso.beolvaso_urlrol("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS60x3YS99bQAxElG7WCKn7_Pu3lcJ6lj6FG_CSZsWDLyzvzKoZQnNQKA");
   new Megjelenito("C:/Users/valikund-pc/Desktop/OpenCV/img2.jpg", m);
   

       }
       }