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

WebUI.callTestCase(findTestCase('Shopstar/Hotel/Unitary test/Select Hotel and rooms'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_name_1'), 'Armando')

WebUI.setText(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_LastName_1'), 'Chanto')

WebUI.setText(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_name_2'), 'Juan')

WebUI.setText(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_LastName_2'), 'Chanto')

WebUI.click(findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/button_Reservar'))

WebUI.click(findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_Revisa y paga_PrivateSwitchBase-input_e4d2f2'))

WebUI.click(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_SeleccionarTarjeta'))

WebUI.waitForElementPresent(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_cvv'), 
    5)

WebUI.sendKeys(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_cvv'), Keys.chord(
        '123'))

WebUI.scrollToElement(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_Revisa y paga_PrivateSwitchBase-input_e4d2f2'), 
    0)

