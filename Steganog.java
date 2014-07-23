package dsuarez_Steganog;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Steganog {
	
	public static String retreiveFromImage(File file) throws IOException {

		String message = "";

		int rgb;

		BufferedImage bufferedImage = ImageIO.read(file);
		
		PrimeIterator primeIterator = new PrimeIterator(bufferedImage.getWidth()
				* bufferedImage.getHeight());
		

		int prime = primeIterator.next();

		for (int i = 0; i < bufferedImage.getWidth(); i++) {
			for (int j = 0; j < bufferedImage.getHeight(); j++) {

				if ((i * bufferedImage.getHeight() + j) == prime) {
					rgb = bufferedImage.getRGB(j, i);
					String s = Integer.toBinaryString(rgb);
					String letter = s.charAt(14) + "" + s.charAt(15)
							+ s.charAt(22) + s.charAt(23) + s.charAt(30)
							+ s.charAt(31) + "";
					int decimal = Integer.parseInt(letter, 2);
					decimal += 32;
					message += (char)decimal;
					if (primeIterator.hasNext()) {
						prime = primeIterator.next();
					}
				}
			}
		}

		return message;

	}
}
