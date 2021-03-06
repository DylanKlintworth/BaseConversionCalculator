import java.util.ArrayList;

public class BaseEight extends Number{
	private long number; //number of this base eight object.
	private int base = 8; //base of a base eight object.
	public BaseEight() { //default constructor, sets number to zero.
		number = 0;
	}
	public BaseEight(String n) { //validates user input, sets number to input otherwise sets number to zero.
		String[] possibleValues = {"0","1","2","3","4","5","6","7"};
		int count = 0;
		for(int i = 0; i < n.length();i++){
			for(int j = 0; j < possibleValues.length;j++){
				if(possibleValues[j].equals(Character.toString(n.charAt(i)))){
					count = count+1;
				}
			}
		}
		if(count == n.length()) {
			long num = Long.valueOf(n);
			number = num;
		}else{
			number = 0;
		}
	}
	public int getBase() { // returns integer of this object's base.
		return base;
	}
	public void setBaseEight(String n) { //sets number to input, otherwise to zero if input is invalid.
		String[] possibleValues = {"0","1","2","3","4","5","6","7"};
		int count = 0;
		for(int i = 0; i < n.length();i++){
			for(int j = 0; j < possibleValues.length;j++){
				if(possibleValues[j].equals(Character.toString(n.charAt(i)))){
					count = count+1;
				}
			}
		}
		if(count == n.length()) {
			long num = Long.valueOf(n);
			number = num;
		}else{
			number = 0;
		}
	}
	public long getBaseEight() { //returns long of this object's number.
		return number;
	}
	public boolean equals(Number n) { //checks if this object is equal to another number by comparing base ten values. returns true or false.
		if(this.toBaseTen().equals(n.toBaseTen())) {
			return true;
		}else {
			return false;
		}
	}
	public boolean equals(BaseEight n) { //checks if this object is equal to another base eight object by comparing number values.
		if(this.getBaseEight() == n.getBaseEight()) {
			return true;
		}else {
			return false;
		}
	}
	public String toString() { //returns string representation of this base's number.
		return Long.toString(number);
	}
	/*
	 * (non-Javadoc)
	 * @see Number#toBaseTen()
	 *  P: String for number as string, String[] for valid numbers in base ten, double[] for input values, double for powers and answers.
	 * I: No input, utilizes object's number value.
	 * P: Cycle through each numeral in the object's number with for loop.
	 * 	Cycle through all possible values for base ten, 0-9.
	 * 		Set temporary String to char value of numeral.
	 * 		if temporary string equals possible value then values[index] = possibleValuesIndex, sets values within array to a possible base ten value.
	 * answer equals values[index]*8^power.
	 * power--;
	 * O: once cycled through, return answer as a string.
	 */
	public String toBaseTen() { //return string representation of this base eight number converted to base ten.
		String numberAsString = Long.toString(number);
		String[] possibleValues = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}; //possible values for base ten.
		double[] values = new double[1000];
		double powers;
		double answer;
		answer = 0;
		powers = numberAsString.length()-1; //power is number length minus 1.
		if(number == 0) {
			return "0";
		}else if(number == 1) {
			return "1";
		}else {
			for(int originalNumIndex = 0; originalNumIndex < numberAsString.length(); originalNumIndex++) { //cycle through numerals through number.
				for(int possibleValuesIndex = 0; possibleValuesIndex < possibleValues.length; possibleValuesIndex++) {//cycle through possible base ten values.
					String temp = Character.toString(numberAsString.charAt(originalNumIndex));
					if(temp.equals(possibleValues[possibleValuesIndex])){ //if equal to a possible value set values to possible value.
						values[originalNumIndex] = possibleValuesIndex;
					}
				}
				answer = answer + values[originalNumIndex]*Math.pow(8,powers);
				powers = powers - 1;
			}
			long answerAsLong = (long) answer;
			return Long.toString(answerAsLong); // return answer converted to string.
		}
	}
	/*
	 * (non-Javadoc)
	 * @see Number#toBaseTwo()
	 * P: Two ArrayLists to store quotients and powers. Long variables to store the dividend, divisor, power, and quotient. String to store answer as a string.
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
		if (number == 0) {
			return "0";
		}else if(number == 1) {
			return "1";
		}else {
			while(dividend > Math.pow(2,power)) {
				powerList.add((long) Math.pow(2, power)); //the powerList ArrayList will store each 2^power so it knows what to subtract later.
				power++;
			}
			for(int i = powerList.size()-1; i >= 0; i--) { //cycle through powerList.
				divisor = powerList.get(i);
				quotient = dividend / divisor;
				if(quotient == 2) {
					quotientList.add(10L);
					dividend = dividend % divisor;
				}else {
				quotientList.add(quotient); //quotient is added to list.
				dividend = dividend % divisor;
				}
			}
			String[] quotientListAsString = new String[quotientList.size()];
			for(int i = 0; i < quotientListAsString.length; i++) { // converts all quotients to string values.
				quotientListAsString[i] = Long.toString(quotientList.get(i));
			}
			for(int i = 0; i < quotientListAsString.length;i++) { //Concatenates string values to make final answer.
				answerAsString = answerAsString.concat(quotientListAsString[i]);
			}
			return answerAsString; // returns final value of base two.
		}
	}
	/*
	 * (non-Javadoc)
	 * @see Number#toBaseSixteen()
	 * P: Two ArrayLists to store quotients and powers. Long variables to store the dividend, divisor, power, and quotient. String to store answer as a string.
	 * Dividend will be set to this object's number converted to base ten.
	 * I: No input, retrieve number from private variable number.
	 * P: Find the greatest value of 16^power that is less than the base ten value.
	 * if number is equal to 16^power then it will find the amount of times it takes to get to one. Then 10^number of times will be returned.
	 * Store each 16^power lower than the number in a power ArrayList.
	 * for loop to cycle down the power ArrayList and set divisor to the index of powerList.
	 * quotient will be set to dividend / divisor and added to quotient ArrayList.
	 * Set dividend to the remainder of the equation above.
	 * if quotient is equal to 16 then that quotient will be set as "16L" so it accounts for base sixteen representation of 16.
	 * loop will run and collect all quotients and add them to the quotient ArrayList.
	 * Another for loop will then cycle through the quotientList and convert it to String values, which will be placed in a string[].
	 * If those quotients equal 10,11,12,13,14,15 then they will be converted to their respective lettering.
	 * Another for loop will concatenate all values within the array together to produce the final string representation.
	 * O: String representation of base ten value converted to base sixteen will be returned.
	 */
	public String toBaseSixteen() {
		ArrayList<Long> powerList = new ArrayList<>();
		ArrayList<Long> quotientList = new ArrayList<>();

		long dividend, divisor, quotient, power;
		String answerAsString;
		answerAsString = "";
		dividend = Long.parseLong(this.toBaseTen());
		divisor = 0;
		quotient = 0;
		power = 0;
		if(number == 0) {
			return "0";
		}else if(number == 1) {
			return "1";
		}else {
			while(dividend > Math.pow(16,power)) { 
				powerList.add((long) Math.pow(16, power));
				power++;
			}
			if(dividend == Math.pow(16, power)) { //checks if dividend == any power of 16.
				int count = 1;
				while(dividend / 16 != 1) {
					dividend = dividend / 16;
					count++;
				}
				return Integer.toString((int)Math.pow(10, count));
			}
			for(int i = powerList.size()-1; i >= 0; i--) {
				divisor = powerList.get(i);
				quotient = dividend / divisor;
				if(quotient == 16) {
					quotientList.add(16L); //adds 16L if quotient is 16.
				}else {
				quotientList.add(quotient); //add quotients to list.
				dividend = dividend % divisor;
				}
			}
			String[] quotientListAsString = new String[quotientList.size()];
			for(int i = 0; i < quotientList.size(); i++) { //checks to see if quotient matches any hexadecimal lettering, if so it adds the letter instead of the quotient.
				if(quotientList.get(i) == 10) {
					quotientListAsString[i] = "A";
				}else if(quotientList.get(i) == 11) {
					quotientListAsString[i] = "B";
				}else if(quotientList.get(i) == 12) {
					quotientListAsString[i] = "C";
				}else if(quotientList.get(i) == 13) {
					quotientListAsString[i] = "D";
				}else if(quotientList.get(i) == 14) {
					quotientListAsString[i] = "E";
				}else if(quotientList.get(i) == 15) {
					quotientListAsString[i] = "F";
				}else if(quotientList.get(i)==16){
					quotientListAsString[i] = "10";
				}else{
				quotientListAsString[i] = Long.toString(quotientList.get(i));
				}
			}
			for(int i = 0; i < quotientListAsString.length; i++) {
				answerAsString = answerAsString + quotientListAsString[i];
			}
			answerAsString = answerAsString.trim();
			return answerAsString; // returns base ten converted to base sixteen.
		}
	}
	public String toBaseEight() { // returns number of this base eight object in string form.
		return Long.toString(number);
	}
}
