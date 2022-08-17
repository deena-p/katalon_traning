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

import basic.GeneralAppLibrary as GAL
import product.ProductLibrary as PL
import internal.GlobalVariable
import mobilelibrary.MobileCustomKeywords
import product.ProductLibrary

import org.openqa.selenium.Keys as Keys

List<String> products = Arrays.asList("Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket","Sauce Labs Backpack","Sauce Labs Bike Light",);
//String productName = "Sauce Labs Onesie"
//String productName = "Sauce Labs Fleece Jacket"
//String productName = "Sauce Labs Bike Light"
//Sauce Labs Fleece Jacket

//login to the application
GAL.startAndLoginToApp(GlobalVariable.userName, GlobalVariable.password)
//add product to the cart
PL.addProductsToTheCart(products)
//tap on ADD TO CART button
GAL.tapOnShoppingCartButton()
//tap on the checkout button
GAL.tapOnCheckoutButton()
//Fill checkout information
GAL.fillCheckoutInformationAndContinue("Sachin","Tendulkar","123456")
//Tap on finish button
GAL.tapOnFinishButton()
//Verify order confirmation
def thankYouText = Mobile.getText(findTestObject('swag_labs/CheckoutCompletePage/thankYou_text'),0)
GAL.verifyOrderConfirmation('THANK YOU FOR YOU ORDER')
Mobile.verifyEqual(thankYouText, "THANK YOU FOR YOU ORDER")
//Tap on back home button
GAL.tapOnBackHomeButton()
//Logout and close the app
GAL.logoutTheAppAndClose()

