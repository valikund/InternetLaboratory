import java.io.IOException;
import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;

import GoogleAPI.GoogleAPI;


public class Collage {
	Mat kimenet;
	
	public Collage(String szo, int magassag, int szelesseg, int kepek_szama) throws IOException, Exception{
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		
		String[] urlek = GoogleAPI.kereso(kepek_szama, szo);
		Mat[] kepek = new Mat[urlek.length-1];
	
		
		int kep_magasag =(int) (magassag/Math.sqrt(kepek_szama));
		int kep_szelessege =(int) (szelesseg/Math.sqrt(kepek_szama));
		
		for(int i=0; i<urlek.length-1; i++){
		Mat temp =Beolvaso.beolvaso_urlrol(urlek[i]);
		temp = Beolvaso.beolvaso_fajlbol(Beolvaso.file_path);
		kepek[i] = Resize.resize(temp, kep_magasag, kep_szelessege);
		
		}
		
		Mat kimenet = new Mat(new Size(szelesseg,magassag), CvType.CV_8UC3);
		
		
		int sor_pozicio =0;
		int oszlop_pozicio=0;
		
		for(int i=0; i<kepek_szama; i++){
			Mat temp = kepek[i];
		kimenet = ImageTiling.beilleszto(temp, kimenet, sor_pozicio, oszlop_pozicio);
		sor_pozicio = kep_szelessege*((i+1)%(int)(Math.sqrt(kepek_szama)));
		oszlop_pozicio = kep_magasag*(int)((i+1)/Math.sqrt(kepek_szama));
		}
		
		new Megjelenito("kep2.jpeg", kimenet);
	}

}
