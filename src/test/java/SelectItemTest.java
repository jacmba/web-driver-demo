import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.*;

public class SelectItemTest {
    private WebDriver driver;
    private String url;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        url = System.getenv("URL");
    }

    @Test
    public void testSelectItemFunctionality() {
        driver.get(url);
        assertThat(driver.getTitle()).isEqualTo("SelectItemTest");

        WebElement selectElement = driver.findElement(By.id("select1"));
        Select select = new Select(selectElement);
        assertThat(select).isNotNull();
        assertThat(selectElement.getAttribute("value")).isEqualTo("yes");
        select.selectByVisibleText("Maybe");
        assertThat(selectElement.getAttribute("value")).isEqualTo("maybe");
    }
}
