package org.utility;

import org.baseClass.BaseClass;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends BaseClass implements ITestListener{


	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		captureScreenShot(name);
	}
	

}
