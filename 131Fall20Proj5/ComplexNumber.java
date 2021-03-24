
public class ComplexNumber {
	
	/* STUDENTS:  You may NOT add any further instance or static variables! */
	private final MyDouble real;   // To be initialized in constructors
	private final MyDouble imag;   // To be initialized in constructors
	
	
	/* STUDENTS: Put your methods here, as described in the project description. */
	
	/*this is a standard constructor. it takes in two parameters of type MyDouble - 
	 * real and imag. real represents the real value of the ComplexNumber, while 
	 * image represents the imag value of the ComplexNumber. */
	public ComplexNumber(MyDouble real, MyDouble imag) {
		this.real = real;
		this.imag = imag;
	}
	/*this is a standard getter. it get the real value of the instance variable, 
	 * since its private.we need a getter so as to be able to use the real value
	 *  in other classes. */
	public MyDouble getReal() {
		return real;
	}
	/*his is a standard getter. it get the imag value of the instance variable, 
	 * since its private. we need a getter so as to be able to use it in other 
	 * classes.*/
	public MyDouble getImag() {
		return imag;
	}
	/*this is a constructor that takes one parameter (a MyDouble) representing 
	 * the real component that is desired for the ComplexNumber being 
	 * constructed. The data member real is to be initialized with that value, 
	 * but the imag component will be set to zero (0). */
	public ComplexNumber(MyDouble real) {
		this(real, new MyDouble(0));
	}
	/*this is a standard copy constructor.it takes in one 
	 * parameter(ComplexNumber) */
	public ComplexNumber (ComplexNumber other) {
		this(other.real,other.imag);
	}
	/*his method takes one parameter (a ComplexNumber).  It will return a 
	 * ComplexNumber that is equal to the sum of the current object and the 
	 * parameter.*/
	public ComplexNumber add(ComplexNumber x) {
		MyDouble realSum = (real.add(x.real)); //sum of real values
		MyDouble imagSum =	(imag.add(x.imag));//sum of imag values
		return new ComplexNumber(realSum,imagSum);
	}
	/*his method takes one parameter (a ComplexNumber).  It will return a 
	 * ComplexNumber that is computed by subtracting the value of parameter 
	 * from the current object*/
	public ComplexNumber subtract(ComplexNumber x) {
		MyDouble realMinus = (real.subtract(x.real));//real values subtraction
		MyDouble imagMinus = (imag.subtract(x.imag));//imag values subtraction
		return new ComplexNumber(realMinus, imagMinus);
	}
	/*this method takes one parameter (a ComplexNumber).  It will return a 
	 * ComplexNumber that represents the product of the current object and the 
	 * parameter. */
	public ComplexNumber multiply (ComplexNumber x) {
		MyDouble realMultiplication = (real.multiply(x.real)).subtract(
				(imag.multiply(x.imag)));/*the real value gotten from
				 multiplication*/
		MyDouble imagMultiplication = (real.multiply(x.imag)).add(
				(imag.multiply(x.real)));/*the imag values gotten from 
				multiplication*/
		return new ComplexNumber (realMultiplication, imagMultiplication);
	}
	/*this method takes one parameter (a ComplexNumber).  It will return the 
	 * quotient computed by dividing the current object by the parameter.*/
	public ComplexNumber divide (ComplexNumber x) {
		MyDouble realDivision = (((real.multiply(x.real)).add((imag.multiply
				(x.imag) ))).divide((x.real.multiply(x.real)).add
				((x.imag.multiply(x.imag)))));/*the real value gotten from the 
				ComplexNumber division*/
	    MyDouble imagDivision = (((imag.multiply(x.real)).subtract(
	    		(real.multiply(x.imag)))).divide(((x.real.multiply(x.real))
	    		.add((x.imag.multiply(x.imag))))));/*the imag value gotten from 
	    		the ComplexNumber division*/
		return new ComplexNumber (realDivision, imagDivision);
	}
	/*this method returns true if both fields match. it takes in a ComplexNumber
	 * parameter and check if its equals to the current object.
	 * it checks so by checking if both their real and imag values are equal*/
	public boolean equals(ComplexNumber x) {
		return real.equals(x.real) && imag.equals(x.imag);
	}
	/*his method takes one parameter (a ComplexNumber) and returns an integer.It 
	 * will compare the norm of the current object with the norm of the 
	 * parameter. If the norms are equal, this method returns 0; if the norm of 
	 * the current object is less than the norm of the parameter, this method 
	 * returns -1; if the norm of the current object is greater than the norm 
	 * of the parameter, this method returns 1.*/
	public int compareTo(ComplexNumber x) {
		MyDouble norm_current =((real.multiply(real)).add((imag.multiply
				(imag)))).sqrt();//calculates the norm of the current object
		MyDouble norm_parameter =((x.real.multiply(x.real)).add(x.imag.multiply
				(x.imag))).sqrt();//calculates the norm of the parameter
		return norm_current.compareTo(norm_parameter);
	}
	/*this method converts the current ComplexNumber object to string. the 
	 * return value for this method is a String.*/
	public String toString() {
		/*this if statement checks to see if the imag is negative (<0) so that  
		 * it can add a '-' in between the string it returns*/
		if (imag.compareTo(new MyDouble(0))<0) {
			return real + (imag + "i");
		}else {
			return real+ "+"+imag+"i";
		}
	}
	/*his method takes one parameter (a ComplexNumber) and returns a MyDouble 
	 * object representing the norm of the complex number.*/
	public static MyDouble norm(ComplexNumber x) {
		MyDouble norm = ((x.real.multiply(x.real)).add(x.imag.multiply
				(x.imag))).sqrt();
		return norm;
	}
	/*this method takes one parameter (a String) and returns a ComplexNumber.  
	 * The parameter is a String that represents a complex number*/
	public static ComplexNumber parseComplexNumber(String x) {
		String trim = x.trim();/*this remove all the spaces in the beginning and
		end of the string*/
		int indexOfPlus = trim.lastIndexOf('+');/*this gets the index of +*/
		int indexOfMinus = trim.lastIndexOf('-');/*this gets the index of -*/
		int iIndex = trim.indexOf('i');/*this gets the index of i*/
		
		/*the lastIndex method gotten from the string class would be used thro-
		 * -ughout the conditions below. this method starts from the back and 
		 * checks for the index of the various character passed in. when last
		 * index of a character is == -1, it means that the character is not 
		 * available in the string. */
		if (x.lastIndexOf('-') == -1) {
			/*this condition checks if the last index of '-' is not available 
			 * then returns the new ComplexNumber*/
			String realSub = (trim.substring(0,indexOfPlus)).trim();
			String imagSub = trim.substring(indexOfPlus+1, iIndex).trim();
			/*this converts the substrings to doubles*/
		    double realDouble = Double.parseDouble(realSub);
			double imagDouble = Double.parseDouble(imagSub);
			MyDouble realMyDouble = new MyDouble(realDouble);
			MyDouble imagMyDouble = new MyDouble(imagDouble);
			return new ComplexNumber (realMyDouble, imagMyDouble);
			
			
		}else if(x.lastIndexOf('+')!=-1 && trim.indexOf('-')==0){
			/*this condition checks to see if there's a plus in between the real
			 * and imag value, and also a minus before the real values, then 
			 * does the statements below and returns ComplexNumber*/
			String realSub = '-'+(trim.substring(1,indexOfPlus)).trim();
			String imagSub = trim.substring(indexOfPlus+1, iIndex).trim();
			/*this converts the substrings to doubles*/
		    double realDouble = Double.parseDouble(realSub);
			double imagDouble = Double.parseDouble(imagSub);
			MyDouble realMyDouble = new MyDouble(realDouble);
			MyDouble imagMyDouble = new MyDouble(imagDouble);
			return new ComplexNumber (realMyDouble, imagMyDouble);
			
		}else if (x.lastIndexOf('-') != -1 && trim.indexOf('-')==0){
			/*this condition check to see if there's a minus between the real 
			 * and imag by using the last index of. it also checks to see if 
			 * there's a minus before the real value. */
			String realSub = '-'+trim.substring(1, indexOfMinus).trim();
			String imagSub = '-'+trim.substring(indexOfMinus+1, iIndex).trim();
			/*this converts the substrings to doubles*/
			double realDouble = Double.parseDouble(realSub);
			double imagDouble = Double.parseDouble(imagSub);
			MyDouble realMyDouble = new MyDouble(realDouble);
			MyDouble imagMyDouble = new MyDouble(imagDouble);
			return new ComplexNumber (realMyDouble, imagMyDouble);
		}else {
			/*basically the else block is meant to check if there's a minus in 
			 * between real and imag and also to ensure there's no minus before
			 * the real value.*/
			String realSub = trim.substring(0, indexOfMinus).trim();
			String imagSub = '-'+trim.substring(indexOfMinus+1, iIndex).trim();
			/*this converts the substrings to doubles*/
			double realDouble = Double.parseDouble(realSub);
			double imagDouble = Double.parseDouble(imagSub);
			MyDouble realMyDouble = new MyDouble(realDouble);
			MyDouble imagMyDouble = new MyDouble(imagDouble);
			return new ComplexNumber (realMyDouble, imagMyDouble);
		}
			
	}
}
