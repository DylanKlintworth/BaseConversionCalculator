public abstract class Number { //Set guideline for each Base and set an equals method for numbers.
	public abstract boolean equals(Number n); //Compare object's values.
	public abstract String toString(); //return object in string representation.
	public abstract String toBaseTen(); //converts object value to base ten.
	public abstract String toBaseTwo();// converts object value to base two.
	public abstract String toBaseEight(); //converts object value to base eight.
	public abstract String toBaseSixteen();//converts object value to base sixteen.
	public abstract int getBase();//returns base of object.
}
