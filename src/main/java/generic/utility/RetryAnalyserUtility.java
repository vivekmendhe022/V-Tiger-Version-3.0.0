package generic.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class contains retry execution of failed test scripts, who actully
 * passed after couple of runs.
 */
public class RetryAnalyserUtility implements IRetryAnalyzer {

	private int count = 0;
	private static final int RETRY_LIMIT = 5;

	@Override
	public boolean retry(ITestResult result) {
		if (RETRY_LIMIT > count) {
			count++;
			return true;
		}
		return false;
	}

}
