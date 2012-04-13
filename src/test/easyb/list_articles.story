import static junit.framework.Assert.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'User can list all articles'

scenario 'user can list all articles', {

    given 'command list articles selected', {

        webDriver = new HtmlUnitDriver();
    }

    when 'list contains articles', {

        webDriver.get("http://localhost:8080/article")
        
        element = webDriver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Captain Hadoque")

        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Captain Hadoque")

        element = webDriver.findElement(By.name("journal"))
        assertNotNull(element)

        element.sendKeys("The Mighty Sea Adventures")

        element = webDriver.findElement(By.name("volume"))
        assertNotNull(element)

        element.sendKeys("2")

        element = webDriver.findElement(By.name("number"))
        assertNotNull(element)

        element.sendKeys("10")

        element = webDriver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2012")

        element.submit()

        webDriver.get("http://localhost:8080/article")
        
        element = webDriver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Tintin")

        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Tintin")

        element = webDriver.findElement(By.name("journal"))
        assertNotNull(element)

        element.sendKeys("The Mighty Adventures of Tintin")

        element = webDriver.findElement(By.name("volume"))
        assertNotNull(element)

        element.sendKeys("1")

        element = webDriver.findElement(By.name("number"))
        assertNotNull(element)

        element.sendKeys("2")

        element = webDriver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2011")

        element.submit()
    }

    then 'all articles will be listed', {
        
        webDriver.getPageSource().contains("Adventures of Captain Hadoque")
        webDriver.getPageSource().contains("The Mighty Adventures of Tintin")
    }
}