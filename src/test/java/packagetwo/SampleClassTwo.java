package packagetwo;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class SampleClassTwo {

	@Test	@Ignore
	public void TestCaseFour() {
		// TODO Auto-generated method stub
		System.out.println("Test Case Four");

	}
	@Test
	public void TestCaseFive() {
		// TODO Auto-generated method stub
		int x = 0;
		System.out.println("Test Case Five");
		Assert.assertEquals("Verify username ", "Naveenraj", x);

	}
	
	@Test
	public void TestCaseSix() {
		// TODO Auto-generated method stub
		System.out.println("Test Case Six");

	}
	
	
	
	
}
