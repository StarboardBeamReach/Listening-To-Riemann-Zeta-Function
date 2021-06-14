 /**************************************************************************
**
**    Handles complex numbers for Listening To Riemann Zeta Function           
**
**************************************************************************
**    StarboardBeamReach
**    2021/06/14
**
**    Holds real and imaginary components and can print to string for testing.
**************************************************************************/


public class ComplexNumber {
	
	private double x; //real
	private double i; //imaginary
	
	public ComplexNumber(double new_x, double new_i) {
		x=new_x;
		i=new_i;
	}
	
	public void addComplexNumber(ComplexNumber numToAdd) {
		x +=numToAdd.getRealComponent();
		i +=numToAdd.getImagComponent();
	}
	
	public double getRealComponent() {
		return x;
	}
	
	public double getImagComponent() {
		return i;
	}
	
	public String toString() {
		return "x = " + x + ", i = " + i;
	}

}
