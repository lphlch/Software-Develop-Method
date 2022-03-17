package Food.Drink;

public class Sprite extends Drink {
    @Override
    public boolean make() {
        System.out.println("Making sprite......");
        return true;
    }
}
