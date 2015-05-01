import org.opencv.core.*;
import org.opencv.highgui.*;
 
public class Main {
 
public static void main(String[] args)
       {
System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
   Mat m= Beolvaso.beolvas("C:/Users/valikund-pc/Desktop/OpenCV/img.jpg");
   new Megjelenito("C:/Users/valikund-pc/Desktop/OpenCV/img.jpg", m);
   m= Resize.resize(m, 400);
   new Megjelenito("C:/Users/valikund-pc/Desktop/OpenCV/img1.jpg", m);
   Mat k = GreyScale.greyscale(m);
   new Megjelenito("C:/Users/valikund-pc/Desktop/OpenCV/img2.jpg", k);
  
   new Histogram2(k);

   
       }
       }