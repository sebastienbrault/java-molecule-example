package yose;

import static com.vtence.molecule.http.MimeTypes.JSON;

import java.util.List;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;

public class PrimeFactor {
	private final Gson gson;

	public PrimeFactor() {
		super();
		this.gson = new Gson();
	}

	public void initPage(Request request, Response response) throws Exception {
		List<String> numbers = request.parameters("number");
		if (numbers == null || numbers.size() == 0) {
			response.statusCode(400);
			return;
		}
		try {
			int number = Integer.parseInt(numbers.get(0));
			response.contentType(JSON).body(primeFactorController(number));
		} catch (NumberFormatException e) {
			response.contentType(JSON).body(primeFactorError(numbers.get(0)));
		}

	}

	public String primeFactorController(int i) {
		Integer[] result = PowerOfTwo.powerOfTwo(i);
		PowerOfTwoBean potb = new PowerOfTwoBean(i, result);
		return toJSON(potb);
	}

	public String toJSON(Object param) {
		return gson.toJson(param);
	}

	public String primeFactorError(String number) {
		PrimeFactorErrorBean pfeb = new PrimeFactorErrorBean(number, "not a number");
		return toJSON(pfeb);
	}
}
