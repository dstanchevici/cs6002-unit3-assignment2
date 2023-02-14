
public class RecursiveArt {

    public static void main (String[] argv)
    {
	DrawTool.display ();
	DrawTool.setXYRange (0, 10, 0, 10);

	// Arguments:
	//  square's initial point,
	//  the square side's length, and
	//  center point
	double topLeftX = 1;
	double topLeftY = 9;
	double side = topLeftY - topLeftX;
	double center = (side/2) + topLeftX;

	drawSquareAndCircle (topLeftX, topLeftY, side, center);
    }

    static void drawSquareAndCircle (double topLeftX, double topLeftY, double side, double center)
    {
	double radius = side/2;
	
	// Base
	if (side < 1 || radius < 1) {
	    return;
	}

	// Draw
	DrawTool.setRectangleColor ("blue");
	DrawTool.drawRectangle (topLeftX, topLeftY, side, side);
	DrawTool.setOvalColor ("red");
	DrawTool.drawCircle (center, center, radius);

	// Recurse
	side = radius * Math.sqrt(2);
	topLeftX = center - (side/2);
	topLeftY = center + (side/2);
	drawSquareAndCircle (topLeftX, topLeftY, side, center);
    }

}
