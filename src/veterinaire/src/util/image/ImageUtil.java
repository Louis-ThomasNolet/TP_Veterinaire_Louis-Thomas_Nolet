package veterinaire.src.util.image;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public abstract class ImageUtil {

	public static ImageIcon getImageIcon(URL url){
		return new ImageIcon(url);
	}

	public static ImageIcon getImageIcon(Class c, String pathImage) {
		return new ImageIcon(c.getResource(pathImage));
	}
}