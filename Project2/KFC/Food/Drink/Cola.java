package Food.Drink;

public class Cola extends Drink {
    @Override
    public boolean make() {
        System.out.println("Making cola......");
        return true;
    }
}
