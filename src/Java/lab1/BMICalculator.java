package Java.lab1;

public class BMICalculator {
    public static void main(String[] args) {
        String status;
		double weight = (double)Integer.parseInt(args[0]);  
		double hight = (double)Integer.parseInt(args[1]) / 100.0;		
		double bmi = weight / (hight * hight);

		if (bmi < 18.5) status = "Underweight"; 
		else if (bmi < 25) status = "Normal";
		else if (bmi < 30) status = "Overweight";
		else status = "Obese";

		System.out.printf("Your weight: %d kg\n", (int)weight);
		System.out.printf("Your hight: %.2f m\n", hight);
		System.out.printf("Your BMI: %.2f\n", bmi);
		System.out.printf("You are in the %s range.\n", status);
    }
    
}
