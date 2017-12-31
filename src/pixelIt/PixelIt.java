package pixelIt;

import java.io.IOException;

public class PixelIt {
	
	/*takes image path
	 *number of desierd colors in the image
	 *return the path of the new image 
	 */
	public static String Pixel(String path,int numberOfColors) throws IOException {
		//declaring and openning the image
		Image image = new Image();
		image.ReadImage(path);
		
		//initializing the three channels of the most x"numberOfColors" repeated colors
		int[] red = GetMostRepeated(image.red,numberOfColors,20);
		int[] green = GetMostRepeated(image.green,numberOfColors,20);
		int[] blue = GetMostRepeated(image.blue,numberOfColors,20);
		
		//debuging
		System.out.println("red : ");
		for(int i = 0 ; i < red.length ; i++) {
			System.out.print(red[i]);
			if(i != red.length-1)
				System.out.print(" , ");
			else
				System.out.println();
		}
		System.out.println("green : ");
		for(int i = 0 ; i < green.length ; i++) {
			System.out.print(green[i]);
			if(i != red.length-1)
				System.out.print(" , ");
			else
				System.out.println();
		}
		System.out.println("blue : ");
		for(int i = 0 ; i < blue.length ; i++) {
			System.out.print(blue[i]);
			if(i != red.length-1)
				System.out.print(" , ");
			else
				System.out.println();
		}
		//end of debugging
		
		//substitute the colors with the most sutable color
		image.red = substitute(red,image.red,5);
		image.green = substitute(green,image.green,5);
		image.blue = substitute(blue,image.blue,5);
		
		return image.WriteImage(path, "jpg", false);
	}
	
	//substitute the colors with the most sutable color
	private static int[][] substitute(int[] colorToUse , int[][] colors,int backGroundThresHold){
		
		for(int i = 0 ; i < colors.length ; i++) {
			for(int j = 0 ; j < colors[i].length ; j++) {
				int index=-1;
				int distance = 0;
				for (int k = 0 ; k < colorToUse.length ; k++) {
					if(k == 0) {
						if(Distance(colorToUse[k],colors[i][j])<=backGroundThresHold) {
							index = k;
							distance = Distance(colorToUse[k],colors[i][j]);
						}
					}else {
						if( index == -1 || distance > Distance(colorToUse[k],colors[i][j])) {
							index = k;
							distance = Distance(colorToUse[k],colors[i][j]);
						}
					}
				}
				colors[i][j] = colorToUse[index];
			}
		}
		return colors;
	}
	
	//return the square differance between two colors
	private static int Distance(int a ,int b){
		int d = a-b;
		return (d*d);
	}
	
	//return array of the most repeated color
	private static int[] GetMostRepeated(int[][] color,int numberOfColors,int distanceBetweenColors){
		int[] mostColor = new int[numberOfColors];
		int[] cumulativeArray = ZeroArray(256);
		
		//count how many times the color comes
		for(int i = 0 ; i < color.length ; i++) {
			for(int j = 0 ; j < color[i].length ; j++) {
				cumulativeArray[color[i][j]]++;
			}
		}
		
		//find the most repeated X"numberOfColors"
		for(int i = 0 ; i < numberOfColors ; i++) {
			int index = 0;
			for(int j = 1 ; j < cumulativeArray.length ; j++) {
				if(cumulativeArray[index]<cumulativeArray[j] &&
						(i-1 < 0 || Math.abs(j-mostColor[i-1]) >= distanceBetweenColors))
					index = j;
			}
			mostColor[i]=index;
			cumulativeArray[index]=-1;
		}
		
		return mostColor;
	}
	
	//make an initialized zero one dimention array with a given length
	private static int[] ZeroArray (int length) {
		int[] array = new int[length];
		for(int i = 0 ; i < length ; i++ ) {
			array[i] = 0;
		}
		return array;
	}
	
}
