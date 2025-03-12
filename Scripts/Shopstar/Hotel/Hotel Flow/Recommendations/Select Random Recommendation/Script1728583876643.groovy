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



void selectOptionRand() {
    TestObject PuntaCana = findTestObject('Object Repository/Shopstar/Page_Hotels/Page_Recommendations/img_Descubre nuestras recomendaciones para _d34453')

    TestObject Bogota = findTestObject('Object Repository/Shopstar/Page_Hotels/Page_Recommendations/img_Descubre nuestras recomendaciones para _d34453_1')

    TestObject Bariloche = findTestObject('Object Repository/Shopstar/Page_Hotels/Page_Recommendations/img_Descubre nuestras recomendaciones para _d34453_1_2')

    TestObject CdPanama = findTestObject('Object Repository/Shopstar/Page_Hotels/Page_Recommendations/img_Descubre nuestras recomendaciones para _d34453_1_2_3')

    TestObject CdMexico = findTestObject('Object Repository/Shopstar/Page_Hotels/Page_Recommendations/img_Descubre nuestras recomendaciones para _d34453_1_2_3_4')

    TestObject Rio = findTestObject('Object Repository/Shopstar/Page_Hotels/Page_Recommendations/img_Descubre nuestras recomendaciones para _d34453_1_2_3_4_5')

    TestObject Santiago = findTestObject('Object Repository/Shopstar/Page_Hotels/Page_Recommendations/img_Descubre nuestras recomendaciones para _d34453_1_2_3_4_5_6')

    TestObject Antigua = findTestObject('Object Repository/Shopstar/Page_Hotels/Page_Recommendations/img_Descubre nuestras recomendaciones para _d34453_1_2_3_4_5_6_7')

    List<TestObject> recommendations = [PuntaCana, Bogota, Bariloche, CdPanama, CdMexico, Rio, Santiago, Antigua]

    int randomIndex = new Random(recommendations.size())

    TestObject SelectedOption = recommendations[randomIndex]

    WebUI.click(SelectedOption)
}

selectOptionRand()
