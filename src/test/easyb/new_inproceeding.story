import static junit.framework.Assert.*
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.htmlunit.HtmlUnitDriver

description 'User can add an valid inproceeding'

scenario 'user cant add a new inproceeding when missing required fields', {
    given 'command add new inproceeding selected', {
        webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:9090");
        element = webDriver.findElement(By.linkText("Add inproceeding"));       
        element.click();
    }

    when 'required fields are not filled', {
        element.submit();
    }
    then 'inproceeding will not be added', {
        webDriver.getPageSource().contains("Author can't be empty").shouldBe true
    }
}

scenario 'user can add an inproceeding with a valid information', {
    given 'command add new inproceeding selected', {
        webDriver = new HtmlUnitDriver();
        webDriver.get("http://localhost:9090");
        element = webDriver.findElement(By.linkText("Add inproceeding"));       
        element.click();
    }

    when 'valid information is entered', {        
        element = webDriver.findElement(By.name("author"))
        assertNotNull(element)

        element.sendKeys("Captain Hadoque")

        element = webDriver.findElement(By.name("title"))
        assertNotNull(element)

        element.sendKeys("Adventures of Captain Hadoque")

        element = webDriver.findElement(By.name("bookTitle"))
        assertNotNull(element)
        element.sendKeys("kirja nii")
        
        element = webDriver.findElement(By.name("releaseYear"))
        assertNotNull(element)

        element.sendKeys("2012")

        element.submit()
    }

    then 'inproceeding will be added', {      
        webDriver.getPageSource().contains("Adventures of Captain Hadoque")
    }
}