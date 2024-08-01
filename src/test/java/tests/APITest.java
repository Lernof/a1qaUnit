package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIMethods;

public class APITest {

    @Test
    public void APItesting(){
        Assert.assertEquals(APIMethods.getAllUsers(),);
    }
}
