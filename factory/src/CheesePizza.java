
public class CheesePizza extends Pizza{
	PizzaIngredientFactory ingredientFactory;
	
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	
	void prepare() {
		System.out.println("Preparing " + name);
		dough  = ingredientFactory.createDough();
		sauce  = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}

	@Override
	Pizza createPizza(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
