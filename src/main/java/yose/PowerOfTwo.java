package yose;
import java.util.ArrayList;

public class PowerOfTwo {

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
