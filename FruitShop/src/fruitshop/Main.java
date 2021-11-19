package fruitshop;

import java.util.*;

public class Main {
    
    static GetInput g = new GetInput();
    
    static Fruit findFruitByID(ArrayList<Fruit> fruitList, String id){
        for (Fruit fruit : fruitList) {
            //found fruit
            if(fruit.getFruitID().equalsIgnoreCase(id)) return fruit;
        }
        return null;
    }
    
    static boolean checkExistedFruit(ArrayList<Fruit> fruitList, String ID){
        //iterate over the fruit list
        for (Fruit fruit : fruitList) {
            //duplicate id
            if(ID.equalsIgnoreCase(fruit.getFruitID())) return true;
        }
        return false;
    }
    
    static void createFruit(ArrayList<Fruit> fruitList){
        while (true) {            
            //user input unduplicate id
            String fruitID;
            while (true) {                
                System.out.print("Enter fruit ID: ");
                fruitID = g.getString();
                //fruit existed
                if(checkExistedFruit(fruitList, fruitID))
                    System.out.println("Fruit is existed.");
                else break;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = g.getString();
            System.out.print("Enter price: ");
            double price = g.getDouble();
            System.out.print("Enter Quantity: ");
            int quantity = g.getInt();
            System.out.print("Enter origin: ");
            String origin = g.getString();
            fruitList.add(new Fruit(fruitID, fruitName, price, quantity, origin));
            System.out.print("Do you want to continue (Y/N)?: ");
            //do not add new fruit anymore
            if(!g.getYN()) {
                System.out.println();
                return;
            }
        } 
    }
    
    static void displayOrderedList(ArrayList<Fruit> orderedList){
        double total = 0;
        System.out.printf("%-15s%-15s%-15s%-5s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit o : orderedList) {
            double amount = o.getFruitQuantity()* o.getFruitPrice();
            System.out.printf("%-15s%-15d%-15.0f%-15.0f\n", 
                    o.getFruitName(), 
                    o.getFruitQuantity(), 
                    o.getFruitPrice(), 
                    amount);
            total += o.getFruitPrice() * o.getFruitQuantity();
        }
        System.out.println("Total: " + total + "$");
    }
    
    static void viewOrder(Hashtable<Integer, Order> orderedList){
        //no order
        if(orderedList.isEmpty()) System.out.println("No orders");
        //iterate over the ordered list
        for (Order o : orderedList.values()) {
            System.out.println("Customer's name: " + o.customerName);
            displayOrderedList(o.order);
            System.out.println();
        }
        System.out.println();
    }
    
    static void displayFruitList(ArrayList<Fruit> fruitList) {
        int item = 1;
        System.out.println("List of fruit:");
        System.out.printf("%-7s%-15s%-15s%-5s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit f : fruitList) {
            //fruit remain
            if (f.getFruitQuantity() > 0) {
                System.out.printf("%-7d%-15s%-15s%-1.0f$\n", 
                item, f.getFruitName(), f.getFruitorigin(), f.getFruitPrice());
                item++;
            }
        }
    }
    
    static Fruit getFruitByItem(int item, ArrayList<Fruit> fruitList) {
        int itemCount = 0;
        for (Fruit fruit : fruitList) {
            //fruit remain
            if (fruit.getFruitQuantity() > 0) itemCount++;
            //found fruit
            if (itemCount == item) return fruit; 
        }
        return null;
    }
    
    static boolean checkExistedItem(ArrayList<Fruit> ol, String ID){
        for (Fruit f : ol) {
            if(ID.equalsIgnoreCase(f.getFruitID())) return true;
        }
        return false;
    }
    
    static void updateOrder(ArrayList<Fruit> ol, String ID, int quantity){
        for (Fruit o : ol) {
            //existed order
            if(o.getFruitID().equalsIgnoreCase(ID)){
                o.setFruitQuantity(o.getFruitQuantity()+ quantity);
                return;
            }
        }
    }
    
    static ArrayList<Fruit> isAbleToBuy(ArrayList<Fruit> fruitList){
        ArrayList<Fruit> isAbleToBuy = new ArrayList<>();
        for (Fruit fruit : fruitList) {
            //is able to buy
            if(fruit.getFruitQuantity() > 0) isAbleToBuy.add(fruit);
        }
        return isAbleToBuy;
    }
    
    static void shopping(ArrayList<Fruit> fruitList, Hashtable<Integer, Order> order) {
        //empty fruit list
        if(fruitList.isEmpty()){
            System.out.println("Empty fruit.");
            System.out.println("");
            return;
        }
        ArrayList<Fruit> ol = new ArrayList<>();
        while (true) {            
            displayFruitList(isAbleToBuy(fruitList));
            System.out.print("Enter item: ");
            int item = g.getChoice(1, isAbleToBuy(fruitList).size());
            Fruit f = getFruitByItem(item, fruitList);
            System.out.println("You selected " + f.getFruitName());
            System.out.print("Enter quantity: ");
            int quantity = g.getChoice(1, f.getFruitQuantity());
            f.setFruitQuantity(f.getFruitQuantity()- quantity);
            System.out.print("Do you want to order now (Y/N): ");
            if(checkExistedItem(ol, f.getFruitID())) updateOrder(ol, f.getFruitID(), quantity);
            else ol.add(new Fruit(f.getFruitID(), f.getFruitName(), f.getFruitPrice(), quantity, f.getFruitorigin()));
            if(g.getYN()) break;
        } 
        displayOrderedList(ol);
        System.out.print("Enter name: ");
        String name = g.getString();
        Order o = new Order(name, ol);
        order.put(order.size()+1, o);
    }
    
    static void menu(){
        System.out.println("===FRUIT SHOP===");
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Your choice: ");
    }
    
    public static void main(String[] args){
        ArrayList<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit("1", "Coconut", 2, 9, "Vietnam"));
        fruitList.add(new Fruit("2", "Orange", 3, 9, "US"));
        fruitList.add(new Fruit("3", "Apple", 4, 9, "Thailand"));
        fruitList.add(new Fruit("4", "Grape", 6, 9, "France"));
        Hashtable<Integer, Order> orderedList = new Hashtable<>();
        while (true) {            
            menu();
            int choice = g.getChoice(1, 4);
            switch(choice){
                case 1:
                    createFruit(fruitList);
                    break;
                case 2:
                    viewOrder(orderedList);
                    break;
                case 3:
                    shopping(fruitList, orderedList);
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
