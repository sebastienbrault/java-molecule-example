package yose.worlds;
import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;

import yose.PowerOfTwo;

public class PowerOfTwoTest {

	@Test
	public void testThatReturnsAnInteger() {
		assertArrayEquals(new Integer[]{2}, PowerOfTwo.powerOfTwo(2));
	}
	
	@Test
	public void testThatReturnsPowerOfTwo() {
		assertArrayEquals(new Integer[]{2,2}, PowerOfTwo.powerOfTwo(4));
	}
	
	@Test
	public void testYoseTheGame() {
		assertArrayEquals(new Integer[]{2,2,2,2}, PowerOfTwo.powerOfTwo(16));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testThatNotPowerOfTwoReturnsException() {
		PowerOfTwo.powerOfTwo(7);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testThatOneReturnsException() {
		PowerOfTwo.powerOfTwo(1);
	}
	
	@Test
	public void testThatReturnsJSONFromBean() {
		PowerOfTwoBean param = new PowerOfTwoBean(16,new Integer[]{2,2,2,2});
		Gson result = PowerOfTwo.toJSON(param);
		assertTrue(result.matches("\\{.*\"number\":.*\\}"));
	}

}
