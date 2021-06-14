 /**************************************************************************
**
**    Handles datapoints for JPanel graph for Listening To Riemann Zeta Function           
**
**************************************************************************
**    StarboardBeamReach
**    2021/06/14
**
**    Contains x and y coordinates for datapoints. 
** 
**    Future versions could move the paintComponent function from the JPanel
**    into this class, so each datapoint would know how to draw itself.
**************************************************************************/

public class DataPoint {

	private double x;
	private double y;
	
	public DataPoint(double x1, double y1) {
		x = x1;
		y = y1;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	
}
