 /**************************************************************************
**
**    JPanel that graphs the datapoints for Listening To Riemann Zeta Function           
**
**************************************************************************
**    StarboardBeamReach
**    2021/06/14
**
**    Contains a list of datapoin and draws them on a graph.
**************************************************************************/


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class RiemannJPanel extends JPanel {
	
	private List<DataPoint> dataToGraph;
	private int panelWidth; //panel dimension
	private int panelHeight; //panel dimension
	private int width; //x value for the graph
	private int height; //y value for the graph
	private int xShift; //sets the x=0 line of the graph
	private int yShift; //sets the y=0 line of the graph
	private double scale; //zooms the graph in/out
	private int pointHalfRadius = 5; //half radius
	
	
	public RiemannJPanel(int pw, int ph, int w, int h) {
		panelWidth = pw;
		panelHeight = ph;
		width = w;
		height = h;
		scale = pw/w;
		xShift = panelWidth/2;
		yShift = panelHeight/2;
		dataToGraph = new ArrayList<DataPoint>();
	}
	
	public void addDataPoint(double x, double y) {
		dataToGraph.add(new DataPoint(x,y));
	}
	
	//borderlayout should handle this, but according to articles on stackoverflow, this helps avoid the panel being too small
	@Override
    public Dimension getPreferredSize(){
       return new Dimension(panelWidth,panelHeight);
    }

	//borderlayout should handle this, but according to articles on stackoverflow, this helps avoid the panel being too small
	@Override
    public Dimension getMinimumSize(){
       return new Dimension(width,height);
    }
	
	@Override
    protected void paintComponent(Graphics g)
    {
        //draws blank background
		g.setColor(Color.WHITE); 
		g.fillRect(0, 0, panelWidth, panelHeight);
		
		//draws grid lines
		g.setColor(Color.GRAY);
		g.drawLine(0,yShift,panelWidth,yShift);
		g.drawLine(xShift,0,xShift,panelHeight);
		
		g.drawString("Chord VI", 20, 10);//top left
		g.drawString("Chord I", panelWidth-60, 20);//top right
		g.drawString("Chord V", 20, panelHeight-20);//bottom left
		g.drawString("Chord IV", panelWidth-60, panelHeight-20);//bottom right
		
		
        try {
        	
        	int pointX;
        	int pointY;
        	int colorCounter = 0;
        	
        	for(DataPoint dataPoint : dataToGraph) {
        		
        		pointX = (int)dataPoint.getX();
        		pointY = (int)dataPoint.getY();
        		
        		//uses a counter to change the color, helps viewer be able to track the spirals
        		g.setColor(new Color(255-colorCounter%255,((int)(colorCounter/4))%255,colorCounter%255));
        		colorCounter++;
        		
        		//if the points are on screen, drawing them using the mapped coordinate system
        		if(mapX(pointX - 2 *pointHalfRadius) < mapX(width) || mapY(pointY - 2 * pointHalfRadius) < mapY(height)) {
        			g.fillOval(mapX(pointX-pointHalfRadius), mapY(pointY-pointHalfRadius),2*pointHalfRadius, 2*pointHalfRadius );
        		}
        		        		
        	} //ends for loops
        	
        }catch(Exception e) {
        	
        	System.out.println("Error drawing panel.");
        
        } //ends catch
        
    }
	
	//shifts and scales x coordinates from panel coord system to graph coord system
	public int mapX(int x1) {
		return (int)((x1 * scale) + xShift);
	}
	
	//shifts, scales, and flips y coordinates from panel coord system to graph coord system
	public int mapY(int y1) {
		return (int)(yShift - (y1 * scale));
	}

}
