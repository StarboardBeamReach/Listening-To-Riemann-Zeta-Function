 /**************************************************************************
**
**    Handles the Jframe window for Listening To Riemann Zeta Function           
**
**************************************************************************
**    StarboardBeamReach
**    2021/06/14
**
**    JFrame window that pops up and contains the JPanel.
**************************************************************************/


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

public class RiemannJFrame extends JFrame{

	private int width;
	private int height;
	private RiemannJPanel panel;
	private int margin = 50;
	private int panelScale = 10;
	
	public RiemannJFrame(int w, int h) {
		width = w;
		height = h;
		panel = new RiemannJPanel(w-margin,h-margin, (w-margin)/panelScale, (h-margin)/panelScale);
	}
	
	public void createAndShowUI(){
		//creates layout and adds panel
		setTitle("Listening To Riemann Zeta Function");
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setSize(width,height);
		c.fill = GridBagConstraints.BOTH;
		add(panel,c);
		//handles frame and frame settings    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationByPlatform(true);
		pack();
		setVisible(true);
    }
	
	public void addDataPointToPanel(ComplexNumber c) {
		panel.addDataPoint(c.getRealComponent(), c.getImagComponent());
	}
	
	
}
	 

