/**
 * Created by Jan on 31.12.2014.
 */
public class Shop_item {
    private int index;
    private int price;
    private String name;

    public Shop_item(int index, int price, String name) {
        this.index = index;
        this.price = price;
        this.name = name;
    }

    public Shop_item(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}


