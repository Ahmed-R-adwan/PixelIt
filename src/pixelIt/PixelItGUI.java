package pixelIt;

import java.io.IOException;

public class PixelItGUI {

	public static void main(String[] args) {
		try {
			System.out.println(PixelIt.Pixel("/home/radwan/Desktop/test.jpg", 3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}