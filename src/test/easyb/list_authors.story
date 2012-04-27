import static junit.framework.Assert.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'User can list all authors'

scenario 'user can list all authors', {

    given 'command add new article (or new book) selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add article"));       
        element.click();
    }


    when 'valid articles and books added', {
        element = driver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Captain Hadoque")

        element = driver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Captain Hadoque")

        element = driver.findElement(By.name("journal"))
        assertNotNull(element)

        element.sendKeys("The Mighty Sea Adventures")

        element = driver.findElement(By.name("volume"))
        assertNotNull(element)

        element.sendKeys("2")

        element = driver.findElement(By.name("number"))
        assertNotNull(element)

        element.sendKeys("10")

        element = driver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2012")

        element.submit()

        driver.get("http://localhost:9090/article");
        
        element = driver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Tintin")

        element = driver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Tintin")

        element = driver.findElement(By.name("journal"))
        assertNotNull(element)

        element.sendKeys("The Mighty Adventures of Tintin")

        element = driver.findElement(By.name("volume"))
        assertNotNull(element)

        element.sendKeys("1")

        element = driver.findElement(By.name("number"))
        assertNotNull(element)

        element.sendKeys("2")

        element = driver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2011")

        element.submit()

        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add book"));       
        element.click();

        element = driver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("TONI KONNI")

        element = driver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Captain Hadoque")

        element = driver.findElement(By.name("publisher"))
        assertNotNull(element)
        element.sendKeys("MIKAEL")

        element = driver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2012")

        element.submit()

        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add book"));       
        element.click();
        
        element = driver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("KASPER HIRVI")

        element = driver.findElement(By.name("publisher"))
        assertNotNull(element)
        element.sendKeys("ARTOMATTIJAMIKAEL")

        element = driver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Tintin")

        element = driver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2011")

        element.submit()
    }

    then 'all authors will be listed', {
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("List all authors"));       
        element.click();
        driver.getPageSource().contains("Captain Hadoque")
        driver.getPageSource().contains("Tintin")
        driver.getPageSource().contains("KASPER HIRVI")
        driver.getPageSource().contains("TONI KONNI")
    }
}
