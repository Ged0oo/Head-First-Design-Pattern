/**
 * ChocolateBoiler implements the Singleton design pattern.
 * Only one instance of ChocolateBoiler can exist at a time.
 *
 * Usage:
 *   ChocolateBoiler boiler = ChocolateBoiler.getInstance();
 *   boiler.fill();
 *   boiler.boil();
 *   boiler.drain();
 *
 * Methods:
 *   - fill(): Fills the boiler with chocolate and milk if empty.
 *   - boil(): Boils the mixture if filled and not yet boiled.
 *   - drain(): Drains the boiled mixture if ready.
 *   - isEmpty(): Returns true if the boiler is empty.
 *   - isBoiled(): Returns true if the mixture is boiled.
 */
public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	private static ChocolateBoiler uniqueInstance;
	
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public static synchronized ChocolateBoiler getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new ChocolateBoiler();
		}
		return uniqueInstance;
	}

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            System.out.println("Filling the boiler with chocolate and milk...");
        } else {
            System.out.println("Boiler already filled!");
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
            System.out.println("Boiling the mixture...");
        } else if (isEmpty()) {
            System.out.println("Cannot boil, boiler is empty!");
        } else {
            System.out.println("Already boiled!");
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
            System.out.println("Draining the boiled chocolate...");
        } else if (isEmpty()) {
            System.out.println("Cannot drain, boiler is empty!");
        } else {
            System.out.println("Cannot drain, not boiled yet!");
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}