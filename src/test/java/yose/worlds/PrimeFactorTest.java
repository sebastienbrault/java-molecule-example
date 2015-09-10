package yose.worlds;

import static com.vtence.molecule.testing.http.HttpResponseAssert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.vtence.molecule.testing.http.HttpRequest;
import com.vtence.molecule.testing.http.HttpResponse;

import yose.PowerOfTwoBean;
import yose.PrimeFactor;
import yose.YoseDriver;

public class PrimeFactorTest {

	PrimeFactor pf = new PrimeFactor();
	YoseDriver yose = new YoseDriver(9999);

	HttpRequest request = new HttpRequest(9999);
	HttpResponse response;

	@Before
	public void startGame() throws Exception {
		yose.start();
	}

	@After
	public void stopGame() throws Exception {
		yose.stop();
	}

	@Test
	public void webServicePrimeFactorReturnsJSON() throws IOException {
		response = request.get("/primeFactors?number=16");
		assertThat(response).isOK().hasContentType("application/json")
				.hasBodyText("{\"number\":16,\"decomposition\":[2,2,2,2]}");
	}

	@Test
	public void webServicePrimeFactorReturnsErrorWhenStringJSON() throws IOException {
		response = request.get("/primeFactors?number=hello");
		assertThat(response).isOK().hasContentType("application/json")
				.hasBodyText("{\"number\":\"hello\",\"error\":\"not a number\"}");
	}

	@Test
	public void testThatReturnsJSONFromBean() {
		PowerOfTwoBean param = new PowerOfTwoBean(16, new Integer[] { 2, 2, 2, 2 });
		String result = pf.toJSON(param);
		assertTrue(result.matches("\\{.*\"number\":.*,\"decomposition\":.*\\}"));
	}

	@Test
	public void testThatReturnsJSONFromBeanError() {
		String result = pf.primeFactorError("hello");
		assertTrue(result.equals("{\"number\":\"hello\",\"error\":\"not a number\"}"));
	}

	@Test
	public void testThatReturnsJSONFromInteger() {
		String result = pf.primeFactorController(16);
		assertTrue(result.matches("\\{.*\"number\":16,\"decomposition\":\\[2,2,2,2\\]\\}"));
	}
}
