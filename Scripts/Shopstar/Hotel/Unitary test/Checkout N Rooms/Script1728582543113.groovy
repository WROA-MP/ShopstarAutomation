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

WebUI.callTestCase(findTestCase('Shopstar/Hotel/Unitary test/Select Hotel and rooms for N rooms'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)



def fillFieldsForRooms(int maxRooms) {
    String nombre = 'Juan'
    String apellido = 'Perez'

    for (int i = 1; i <= maxRooms; i++) {
        TestObject inputName = findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_name_' + i)
        TestObject inputLastName = findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_LastName_' + i)

        if (WebUI.verifyElementPresent(inputName, 5, FailureHandling.OPTIONAL)) {
            WebUI.setText(inputName, nombre)
            WebUI.setText(inputLastName, apellido)
        } else {
            WebUI.comment("No se encontró el campo input_name_" + i + ", procediendo a la reserva.")
            proceedToReservation()
            return
        }
    }
    proceedToReservation()
}
def scrollToPosition(int x, int y) {
	WebUI.executeJavaScript("window.scrollTo(arguments[0], arguments[1]);", Arrays.asList(x, y))
}


def proceedToReservation() {
    WebUI.delay(1)

    // Hacer scroll al inicio de la página (0,0)
    scrollToPosition(0, 0)

    // Obtener el botón "Reservar"
    def reservarButton = findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/button_Reservar')

    // Verificar la presencia del botón "Reservar"
    if (WebUI.verifyElementPresent(reservarButton, 5)) {
        WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(reservarButton)))
        WebUI.comment("Se hizo clic en el botón 'Reservar'.")
    } else {
        WebUI.comment("El botón 'Reservar'n se encontró...")
        return
    }

    WebUI.delay(2)

    // Click en los checkboxes necesarios para completar la reserva
    WebUI.click(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_Revisa y paga_PrivateSwitchBase-input_e4d2f2'))
    WebUI.click(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_SeleccionarTarjeta'))
}

// Definir el número máximo de habitaciones a llenar
int maxRooms = 6

// Llamar a la función para rellenar los campos
fillFieldsForRooms(maxRooms)

