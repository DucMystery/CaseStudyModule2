package CodeGym.Manager;

import CodeGym.Model.Fridge;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class ProductManagerTest {

    @Test
    public void checkProductFridgeTest() {
        Fridge fridge = new Fridge("i2", "i", "apple", 256, 123, "new 100%");
        Pattern pattern = Pattern.compile("^[I,D]{2}\\\\s[:]{1}\\\\s[2]{1}.*$");
        boolean output = false;
        Matcher matcher = pattern.matcher(fridge.toString());
        assertEquals(matcher.matches(), output);


    }
}
