
public interface PizzaIngredientFactory {
	Dough createDough();
	Sauce createSauce();
	Cheese createCheese();
	Clams createClam();
	Veggies[] createVeggies();
	Pepperoni createPepperoni();
}
