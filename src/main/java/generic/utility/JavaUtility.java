package generic.utility;

import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(1000);
	}
}
