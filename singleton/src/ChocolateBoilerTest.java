public class ChocolateBoilerTest {
    public static void main(String[] args) {
        ChocolateBoiler boiler1 = ChocolateBoiler.getInstance();
        boiler1.fill();
        boiler1.boil();
        boiler1.drain();

        System.out.println();

        ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();
        boiler2.fill();
        boiler2.boil();
        boiler2.drain();

        System.out.println();

        if (boiler1 == boiler2) {
            System.out.println("boiler1 and boiler2 are the SAME instance ✅");
        } else {
            System.out.println("boiler1 and boiler2 are DIFFERENT instances ❌");
        }
    }
}
