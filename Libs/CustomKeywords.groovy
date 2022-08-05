
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import java.util.List

import com.kms.katalon.core.testobject.TestObject

import com.applitools.eyes.selenium.Eyes

import org.openqa.selenium.WebElement

import com.applitools.eyes.RectangleSize


 /**
	 * Swipe mobile app <br/>
	 * Example values: <br/>
	 * Top to bottom: 0.3 to 0.7 <br/>
	 * Bottom to top: 0.7 to 0.3 <br/>
	 * @param startPercentage start percentage of swipe start point
	 * @param endPercentage end percentage of swipe end point
	 */ 
def static "mobilelibrary.MobileCustomKeywords.swipeMobileAppInVericalWay"(
    	double startPercentage	
     , 	double endPercentage	) {
    (new mobilelibrary.MobileCustomKeywords()).swipeMobileAppInVericalWay(
        	startPercentage
         , 	endPercentage)
}


def static "mobilelibrary.MobileCustomKeywords.swipeBottomToTop"(
    	int noOfTimes	) {
    (new mobilelibrary.MobileCustomKeywords()).swipeBottomToTop(
        	noOfTimes)
}


def static "mobilelibrary.MobileCustomKeywords.swipeTopToBottom"(
    	int noOfTimes	) {
    (new mobilelibrary.MobileCustomKeywords()).swipeTopToBottom(
        	noOfTimes)
}


def static "basic.GeneralLibrary.loginToTheApplication"(
    	String userName	
     , 	String password	) {
    (new basic.GeneralLibrary()).loginToTheApplication(
        	userName
         , 	password)
}


def static "basic.GeneralLibrary.startTheAppAndLoginToTheApplication"(
    	String userName	
     , 	String password	) {
    (new basic.GeneralLibrary()).startTheAppAndLoginToTheApplication(
        	userName
         , 	password)
}


def static "basic.GeneralLibrary.logoutTheApp"() {
    (new basic.GeneralLibrary()).logoutTheApp()
}


def static "basic.GeneralLibrary.logoutTheAppAndClose"() {
    (new basic.GeneralLibrary()).logoutTheAppAndClose()
}


def static "product.ProductLibrary.addProductToTheCart"(
    	String productName	) {
    (new product.ProductLibrary()).addProductToTheCart(
        	productName)
}


def static "product.ProductLibrary.addProductsToTheCart"(
    	java.util.List<String> products	) {
    (new product.ProductLibrary()).addProductsToTheCart(
        	products)
}


def static "product.ProductLibrary.selectProduct"(
    	String productName	) {
    (new product.ProductLibrary()).selectProduct(
        	productName)
}


def static "product.ProductLibrary.getProductDetail"(
    	String productName	) {
    (new product.ProductLibrary()).getProductDetail(
        	productName)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkWindow"(
    	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkWindow(
        	testName)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkTestObject"(
    	TestObject testObject	
     , 	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkTestObject(
        	testObject
         , 	testName)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkElement"(
    	Eyes eyes	
     , 	WebElement element	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkElement(
        	eyes
         , 	element)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpenWithBaseline"(
    	String baselineName	
     , 	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpenWithBaseline(
        	baselineName
         , 	testName
         , 	viewportSize)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpen"(
    	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpen(
        	testName
         , 	viewportSize)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesClose"(
    	Eyes eyes	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesClose(
        	eyes)
}


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesInit"() {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesInit()
}
