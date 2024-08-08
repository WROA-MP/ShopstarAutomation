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

Calendar cal = Calendar.getInstance()

Date todaysDate = new Date()

def formattedDate = todaysDate.format('dd-MM-yyyy')

Date next2Date = new Date()

def Add2Date = next2Date.format('dd-MM-yyyy')

cal.setTime(next2Date)

cal.add(Calendar.DATE, 2)

currentDate = cal.getTime()

def future2Date = currentDate.format('dd-MM-yyyy')

Date next16Date = new Date()

def Add16Date = next16Date.format('dd-MM-yyyy')

cal.setTime(next16Date)

cal.add(Calendar.DATE, 16)

currentDate = cal.getTime()

def future16Date = currentDate.format('dd-MM-yyyy')

println('fecha actual+2: ' + future2Date)

println('fecha futura: ' + future16Date)

////
WebUI.callTestCase(findTestCase('Shopstar/Login/Login User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Shopstar Viajes/svg'))

WebUI.scrollToPosition(0, 400)

WebUI.setText(findTestObject('Object Repository/Page_Shopstar Viajes/input_Autos_pickUpLocation-autocomplete'), 'LIM')

WebUI.click(findTestObject('Object Repository/Page_Shopstar Viajes/li_Aeropuerto Intl Jorge Chvez, LIM, Per'))

WebUI.click(findTestObject('Object Repository/Page_Shopstar Viajes/input_Autos_outlined-read-only-input'))

WebUI.doubleClick(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/First Date Calendar'))

WebUI.setText(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/First Date Calendar'), future2Date)

WebUI.doubleClick(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Second Date Calendar'))

WebUI.setText(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Second Date Calendar'), future16Date)

WebUI.click(findTestObject('Object Repository/Page_Shopstar Viajes/button_Buscar'))

WebUI.scrollToPosition(0, 800)

WebUI.click(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Click Transmision Filter'))

WebUI.click(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Click Transmision Automatico'))

WebUI.click(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Click Aplicar Filtro'))

WebUI.click(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/button_Ver Detalles'))

WebUI.click(findTestObject('Page_Shopstar Viajes/button_Continuar'))

WebUI.delay(5)

WebUI.click(findTestObject('Page_Shopstar Viajes/button_Siguiente'))

WebUI.click(findTestObject('Shopstar/Login User/Page_Shopstar Viajes/Click Debito o Credito'))

