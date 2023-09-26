package generic.utility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * This method will generate random numbers form 1 to 1000.
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(1000);
	}

	/**
	 * This method will give current date in format.
	 * @return
	 */
	public String getDateInFormate() {
		Date d = new Date();
		String[] s = d.toString().split(" ");
		String month = s[1];
		String date = s[2];
		String year = s[5];
		String time = s[3].replace(':', '-');
		return date + " " + month + " " + year + " " + time;
	}
	

	public static void main(String[] args) {
		JavaUtility j = new JavaUtility();
		j.getDateInFormate();
	}
}
