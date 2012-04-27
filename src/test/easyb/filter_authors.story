import static junit.framework.Assert.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'User can filter elements by any author'

scenario 'user can filter elements by any author', {

    given 'some books and articles are added into the database', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add article"));       
        element.click();

        element = driver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("KASPER HIRVI")

        element = driver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of TONI KONNI")

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

        element.sendKeys("KASPER HIRVI")

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


    when 'a specified author is seleceted', {
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("KASPER HIRVI"));       
        element.click();
    }

    then 'all references made by the author is listed', {     
        driver.getPageSource().contains("Adventures of Tintin")
        driver.getPageSource().contains("Adventures of Captain Hadoque")
        driver.getPageSource().contains("Adventures of TONI KONNI")
    }
}
