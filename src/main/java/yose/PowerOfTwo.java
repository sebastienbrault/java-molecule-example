package yose;

import java.util.ArrayList;

import com.google.gson.Gson;

import yose.worlds.PowerOfTwoBean;

public class PowerOfTwo {
	private final Gson gson;

	public PowerOfTwo() {
		super();
		this.gson = new Gson();
	}

	public Integer[] powerOfTwo(int i) {
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

	public String toJSON(PowerOfTwoBean param) {
		return gson.toJson(param);
	}

	public String powerOfTwoController(int i) {
		Integer[] result = powerOfTwo(i);
		PowerOfTwoBean potb = new PowerOfTwoBean(i, result);
		return toJSON(potb);
	}

}
