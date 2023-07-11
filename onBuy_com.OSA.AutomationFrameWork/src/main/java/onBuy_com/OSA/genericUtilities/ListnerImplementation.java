package onBuy_com.OSA.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot takesscreenshot= (TakesScreenshot)BaseClass.sdriver;
		File src=takesscreenshot.getScreenshotAs(OutputType.FILE);
		LocalDateTime dateTime= LocalDateTime.now();
		String dt=dateTime.toString().replace(" ","_").replace(":", "_");
		String methodName = result.getMethod().getMethodName();
		File dst = new File("./ScreenShots/"+methodName+"_"+dt+".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
			}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	
	
}
