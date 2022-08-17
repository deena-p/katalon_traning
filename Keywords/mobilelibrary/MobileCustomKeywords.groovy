package mobilelibrary

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class MobileCustomKeywords {

	private static String previousPageSource = ""

	/**
	 * Swipe mobile app <br/>
	 * Example values: <br/>
	 * Top to bottom: 0.3 to 0.7 <br/>
	 * Bottom to top: 0.7 to 0.3 <br/>
	 * @param startPercentage start percentage of swipe start point
	 * @param endPercentage end percentage of swipe end point
	 */
	@Keyword
	public static void swipeMobileAppInVericalWay(double startPercentage, double endPercentage) {
		int deviceHeight = Mobile.getDeviceHeight()
		int deviceWidth = Mobile.getDeviceWidth()
		int startX = deviceWidth/2
		int endX = startX
		int startY = deviceHeight * startPercentage
		int endY = deviceHeight * endPercentage
		Mobile.swipe(startX, startY, endX, endY)
	}

	@Keyword
	public static void swipeBottomToTop(int noOfTimes) {
		for (int i=0; i<noOfTimes; i++) {
			swipeMobileAppInVericalWay(0.7,0.3)
		}
	}

	@Keyword
	public static void swipeTopToBottom(int noOfTimes) {
		for (int i=0; i<noOfTimes; i++) {
			swipeMobileAppInVericalWay(0.3,0.7)
		}
	}
	
	@Keyword
	public static void scrollAndTap(TestObject element) {
		scrollToTheElement(element)
		Mobile.tap(element, 0)
	}

	@Keyword
	public static void scrollToTheElement(TestObject element) {
		//if element is not available in the page view
		if(!Mobile.waitForElementPresent(element, 1)) {
			//make sure you are in top of the page
			swipeToTheTopOfThePage()
			//swipe to the element
			while(!Mobile.waitForElementPresent(element, 1)) {
				if(isEndOfPage(MobileDriverFactory.getDriver().getPageSource())) {
					KeywordUtil.markFailedAndStop("Unable to find the given element")
				} else {
					swipeBottomToTop(1)
				}
			}
		}
	}

	public static void swipeToTheTopOfThePage() {
		while(!isEndOfPage(MobileDriverFactory.getDriver().getPageSource())) {
			swipeTopToBottom(1)
		}
	}

	public static void swipeToTheBottomOfThePage() {
		while(!isEndOfPage(MobileDriverFactory.getDriver().getPageSource())) {
			swipeBottomToTop(1)
		}
	}

	public static boolean isEndOfPage(String currentPageSource) {
		if(currentPageSource.equalsIgnoreCase(previousPageSource)) {
			previousPageSource = ""
			return true
		}
		previousPageSource = currentPageSource
		return false
	}
}
