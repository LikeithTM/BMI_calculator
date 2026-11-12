
package bmi.bmi_calculator;

public class BmiCalculator {

    // Calculate BMI
    public double calculateBMI(double weight, double height) {

        if (weight <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                "Weight and height must be greater than zero."
            );
        }

        if (!Double.isFinite(weight) || !Double.isFinite(height)) {
            throw new IllegalArgumentException(
                "Weight and height must be valid finite numbers."
            );
        }

        if (weight > 500 || height > 3.0 || height < 0.3) {
            throw new IllegalArgumentException(
                "Weight or height is outside the accepted range."
            );
        }

        return weight / (height * height);
    }

    // Determine BMI category
    public String getBMICategory(double bmi) {

        if (!Double.isFinite(bmi) || bmi <= 0) {
            throw new IllegalArgumentException(
                "BMI must be a positive finite number."
            );
        }

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal weight";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Display BMI result
    public void displayResult(double weight, double height) {

        double bmi = calculateBMI(weight, height);

        String category = getBMICategory(bmi);

        System.out.printf("BMI: %.2f%n", bmi);
        System.out.println("Category: " + category);
    }

    // Main method
    public static void main(String[] args) {

        BmiCalculator calculator = new BmiCalculator();

        double weight = 70;
        double height = 1.75;

        calculator.displayResult(weight, height);
    }
}
