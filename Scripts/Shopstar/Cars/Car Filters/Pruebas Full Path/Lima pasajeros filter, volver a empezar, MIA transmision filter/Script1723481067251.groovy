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
//librerias tiempo
import groovy.time.TimeCategory as TimeCategory
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import java.util.Calendar as Calendar
//fecha de hoy
import utils.DateUtils as DateUtils

// Obtener la fecha n días en el futuro
WebUI.callTestCase(findTestCase('Shopstar/Cars/Car Filters/Car Filters Full Path/Pasajeros Filter Car Full Path'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.back()

WebUI.back()

WebUI.back()

//librerias tiempo
//fecha de hoy
// Obtener la fecha n días en el futuro
def futureNDate = DateUtils.getFutureDate(4)

println('Future date (N days): ' + futureNDate)

// Obtener la fecha z días en el futuro
def futureZDate = DateUtils.getFutureDate(6)

println('Future date (Z days): ' + futureZDate)

WebUI.scrollToPosition(0, 400)

WebUI.setText(findTestObject('Object Repository/Page_Shopstar Viajes/input_Autos_pickUpLocation-autocomplete'), 'MIA')

WebUI.click(findTestObject('Object Repository/Page_Shopstar Viajes/li_Aeropuerto Intl Jorge Chvez, LIM, Per'))

WebUI.click(findTestObject('Object Repository/Page_Shopstar Viajes/input_Autos_outlined-read-only-input'))

WebUI.doubleClick(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/First Date Calendar'))

WebUI.setText(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/First Date Calendar'), futureZDate)

WebUI.doubleClick(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Second Date Calendar'))

WebUI.setText(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Second Date Calendar'), futureZDate)

WebUI.click(findTestObject('Object Repository/Page_Shopstar Viajes/button_Buscar'))

WebUI.scrollToPosition(0, 800)

WebUI.click(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Click Tipo de auto'))

WebUI.click(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Primer tipo de auto'))

WebUI.click(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Click Aplicar Filtro'))

WebUI.click(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/button_Ver Detalles'))

WebUI.click(findTestObject('Page_Shopstar Viajes/button_Continuar'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_Shopstar Viajes/button_Siguiente'))

WebUI.click(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Click Debito o Credito'))

