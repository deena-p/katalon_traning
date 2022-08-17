
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import java.util.List

import basic.SortBy

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


def static "mobilelibrary.MobileCustomKeywords.scrollAndTap"(
    	TestObject element	) {
    (new mobilelibrary.MobileCustomKeywords()).scrollAndTap(
        	element)
}


def static "mobilelibrary.MobileCustomKeywords.scrollToTheElement"(
    	TestObject element	) {
    (new mobilelibrary.MobileCustomKeywords()).scrollToTheElement(
        	element)
}


def static "basic.GeneralAppLibrary.loginToTheApplication"(
    	String userName	
     , 	String password	) {
    (new basic.GeneralAppLibrary()).loginToTheApplication(
        	userName
         , 	password)
}


def static "basic.GeneralAppLibrary.startAndLoginToApp"(
    	String userName	
     , 	String password	) {
    (new basic.GeneralAppLibrary()).startAndLoginToApp(
        	userName
         , 	password)
}


def static "basic.GeneralAppLibrary.logoutTheApp"() {
    (new basic.GeneralAppLibrary()).logoutTheApp()
}


def static "basic.GeneralAppLibrary.logoutTheAppAndClose"() {
    (new basic.GeneralAppLibrary()).logoutTheAppAndClose()
}


def static "basic.GeneralAppLibrary.tapOnShoppingCartButton"() {
    (new basic.GeneralAppLibrary()).tapOnShoppingCartButton()
}


def static "basic.GeneralAppLibrary.tapOnCheckoutButton"() {
    (new basic.GeneralAppLibrary()).tapOnCheckoutButton()
}


def static "basic.GeneralAppLibrary.fillCheckoutInformationAndContinue"(
    	String firstName	
     , 	String lastName	
     , 	String zipCode	) {
    (new basic.GeneralAppLibrary()).fillCheckoutInformationAndContinue(
        	firstName
         , 	lastName
         , 	zipCode)
}


def static "basic.GeneralAppLibrary.tapOnFinishButton"() {
    (new basic.GeneralAppLibrary()).tapOnFinishButton()
}


def static "basic.GeneralAppLibrary.verifyOrderConfirmation"(
    	String orderConfirmationMessage	) {
    (new basic.GeneralAppLibrary()).verifyOrderConfirmation(
        	orderConfirmationMessage)
}


def static "basic.GeneralAppLibrary.tapOnBackHomeButton"() {
    (new basic.GeneralAppLibrary()).tapOnBackHomeButton()
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


def static "product.ProductLibrary.clickSortButton"() {
    (new product.ProductLibrary()).clickSortButton()
}


def static "product.ProductLibrary.clickOnSortItemsBy"(
    	String sortingType	) {
    (new product.ProductLibrary()).clickOnSortItemsBy(
        	sortingType)
}


def static "product.ProductLibrary.clickOnSortItemsBy"(
    	SortBy sortBy	) {
    (new product.ProductLibrary()).clickOnSortItemsBy(
        	sortBy)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkElement"(
    	Eyes eyes	
     , 	WebElement element	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkElement(
        	eyes
         , 	element)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkTestObject"(
    	TestObject testObject	
     , 	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkTestObject(
        	testObject
         , 	testName)
}


def static "com.kms.katalon.keyword.applitools.BasicKeywords.checkWindow"(
    	String testName	) {
    (new com.kms.katalon.keyword.applitools.BasicKeywords()).checkWindow(
        	testName)
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


def static "com.kms.katalon.keyword.applitools.EyesKeywords.eyesOpenWithBaseline"(
    	String baselineName	
     , 	String testName	
     , 	RectangleSize viewportSize	) {
    (new com.kms.katalon.keyword.applitools.EyesKeywords()).eyesOpenWithBaseline(
        	baselineName
         , 	testName
         , 	viewportSize)
}
