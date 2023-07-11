package onBuy_com.OSA.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer{

	int count=0;
	int retry=2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<retry)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
