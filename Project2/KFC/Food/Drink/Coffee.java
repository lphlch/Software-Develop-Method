package Food.Drink;

public class Coffee extends Drink {

    @Override
    public boolean make() {
        System.out.println("Making coffee......");
        return true;
    }
}
