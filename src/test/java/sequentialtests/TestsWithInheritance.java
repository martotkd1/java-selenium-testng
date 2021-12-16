package sequentialtests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsWithInheritance extends TestBase {
    @Test
    public void test1() {
        driver.get("https://www.google.com");
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @Test
    public void test2() {
        driver.get("https://www.abv.bg");
        Assert.assertEquals(driver.getTitle(), "АБВ Поща");
    }
}