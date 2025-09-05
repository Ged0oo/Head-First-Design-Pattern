
public class PepperoniPizza extends Pizza {
	PizzaIngredientFactory ingredientFactory;

	public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		veggies = ingredientFactory.createVeggies();
		cheese = ingredientFactory.createCheese();
		pepperoni = ingredientFactory.createPepperoni();
	}

	@Override
	Pizza createPizza(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
