package dsuarez_Steganog;

import java.io.File;
import java.io.IOException;

public class Startup {

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Diego Suarez\\Desktop\\decrypt.png");
		
		try{
			String message = Steganog.retreiveFromImage(file);
			System.out.println(message);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
