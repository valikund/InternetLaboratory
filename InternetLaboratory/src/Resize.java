import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;


public class Resize {
	public static Mat resize(Mat cropImage, int height, int width){
		Mat croppedimage = cropImage;
		Mat resizeimage = new Mat();
		Size sz = new Size(height,width);
		Imgproc.resize( croppedimage, resizeimage, sz );
		
		return resizeimage;
	}

}
