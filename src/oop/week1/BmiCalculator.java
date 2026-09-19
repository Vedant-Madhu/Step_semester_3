package oop.week1;

public class BmiCalculator {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        if (bmi <= 24.9)
            return "Normal";
        if (bmi <= 29.9)
            return "Overweight";
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("Person %d | %.2f m | %.1f kg | %.2f | %s\n", (i + 1), heights[i], weights[i], bmi,
                    getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        printWellnessReport(new double[] { 1.75, 1.60 }, new double[] { 70.0, 90.0 });
    }
}