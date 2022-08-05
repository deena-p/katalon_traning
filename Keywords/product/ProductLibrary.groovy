package product

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.MobileTestObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import data.ProductData
import internal.GlobalVariable
import mobilelibrary.MobileCustomKeywords

public class ProductLibrary {

	private static String productLocator = "//*[@text='%s']"
	private static String productAddToCardXpath = "//*[@text='%s']/following-sibling::*/*[@text='ADD TO CART']"
	private static String previousPageSource = ""

	@Keyword
	public static void addProductToTheCart(String productName) {
		String productXpath = String.format(productAddToCardXpath, productName)
		println productXpath
		//MobileTestObject productAddToCartObject = new MobileTestObject().addProperty("xpath", ConditionType.EQUALS, productXpath)
		TestObject productObject = new TestObject().addProperty("xpath", ConditionType.EQUALS, productXpath)
		while(!Mobile.waitForElementPresent(productObject, 1)) {
			//if it is end of mobile page, it has to stop swipe
			if(isEndOfTheMobileAppPage(MobileDriverFactory.getDriver().getPageSource())) {
				KeywordUtil.markFailedAndStop("Unable to find the product " + productName)
			} else {
				MobileCustomKeywords.swipeBottomToTop(1)
			}
		}
		Mobile.tap(productObject,0)
		KeywordUtil.markPassed("Update the card for the product " + productName)
		//once it reached end of the page - scroll back to the first page, so that next product will work fine
		while(!isEndOfTheMobileAppPage(MobileDriverFactory.getDriver().getPageSource())) {
			MobileCustomKeywords.swipeTopToBottom(1)
		}
	}

	public static boolean isEndOfTheMobileAppPage(String currentPageSource) {
		if(currentPageSource.equalsIgnoreCase(previousPageSource)) {
			previousPageSource = ""
			return true
		}
		previousPageSource = currentPageSource
		return false
	}

	@Keyword
	public static void addProductsToTheCart(List<String> products) {
		products.forEach{product -> addProductToTheCart(product)}
	}

	@Keyword
	public static void selectProduct(String productName) {
		TestObject productObject = new TestObject().addProperty("xpath", ConditionType.EQUALS, String.format(productLocator, productName))
		while(!Mobile.waitForElementPresent(productObject, 1)) {
			//if it is end of mobile page, it has to stop swipe
			if(isEndOfTheMobileAppPage(MobileDriverFactory.getDriver().getPageSource())) {
				KeywordUtil.markFailedAndStop("Unable to find the product " + productName)
			} else {
				MobileCustomKeywords.swipeBottomToTop(1)
			}
		}
		Mobile.tap(productObject)
		KeywordUtil.markFailedAndStop("Successfully selected the product " + productName)
	}

	@Keyword
	public static ProductData getProductDetail(String productName) {
		MobileCustomKeywords.swipeMobileAppInVericalWay(0.6, 0.5)
		String productNameLocator = "//android.widget.TextView[@text = '%s']"
		String productDescLocator = "//android.widget.TextView[@text = '%s']/following-sibling::android.widget.TextView"
		String productPriceLocator = "//android.widget.TextView[@text = '%s']/../following-sibling::android.widget.TextView"
		TestObject productNameObject = new TestObject().addProperty("xpath", ConditionType.EQUALS, String.format(productNameLocator, productName))
		TestObject productDescObject = new TestObject().addProperty("xpath", ConditionType.EQUALS, String.format(productDescLocator, productName))
		TestObject productPriceObject = new TestObject().addProperty("xpath", ConditionType.EQUALS, String.format(productPriceLocator, productName))
		ProductData productData = new ProductData()
		productData.setProductName(Mobile.getText(productNameObject, 0))
		productData.setProductDescription(Mobile.getText(productNameObject, 0))
		productData.setProductPrice(Double.parseDouble(Mobile.getText(productNameObject, 0).replace('$', '')))
		return productData
	}
}
