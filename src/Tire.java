import java.util.Objects;

public class Tire extends Item {
    int wheelDiameter;
    int sectionWidth;
    boolean passengerTire;

    public Tire(int w, int s, boolean pt,double price, int invQuantity){
        super(price, invQuantity);
        this.wheelDiameter = w;
        this.sectionWidth = s;
        this.passengerTire = pt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tire)) return false;
        Tire tire = (Tire) o;
        return wheelDiameter == tire.wheelDiameter &&
                sectionWidth == tire.sectionWidth &&
                passengerTire == tire.passengerTire &&
                getPrice() == tire.getPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(wheelDiameter, sectionWidth, passengerTire, getPrice());
    }

    @Override
    public String toString(){
        String result = "";
        if(passengerTire) result += "Passenger tire";
        else result = "Front Tire";
        return result + " with " + wheelDiameter + "\" wheel diameter " + sectionWidth +
                " mm. section width, price $" + String.format("%,.2f",getPrice()) + " each (" + getInvQuantity() +" in stock, " + getSoldQuantity()
                + " sold).";
    }
}
