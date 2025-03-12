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
import groovy.time.TimeCategory as TimeCategory
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import java.util.Calendar as Calendar
import utils.DateUtils as DateUtils

// Obtener la fecha n días en el futuro
WebUI.callTestCase(findTestCase('Shopstar/Login/Login User'), [:], FailureHandling.STOP_ON_FAILURE)

def futureNDate = DateUtils.getFutureDate(4)

println('Future date (N days): ' + futureNDate)

// Obtener la fecha z días en el futuro
def futureZDate = DateUtils.getFutureDate(6)

println('Future date (Z days): ' + futureZDate)

WebUI.click(findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/div_Alojamientos'))

WebUI.click(findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/div_1 Habitacin'))

WebUI.click(findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/button_Aadir habitacin'))

WebUI.click(findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/button_Listo'))

WebUI.setText(findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/input_Autos_hotels-destination-autocomplete'), 
    'san jose')

WebUI.click(findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/p_San Jos, Provincia de San Jos, Costa Rica'))

WebUI.click(findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/input_Autos_outlined-read-only-input'), 
    FailureHandling.STOP_ON_FAILURE)

// Localizar los campos de entrada donde se deben ingresar las fechas
TestObject dateFieldStart = findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/input_do_w-full')

TestObject dateFieldEnd = findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/input_do_w-full - 2nd')

// Hacer clic y luego establecer la fecha N días en el futuro
WebUI.click(dateFieldStart)

WebUI.setText(dateFieldStart, futureNDate)

// Hacer clic y luego establecer la fecha Z días en el futuro
WebUI.click(dateFieldEnd)

WebUI.setText(dateFieldEnd, futureZDate)

WebUI.click(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/input_Autos_outlined-read-only-input'))

WebUI.click(findTestObject('Object Repository/Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/button_Buscar'))

