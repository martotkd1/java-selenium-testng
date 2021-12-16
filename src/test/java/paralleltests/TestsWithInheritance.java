package paralleltests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import paralleltests.TestBase;

public class TestsWithInheritance extends TestBase {
    @Test
    public void test1() {
        goTo("https://www.google.com");
        Assert.assertEquals(driver.get().getTitle(), "Google");
    }

    @Test
    public void test2() {
        goTo("https://www.abv.bg");
        Assert.assertEquals(driver.get().getTitle(), "АБВ Поща");
    }
}