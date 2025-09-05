import java.util.ArrayList;

public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Clams clam;
	Cheese cheese;
	Pepperoni pepperoni;
	Veggies veggies[];	
	
	ArrayList toppings = new ArrayList();
	
    abstract void prepare();
    
    abstract Pizza createPizza(String name);
    
    void setName(String name) {
		this.name = name;
	}

    
    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    
    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    
    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    
    public String getName() {
        return name;
    }
}
