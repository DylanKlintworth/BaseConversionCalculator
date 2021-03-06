import java.util.ArrayList;
public class BaseTen extends Number{
	private long number; // The number of the base ten object. This is what user inputs.
	private int base = 10; // Base ten base is ten.
	public BaseTen(){ //Default constructor, sets number to zero.
		number = 0;
	}
	public BaseTen(String n) { //Check if user inputs valid number for base ten, if not set number to zero.
		String[] possibleValues = {"0","1","2","3","4","5","6","7","8","9"};
		int count = 0;
		for(int i = 0; i < n.length();i++){ //Cycles through argument input by user.
			for(int j = 0; j < possibleValues.length;j++){ //Cycles through possible values for base ten.
				if(possibleValues[j].equals(Character.toString(n.charAt(i)))){ //Checks if each char in user's input is equal to a possible value.
					count = count+1; //Count is increased by one if input is valid.
				}
			}
		}
		if(count == n.length()) { // If the count is the length of the user's input then the number will be set.
			long num = Long.valueOf(n);
			number = num;
		}else{ //Otherwise set to zero.
			number = 0; 
		}
	}
	public int getBase() { //return the base of base ten for main window.
		return base;
	}
	public String toBaseTen() { //returns string representation of base ten number.
		return Long.toString(number);
	}
	public boolean equals(Number n) { //checks if this base ten object is equal to another number.
		if(this.toBaseTen().equals(n.toBaseTen())) { // converts both numbers to base ten and compares string values.
			return true; // if equal return true, otherwise returns false.
		}else {
			return false;
		}
	}
	public boolean equals(BaseTen n) { //checks if this base ten value is equal to another base ten object's value.
		if(this.getBaseTen() == n.getBaseTen()) { // if equal returns true, otherwise returns false.
			return true;
		}else {
			return false;
		}
	}
	public void setBaseTen(String n) { //changes this BaseTen's number to whatever user inputs as string.
		String[] possibleValues = {"0","1","2","3","4","5","6","7","8","9"};
		int count = 0;
		for(int i = 0; i < n.length();i++){
			for(int j = 0; j < possibleValues.length;j++){
				if(possibleValues[j].equals(Character.toString(n.charAt(i)))){ //if input char matches a possible value, count increases by 1.
					count = count+1;
				}
			}
		}
		if(count == n.length()) { // if the count is equal to the input's length then the number will be set to the input, otherwise it is set to zero.
			long num = Long.valueOf(n);
			number = num;
		}else{
			number = 0;
		}
	}
	public long getBaseTen() { //returns a long representation of the base ten's private variable number;
		return number;
	}
	/*
	 * (non-Javadoc)
	 * @see Number#toBaseTwo()
	 * P: Two ArrayLists to store quotients and powers. Long variables to store the dividend, divisor, power, and quotient. String to store answer as a string.
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
	public String toBaseTwo() { //returns a string representation of this base ten value converted to base two.
		ArrayList<Long> powerList = new ArrayList<>(); //Store 2^power
		ArrayList<Long> quotientList = new ArrayList<>(); //Store quotients 

		long dividend, divisor, quotient, power;
		String answerAsString; //This will be returned
		answerAsString = "";
		dividend = number;
		divisor = 0;
		quotient = 0;
		power = 0;
		if (number == 0) { // if this base ten number is zero, it returns String representation of zero.
			return "0";
		}else if(number == 1) { // if this base ten number is 1, it returns the String representation of 1.
			return "1";
		}else {
			while(dividend > Math.pow(2,power)) { //while the dividend is greater than 2 to the power it will repeat.
				powerList.add((long) Math.pow(2, power)); //the powerList ArrayList will store each 2^power so it knows what to subtract later.
				power++; // power increases for each iteration.
			}
			for(int i = powerList.size()-1; i >= 0; i--) { //cycle through powerList 
				divisor = powerList.get(i); //divisor set to last position of powerList.
				quotient = dividend / divisor;
				if(quotient == 2) {
					quotientList.add(10L); //makes sure if quotient is equal to 2 it will be stored as 10L for future string purposes.
					dividend = dividend % divisor; //dividend becomes remainder of dividend / divisor.
				}else {
				quotientList.add(quotient); //quotient is added to list.
				dividend = dividend % divisor;
				}
			}
			String[] quotientListAsString = new String[quotientList.size()]; //String array to store values of quotientList as a string.
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
	 * @see Number#toBaseEight()
	 * P: Two ArrayLists to store quotients and powers. Long variables to store the dividend, divisor, power, and quotient. String to store answer as a string.
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
	public String toBaseEight() { //returns string representation of base ten value converted to base eight.
		ArrayList<Long> powerList = new ArrayList<>();
		ArrayList<Long> quotientList = new ArrayList<>();

		long dividend, divisor, quotient, power;
		String answerAsString;
		answerAsString = "";
		dividend = number;
		divisor = 0;
		quotient = 0;
		power = 0;
		if (number == 0) {
			return "0";
		}else if(number == 1) {
			return "1";
		}else{
			while(dividend > Math.pow(8,power)) { //while the dividend is greater than 8 to the power it will repeat.
				powerList.add((long) Math.pow(8, power)); //the powerList ArrayList will store each 8^power so it knows what to subtract later.
				power++;
			}
			for(int i = powerList.size()-1; i >= 0; i--) { //cycle through powerList
				divisor = powerList.get(i);
				quotient = dividend / divisor;
				if(quotient == 8) {
					quotientList.add(10L); //quotient 10L is added to list.
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
			for(int i = 0; i < quotientListAsString.length;i++) { //Creates final answer by adding string representations together.
				answerAsString = answerAsString.concat(quotientListAsString[i]);
			}
			return answerAsString; //returns answer in a string representation in base eight.
		}
	}
	/*
	 * (non-Javadoc)
	 * @see Number#toBaseSixteen()
	 * P: Two ArrayLists to store quotients and powers. Long variables to store the dividend, divisor, power, and quotient. String to store answer as a string.
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
	public String toBaseSixteen() { //returns string representation of this base ten value converted to base sixteen.
		ArrayList<Long> powerList = new ArrayList<>();
		ArrayList<Long> quotientList = new ArrayList<>();

		long dividend, divisor, quotient, power;
		String answerAsString;
		answerAsString = "";
		dividend = number;
		divisor = 0;
		quotient = 0;
		power = 0;
		if(number == 0) {
			return "0";
		}else if(number == 1) {
			return "1";	
		}else {
			while(dividend > Math.pow(16,power)) { //checks all values of 16^power that are less than dividend.
				powerList.add((long) Math.pow(16, power));
				power++;
			}
			if(dividend == Math.pow(16, power)) { //checks if dividend == any power of 16.
				int count = 1;
				while(dividend / 16 != 1) {
					dividend = dividend / 16;
					count++;
				}
				return Integer.toString((int)Math.pow(10, count)); // returns value of 16^power
			}
			for(int i = powerList.size()-1; i >= 0; i--) { // cycles through power list.
				divisor = powerList.get(i);
				quotient = dividend / divisor;
				if(quotient == 16) {
					quotientList.add(16L); //adds 16L if quotient is 16.
				}else {
				quotientList.add(quotient);
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
	public String toString() { // returns string representation of the base ten object's value.
		return Long.toString(number);
	}
}