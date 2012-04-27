import static junit.framework.Assert.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'User can list articles, books and inproceedings as BiBTeX'

scenario 'all added articles are listed as bibtex', {
    
    given 'command add new article selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add article"));       
        element.click();
    }

    when 'database contains articles', {
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
    }

    then 'all articles will be listed as BiBTeX format', {
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("List all BiBTeXs"));       
        element.click();
        driver.getPageSource().contains("Adventures of Captain Hadoque")
        driver.getPageSource().contains("The Mighty Adventures of Tintin")
    }
}

scenario 'all added books are listed as bibtex', {

    given 'command add book selected', {
        webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:9090");
        element = webDriver.findElement(By.linkText("Add book"));       
        element.click();
    }

    when 'database contains all added books', {
        
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

    then 'all books will be listed as BiBTeX format', {
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("List all BiBTeXs"));       
        element.click();     
        webDriver.getPageSource().contains("Adventures of Captain Hadoque")
        webDriver.getPageSource().contains("The Mighty Adventures of Tintin")
    }
}

scenario 'all added inproceedings are listed as bibtex', {
    given 'command add an inproceeding selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add inproceeding"));       
        element.click();
    }

    when 'valid inproceedings are added', {
        element = driver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Captain Hadoque")

        element = driver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Captain Hadoque")

        element = driver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2012")

        element = driver.findElement(By.name("bookTitle"))
        assertNotNull(element)

        element.sendKeys("mammamia")

        element.submit()

        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add inproceeding"));       
        element.click();
        
        element = driver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Tintin")

        element = driver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Tintin")


        element = driver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2011")

        element = driver.findElement(By.name("bookTitle"))
        assertNotNull(element)

        element.sendKeys("JammaTia")

        element.submit()
    }

    then 'all inproceedings will be listed as BiBTeX format', {
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("List all BiBTeXs"));       
        element.click();      
        driver.getPageSource().contains("Adventures of Captain Hadoque")
        driver.getPageSource().contains("The Mighty Adventures of Tintin")
    }
}