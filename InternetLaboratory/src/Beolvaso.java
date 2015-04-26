import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;


public class Beolvaso {
	public static Mat beolvas(String forras){
		Mat uj = Highgui.imread(forras ,Highgui.CV_LOAD_IMAGE_COLOR);
		return uj;
	}

}
