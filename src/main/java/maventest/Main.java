package maventest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.TestNG;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNG test = new TestNG();
        List<String> suites = new ArrayList<String>();
        suites.add("testng.xml");
        test.setTestSuites(suites);
        test.run();

	}
	

}
