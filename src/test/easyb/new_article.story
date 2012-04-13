import static junit.framework.Assert.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'User can add an valid article'
 
scenario 'user can add an article with valid information', {

    given 'command add article selected', {

        webDriver = new HtmlUnitDriver();
    }

    when 'valid information is entered', {
        
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
    }

    then 'article will be added', {
        
        webDriver.getPageSource().contains("Adventures of Captain Hadoque")
    }
}