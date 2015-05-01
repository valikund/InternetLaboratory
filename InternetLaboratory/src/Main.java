import org.opencv.core.*;
import org.opencv.highgui.*;
 
public class Main {
 
public static void main(String[] args)
       {
System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
   Mat m= Beolvaso.beolvas("C:/Users/valikund-pc/Desktop/OpenCV/img.jpg");
   Mat b= Beolvaso.beolvas("C:/Users/valikund-pc/Desktop/OpenCV/img_other.jpg");
   
   
//   new Megjelenito("C:/Users/valikund-pc/Desktop/OpenCV/img.jpg", m);
   m= Resize.resize(m, 400);
//   new Megjelenito("C:/Users/valikund-pc/Desktop/OpenCV/img1.jpg", m);
   m = GreyScale.greyscale(m);
   
   b= Resize.resize(b, 400);
   b = GreyScale.greyscale(b);
   
   
//   new Megjelenito("C:/Users/valikund-pc/Desktop/OpenCV/img2.jpg", b);
  
   new Histogram2(b);
   new Histogram2(m);
   
   
   
   
       }
       }