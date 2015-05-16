
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;


public class ImageTiling {
//	public static void main(String[] args) throws IOException{
//		
//	
//		Mat a = Beolvaso.beolvaso_fajlbol("C:/Users/valikund-pc/Desktop/OpenCV/img2.jpg");
//		Mat b = Beolvaso.beolvaso_fajlbol("C:/Users/valikund-pc/Desktop/OpenCV/img.jpg");
//		
//	 	Mat bSubmat = b.submat(a.rows()*2, a.rows()*3, a.cols()*2, a.cols()*3);    	
//    	a.copyTo(bSubmat);
//		
//		new Megjelenito("temp.jpg",b);
//
//	}
	
	public static Mat beilleszto(Mat amit_illesztunk, Mat amibe_illesztunk, int sor, int oszlop) throws IOException{
		
		
		
	 	Mat bSubmat = amibe_illesztunk.submat(sor, amit_illesztunk.rows()+sor, oszlop, amit_illesztunk.cols()+oszlop);    	
    	amit_illesztunk.copyTo(bSubmat);
		
		new Megjelenito("temp.jpg",amibe_illesztunk);
		
		return amibe_illesztunk;

	}
}
