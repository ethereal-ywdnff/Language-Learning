import sheffield.*;
public class Assignment2 {
	public static void main(String [] args) {
		
		//draw a picture of 520x520
		EasyGraphics graphicsWindow = new EasyGraphics(520, 520);
		
		//draw the background which contains the sky, grass and water
		final int background = 520;
		int proportionOfSky = (int)(background*0.25);
		int proportionOfGrass = (int)(background*0.5);
		int proportionOfRriver = (int)(background*0.25);
		graphicsWindow.setColor(0, 245, 255);//baby blue
		graphicsWindow.fillRectangle(0, 390, 520, proportionOfSky);
		graphicsWindow.setColor(78, 238, 148);//green
		graphicsWindow.fillRectangle(0, proportionOfRriver, 520, proportionOfGrass);
		graphicsWindow.setColor(0, 139, 139);//cyan
		graphicsWindow.fillRectangle(0, 0, 520, proportionOfRriver);
		
		//read in the duck.txt
		EasyReader characterInput = new EasyReader("duck.txt");
		
		//make the duck.txt an array of 130x130 
		char[][] duck = new char[130][130];
		for (int m=0; m<130; m++) 
			for (int n=0; n<130; n++) 
				duck[m][n] = characterInput.readChar();
		
		//creat the alphabetical letters
		char[] letters = new char[26];
		for (int l=0; l<26; l++) {
			letters[l] = (char)('a'+l);
		}
		
		//display the array of duck.txt and draw the ducks
		for (int a=0; a<duck.length; a++) {
			char[] rows = duck[a];
			for (int i=0; i<rows.length; i++) {
				char column = rows[i];
				for (int n=0; n<letters.length; n++) {
					if (column==letters[n]) {
						
						//draw the eyes
						if (column%22==0) {
							graphicsWindow.setColor(0, 0, 0);//black
							graphicsWindow.fillRectangle(2*i, 2*(130-a)+260, 2, 2);
							graphicsWindow.plot(i+340, 450-a);
							graphicsWindow.plot(320-i, 320-a);
							graphicsWindow.fillRectangle(2*i+260, 2*(130-a), 2, 2);
							continue;
						}
						
						//get rid of the letters which numeric value is even
						if ((n+1)%2==0) {
							continue;
						}
						
						//draw the bills
						if (column%5!=0) {
							graphicsWindow.setColor(176, 196, 222);//grey
							graphicsWindow.fillRectangle(2*i, 2*(130-a)+260, 2, 2);
							graphicsWindow.plot(i+340, 450-a);
							graphicsWindow.plot(320-i, 320-a);
							graphicsWindow.fillRectangle(2*i+260, 2*(130-a), 2, 2);
							continue;
						}
						
						//draw the legs
						if (column%7!=0) {
							graphicsWindow.setColor(255, 0, 0);//red
							graphicsWindow.fillRectangle(2*i, 2*(130-a)+260, 2, 2);
							graphicsWindow.plot(i+340, 450-a);
							graphicsWindow.plot(320-i, 320-a);
							graphicsWindow.setColor(0, 139, 139);
							graphicsWindow.fillRectangle(2*i+260, 2*(130-a), 2, 2);
							continue;
						}
						
						//draw the bodies
						if ( (n+1)%2!=0) {
							graphicsWindow.setColor(255, 255, 0);
							graphicsWindow.fillRectangle(2*i, 2*(130-a)+260, 2, 2);
							graphicsWindow.plot(i+340, 450-a);
							graphicsWindow.plot(320-i, 320-a);
							graphicsWindow.fillRectangle(2*i+260, 2*(130-a), 2, 2);

						}
					}
				}


			}
		}
	
	}
}