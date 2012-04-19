import static junit.framework.Assert.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'User can add a valid book'

scenario 'user cant add a new book when missing required fields', {
    given 'command add new a book selected' {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add book"));       
        element.click();
    }

    when 'required fields are not filled', {
        element.submit();
    }
    then 'book will not be added', {
        driver.getPageSource().contains("Author can't be empty").shouldBe true
    }
}

scenario 'user can add an book with a valid information', {

    given 'command add a book selected', {
        driver = new HtmlUnitDriver();
        driver.get("http://localhost:9090");
        element = driver.findElement(By.linkText("Add book"));       
        element.click();
    }

    when 'valid information is entered', {   
        element = webDriver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Captain Hadoque")

        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Captain Hadoque")


        element = webDriver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2012")

        element = webDriver.findElement(By.name("publisher"))
        assertNotNull(element)

        element.sendKeys("KONNILAE")

        element.submit()
    }

    then 'the book will be added', {       
        webDriver.getPageSource().contains("Adventures of Captain Hadoque")
    }
}