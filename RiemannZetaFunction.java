 /**************************************************************************
**
**    Calculates Riemann Zeta partial sum for Listening To Riemann Zeta Function           
**
**************************************************************************
**    StarboardBeamReach
**    2021/06/14
**
**    Sums the first n terms of the infinite series
**************************************************************************/

public class RiemannZetaFunction {

	private int max_steps;
	
	public RiemannZetaFunction(int new_max_steps) {
		max_steps = new_max_steps;
	}
	
	public ComplexNumber calculate(ComplexNumber input, int current_step) {
	
		//variables are based on the equation form of 1 / ( a+bi ^ (c+di) )
		double a = current_step; //equivalent to n in the infinite series
		double b = 0; //this term is in the generic formula, but not in the riemann
		double c = input.getRealComponent();
		double d = input.getImagComponent();
		double e = 2.71828; //approximation of e
		
		//radius and angle theta in polar coordinate
		double r = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		double t = Math.atan(b/a);
		
		double real_comp = Math.pow(r, c) * Math.pow(e, d*t) * Math.cos(c*t+d*Math.log(r));
		double imag_comp = Math.pow(r, c) * Math.pow(e, d*t) * Math.sin(c*t+d*Math.log(r));
		
		ComplexNumber nextAddition = new ComplexNumber(real_comp,imag_comp);
		
		System.out.println("\tInside Riemann Zeta Function - Calculate: nextAddition = " + nextAddition + " and current_step = " + current_step);
	
		if (current_step <= max_steps) {
			
			int next_step = current_step + 1;
			nextAddition.addComplexNumber(calculate(input,next_step));
			return nextAddition;
		
		}else {
			
			return nextAddition; //the infinite sum is only calculated to a finite number of terms, this is the last term added
		}
		
	}
}
