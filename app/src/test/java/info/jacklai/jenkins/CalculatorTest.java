package info.jacklai.jenkins;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jacklai on 08/08/2017.
 */
public class CalculatorTest {
    @Test
    public void add() throws Exception {
        int a = 1;
        int b = 3;
        int expect = 4;

        Calculator calculator = new Calculator();
        int actual = calculator.add(a, b);

        Assert.assertEquals(expect, actual);
    }

    @Test
    public void subtract() throws Exception {
        int a = 3;
        int b = 1;
        int expect = 2;

        Calculator calculator = new Calculator();
        int actual = calculator.subtract(a, b);

        Assert.assertEquals(expect, actual);
    }

}