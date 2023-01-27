import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.*;

public class TableTest {
    private WebDriver driver;
    private String url;

    @Before
    public void setup() {
        driver = new FirefoxDriver();
        url = System.getenv("URL");
    }

    @Test
    public void testTableFunctionality() {
        driver.get(url);
        assertThat(driver.getTitle()).isEqualTo("TableTest");

        WebElement outerTable = driver.findElement(By.tagName("table"));
        assertThat(outerTable).isNotNull();
        WebElement innerTable = outerTable.findElement(By.tagName("table"));
        assertThat(innerTable).isNotNull();

        WebElement row = outerTable.findElement(By.tagName("td"));
        assertThat(row.getText()).isEqualTo("Table 1 Row 1");

        WebElement otherRow = innerTable.findElements(By.tagName("td")).get(1);
        assertThat(otherRow.getText()).isEqualTo("Table 2 Row 2");
    }
}
