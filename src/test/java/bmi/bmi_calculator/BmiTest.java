
package bmi.bmi_calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BmiCalculatorTest {

    BmiCalculator calculator = new BmiCalculator();

    // Test 1: BMI calculation for known values
    @Test
    void testCalculateBMI() {

        double bmi = calculator.calculateBMI(70, 1.75);

        assertEquals(30, bmi, 0.01);
    }

    // Test 2: Underweight category
    @Test
    void testUnderweightCategory() {

        assertEquals("Underweight",
                calculator.getBMICategory(18.49));
    }

    // Test 3: Normal weight category
    @Test
    void testNormalWeightCategory() {

        assertEquals("Normal weight",
                calculator.getBMICategory(22.0));
    }

    // Test 4: Overweight category
    @Test
    void testOverweightCategory() {

        assertEquals("Overweight",
                calculator.getBMICategory(27.0));
    }

    // Test 5: Obese category
    @Test
    void testObeseCategory() {

        assertEquals("Obese",
                calculator.getBMICategory(30.0));
    }

    // Test 6: Category boundary 18.5
    @Test
    void testBoundary18_5() {

        assertEquals("Normal weight",
                calculator.getBMICategory(18.5));
    }

    // Test 7: Category boundary 25
    @Test
    void testBoundary25() {

        assertEquals("Overweight",
                calculator.getBMICategory(25.0));
    }

    // Test 8: Category boundary 30
    @Test
    void testBoundary30() {

        assertEquals("Obese",
                calculator.getBMICategory(30.0));
    }

    // Test 9: Zero weight
    @Test
    void testZeroWeight() {

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateBMI(0, 1.75));
    }

    // Test 10: Negative weight
    @Test
    void testNegativeWeight() {

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateBMI(-70, 1.75));
    }

    // Test 11: Zero height
    @Test
    void testZeroHeight() {

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateBMI(70, 0));
    }

    // Test 12: Negative height
    @Test
    void testNegativeHeight() {

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateBMI(70, -1.75));
    }

    // Test 13: Invalid extreme weight
    @Test
    void testExtremeWeight() {

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateBMI(600, 1.75));
    }

    // Test 14: Invalid extreme height
    @Test
    void testExtremeHeight() {

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateBMI(70, 3.5));
    }

    // Test 15: NaN input
    @Test
    void testNaNWeight() {

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateBMI(Double.NaN, 1.75));
    }

    // Test 16: Infinite input
    @Test
    void testInfiniteHeight() {

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateBMI(70, Double.POSITIVE_INFINITY));
    }

    // Test 17: Invalid BMI category
    @Test
    void testInvalidBMI() {

        assertThrows(IllegalArgumentException.class,
                () -> calculator.getBMICategory(0));
    }
}
