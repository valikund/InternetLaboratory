import org.opencv.core.*;
import org.opencv.highgui.*;
import org.opencv.imgproc.Imgproc;
 
public class Main {
 
public static void main(String[] args)
       {
System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
   Mat m= Beolvaso.beolvas("C:/Users/valikund-pc/Desktop/OpenCV/Histogram_Comparison_Source_0.jpg");
   Mat b= Beolvaso.beolvas("C:/Users/valikund-pc/Desktop/OpenCV/Histogram_Comparison_Source_1.jpg");
   
   
//   new Megjelenito("C:/Users/valikund-pc/Desktop/OpenCV/img.jpg", m);
   m= Resize.resize(m, 400);
   new Megjelenito("C:/Users/valikund-pc/Desktop/OpenCV/img1.jpg", m);
   m = GreyScale.greyscale(m);
   
   b= Resize.resize(b, 400);
   b = GreyScale.greyscale(b);
   
   
//      new Megjelenito("C:/Users/valikund-pc/Desktop/OpenCV/img2.jpg", b)
 
   	Mat a = Histogram2.hist(b);
   	Mat c = Histogram2.hist(m);
   
   	double[] eredmeny= CompareHist.compHist(a,c, new int[]{0,1,2,3});
   	for(int i=0; i<eredmeny.length; i++)
   	System.out.println(eredmeny[i]);
 
   
   
   
       }
       }