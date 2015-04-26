import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;


public class GreyScale {
	public static Mat greyscale(Mat forras){
		Mat kimenet= new Mat();
		Imgproc.cvtColor(forras, kimenet, Imgproc.COLOR_RGB2GRAY);
		return kimenet;
	}

}
