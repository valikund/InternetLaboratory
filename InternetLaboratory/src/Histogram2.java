import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;


public class Histogram2 {
	public Histogram2(Mat image){
		
	    Mat src = new Mat(image.height(), image.width(), CvType.CV_8UC2);
	    
	    Vector<Mat> bgr_planes = new Vector<>();
	    if (image.channels()>1){
	    Imgproc.cvtColor(image, src, Imgproc.COLOR_RGB2GRAY);
		    Core.split(src, bgr_planes);
	    }
	    else{
	    	    	bgr_planes.addElement(src);
	    }
	    MatOfInt histSize = new MatOfInt(256);


	    final MatOfFloat histRange = new MatOfFloat(0f, 256f);

	    boolean accumulate = false;

	    Mat b_hist = new  Mat();

	    Imgproc.calcHist(bgr_planes, new MatOfInt(0),new Mat(), b_hist, histSize, histRange, accumulate);

	    int hist_w = 512;
	    int hist_h = 600;
	    long bin_w;
	    bin_w = Math.round((double) (hist_w / 256));

	    Mat histImage = new Mat(hist_h, hist_w, CvType.CV_8UC1);

	    Core.normalize(b_hist, b_hist, 3, histImage.rows(), Core.NORM_MINMAX);



	    for (int i = 1; i < 256; i++) {         


	        Core.line(histImage, new Point(bin_w * (i - 1),hist_h- Math.round(b_hist.get( i-1,0)[0])), 
	                new Point(bin_w * (i), hist_h-Math.round(Math.round(b_hist.get(i, 0)[0]))),
	                new  Scalar(255, 0, 0), 2, 8, 0);

	    }


	    new Megjelenito("C:/Users/valikund-pc/Desktop/OpenCV/img3.jpg", histImage);
	}
}

