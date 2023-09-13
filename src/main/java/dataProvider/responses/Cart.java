package dataProvider.responses;

import java.util.List;

public class Cart {

    private String total;
    private List<Item> items;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }



}
