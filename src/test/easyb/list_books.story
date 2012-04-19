import static junit.framework.Assert.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'User can list all books'

scenario 'books missing required fields are not added in database', {
    
    given 'command add new book selected', {
        webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:9090");
        element = webDriver.findElement(By.linkText("Add book"));       
        element.click();
    }

    when 'required fields are not filled', {
        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("KIRJATROL")

        element.submit();

        webDriver.get("http://localhost:9090/book");

        element = webDriver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Arton vuoro")

        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Arto yo")

        element = webDriver.findElement(By.name("publisher"))
        assertNotNull(element)

        element.sendKeys("javamaster")

        element = webDriver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("255")

        element.submit();
    }

    then 'invalid books are not listed', {
        webDriver.getPageSource().contains("KIRJATRO").shouldBe false
    }
}

scenario 'user can list all books', {

    given 'command add book selected', {
        webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:9090");
        element = webDriver.findElement(By.linkText("Add book"));       
        element.click();
    }

    when 'list contains books', {
        
        element = webDriver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Captain Hadoque")

        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Captain Hadoque")

        element = webDriver.findElement(By.name("publisher"))
        assertNotNull(element)
        element.sendKeys("MIKAEL")

        element = webDriver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2012")

        element.submit()

        webDriver.get("http://localhost:9090");
        element = webDriver.findElement(By.linkText("Add book"));       
        element.click();
        
        element = webDriver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Tintin")

        element = webDriver.findElement(By.name("publisher"))
        assertNotNull(element)
        element.sendKeys("ARTOMATTIJAMIKAEL")

        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Tintin")

        element = webDriver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2011")

        element.submit()
    }

    then 'all books will be listed', {     
        webDriver.getPageSource().contains("Adventures of Captain Hadoque")
        webDriver.getPageSource().contains("The Mighty Adventures of Tintin")
    }
}