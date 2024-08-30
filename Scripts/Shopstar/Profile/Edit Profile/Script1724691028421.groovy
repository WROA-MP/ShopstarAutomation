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
import utils.NombreIncrementador as NombreIncrementador

WebUI.callTestCase(findTestCase('Shopstar/Login/Login User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Shopstar/Page_Profile-DropDown/Page_Profile/div_NombreUser'))

WebUI.click(findTestObject('Shopstar/Page_Profile-DropDown/Page_Profile/div_Datos personales'))

WebUI.click(findTestObject('Shopstar/Page_Profile-DropDown/Page_Profile/button_Editar informacin personal'))

WebUI.setText(findTestObject('Shopstar/Page_Profile-DropDown/Page_Profile/input_Nombre_outline-none w-full'), 'Armando')

WebUI.setText(findTestObject('Shopstar/Page_Profile-DropDown/Page_Profile/input_Apellido'), 'Chanto')


void seleccionarRadioButtonAleatorio() {
	TestObject radioMale = findTestObject('Shopstar/Page_Profile-DropDown/Page_Profile/input_Gnero_Male')
	TestObject radioFemale = findTestObject('Shopstar/Page_Profile-DropDown/Page_Profile/input_Gnero_Female')
	TestObject radioOther = findTestObject('Shopstar/Page_Profile-DropDown/Page_Profile/input_Gnero_Other')
	
	List<TestObject> radioButtons = [radioMale, radioFemale, radioOther]
	
	int randomIndex = new Random().nextInt(radioButtons.size())
	
	TestObject selectedRadioButton = radioButtons[randomIndex]
	
	WebUI.click(selectedRadioButton)

}

seleccionarRadioButtonAleatorio()


WebUI.click(findTestObject('Shopstar/Page_Profile-DropDown/Page_Profile/button_Guardar'))

