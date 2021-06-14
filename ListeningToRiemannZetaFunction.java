 /**************************************************************************
**
**    Main or Listening To Riemann Zeta Function           
**
**************************************************************************
**    StarboardBeamReach
**    2021/06/14
**
**    The Riemann Zeta Function is a famous equation that maps complex numbers
**    to another set of complex numbers. The formula is studied for its impacts
**    on prime numbers and has practical applicates in many fields such as 
**    condensed matter physic. 
**
**    This program calculates and graphs an approximation of the Riemann Zeta function
**    by summing the first n terms of the infinite series. Music is then played
**    based on the real and imaginary components of that complex output.
**  
**    Requires JFugue-5.0.9.jar from www.jfugue.org
**************************************************************************/

public class ListeningToRiemannZetaFunction {
	
	public static void main(String[] args) {
		
		RiemannJFrame frame = new RiemannJFrame(600,600);
		int termsToSum = 45;
		RiemannZetaFunction riemann = new RiemannZetaFunction(termsToSum);
		MultithreadMusicPlayer musicPlayer = null;
		
		double startReal = 0.5;
		double startImag = -15;
		double stepReal = 0.0;
		double stepImag = -0.005;
		double realInput = startReal;
		double imagInput = startImag;
				
		ComplexNumber complexInput;
		ComplexNumber complexOutput;
		
		frame.createAndShowUI();
		
		for(int k=0; k<5000; k++) {
			
			complexInput = new ComplexNumber(realInput,imagInput);
			complexOutput = riemann.calculate(complexInput, 1);
			
			System.out.println("complexInput = " + complexInput);
			System.out.println("complexOutput = " + complexOutput);
			
			frame.addDataPointToPanel(complexOutput);
			frame.repaint();
			
			realInput += stepReal;
			imagInput += stepImag;
				
			if(musicPlayer == null || musicPlayer.getState() == Thread.State.TERMINATED) {
				musicPlayer = new MultithreadMusicPlayer(complexOutput);
				musicPlayer.start();
			}
			
			try {
				Thread.sleep(95);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//end for
		
	}//end main
	
}//end class