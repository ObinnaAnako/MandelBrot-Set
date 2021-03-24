import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testBasicConstructorsAndGetters() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);
		
		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 && x.getImag().compareTo(b) == 0);
		
		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0 && z.getImag().compareTo(new MyDouble(0)) == 0);
	}
	
	@Test
	public void testCopyConstructor() {
		
		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		
		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);     // Check to be sure they are not aliased!
		assertTrue(y.getReal().compareTo(a) == 0 && y.getImag().compareTo(b) == 0);
	}
	@Test
	public void testAdd() {
		MyDouble a = new MyDouble(5.7), b = new MyDouble(3.2), 
				c = new MyDouble (3.0), d = new MyDouble(-4.0);
		ComplexNumber x  = new ComplexNumber (a,b);
		ComplexNumber y  = new ComplexNumber (c,d);
		ComplexNumber z  = new ComplexNumber (a.add(c),b.add(d));
		
		assertTrue(a.add(c).equals(new MyDouble(8.7)));
		assertTrue(b.add(d).equals(new MyDouble(-0.8)));
		assertTrue(x.add(y).equals(z));
		
	}
	@Test
	public void testSubtract() {
		MyDouble a = new MyDouble(5.7), b = new MyDouble(3.2), 
				c = new MyDouble (3.0), d = new MyDouble(-4.0);
		ComplexNumber x  = new ComplexNumber (a,b);
		ComplexNumber y  = new ComplexNumber (c,d);
		ComplexNumber z  = new ComplexNumber (a.subtract(c),b.subtract(d));
		

		assertTrue(a.subtract(c).equals(new MyDouble(2.7)));
		assertTrue(b.subtract(d).equals(new MyDouble(7.2)));
		assertTrue(x.subtract(y).equals(z));
	}
	@Test
	public void testMultiply() {
		MyDouble aReal = new MyDouble(-2.0), aImag = new MyDouble(5.0), 
				bReal = new MyDouble (9.0), bImag = new MyDouble(-4.0),
				cReal = new MyDouble(4.0), cImag = new MyDouble(2.0),
				dReal = new MyDouble(3.0), dImag = new MyDouble(2.0);
		
		ComplexNumber x  = new ComplexNumber (aReal,aImag);
		ComplexNumber y  = new ComplexNumber (bReal,bImag);
		ComplexNumber z  = new ComplexNumber (cReal,cImag);
		ComplexNumber v  = new ComplexNumber (dReal,dImag);
		
		assertTrue(x.multiply(y).equals(new ComplexNumber(new MyDouble (2), new MyDouble (53))));
		assertTrue(z.multiply(v).equals(new ComplexNumber(new MyDouble (8), new MyDouble (14))));
		
		//real multiplication of x and y
		
	}
	@Test
	public void testDivide() {
		MyDouble aReal = new MyDouble(16.0), aImag = new MyDouble(-2.0), 
				bReal = new MyDouble (3.0), bImag = new MyDouble(-2.0),
				cReal = new MyDouble(-8.0), cImag = new MyDouble(27.0),
				dReal = new MyDouble(2.0), dImag = new MyDouble(3.0);
		
		ComplexNumber x  = new ComplexNumber (aReal,aImag);
		ComplexNumber y  = new ComplexNumber (bReal,bImag);
		ComplexNumber z  = new ComplexNumber (cReal,cImag);
		ComplexNumber v  = new ComplexNumber (dReal,dImag);
		
		assertTrue(x.divide(y).equals(new ComplexNumber(new MyDouble (4), new MyDouble (2))));
		assertTrue(z.divide(v).equals(new ComplexNumber(new MyDouble (5), new MyDouble (6))));
	}
	@Test
	public void testEquals() {
		MyDouble aReal = new MyDouble(16.0), aImag = new MyDouble(-2.0), 
				bReal = new MyDouble (16.0), bImag = new MyDouble(-2.0),
				cReal = new MyDouble(-8.0), cImag = new MyDouble(27.0),
				dReal = new MyDouble(2.0), dImag = new MyDouble(3.0);
		
		ComplexNumber x  = new ComplexNumber (aReal,aImag);
		ComplexNumber y  = new ComplexNumber (bReal,bImag);
		ComplexNumber z  = new ComplexNumber (cReal,cImag);
		ComplexNumber v  = new ComplexNumber (dReal,dImag);
		
		assertTrue(x.equals(y)==true);
		assertTrue(z.equals(v)==false);
	}
	@Test
	public void testcompareTo() {
		MyDouble aReal = new MyDouble(3.0), aImag = new MyDouble(4.0), 
				bReal = new MyDouble (5.0), bImag = new MyDouble(-12.0),
				cReal = new MyDouble(3.0), cImag = new MyDouble(4.0);
		
		ComplexNumber x  = new ComplexNumber (aReal,aImag); MyDouble normx = new MyDouble(5);
		ComplexNumber y  = new ComplexNumber (bReal,bImag); MyDouble normy = new MyDouble(13);
		ComplexNumber z  = new ComplexNumber (cReal,cImag); MyDouble normz = new MyDouble(5);
		
		assertTrue(x.compareTo(y)==-1);
		assertTrue(y.compareTo(x)==1);
		assertTrue(x.compareTo(z)==0);
	}
	@Test
	public void testtoString() {
		MyDouble aReal = new MyDouble(16), aImag = new MyDouble(-2), 
				bReal = new MyDouble (-16), bImag = new MyDouble(-4),
				cReal = new MyDouble(-8), cImag = new MyDouble(27),
				dReal = new MyDouble(2), dImag = new MyDouble(3);
		
		ComplexNumber x  = new ComplexNumber (aReal,aImag);
		ComplexNumber y  = new ComplexNumber (bReal,bImag);
		ComplexNumber z  = new ComplexNumber (cReal,cImag);
		ComplexNumber v  = new ComplexNumber (dReal,dImag);
		assertTrue((x.toString()).equals("16.0-2.0i"));
		assertTrue((y.toString()).equals("-16.0-4.0i"));
		assertTrue((z.toString()).equals("-8.0+27.0i"));
		assertTrue((v.toString()).equals("2.0+3.0i"));
	}
	@Test
	public void testnorm() {
		MyDouble aReal = new MyDouble(3.0), aImag = new MyDouble(4.0), 
				bReal = new MyDouble (5.0), bImag = new MyDouble(-12.0),
				cReal = new MyDouble(3.0), cImag = new MyDouble(4.0);
		
		ComplexNumber x  = new ComplexNumber (aReal,aImag); 
		MyDouble normx = new MyDouble(5);
		ComplexNumber y  = new ComplexNumber (bReal,bImag); 
		MyDouble normy = new MyDouble(13);
		ComplexNumber z  = new ComplexNumber (cReal,cImag); 
		MyDouble normz = new MyDouble(5);
		
		assertTrue(ComplexNumber.norm(x).equals(normx));
		assertTrue(ComplexNumber.norm(y).equals(normy));
		assertTrue(ComplexNumber.norm(z).equals(normz));
	}
	
	
	@Test
	public void testParse() {
		String x  = "5.7   +       10  i";
		String y  = "-   5.7  +  10  i";
		String z  = "-   5.7 -  10  i";
		String h = "5.7  -  10i";
		MyDouble a = new MyDouble(5.7), b = new MyDouble(10),
				c = new MyDouble (-5.7), d = new MyDouble (-10);
		ComplexNumber e = new ComplexNumber (a,b);
		ComplexNumber f = new ComplexNumber (a,d);
		ComplexNumber g = new ComplexNumber (c,b);
		ComplexNumber i = new ComplexNumber (c,d);
			
		assertTrue(ComplexNumber.parseComplexNumber(y).equals(g));
		assertTrue(ComplexNumber.parseComplexNumber(x).equals(e));
		assertTrue(ComplexNumber.parseComplexNumber(z).equals(i));
		assertTrue(ComplexNumber.parseComplexNumber(h).equals(f));
	}
	
	
}
