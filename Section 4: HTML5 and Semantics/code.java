package graphicsTester;

import java.awt.Color;
import graphics.*;
import systemInput.*;


public class Main {
	public static void main(String [] args) {
		EasyReader in = new EasyReader();

		int height = in.readInt("Height of Cube : ");
		int width = in.readInt("Width of Cube : ");

		GraphicsManager graphics = new GraphicsManager(1000,1000);	
		final int sum = 0;

		if(width > 10 && width < 1000 && height > 10 && height < 1000) {

			//Back bg = new Back(0,0,0);
			int red =0;
			int green =0;
			int blue=0;

			Color black = new Color(red,green,blue);
			String color = in.readString("Colour of cube : (red/green/blue or custom) : ");

			switch(color) {
			case "red":
				graphics.setColor(255,0,0);
				break;
			case "green":
				graphics.setColor(0, 255, 0);
				break;
			case "blue":
				graphics.setColor(0, 0, 255);
				break;
			case "black":
				graphics.setColor(0, 0, 0);
				break;
			case "custom":
				int r = in.readInt("red component : ");
				int g = in.readInt("green component : ");
				int b = in.readInt("blue component : ");
				graphics.setColor(r, g, b);
				break;
			}

			final int initialX = 100;
			final int initialY = 100;

			graphics.setColor(0, 0, 0);
			graphics.drawRectangle(0, 0, 1000, 1000);
			graphics.fillRectangle(0, 0, 1000, 1000);

			graphics.setColor(0, 255, 0);
			graphics.drawRectangle(initialX, initialY, width, height);
			int heightCoeffecient = height * 4/3;

			try {
				graphics.drawLine(initialX, height+initialY, initialX+(height / 4), initialY+(heightCoeffecient));
				graphics.drawLine(initialX+width, initialY+height, width+initialX+(height/4), initialY+(heightCoeffecient));
				graphics.drawLine(initialX+(height/4), initialY+(heightCoeffecient), width+initialX+(height/4), initialY+(heightCoeffecient));
				graphics.drawLine(initialX+width, 100, width+initialX+(height/4), initialY+(height/4));
				graphics.drawLine(width+initialX+(height/4), initialY+(height/4), width+initialX+(height/4), initialY+(heightCoeffecient));
			} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}

		else {
			System.out.println("Measurements too small/large");
		}

		int heightTriangle = in.readInt("Height of triangle : ");
		int widthTriangle = in.readInt("Width of triangle : ");

		if(widthTriangle > 10 && widthTriangle < 1000 && heightTriangle > 10 && heightTriangle < 1000) {
			final int initialTriX = 500;
			final int initialTriY = 500;
            
            graphics.setColor(0,255,0);
			graphics.drawLine(initialTriX, initialTriY, initialTriX+widthTriangle, initialTriY+heightTriangle);
			graphics.drawLine(initialTriX, initialTriY, initialTriX+(widthTriangle*2), initialTriY);
			graphics.drawLine(initialTriX+(widthTriangle*2), initialTriY, initialTriX+widthTriangle, initialTriY+heightTriangle);

			final int coeffecientTri = 8;
			int slantLength = (int)Math.sqrt((heightTriangle*heightTriangle)+(widthTriangle*widthTriangle));
			int smallSlantLength = slantLength / coeffecientTri;

			graphics.drawLine(initialTriX+widthTriangle, initialTriY+heightTriangle,
					(initialTriX+widthTriangle)+smallSlantLength,(initialTriY+heightTriangle)+smallSlantLength);

			graphics.drawLine(initialTriX+(widthTriangle*2), initialTriY,
					initialTriX+(widthTriangle*2)+smallSlantLength,initialTriY+smallSlantLength );

			graphics.drawLine(initialTriX+(widthTriangle*2)+smallSlantLength, initialTriY+smallSlantLength,
					(initialTriX+widthTriangle)+smallSlantLength, (initialTriY+heightTriangle)+smallSlantLength);

		}	

	}

}

