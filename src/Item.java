import java.io.Serializable;

public abstract class Item implements Serializable, Comparable<Item> {
    //attributes
    private double price;
    private int invQuantity;
    private int soldQuantity;
    private int cartQuantity;

    //constructor
    public Item(double price, int invQuantity){
        this.price = price;
        this.invQuantity = invQuantity;
        this.soldQuantity = 0;
        this.cartQuantity = 0;
    }

    //getters and setters
    public double getPrice(){return price;}
    public int getInvQuantity(){return invQuantity;}
    public int getSoldQuantity(){return soldQuantity;}
    public int getCartQuantity() {return cartQuantity;}
    public void setInvQuantity(int q){invQuantity -= q;}
    public void setSoldQuantity(int q){soldQuantity += q;}
    public void setCartQuantity(int q){cartQuantity += q;}

    public double sellUnits(int amount){
        if( amount > 0 && invQuantity >= amount){
            invQuantity -= amount;
            soldQuantity += amount;
            cartQuantity = 0;
            System.out.println(amount*price);
            return amount*price;
        }
        return 0;
    }

    public void updateStockQuantity(int amount){invQuantity += amount;}

    //for sorting by soldQuantity
    public int compareTo(Item newItem){
        return newItem.soldQuantity - this.soldQuantity;
    }

    public abstract String toString();
    public abstract boolean equals(Object o);
    public abstract int hashCode();
}
