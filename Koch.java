/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {
		if (args.length == 5) {
            curve(Integer.parseInt(args[0]),
                  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
                  Double.parseDouble(args[3]), Double.parseDouble(args[4]));
        } else if (args.length == 1) {
            snowFlake(Integer.parseInt(args[0]));
        }
		}
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);
		if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        double dx = (x2 - x1) / 3.0;
        double dy = (y2 - y1) / 3.0;

        double xb = x1 + dx;
        double yb = y1 + dy;

        double xd = x1 + 2 * dx;
        double yd = y1 + 2 * dy;

        double cos60 = 0.5;
        double sin60 = Math.sqrt(3.0) / 2.0;
        double xc = xb + (dx * cos60 - dy * sin60);
        double yc = yb + (dx * sin60 + dy * cos60);

        curve(n - 1, x1, y1, xb, yb);
        curve(n - 1, xb, yb, xc, yc);
        curve(n - 1, xc, yc, xd, yd);
        curve(n - 1, xd, yd, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		double x1 = 0.25;
        double y1 = 0.25;
        double x2 = 0.85;
        double y2 = 0.25;
        double x3 = (x1 + x2) / 2.0;
        double y3 = y1 + (x2 - x1) * Math.sqrt(3.0) / 2.0;

        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
	}
}
