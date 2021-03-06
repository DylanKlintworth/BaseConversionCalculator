import java.util.ArrayList;

public class BaseSixteen extends Number{
	private String number; //String for object's number due to inclusion of lettering.
	private int base = 16; //Base sixteen base.
	private String[] possibleValues = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"}; //Possible base sixteen values.
	public BaseSixteen(){ //Default constructor, sets number to zero.
		number = "0";
	}
	public BaseSixteen(String input) { //Sets number to valid base sixteen value, otherwise sets to zero
		input = input.toUpperCase();
		int isValid = 0;
		for(int i = 0; i < input.length(); i++) {
			for(int j = 0; j < possibleValues.length; j++) {
				if(Character.toString(input.charAt(i)).equals(possibleValues[j])) {
					isValid = isValid+1;
				}
			}
		}
		if(isValid == input.length()) {
			number = input;
		}else {
			number = "0";
		}
	}
	public int getBase() { // returns base sixteen base.
		return base;
	}
	public boolean equals(Number n) { //Checks if this base sixteen object is equal to another number by comparing base ten values.
		if(this.toBaseTen().equals(n.toBaseTen())) {
			return true;
		}else{
			return false;
		}
	}
	public void setBaseSixteen(String n) {//Sets number to a valid base sixteen number, otherwise set to zero.
		n = n.toUpperCase();
		int isValid = 0;
		for(int i = 0; i < n.length(); i++) {
			for(int j = 0; j < possibleValues.length; j++) {
				if(Character.toString(n.charAt(i)).equals(possibleValues[j])) {
					isValid = isValid+1;
				}
			}
		}
		if(isValid == n.length()) {
			number = n;
		}else {
			number = "0";
		}
	}
	public String getBaseSixteen() { //Returns string representation of this object's number.
		return number;
	}
	public boolean equals(BaseSixteen b) { //Compares this object to another BaseSixteen object by comparing number value.
		if(this.getBaseSixteen().equals(b.getBaseSixteen())) {
			return true;
		}else {
			return false;
		}
	}
	public String toString() { //Returns string representation of hexadecimal.
		return number;
	}
	/*
	 * (non-Javadoc)
	 * @see Number#toBaseTen()
	 * P: String for number as string, String[] for valid numbers in base ten, double[] for input values, double for powers and answers.
	 * I: No input, utilizes object's number value.
	 * P: Cycle through each numeral in the object's number with for loop.
	 * 	Cycle through all possible values for base ten, 0-9.
	 * 		Set temporary String to char value of numeral.
	 * 		if temporary string equals possible value then values[index] = possibleValuesIndex, sets values within array to a possible base ten value.
	 * answer equals values[index]*16^power.
	 * power--;
	 * O: once cycled through, return answer as a string.
	 */
	public String toBaseTen() { //returns base sixteen number converted to base ten.
		ArrayList<Integer> values = new ArrayList<>();
		double powers;
		double answer;
		answer = 0;
		powers = number.length()-1;
		if(number.equals("0")) {
			return "0";
		}else if(number.equals("1")) {
			return "1";
		}else {
			for(int originalNumIndex = 0; originalNumIndex < number.length(); originalNumIndex++) { //Cycle through each index within number.
				for(int possibleValuesIndex = 0; possibleValuesIndex < possibleValues.length; possibleValuesIndex++) { //Cycle through values within possible values.
					String temp = Character.toString(number.charAt(originalNumIndex)); // Converts char in number to String.
					if(temp.equals(possibleValues[possibleValuesIndex])){ // checks if char equals a possible value.
						values.add(originalNumIndex, possibleValuesIndex);
					}
				}
				answer = answer + values.get(originalNumIndex)*Math.pow(16,powers);
				powers = powers - 1;
			}
			long answerAsLong = (long) answer;
			return Long.toString(answerAsLong);
		}
	}
	/*
	 * (non-Javadoc)
	 * @see Number#toBaseTwo()
	 *  P: Two ArrayLists to store quotients and powers. Long variables to store the dividend, divisor, power, and quotient. String to store answer as a string.
	 * Dividend set to this object's number converted to base ten.
	 * I: No input, retrieve number from private variable number.
	 * P: Find the greatest value of 2^power that is less than the base ten value.
	 * Store each 2^power lower than the number in a power ArrayList.
	 * for loop to cycle down the power ArrayList and set divisor to the index of powerList.
	 * quotient will be set to dividend / divisor and added to quotient ArrayList.
	 * Set dividend to the remainder of the equation above.
	 * if quotient is equal to 2 then that quotient will be set as "10L" so it accounts for base two representation of 2.
	 * loop will run and collect all quotients and add them to the quotient ArrayList.
	 * Another for loop will then cycle through the quotientList and convert it to String values, which will be placed in a string[].
	 * Another for loop will concatenate all values within the array together to produce the final string representation.
	 * O: String representation of base ten value converted to base two will be returned.
	 */
	public String toBaseTwo() {
		ArrayList<Long> powerList = new ArrayList<>();
		ArrayList<Long> quotientList = new ArrayList<>();

		long dividend, divisor, quotient, power;
		String answerAsString;
		answerAsString = "";
		dividend = Long.parseLong(this.toBaseTen());
		divisor = 0;
		quotient = 0;
		power = 0;
		if (number.equals("0")) {
			return "0";
		}else if(number.equals("1")) {
			return "1";
		}else {
			while(dividend > Math.pow(2,power)) {
				powerList.add((long) Math.pow(2, power));
				power++;
			}
			for(int i = powerList.size()-1; i >= 0; i--) {
				divisor = powerList.get(i);
				quotient = dividend / divisor;
				if(quotient == 2) {
					quotientList.add(10L);
					dividend = dividend % divisor;
				}else {
				quotientList.add(quotient);
				dividend = dividend % divisor;
				}
			}
			String[] quotientListAsString = new String[quotientList.size()];
			for(int i = 0; i < quotientListAsString.length; i++) {
				quotientListAsString[i] = Long.toString(quotientList.get(i));
			}
			for(int i = 0; i < quotientListAsString.length;i++) {
				answerAsString = answerAsString.concat(quotientListAsString[i]);
			}
			return answerAsString;
		}
	}
	/*
	 * (non-Javadoc)
	 * @see Number#toBaseEight()
	 * P: Two ArrayLists to store quotients and powers. Long variables to store the dividend, divisor, power, and quotient. String to store answer as a string.
	 * Dividend will be set to this object's number converted to base ten.
	 * I: No input, retrieve number from private variable number.
	 * P: Find the greatest value of 8^power that is less than the base ten value.
	 * Store each 8^power lower than the number in a power ArrayList.
	 * for loop to cycle down the power ArrayList and set divisor to the index of powerList.
	 * quotient will be set to dividend / divisor and added to quotient ArrayList.
	 * Set dividend to the remainder of the equation above.
	 * if quotient is equal to 8 then that quotient will be set as "10L" so it accounts for base eight representation of 8.
	 * loop will run and collect all quotients and add them to the quotient ArrayList.
	 * Another for loop will then cycle through the quotientList and convert it to String values, which will be placed in a string[].
	 * Another for loop will concatenate all values within the array together to produce the final string representation.
	 * O: String representation of base ten value converted to base eight will be returned.
	 */
	public String toBaseEight() {
		ArrayList<Long> powerList = new ArrayList<>();
		ArrayList<Long> quotientList = new ArrayList<>();

		long dividend, divisor, quotient, power;
		String answerAsString;
		answerAsString = "";
		dividend = Long.parseLong(this.toBaseTen());
		divisor = 0;
		quotient = 0;
		power = 0;
		if (number.equals("0")) {
			return "0";
		}else if(number.equals("1")) {
			return "1";
		}else{
			while(dividend > Math.pow(8,power)) {
				powerList.add((long) Math.pow(8, power));
				power++;
			}
			for(int i = powerList.size()-1; i >= 0; i--) {
				divisor = powerList.get(i);
				quotient = dividend / divisor;
				if(quotient == 8) {
					quotientList.add(10L);
					dividend = dividend % divisor;
				}else {
				quotientList.add(quotient);
				dividend = dividend % divisor;
				}
			}
			String[] quotientListAsString = new String[quotientList.size()];
			for(int i = 0; i < quotientListAsString.length; i++) {
				quotientListAsString[i] = Long.toString(quotientList.get(i));
			}
			for(int i = 0; i < quotientListAsString.length;i++) {
				answerAsString = answerAsString.concat(quotientListAsString[i]);
			}
			return answerAsString;
		}
	}
	public String toBaseSixteen() {
		return number;
	}
}
