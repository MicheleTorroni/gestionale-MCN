package utility;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Images {
	public static void impostaIcona(JFrame frame) {
		ImageIcon img = new ImageIcon(frame.getClass().getClassLoader().getResource("logo.png"));
		frame.setIconImage(img.getImage());
	}
}
