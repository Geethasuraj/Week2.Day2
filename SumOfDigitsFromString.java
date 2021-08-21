package week2.day2assignment;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "Tes12Le79af65";
		int sum = 0;

		// Iterate an array over the String
		for (int i = 0; i < text.length(); i++) {
			// Get each character and check if it is a number using Character.isDigit()
			if (Character.isDigit(text.charAt(i))) {
				// Now covert char to int using Character.getNumericValue() and add it to sum
				sum = sum + Character.getNumericValue(text.charAt(i));
			}

		}

		// Now Print the value

		System.out.println("sum of digits from string: " + sum);
	}

}
