package pixelIt;

public class PixelItGUI {

	public static void main(String[] args) {
		
	}
}

//open iput file/image
//BufferedImage img = null;
//Color tempColor = null;
//
//try {
//	img = ImageIO.read(new File(path));
//} catch (IOException e) {
//	System.out.println(e);
//	e.printStackTrace();
//}
//
//BufferedImage img = null;
//Color tempColor = null;
//img = new BufferedImage(width,hight,BufferedImage.TYPE_BYTE_GRAY);
//
//for(int i = 0; i < width ;i++) {
//	for(int j = 0 ; j < hight ; j++) {
//		tempColor = new Color(pixels.get(i).get(j),pixels.get(i).get(j),pixels.get(i).get(j));
//		img.setRGB(i, j, tempColor.getRGB());
//	}
//}
//
//ImageIO.write(img, "jpg", new File(path+".jpg"));