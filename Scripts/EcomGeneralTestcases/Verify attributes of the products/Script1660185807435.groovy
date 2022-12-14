import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.stream.Collectors

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import mobilelibrary.MobileCustomKeywords
import product.ProductLibrary as PL

import org.openqa.selenium.Keys as Keys
import basic.GeneralLibrary as GL
import data.ProductData
import product.ProductLibrary as PL

//login to the application
GL.startAndLoginToApp(GlobalVariable.userName, GlobalVariable.password)
//Get the test data
List<ProductData> productList;
TestData productTestData = TestDataFactory.findTestData(GlobalVariable.productTestDataFile)
productList = productTestData.getAllData().stream().map{product -> new ProductData(product[0],product[1], Double.parseDouble(product[2]))}.collect(Collectors.toList())
//Iterate each product for the verification
productList.forEach { expectedProduct -> 
	//selecting the product
	PL.selectProduct(expectedProduct.productName)
	//get the product details
	ProductData actualProduct = PL.getProductDetail(expectedProduct.getProductName())
	if(actualProduct == expectedProduct) {
		KeywordUtil.markPassed("Successfully verified the details of the product " + expectedProduct.getProductName())
		//Mobile.takeScreenshot()
	} else {
		KeywordUtil.markFailedAndStop("Verification failed for the product " + expectedProduct.getProductName())
	}
	//Go back to the first page
	while(!MobileCustomKeywords.isEndOfPage(MobileDriverFactory.getDriver().getPageSource())) {
		MobileCustomKeywords.swipeTopToBottom(1)
	}
}
//Logout and close the app
GL.logoutTheAppAndClose()