package yose;
import static com.vtence.molecule.http.MimeTypes.JSON;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;

import yose.Ping.Pong;

public class PowerOfTwo {
	
	

    public PowerOfTwo(Gson gson) {

    }

    public void initPage(Request request, Response response) throws Exception {
        List<String> numbers = request.parameters("number");
        if (numbers == null || numbers.size() == 0) {
            response.statusCode(400);
            return;
        }
        int number = Integer.parseInt( numbers.get(0));
        return;
    }


	public static Integer[] powerOfTwo(int i) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int res = i;
		do {
			if (res % 2 != 0) {
				throw new IllegalArgumentException("Not a Power Of Two"); 
			}
			res = res / 2;
			result.add(2);
		} while (res != 1);
		return result.toArray(new Integer[result.size()]);
	}

	public static String toJSON() {
		// TODO Auto-generated method stub
		return "{\"number\":}";
	}

}
