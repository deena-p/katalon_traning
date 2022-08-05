import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import basic.GeneralLibrary as GL
import internal.GlobalVariable
import mobilelibrary.MobileCustomKeywords
import product.ProductLibrary

import org.openqa.selenium.Keys as Keys

//login to the application
GL.startTheAppAndLoginToTheApplication(GlobalVariable.userName, GlobalVariable.password)

//List<String> products = Arrays.asList("Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket","Sauce Labs Backpack","Sauce Labs Bike Light",);
String productName = "Sauce Labs Onesie"
//String productName = "Sauce Labs Fleece Jacket"
//String productName = "Sauce Labs Bike Light"
//Sauce Labs Fleece Jacket

//add product to the cart
ProductLibrary.addProductToTheCart(productName)

//tap on ADD TO CART button
Mobile.tap(findTestObject('Object Repository/ecommercesampleapp/RecordedObjects/shoppingCard_button'), 0)


Mobile.tap(findTestObject('Object Repository/ecommercesampleapp/RecordedObjects/checkout_button'), 0)

Mobile.setText(findTestObject('Object Repository/ecommercesampleapp/RecordedObjects/firstName_input'), 
    'estat', 0)

Mobile.setText(findTestObject('Object Repository/ecommercesampleapp/RecordedObjects/lastName_input'), 
    'lastname', 0)

Mobile.setText(findTestObject('Object Repository/ecommercesampleapp/RecordedObjects/postalCode_input'), 
    '32432432', 0)

Mobile.tap(findTestObject('Object Repository/ecommercesampleapp/RecordedObjects/continue_button'), 0)

MobileCustomKeywords.swipeBottomToTop(1)

Mobile.tap(findTestObject('Object Repository/ecommercesampleapp/RecordedObjects/finish_button'), 0)

Mobile.tap(findTestObject('Object Repository/ecommercesampleapp/RecordedObjects/backHome_button'), 0)

//Logout and close the app
GL.logoutTheAppAndClose()

