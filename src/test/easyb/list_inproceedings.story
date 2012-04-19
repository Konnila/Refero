import static junit.framework.Assert.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'User can list all inproceedings'

scenario 'inproceedings missing required fields are not added in database' {    
    given 'command add new inproceeding selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add inproceeding"));       
        element.click();
    }

    when 'required fields are not filled', {
        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("MASA MATALA")

        element.submit();

        driver.get("http://localhost:9090/inproceeding");

        element = webDriver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Luke")

        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Captain LUKELUUKKAINEN")

        element = webDriver.findElement(By.name("bookTitle"))
        assertNotNull(element)

        element.sendKeys("mammamia")

        element = webDriver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2012")

        element.submit();
    }

    then 'invalid inproceedings are not listed', {
        driver.getPageSource().contains("MASA MATALA").shouldBe false
    }
}

scenario 'user can list all added inproceedings', {
    given 'command add an inproceeding selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add inproceeding"));       
        element.click();
    }

    when 'valid inproceedings are added', {
        element = webDriver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Captain Hadoque")

        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Captain Hadoque")

        element = webDriver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2012")

        element = webDriver.findElement(By.name("bookTitle"))
        assertNotNull(element)

        element.sendKeys("mammamia")

        element.submit()

        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add inproceeding"));       
        element.click();
        
        element = webDriver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Tintin")

        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Tintin")


        element = webDriver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2011")

        element = webDriver.findElement(By.name("bookTitle"))
        assertNotNull(element)

        element.sendKeys("JammaTia")

        element.submit()
    }

    then 'all valid inproceedings will be listed', {     
        webDriver.getPageSource().contains("Adventures of Captain Hadoque")
        webDriver.getPageSource().contains("The Mighty Adventures of Tintin")
    }
}