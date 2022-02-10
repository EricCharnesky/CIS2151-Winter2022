package checkingforinterfaces;

public class ItemStorage implements Countable {

    private int numberOfItems;

    public ItemStorage() {
        numberOfItems = 0;
    }

    @Override
    public int increaseCount() {
        numberOfItems++;
        return numberOfItems;
    }

    @Override
    public int decreaseCount() {
        if (numberOfItems > 0) {
            numberOfItems--;
        }

        return numberOfItems;
    }

}
