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

// Lista de objetos de tipo de alojamiento
WebUI.callTestCase(findTestCase('Shopstar/Hotel/Hotel Flow/Search hotel with 2 rooms'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Shopstar/Page_Hotels/Page_Filters_Order/div_Tipo de Alojamiento'))

// Lista de objetos de tipo de alojamiento
List<TestObject> tiposAlojamiento = [
    //findTestObject('Shopstar/Page_Hotels/Page_Filters_Order/input_Tipo de Alojamiento_Check_ApartaHotel'),
    findTestObject('Shopstar/Page_Hotels/Page_Filters_Order/input_Tipo de Alojamiento_Check_Apartamento'),
    findTestObject('Shopstar/Page_Hotels/Page_Filters_Order/input_Tipo de Alojamiento_Check_Camping'),
    findTestObject('Shopstar/Page_Hotels/Page_Filters_Order/input_Tipo de Alojamiento_Check_CasaCampo'),
    findTestObject('Shopstar/Page_Hotels/Page_Filters_Order/input_Tipo de Alojamiento_Check_Hostal'),
    findTestObject('Shopstar/Page_Hotels/Page_Filters_Order/input_Tipo de Alojamiento_Check_Hotel'),
    findTestObject('Shopstar/Page_Hotels/Page_Filters_Order/input_Tipo de Alojamiento_Check_Resort')
]

// Iterar sobre cada tipo de alojamiento
for (TestObject tipo : tiposAlojamiento) {
    
    // Seleccionar el tipo de alojamiento
    WebUI.click(tipo)
    
    // Aplicar los filtros utilizando el botón de aplicar
    WebUI.click(findTestObject('Shopstar/Page_Hotels/Page_Filters_Order/button_Aplicar'))
    
    // Esperar a que se actualicen los resultados
    WebUI.waitForElementVisible(findTestObject('Shopstar/Page_Hotels/Page_Filters_Order/Lista_Resultados'), 10)
    
    // Verificar si se muestra el mensaje de "No se encontraron hoteles"
    boolean noHayResultados = WebUI.verifyElementPresent(findTestObject('Shopstar/Page_Hotels/Page_Filters_Order/h2_No se encontraron hoteles'), 5, FailureHandling.OPTIONAL)
    
    if (!noHayResultados) {
        WebUI.comment("Se encontraron resultados con el filtro: " + tipo.getObjectId())
        break
    } else {
        WebUI.comment("No se encontraron resultados con el filtro: " + tipo.getObjectId())
    }

	
	// Si después de probar todos los tipos de alojamiento no se encuentran resultados
	if (noHayResultados) {
	    WebUI.comment("No se encontraron resultados para ninguno de los tipos de alojamiento.")
	}
}

