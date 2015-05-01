import org.opencv.imgproc.Imgproc;
import org.opencv.core.Mat;
import org.opencv.core.*;


public class CompareHist {
	public static double[] compHist(Mat a, Mat b, int[] method){
		
		double[] correl=new double[method.length];
		for(int i=0; i<method.length; i++){
			correl[i] = Imgproc.compareHist(a, b,  i);
		}
		return correl;
	
	}
}
