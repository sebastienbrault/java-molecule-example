package yose.worlds;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import yose.PowerOfTwo;
import yose.PowerOfTwoBean;

public class PowerOfTwoTest {

	private PowerOfTwo pot = new PowerOfTwo();;

	// @BeforeClass
	// public static void setUpBeforeClass() throws Exception {
	// pot = new PowerOfTwo();
	// }

	@Test
	public void testThatReturnsAnInteger() {
		assertArrayEquals(new Integer[] { 2 }, pot.powerOfTwo(2));
	}

	@Test
	public void testThatReturnsPowerOfTwo() {
		assertArrayEquals(new Integer[] { 2, 2 }, pot.powerOfTwo(4));
	}

	@Test
	public void testYoseTheGame() {
		assertArrayEquals(new Integer[] { 2, 2, 2, 2 }, pot.powerOfTwo(16));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatNotPowerOfTwoReturnsException() {
		pot.powerOfTwo(7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThatOneReturnsException() {
		pot.powerOfTwo(1);
	}

	@Test
	public void testThatReturnsJSONFromBean() {
		PowerOfTwoBean param = new PowerOfTwoBean(16, new Integer[] { 2, 2, 2, 2 });
		String result = pot.toJSON(param);
		assertTrue(result.matches("\\{.*\"number\":.*\\}"));
	}

	@Test
	public void testThatReturnsJSONFromInteger() {
		String result = pot.powerOfTwoController(16);
		assertTrue(result.matches("\\{.*\"number\":16,\"decomposition\":\\[2,2,2,2\\]\\}"));
	}

}
