import org.opencv.core.*;
import org.opencv.highgui.*;
 
public class Main {
 
public static void main(String[] args)
       {
System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
   Mat m=Highgui.imread("C:/Users/valikund-pc/Desktop/OpenCV/img.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
   new LoadImage("C:/Users/valikund-pc/Desktop/OpenCV/img.jpg",m);
       }
       }