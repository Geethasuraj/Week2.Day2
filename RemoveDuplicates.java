package week2.day2assignment;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "We learn java basics as part of java sessions in java week1";
		// Initialize an integer variable as count
		int count = 0;
		// Split the String into array and iterate over it
		String arr[] = text.split(" ");
		for (int i = 0; i < arr.length; i++) {
			// Initialize another loop to check whether the word is there in the array
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i].equals(arr[j])) {
					// if it is available then increase and count by 1.
					count = count + 1;
				}

				// if the count > 1 then replace the word as ""
				if (count >= 1) {

					arr[j] = arr[j].replace(arr[i], " ");

				}
			}
			// Displaying the String without duplicate words
			System.out.println(" " + arr[i] + " ");

		}
	}
}
