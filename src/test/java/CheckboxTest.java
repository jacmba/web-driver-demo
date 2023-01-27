import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckboxTest {
    private WebDriver driver;
    private String url;

    @Before
    public void Setup() {
        driver = new FirefoxDriver();
        url = System.getenv("URL");
    }

    @Test
    public void testCheckboxFunctionality() {
        driver.get(url);
        assertThat(driver.getTitle()).isEqualTo("CheckboxTest");

        WebElement mayoCheckbox = driver.findElement(By.id("mayoCheckbox"));
        WebElement lettuceCheckbox = driver.findElement(By.id("lettuceCheckbox"));
        WebElement turkeyCheckbox = driver.findElement(By.id("turkeyCheckbox"));

        assertThat(mayoCheckbox.getAttribute("value")).isEqualTo("mayo");
        assertThat(lettuceCheckbox.getAttribute("value")).isEqualTo("lettuce");
        assertThat(turkeyCheckbox.getAttribute("value")).isEqualTo("turkey");

        assertThat(mayoCheckbox.isSelected()).isFalse();
        assertThat(lettuceCheckbox.isSelected()).isFalse();
        assertThat(turkeyCheckbox.isSelected()).isFalse();

        mayoCheckbox.click();
        turkeyCheckbox.click();

        assertThat(mayoCheckbox.isSelected()).isTrue();
        assertThat(lettuceCheckbox.isSelected()).isFalse();
        assertThat(turkeyCheckbox.isSelected()).isTrue();
    }
}
