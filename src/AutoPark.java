import java.util.*;
import java.io.*;
import java.lang.reflect.Array;


public class AutoPark implements Serializable{
    private String name;
    private double revenue;
    private int numSales;
    private ArrayList<Item> items;

    //constructor
    public AutoPark(String name) {
        this.name = name;
        revenue = 0;
        numSales = 0;
        items = new ArrayList<>();
    }

    //getters and setters
    public String getName() { return name; }
    public List<Item> getItems() { return items; }
    public double getRevenue() { return revenue; }
    public int getNumSales() { return numSales; }

    //returns items but only the items that still have inventory
    public List<Item> getAvailableItems(){
        List<Item> availableItems = new ArrayList<>();
        for(Item item : items){
            if(item.getInvQuantity() > item.getCartQuantity()){
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    //return string array of items that are in the cart
    public ArrayList<String> getCartItems(){
        ArrayList<Item> cartItems = new ArrayList<>();
        ArrayList<String> cartItemsString = new ArrayList<>();
        for(Item item : items){
            if(item.getCartQuantity() > 0){
                cartItemsString.add(item.getCartQuantity() + " x " + item);
            }
        }
        return cartItemsString;
    }

    // adding Items to inventory, should not add duplicates (based on attributes of each concrete child class that do not change)
    public boolean addItem(Item item) {
        for(Item i : items){
            if(i.equals(item))
                return false;
        }
        return items.add(item);
    }

    //add to cart
    public void addToCart(Item item){
        if(item.getInvQuantity() > item.getCartQuantity()){
          item.setCartQuantity(1);
        }
    }

    //remove from cart
    public void removeFromCart(String strItem){
        for(Item item : items){
            if((item.getCartQuantity() + " x " + item).equals(strItem)){
                item.setCartQuantity(-1);
                return;
            }
        }
    }

    //complete sale
    public void completeSale(){
        double price = 0;
        for(Item item : items){
            if(item.getCartQuantity() > 0){
                price += item.sellUnits(item.getCartQuantity());
            }
        }
        revenue += price;
        numSales++;
    }

    //get avreage sale
    public double getAvgSale(){
        if(numSales == 0) return 0;
        return revenue/numSales;
    }

    //get avreage sale String
    public String getAvgSaleString(){
        if(numSales == 0) return "N/A";
        return String.format("%.2f", getAvgSale());
    }

    //get cart total
    public double getCartTotal(){
        double total = 0;
        for(Item item : items){
            if(item.getCartQuantity() > 0){
                total += item.getCartQuantity() * item.getPrice();
            }
        }
        return total;
    }
            

    public void printItems(){
        if(items.isEmpty()){
            System.out.println("No items in inventory.");
            return;
        } else {
            System.out.println("Inventory:");
            for(Item item : items){
                System.out.println(item);
            }
        }
    }

    public List<Item> getXPopularItems(int x){
        if(x <= 0) return new ArrayList<>();

        List<Item> result = new ArrayList<>(items);
        Collections.sort(result); // sort by soldQuantity using compareTo method in Item class

        if(x > result.size()){ return result; }
        return result.subList(0, x);
    }

    public boolean saveToFile(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException i) {
            return false;
        }
    }

    public static AutoPark loadFromFile(String filename) {
        AutoPark autoPark = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            autoPark = (AutoPark) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("AutoPark class not found");
            return null;
        }
        return autoPark;
    }

    @Override
    public String toString() {
        return "AutoPark{" + "name='" + name + '\'' + ", revenue=" + revenue + ", items=" + items + '}';
    }

    public static AutoPark createPark() {
        AutoPark park1 = new AutoPark("VroomVille Vehicle Haven");
        Sedan s1 = new Sedan("Hyundai", "Sonata", "Black", 2020, 35000, 10);
        Sedan s2 = new Sedan("BMW", "3 Series", "White", 2022, 42000, 10);
        park1.addItem(s1);
        park1.addItem(s2);
        SUV suv1 = new SUV("Chevy", "Trailblazer", "Red", 2021, true,32000,10);
        SUV suv2 = new SUV("Jeep", "Grand Cherokee", "Green", 2018, false,21000,10);
        park1.addItem(suv1);
        park1.addItem(suv2);
        Truck t1 = new Truck("Toyota", "Tacoma", 2019, "goods",true,28000,10);
        Truck t2 = new Truck("Ford", "Ranger", 2022, "equipment",false,30000,10);
        park1.addItem(t1);
        park1.addItem(t2);
        Van v1 = new Van("Ford", "Transit", 2020, "goods",true,22000,10);
        Van v2 = new Van("Ram", "ProMaster", 2019, "equipment",false,19000,10);
        park1.addItem(v1);
        park1.addItem(v2);
        Tire tire1 = new Tire(10,30,true,390, 20);
        Tire tire2 = new Tire(12,35,false,320,20);
        park1.addItem(tire1);
        park1.addItem(tire2);
        return park1;
    }

    public static void main(String[] args) {
        AutoPark park1 = createPark();
        park1.printItems();
    }
}
