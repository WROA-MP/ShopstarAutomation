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
import javax.mail.*
import javax.mail.pop3.*
import javax.mail.internet.*
import javax.mail.internet.MimeMultipart as MimeMultipart
import java.util.Properties as Properties

WebUI.openBrowser('')

WebUI.navigateToUrl('https://exploremuscle.com/')

WebUI.maximizeWindow(FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Explore/Login User/Page_Explore/a_Iniciar sesin'))

WebUI.click(findTestObject('Object Repository/Explore/Login User/Page_Explore/input_DNI_ibk-textfield__value'))

WebUI.setText(findTestObject('Object Repository/Explore/Login User/Page_Explore/input_DNI_ibk-textfield__value'), '89822222')

WebUI.setEncryptedText(findTestObject('Object Repository/Explore/Login User/Page_Explore/input_Pass_ibk-textfield__value_1'), 
    'u7uNa5h1Ehdj3LDeO7sxX0oS9YL+xYSZ')

WebUI.click(findTestObject('Object Repository/Explore/Login User/Page_Explore/button_Ingresar'))

WebUI.delay(9)

// Conexión POP
Properties properties = new Properties()

properties.put('mail.store.protocol', 'pop3s')

properties.put('mail.pop3s.host', 'pop.gmail.com')

properties.put('mail.pop3s.port', '995')

properties.put('mail.pop3s.ssl.enable', 'true')

properties.put('mail.pop3s.starttls.enable', 'true')

properties.put('mail.pop3s.ssl.protocols', 'TLSv1.2')

properties.put('mail.pop3s.auth', 'true')

String username = 'qamusclemails@gmail.com'

String password = 'oqetsxgdjxsebxjb'

// Crear una sesión con las propiedades y la autenticación
Session emailSession = Session.getInstance(properties, new Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password)
	}
})

// Conectar a la tienda de correos
Store store = emailSession.getStore('pop3s')

store.connect()

Folder inbox = store.getFolder('INBOX')

inbox.open(Folder.READ_ONLY)

Message[] messages = inbox.getMessages()

// Procesar solo el correo más reciente
if (messages.length > 0) {
    Message message = messages[messages.length - 1]
    String subject = message.getSubject()

    if (subject.contains('Benefit')) {
        String content = getTextFromMessage(message)

        def matcher = content =~ 'style="font-weight: bold; color: #05be50;">(.*?)</span><br>'

        if (matcher.find()) {
            String extractedText = matcher.group(1)

            println('Codigo OTP: ' + extractedText)
			
			WebUI.click(findTestObject('Explore/Login User/Page_Explore/input_email_ibk-textfield__value_1'))

            WebUI.setText(findTestObject('Explore/Login User/Page_Explore/input_email_ibk-textfield__value_1'), extractedText)

            WebUI.click(findTestObject('Explore/Login User/Page_Explore/button_enviar_codigo'))
        }
    }
}

inbox.close(true)

store.close()

String getTextFromMessage(Message message) throws Exception {
    String result = ''

    if (message.getContent() instanceof String) {
        result = message.getContent()
    } else if (message.getContent() instanceof MimeMultipart) {
        MimeMultipart mimeMultipart = ((message.getContent()) as MimeMultipart)

        result = getTextFromMimeMultipart(mimeMultipart)
    }
    
    return result
}

String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
    int count = mimeMultipart.getCount()

    String result = ''

    for (int i = 0; i < count; i++) {
        BodyPart bodyPart = mimeMultipart.getBodyPart(i)

        if (bodyPart.isMimeType('text/plain')) {
            result = ((result + '\n') + bodyPart.getContent())
        } else if (bodyPart.isMimeType('text/html')) {
            String html = ((bodyPart.getContent()) as String)

            result = ((result + '\n') + org.jsoup.Jsoup.parse(html).text())
        } else if (bodyPart.getContent() instanceof MimeMultipart) {
            result = (result + getTextFromMimeMultipart(((bodyPart.getContent()) as MimeMultipart)))
        }
    }
    
    return result
}

//// Crear una sesión con las propiedades y la autenticación
//Session emailSession = Session.getInstance(properties, new Authenticator() {
//	protected PasswordAuthentication getPasswordAuthentication() {
//		return new PasswordAuthentication(username, password)
//	}
//})