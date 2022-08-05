package basic

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class GeneralLibrary {

	@Keyword
	public static void loginToTheApplication(String userName, String password) {
		//enter userName
		Mobile.setText(findTestObject('Object Repository/ecommercesampleapp/LoginPage/userName_input'), userName, 0)
		//enter password
		Mobile.setText(findTestObject('Object Repository/ecommercesampleapp/LoginPage/password_input'), password, 0)
		//clicking the login button
		Mobile.tap(findTestObject('Object Repository/ecommercesampleapp/LoginPage/login_button'), 0)
		Mobile.verifyElementExist(findTestObject('Object Repository/ecommercesampleapp/ProductPage/menu_button'), 2)
		//Verification
		if(Mobile.waitForElementPresent(findTestObject('Object Repository/ecommercesampleapp/ProductPage/menu_button'), 2)) {
			KeywordUtil.markPassed("Login to the application is successful for the user" + userName)
		} else {
			KeywordUtil.markFailedAndStop("Login to the application is failed for the user " + userName)
		}
	}

	@Keyword
	public static void startTheAppAndLoginToTheApplication(String userName, String password) {
		//start the application
		Mobile.startApplication('C:\\Deena\\Automation\\KatalonTraining\\Android\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk', true)
		loginToTheApplication(userName, password)
	}

	@Keyword
	public static void logoutTheApp() {
		//click on top right menu
		Mobile.tap(findTestObject('Object Repository/ecommercesampleapp/ProductPage/menu_button'), 0)
		//click on logout link
		Mobile.tap(findTestObject('Object Repository/ecommercesampleapp/ProductPage/logout_button'), 0)
		//Verify whether logout the app navigate back to sign in page
		if(Mobile.waitForElementPresent(findTestObject('Object Repository/ecommercesampleapp/LoginPage/userName_input'), 2)) {
			KeywordUtil.markPassed("Login to the application is successful for the user")
		} else {
			KeywordUtil.markFailedAndStop("Login to the application is failed for the user ")
		}
	}

	@Keyword
	public static void logoutTheAppAndClose() {
		logoutTheApp()
		//close the application
		Mobile.closeApplication()
	}
}
