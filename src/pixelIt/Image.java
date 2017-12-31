package pixelIt;

import java.io.File;
import java.awt.Color;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Image{
	public int width;//carry the image width
	public int hight;//carry the image hight
	public int[][] red;//carry the red color of every pixel
	public int[][] blue;//carry the blue color of every pixel
	public int[][] green;//carry the green color of every pixel
	
	/*takes the path to read the image
	 */
	public void ReadImage(String path) throws IOException{
		//open iput file/image
		BufferedImage image = null;
		Color color = null;
		//openning the image
		image = ImageIO.read(new File(path));
		//getting the width and the hight
		width = image.getWidth();
		hight = image.getHeight();
		//initializing the channels
		red = new int[width][hight];
		blue = new int[width][hight];
		green = new int[width][hight];
		//disassemple the image
		for(int i = 0 ; i < width ; i++) {
			for(int j = 0 ; j < hight ; j++) {
				color = new Color( image.getRGB(i, j) );
				red[i][j]=color.getRed();
				blue[i][j]=color.getBlue();
				green[i][j]=color.getGreen();
			}
		}
	}
	
	/*takes the path to write the image
	 * takes the extention of the image
	 */
	public String WriteImage(String path,String extention,boolean mark) throws IOException{
		BufferedImage image = null;
		Color color = null;
		//initializing a buffer
		image = new BufferedImage(width,hight,BufferedImage.TYPE_INT_RGB);
		//assempling the image
		for(int i = 0; i < width ;i++) {
			for(int j = 0 ; j < hight ; j++) {
				color = new Color(red[i][j],green[i][j],blue[i][j]);
				image.setRGB(i, j, color.getRGB());
			}
		}
		
		//program mark
		//puts a pixels at the bottom right to mark the image with the program name
		if(mark) {
			
		}
		
		//writting the image
		String newPath = path+"."+extention;
		ImageIO.write(image, extention, new File(path+"."+extention));
		return newPath;
	}
}