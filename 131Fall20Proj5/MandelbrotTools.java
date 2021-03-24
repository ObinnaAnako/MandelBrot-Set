import java.awt.Color;

public class MandelbrotTools {
	
	/*  STUDENTS:  Put your "isBig" and "divergence" methods here. */
	/*this method takes one parameter, a ComplexNumber, and will return type 
	 * boolean*/
	public static boolean isBig(ComplexNumber x) {
		/*the variable norm_square is basically the squared value of the norm. 
		 *thats the reason why i called it normed square. its a MyDouble*/
		MyDouble norm_square = (x.getReal().multiply(x.getReal())).add
				(x.getImag().multiply(x.getImag()));
		if (norm_square.compareTo(Controller.DIVERGENCE_BOUNDARY) > 0 ) {
			return true;
		}else {
			return false;
		}
	}
	/*his method takes one parameter, a ComplexNumber which we will call z0.  
	 * The method will return type integer. This method calculates a sequence of
	 *  complex numbers z1, z2, z3, z4. etc*/
	public static int divergence(ComplexNumber z0) {
		ComplexNumber z = new ComplexNumber(z0);
		/*These values will be computed one by one.  After each value is 
		 * computed, test to see whether or not it isBig As soon as one of the 
		 * terms in the sequence isBig, exit the method immediately.  In this 
		 * case, the return value will be the index (i) of the term that was too 
		 * big*/
		for (int i =1; i <= Controller.LIMIT; i++) {
			z = (z.multiply(z)).add(z0);
			if (isBig(z)==true) {
				return i;
			}
		}
		/*if the controller limit is exceeded*/
		return -1;
	}

	
	
	
	
	
	
	/* This method selects a non-black color for a point which DIVERGED when tested with the Mandelbrot
	 * recurrence, based on how many terms in the sequence were computed before the terms got "too big".
	 * 
	 * The parameter represents the index of the term in the sequence which was first to be "too big".  
	 * This value could be anything from 0 to Controller.LIMIT.  The return value is the Color to be used 
	 * to color in the point.
	 * 
	 * STUDENTS:  IF you want to have some fun, write code for the else-if clause below which says
	 * "modify this block to create your own color scheme".  When someone runs the program and selects 
	 * "Student Color Scheme", the code you have written below will determine the colors.
	 */
	public static Color getColor(int divergence) {
		Color returnValue;
		
		if (Controller.colorScheme == Controller.RED_AND_WHITE_BANDS) {
			returnValue = (divergence  % 2 == 0)? Color.WHITE : Color.RED;
		}
		
		else if (Controller.colorScheme == Controller.CRAZY_COLORS) {
			int value = divergence * 2;
			int redAmount = (value % 5) * (255/5);
			int greenAmount = (value % 7) * (255/7);
			int blueAmount = (value % 9) * (255/9);
			returnValue = new Color(redAmount, greenAmount, blueAmount); 
		}
		
		else if (Controller.colorScheme == Controller.STUDENT_DEFINED){
			
			
			/***************************************************************
			 * Modify this block to create your own color scheme!          *
			 ***************************************************************/
			returnValue = Color.WHITE;  // take this out and return something useful
			
			
		}
		else
			throw new RuntimeException("Unknown color scheme selected!");
		return returnValue;
	}
	
	

}
