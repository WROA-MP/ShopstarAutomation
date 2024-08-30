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

WebUI.delay(3)

// Función para rellenar los campos de nombre y apellido según la cantidad de habitaciones
def fillFieldsForRooms(int maxRooms) {
    String nombre = 'Juan'
    String apellido = 'Perez'

    for (int i = 1; i <= maxRooms; i++) {
        if (WebUI.verifyElementPresent(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_name_' + i), 5, FailureHandling.OPTIONAL)) {
            WebUI.setText(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_name_' + i), nombre)
            WebUI.setText(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_LastName_' + i), apellido)
        } else {
            // Si no encuentra un input, sale del bucle y procede con la reserva
            WebUI.comment("No se encontró el campo input_name_" + i + ", procediendo a la reserva.")
            proceedToReservation()
            return
        }
    }
    // Si completa el llenado de todos los inputs, también procede a la reserva
    proceedToReservation()
}

// Función para hacer scroll a una posición específica
def scrollToPosition(int x, int y) {
    WebUI.executeJavaScript("window.scrollTo(arguments[0], arguments[1]);", Arrays.asList(x, y))
}

// Proceder con la reserva
def proceedToReservation() {
    WebUI.delay(1) // Esperar un momento para asegurar que la página esté estable

    // Hacer scroll al inicio de la página (0,0)
    scrollToPosition(0, 0)

    // Obtener el botón "Reservar"
    def reservarButton = findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/button_Reservar')

    // Esperar explícitamente por el botón "Reservar"
    WebUI.waitForElementVisible(reservarButton, 5)

    // Verificar si el botón es visible y habilitado
    if (WebUI.verifyElementVisible(reservarButton) && WebUI.verifyElementClickable(reservarButton)) {
        try {
            // Intentar clic con JavaScript para mejorar la rapidez
            WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(reservarButton)))
            WebUI.comment("Se hizo clic en el botón 'Reservar'.")
        } catch (Exception e) {
            WebUI.comment("Error al hacer clic en el botón 'Reservar': " + e.getMessage())
            // Intentar clic con JavaScript si el clic convencional falla
            WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(reservarButton)))
        }
    } else {
        WebUI.comment("El botón 'Reservar' no es visible o no es clickeable.")
        // Intentar con JavaScript si el botón no es visible o clickeable
        WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(WebUI.findWebElement(reservarButton)))
        WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(WebUI.findWebElement(reservarButton)))
    }

    // Asegúrate de esperar después del clic
    WebUI.delay(2)
    
    // Hacer clic en los otros elementos
    WebUI.click(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_Revisa y paga_PrivateSwitchBase-input_e4d2f2'))
    WebUI.click(findTestObject('Shopstar/Page_Hotels/Page_ShopstarViajes_Hotel_e2e/Page_Checkout/input_SeleccionarTarjeta'))
}

// Definir el número máximo de habitaciones a llenar
int maxRooms = 6

// Llamar a la función para rellenar los campos
fillFieldsForRooms(maxRooms)