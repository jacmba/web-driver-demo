import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RadioButtonsTest {

    WebDriver driver;
    String url;

    @Before
    public void Setup() {
        driver = new FirefoxDriver();
        url = System.getenv("URL");
    }

    @Test
    public void testRadioButtonsFunctionality() {
        driver.get(url);
        assertThat(driver.getTitle()).isEqualTo("RadioButtonTest");

        List<WebElement> radioButtons = driver.findElements(By.name("color"));
        assertThat(radioButtons.get(0).isSelected()).isTrue();
        assertThat(radioButtons.get(1).isSelected()).isFalse();

        radioButtons.get(1).click();
        assertThat(radioButtons.get(0).isSelected()).isFalse();
        assertThat(radioButtons.get(1).isSelected()).isTrue();

        String selected = null;

        for (WebElement btn : radioButtons) {
            if (btn.isSelected()) {
                selected = btn.getAttribute("value");
                System.out.println("The selected color is " + selected);
            }
        }

        assertThat(selected).isEqualTo("green");
    }
}
