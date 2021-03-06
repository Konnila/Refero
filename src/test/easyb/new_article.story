import static junit.framework.Assert.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'User can add an valid article'

scenario 'user cant add a new article when missing required fields', {
    given 'command add new article selected', {
        webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:9090");
        element = webDriver.findElement(By.linkText("Add article"));       
        element.click();
    }

    when 'required fields are not filled', { 
        webDriver.get("http://localhost:9090/article");
        element = webDriver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Captain Hadoque")
        element.submit();
    }
    then 'article will not be added', {
        webDriver.getPageSource().contains("cant be empty").shouldBe true
    }
}

scenario 'user can add an article with a valid information', {

    given 'command add article selected', {
        webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:9090");
        element = webDriver.findElement(By.linkText("Add article"));       
        element.click();
    }

    when 'valid information is entered', {              
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