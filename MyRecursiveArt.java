public class MyRecursiveArt {

    public static void main (String[] argv)
    {
	DrawTool.display ();
        DrawTool.setXYRange (0, 10, 0, 10);

	drawPattern (1.0, 9.0);

	drawCircle (7.0, 5.0);
    }

    static void drawCircle (double x, double y)
    {
	DrawTool.drawCircle (x,y, 2.0);
	drawSegments (x, y, 2.0, 10.0);
    }

    static void drawSegments (double x, double y, double radius, double angle)
    {

	if (angle >= 60) {
	    return;
	}

	double newY = y + (Math.sin(angle) * radius);
	double newX  = x - (Math.cos(angle) * radius);
	DrawTool.drawLine (x,y, newX,newY);

	angle += 10;
	drawSegments (x, y, radius, angle);

    }

    static void drawPattern (double x, double y)
    {
	// Base
	if (y-1 < 1) {
	    return;
	}

	// Draw three parallels
	DrawTool.drawLine (x,y, x, y-1);
	DrawTool.drawLine (x+1,y, x+1, y-1);
	DrawTool.drawLine (x+2,y, x+2, y-1);

	// Draw diagonals
	DrawTool.drawLine (x,y-1, x+1,y-2);
	DrawTool.drawLine (x+1,y-1, x+2,y-2);
	DrawTool.drawLine (x+2,y-1, x+1.5,y-1.5);
	DrawTool.drawLine (x,y-2, x+0.5,y-1.5);

	// Recurse
	y -= 2;
	drawPattern (x, y);
    }

}
