package factory_pattern.helper;

import org.junit.Assert;
import org.junit.Test;

public class TitleCaseTest {
    @Test
    public void allLowerCaseString() {
        String sampleString = "example";
        String titleCaseString = StringHelper.toTitleCase(sampleString);
        Assert.assertEquals("Example", titleCaseString);
    }

    @Test
    public void allUpperCaseString() {
        String sampleString = "EXAMPLE";
        String titleCaseString = StringHelper.toTitleCase(sampleString);
        Assert.assertEquals("Example", titleCaseString);
    }
}
