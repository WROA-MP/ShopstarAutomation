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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testcase.TestCaseContext

WebUI.delay(3)

// Función para rellenar los campos de nombre y apellido según la cantidad de habitaciones
def fillFieldsForRooms(int maxRooms) {
	String nombre = 'Juan'
	String apellido = 'Perez'
	boolean fieldFound = false

	for (int i = 1; i <= maxRooms; i++) {
		TestObject inputName = findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_name_' + i)
		TestObject inputLastName = findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_LastName_' + i)

		if (WebUI.verifyElementPresent(inputName, 5, FailureHandling.OPTIONAL)) {
			WebUI.setText(inputName, nombre)
			WebUI.setText(inputLastName, apellido)
			fieldFound = true
		} else {
			WebUI.comment("No se encontró el campo input_name_" + i + ", se procederá con la reserva.")
			break
		}
	}

	// Llamar a la función para proceder con la reserva si se encontraron campos
	if (fieldFound) {
		proceedToReservation()
	}
}

// Proceder con la reserva
def proceedToReservation() {
	try {
		// Añadir un scroll antes de hacer clic en el botón
		WebUI.scrollToElement(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/button_Reservar'), 5)
		WebUI.delay(1) // Pequeño delay para estabilizar el scroll

		WebUI.click(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/button_Reservar'))
		WebUI.click(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_Revisa y paga_PrivateSwitchBase-input_e4d2f2'))
		WebUI.click(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_SeleccionarTarjeta'))
	} catch (Exception e) {
		WebUI.comment("Error al intentar proceder con la reserva: " + e.getMessage())
	}
}

// Definir el número máximo de habitaciones a llenar
int maxRooms = 6

// Llamar a la función para rellenar los campos
fillFieldsForRooms(maxRooms)