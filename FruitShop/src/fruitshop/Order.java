package fruitshop;

import java.util.ArrayList;

public class Order {
    
    String customerName;
    ArrayList<Fruit> order;

    public Order(String customerName, ArrayList<Fruit> order) {
        this.customerName = customerName;
        this.order = order;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Fruit> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<Fruit> order) {
        this.order = order;
    }
    
}
