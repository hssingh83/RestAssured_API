package resources;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




public class listeners implements ITestListener{ 
	
//	baseProperties bs=new baseProperties();


public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub

	
	System.out.print("\nTest Case "+ result.getName() + " Passed\n\n");
	System.out.print("=========================================\n");
	
	
}

public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	System.out.print("\nTest Case "+ result.getName() + " failed\n\n");
	System.out.print("=========================================\n");
	
	
	
/*  try {
	bs.getScreenshot(result.getName());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}*/
	
	
}

public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
	System.out.print("\n "+ context.getName() + " Started\n");
	System.out.print("=========================================\n");
}

public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	System.out.print("\n "+ context.getName() + " Completed\n");
	System.out.print("=========================================\n");
	
	
}
}
