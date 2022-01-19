package userDefinedLibraries;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class FailReport {

	public ExtentReports report;
	public static String path;

	// To print log message for failure
	public static void reportFail(ExtentTest logger,String reportString, WebDriver driver) {
		logger.log(Status.FAIL, reportString);
		path = ScreenShot.screenShotTC(driver);
		try {
			logger.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
