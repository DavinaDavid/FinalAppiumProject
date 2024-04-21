package steps;

import core.AndroidDriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AvailabilityPage {
    @Given("I choose Availability tab from Bottom")
    public void i_choose_availability_tab_from_bottom() {
        AndroidDriverSetup.getAndroidDriver().findElement(By.cssSelector(".input"));

    }
}
