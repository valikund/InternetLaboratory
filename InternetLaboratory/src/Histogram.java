import java.util.LinkedList;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;


public class Histogram {
	public Histogram(Mat source,int size, int range ){
		java.util.List<Mat> matList = new LinkedList<Mat>();
        matList.add(source);
        Mat histogram = new Mat();
        MatOfFloat ranges=new MatOfFloat(0,range);
        Imgproc.calcHist(
                matList, 
                new MatOfInt(3), 
                new Mat(), 
                histogram , 
                new MatOfInt(size), 
                ranges);
        
        //komment
        System.out.println("histogram\n"+histogram.dump());	
        
        
        int hist_w = 512; int hist_h = 400;
    	int bin_w = (int) Math.round((double) hist_w/ (double)size);

    	Mat histImage = new Mat( hist_h, hist_w, CvType.CV_8UC3 , new Scalar( 0,0,0) );
    	
    	Core.normalize(histogram, histogram, 0, histImage.rows(), Core.NORM_MINMAX, -1,new Mat() );
    	
    	

    	


	
	
	}
	
	
}
