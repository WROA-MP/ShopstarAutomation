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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Shopstar Viajes/Hotel_Recommendations/Home_Page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.findWebElement(findTestObject('Shopstar/Page_Shopstar_Viajes/Page_Hotel_Recommendations/h6_Casa Andina Premium Piura'))

WebUI.scrollToElement(findTestObject('Shopstar/Page_Shopstar_Viajes/Page_Hotel_Recommendations/h6_Casa Andina Premium Piura'), 
    0)

WebUI.click(findTestObject('Shopstar/Page_Shopstar_Viajes/Page_Hotel_Recommendations/h6_Casa Andina Premium Piura'))

WebUI.click(findTestObject('Object Repository/Shopstar/Page_Shopstar_Viajes/Page_Hotel_Recommendations/button_Volver (1)'))

