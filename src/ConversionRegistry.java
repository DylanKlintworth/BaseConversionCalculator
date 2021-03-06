import java.util.ArrayList;
public class ConversionRegistry {
	private ArrayList<String> registryNumberContainer; //Stores conversions when user converts number to different bases.
	public ConversionRegistry() { // initializes the ArrayList.
		registryNumberContainer = new ArrayList<>();
	}
	public ArrayList<String> getNumberList(){ //returns the ArrayList of conversions.
		return registryNumberContainer;
	}
	public void addNumber(Number i) { //Adds all the conversions of a given number to the ArrayList. Checks which base is entered.
		if(i.getBase() == 10) {
			registryNumberContainer.add(i.toBaseTen() + " - Base 10: " + i.toBaseTwo() + " - Base 2: " + i.toBaseEight() + " - Base 8: " + i.toBaseSixteen() + " - Base 16.");
		}else if(i.getBase() == 2) {
			registryNumberContainer.add(i.toBaseTwo() + " - Base 2: " + i.toBaseTen() + " - Base 10: " + i.toBaseEight() + " - Base 8: " + i.toBaseSixteen() + " - Base 16.");
		}else if(i.getBase() == 8) {
			registryNumberContainer.add(i.toBaseEight() + " - Base 8: " + i.toBaseTwo() + " - Base 2: " + i.toBaseTen() + " - Base 10: " + i.toBaseSixteen() + " - Base 16.");
		}else{
			registryNumberContainer.add(i.toBaseSixteen() + " - Base 16: " + i.toBaseTwo() + " - Base 2: " + i.toBaseEight() + " - Base 8: " + i.toBaseTen() + " - Base 10.");
		}
	}
	public void printNumberList() { //Prints the ArrayList to the console.
		for(int i = 0; i < registryNumberContainer.size(); i++) {
			System.out.println(registryNumberContainer.get(i));
		}
	}
}
