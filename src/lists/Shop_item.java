package lists;

public class Shop_item {
    private int index;
    private int price;
    private String name;

    public Shop_item(String name, int price) {
        this.price = price;
        this.name = name;
    }
    public Shop_item(String name) {
        this.name = name;
    }


    public void setIndex(int index) {
        this.index = index;
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


