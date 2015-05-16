import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;


public class ImageTiling {
	public static void main(String[] args) throws IOException{
		
	
		Mat a = Beolvaso.beolvaso_fajlbol("C:/Users/valikund-pc/Desktop/OpenCV/img2.jpg");
		Mat b = Beolvaso.beolvaso_fajlbol("C:/Users/valikund-pc/Desktop/OpenCV/img.jpg");
		
	 	Mat bSubmat = b.submat(a.rows(), a.rows()*2, a.cols(), a.cols()*2);    	
    	a.copyTo(bSubmat);
		
		new Megjelenito("temp.jpg",b);

	}
}
